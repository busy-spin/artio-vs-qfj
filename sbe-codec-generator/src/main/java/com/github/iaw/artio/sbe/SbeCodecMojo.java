package com.github.iaw.artio.sbe;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "sbe-gen", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class SbeCodecMojo extends AbstractMojo {

    @Parameter(property = "generatedSrcDir", defaultValue = "Generated source directory")
    private String generatedSrcDir;

    @Parameter(property = "validationXsd", defaultValue = "Validation xsd file")
    private String validationXsd;

    @Parameter(property = "schemaFiles", defaultValue = "List of schema files to use, use ; as separator")
    private String schemaFiles;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            SbeGenerator sbeGenerator = new SbeGenerator();
            sbeGenerator.generate(schemaFiles, validationXsd, generatedSrcDir);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
