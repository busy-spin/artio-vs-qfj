package com.github.iaw.artio.sbe;

public class Driver {

    public static void main(String[] args) {
        String fileNames = args[0];
        String validationXsd = args[1];
        String outputDir = args[2];

        SbeGenerator sbeGenerator = new SbeGenerator();

        sbeGenerator.generate(fileNames, validationXsd, outputDir);

    }

}
