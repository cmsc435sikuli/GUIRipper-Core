package edu.umd.cs.guitar.ripper;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.cli.ParseException;

import edu.umd.cs.guitar.util.Util;

public class GRipperConfiguration {

    // Subclasses should add their own options to this list
    protected Options opts;

    // Useful for subclasses to get command line options
    protected CommandLine cmd;

    public GRipperConfiguration() {
        opts = new Options();
        opts.addOption( OptionBuilder.withLongOpt("gui-file")
                        .withDescription("destination GUI file path")
                        .hasArg()
                        .withArgName("GUI_FILE")
                        .create() );
    }

    public void parseArguments(String[] args) throws ParseException {
        PosixParser parser = new PosixParser();
        cmd = parser.parse( opts, args );
        
        GUI_FILE = cmd.getOptionValue("gui-file", "GUITAR-Default.GUI");
        //LOG_FILE = cmd.getOptionValue("log-file", Util.getTimeStamp()+".log");
    }

    public static String GUI_FILE;

    // @Option(name = "--log-file", usage = "log file name ", aliases = "-l")
    public static String LOG_FILE = Util.getTimeStamp() + ".log";

    // @Option(name = "--open-win-file", usage = "log file name", aliases = "-ow")
    public static String LOG_WIDGET_FILE = "log_widget.xml";

    // @Option(name = "--config-file", usage = "Configuration file for the ripper defining terminal and ignored components/windows", aliases = "-cf")
    public static String CONFIG_FILE = "configuration.xml";

    public static int DELAY = 5000;
}
