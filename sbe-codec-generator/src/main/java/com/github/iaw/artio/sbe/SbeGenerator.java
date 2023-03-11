package com.github.iaw.artio.sbe;

import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;
import org.xml.sax.InputSource;
import uk.co.real_logic.sbe.generation.CodeGenerator;
import uk.co.real_logic.sbe.generation.TargetCodeGenerator;
import uk.co.real_logic.sbe.generation.TargetCodeGeneratorLoader;
import uk.co.real_logic.sbe.ir.Ir;
import uk.co.real_logic.sbe.ir.IrDecoder;
import uk.co.real_logic.sbe.ir.IrEncoder;
import uk.co.real_logic.sbe.xml.IrGenerator;
import uk.co.real_logic.sbe.xml.MessageSchema;
import uk.co.real_logic.sbe.xml.ParserOptions;
import uk.co.real_logic.sbe.xml.SchemaTransformer;
import uk.co.real_logic.sbe.xml.SchemaTransformerFactory;
import uk.co.real_logic.sbe.xml.XmlSchemaParser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SbeGenerator {

    public static final String JAVA_INTERFACE_PACKAGE = "org.agrona.sbe";
    public static final String JAVA_DEFAULT_ENCODING_BUFFER_TYPE = MutableDirectBuffer.class.getName();
    public static final String JAVA_DEFAULT_DECODING_BUFFER_TYPE = DirectBuffer.class.getName();
    public static final String VALIDATION_STOP_ON_ERROR = "sbe.validation.stop.on.error";
    public static final String VALIDATION_WARNINGS_FATAL = "sbe.validation.warnings.fatal";
    public static final String VALIDATION_XSD = "sbe.validation.xsd";
    public static final String VALIDATION_SUPPRESS_OUTPUT = "sbe.validation.suppress.output";
    public static final String GENERATE_STUBS = "sbe.generate.stubs";
    public static final String XINCLUDE_AWARE = "sbe.xinclude.aware";
    public static final String TYPES_PACKAGE_OVERRIDE = "sbe.types.package.override";
    public static final String TARGET_LANGUAGE = "sbe.target.language";
    public static final String GENERATE_IR = "sbe.generate.ir";
    public static final String OUTPUT_DIR = "sbe.output.dir";
    public static final String TARGET_NAMESPACE = "sbe.target.namespace";
    public static final String CPP_NAMESPACES_COLLAPSE = "sbe.cpp.namespaces.collapse";
    public static final String JAVA_GENERATE_INTERFACES = "sbe.java.generate.interfaces";
    public static final String JAVA_ENCODING_BUFFER_TYPE = "sbe.java.encoding.buffer.type";
    public static final String JAVA_DECODING_BUFFER_TYPE = "sbe.java.decoding.buffer.type";
    public static final String JAVA_GROUP_ORDER_ANNOTATION = "sbe.java.generate.group-order.annotation";
    public static final String CSHARP_GENERATE_NAMESPACE_DIR = "sbe.csharp.generate.namespace.dir";
    public static final String KEYWORD_APPEND_TOKEN = "sbe.keyword.append.token";
    public static final String DECODE_UNKNOWN_ENUM_VALUES = "sbe.decode.unknown.enum.values";
    public static final String SCHEMA_TRANSFORM_VERSION = "sbe.schema.transform.version";

    public void generate(String fileNames, String validationXsd, String outputDir) {

        String[] args = fileNames.split(";");
        try {
            System.setProperty("sbe.output.dir", outputDir);
            System.setProperty("sbe.target.language", "Java");
            System.setProperty("sbe.java.generate.interfaces", "true");
            System.setProperty("sbe.validation.stop.on.error", "true");
            System.setProperty("sbe.decode.unknown.enum.values", "true");
            System.setProperty("sbe.xinclude.aware", "true");
            System.setProperty("sbe.validation.xsd", validationXsd);
            generate(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void generate(String[] args) throws Exception {
        if (args.length == 0) {
            System.err.format("Usage: %s <filenames>...%n", SbeGenerator.class.getName());
            System.exit(-1);
        }

        String[] var1 = args;
        int var2 = args.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            String fileName = var1[var3];
            Ir ir;
            String outputDirName;
            if (fileName.endsWith(".xml")) {
                outputDirName = System.getProperty("sbe.validation.xsd");
                if (outputDirName != null) {
                    validateAgainstSchema(fileName, outputDirName);
                }

                MessageSchema schema = parseSchema(fileName);
                SchemaTransformer transformer = new SchemaTransformerFactory(System.getProperty("sbe.schema.transform.version"));
                ir = (new IrGenerator()).generate(transformer.transform(schema), System.getProperty("sbe.target.namespace"));
            } else {
                if (!fileName.endsWith(".sbeir")) {
                    System.err.println("Input file format not supported: " + fileName);
                    System.exit(-1);
                    return;
                }

                IrDecoder irDecoder = new IrDecoder(fileName);
                Throwable var39 = null;

                try {
                    ir = irDecoder.decode();
                } catch (Throwable var35) {
                    var39 = var35;
                    throw var35;
                } finally {
                    if (irDecoder != null) {
                        if (var39 != null) {
                            try {
                                irDecoder.close();
                            } catch (Throwable var32) {
                                var39.addSuppressed(var32);
                            }
                        } else {
                            irDecoder.close();
                        }
                    }

                }
            }

            outputDirName = System.getProperty("sbe.output.dir", ".");
            if (Boolean.parseBoolean(System.getProperty("sbe.generate.stubs", "true"))) {
                String targetLanguage = System.getProperty("sbe.target.language", "Java");
                generate(ir, outputDirName, targetLanguage);
            }

            if (Boolean.parseBoolean(System.getProperty("sbe.generate.ir", "false"))) {
                File inputFile = new File(fileName);
                String inputFilename = inputFile.getName();
                int nameEnd = inputFilename.lastIndexOf(46);
                String namePart = inputFilename.substring(0, nameEnd);
                File fullPath = new File(outputDirName, namePart + ".sbeir");
                IrEncoder irEncoder = new IrEncoder(fullPath.getAbsolutePath(), ir);
                Throwable var13 = null;

                try {
                    irEncoder.encode();
                } catch (Throwable var34) {
                    var13 = var34;
                    throw var34;
                } finally {
                    if (irEncoder != null) {
                        if (var13 != null) {
                            try {
                                irEncoder.close();
                            } catch (Throwable var33) {
                                var13.addSuppressed(var33);
                            }
                        } else {
                            irEncoder.close();
                        }
                    }

                }
            }
        }

    }

    public static void validateAgainstSchema(String sbeSchemaFilename, String xsdFilename) throws Exception {
        ParserOptions.Builder optionsBuilder = ParserOptions.builder().xsdFilename(System.getProperty("sbe.validation.xsd")).xIncludeAware(Boolean.parseBoolean(System.getProperty("sbe.xinclude.aware"))).stopOnError(Boolean.parseBoolean(System.getProperty("sbe.validation.stop.on.error"))).warningsFatal(Boolean.parseBoolean(System.getProperty("sbe.validation.warnings.fatal"))).suppressOutput(Boolean.parseBoolean(System.getProperty("sbe.validation.suppress.output")));
        Path path = Paths.get(sbeSchemaFilename);
        InputStream in = new BufferedInputStream(Files.newInputStream(path));
        Throwable var5 = null;

        try {
            InputSource inputSource = new InputSource(in);
            if (path.toAbsolutePath().getParent() != null) {
                inputSource.setSystemId(path.toUri().toString());
            }

            XmlSchemaParser.validate(xsdFilename, inputSource, optionsBuilder.build());
        } catch (Throwable var14) {
            var5 = var14;
            throw var14;
        } finally {
            if (in != null) {
                if (var5 != null) {
                    try {
                        in.close();
                    } catch (Throwable var13) {
                        var5.addSuppressed(var13);
                    }
                } else {
                    in.close();
                }
            }

        }

    }

    public static MessageSchema parseSchema(String sbeSchemaFilename) throws Exception {
        ParserOptions.Builder optionsBuilder = ParserOptions.builder().xsdFilename(System.getProperty("sbe.validation.xsd")).xIncludeAware(Boolean.parseBoolean(System.getProperty("sbe.xinclude.aware"))).stopOnError(Boolean.parseBoolean(System.getProperty("sbe.validation.stop.on.error"))).warningsFatal(Boolean.parseBoolean(System.getProperty("sbe.validation.warnings.fatal"))).suppressOutput(Boolean.parseBoolean(System.getProperty("sbe.validation.suppress.output")));
        Path path = Paths.get(sbeSchemaFilename);
        InputStream in = new BufferedInputStream(Files.newInputStream(path));
        Throwable var4 = null;

        MessageSchema var6;
        try {
            InputSource inputSource = new InputSource(in);
            if (path.toAbsolutePath().getParent() != null) {
                inputSource.setSystemId(path.toUri().toString());
            }

            var6 = XmlSchemaParser.parse(inputSource, optionsBuilder.build());
        } catch (Throwable var15) {
            var4 = var15;
            throw var15;
        } finally {
            if (in != null) {
                if (var4 != null) {
                    try {
                        in.close();
                    } catch (Throwable var14) {
                        var4.addSuppressed(var14);
                    }
                } else {
                    in.close();
                }
            }

        }

        return var6;
    }

    public static void generate(Ir ir, String outputDirName, String targetLanguage) throws Exception {
        TargetCodeGenerator targetCodeGenerator = TargetCodeGeneratorLoader.get(targetLanguage);
        CodeGenerator codeGenerator = targetCodeGenerator.newInstance(ir, outputDirName);
        codeGenerator.generate();
    }

}
