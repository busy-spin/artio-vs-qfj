package com.github.iaw.artio.code_generator;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo( name = "artio-gen")
public class ArtioCodecMojo extends AbstractMojo {

    @Parameter( property = "generatedSrcDir", defaultValue = "Generated source directory" )
    private String generatedSrcDir;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

    }

}
