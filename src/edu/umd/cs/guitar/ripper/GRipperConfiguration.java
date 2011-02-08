package edu.umd.cs.guitar.ripper;

import org.kohsuke.args4j.Option;

public class GRipperConfiguration {
    @Option(name = "--gui-file", usage = "destination GUI file path", aliases = "-g")
    public static String GUI_FILE = "GUITAR-Default.GUI";
}
