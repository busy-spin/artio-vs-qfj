package com.github.iaw.artio.code_generator;

import uk.co.real_logic.artio.dictionary.generation.CodecConfiguration;
import uk.co.real_logic.artio.dictionary.generation.CodecGenerator;

public final class CodecGenerationTool {
    public CodecGenerationTool() {
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            printUsageAndExit();
        }

        String outputPath = args[0];
        String files = args[1];
        String[] fileNames = files.split(";");
        String parentPackage = args[2];

        try {
            CodecConfiguration config = (new CodecConfiguration())
                    .outputPath(outputPath)
                    .fileNames(fileNames)
                    .parentPackage(parentPackage);
            CodecGenerator.generate(config);
        } catch (Throwable var5) {
            var5.printStackTrace();
            printUsageAndExit();
        }

    }

    private static void printUsageAndExit() {
        System.err.println("Usage: CodecGenerationTool </path/to/output-directory> <[/path/to/fixt-xml/dictionary;]/path/to/xml/dictionary>");
        System.exit(-1);
    }
}
