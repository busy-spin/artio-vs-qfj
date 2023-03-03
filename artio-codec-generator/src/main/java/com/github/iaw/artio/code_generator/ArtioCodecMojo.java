package com.github.iaw.artio.code_generator;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import uk.co.real_logic.artio.dictionary.generation.CodecConfiguration;
import uk.co.real_logic.artio.dictionary.generation.CodecGenerator;

@Mojo(name = "artio-gen", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class ArtioCodecMojo extends AbstractMojo {

    @Parameter(property = "generatedSrcDir", defaultValue = "Generated source directory")
    private String generatedSrcDir;

    @Parameter(property = "parentPackage", defaultValue = "Parent package")
    private String parentPackage;

    @Parameter(property = "dictFiles", defaultValue = "List of dictionary files to use, use ; as separator")
    private String dictFiles;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        String[] fileNames = dictFiles.split(";");

        try {
            CodecConfiguration config = (new CodecConfiguration())
                    .outputPath(generatedSrcDir)
                    .fileNames(fileNames)
                    .parentPackage(parentPackage);
            CodecGenerator.generate(config);
        } catch (Throwable var5) {
            var5.printStackTrace();
        }
    }

}
