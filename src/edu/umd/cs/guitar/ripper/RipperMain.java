package edu.umd.cs.guitar.ripper;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class RipperMain {
    private GRipperConfiguration config;

    public RipperMain(GRipperConfiguration config) {
        this.config = config;
    }

    private Ripper ripper;

    public void execute() {
        System.out.println("executing the ripper main");
        System.out.println(config.GUI_FILE);
    }
}
