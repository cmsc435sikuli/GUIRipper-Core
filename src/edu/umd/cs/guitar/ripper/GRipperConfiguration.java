package edu.umd.cs.guitar.ripper;

import org.kohsuke.args4j.Option;

import edu.umd.cs.guitar.util.Util;

public class GRipperConfiguration {
    @Option(name = "--gui-file", usage = "destination GUI file path", aliases = "-g")
    public static String GUI_FILE = "GUITAR-Default.GUI";

    @Option(name = "--log-file", usage = "log file name ", aliases = "-l")
    public static String LOG_FILE = Util.getTimeStamp() + ".log";

    @Option(name = "--open-win-file", usage = "log file name", aliases = "-ow")
    public static String LOG_WIDGET_FILE = "log_widget.xml";

    @Option(name = "--config-file", usage = "Configuration file for the ripper defining terminal and ignored components/windows", aliases = "-cf")
    public static String CONFIG_FILE = "configuration.xml";
}
