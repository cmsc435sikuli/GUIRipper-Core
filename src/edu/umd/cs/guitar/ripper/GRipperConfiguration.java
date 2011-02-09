package edu.umd.cs.guitar.ripper;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.HelpFormatter;

import edu.umd.cs.guitar.util.Util;

public class GRipperConfiguration {

    // Subclasses should add their own options to this list
    protected Options opts;

    // Useful for subclasses to get command line options
    protected CommandLine cmd;

    public GRipperConfiguration() {
        opts = new Options();
        opts.addOption( "g", "gui-file", true, "destination GUI file path" );
        opts.addOption( "l", "log-file", true, "log file name" );
        opts.addOption( null, "open-win-file", true, "widget log file" );
        opts.addOption( "c", "config-file", true, "configuration file for the ripper defining terminal and ignored components/windows" );
        opts.addOption( "d", "delay", true, "delay between actions" );
        opts.addOption( "h", "help", false, "Print this message" );
    }

    public void parseArguments(String[] args) throws ParseException {
        PosixParser parser = new PosixParser();
        cmd = parser.parse( opts, args );

        if ( cmd.hasOption("help") ) {
            // Print help and exit with non-zero status code
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "RipperMain", opts );
            System.exit(1);
        }
        
        GUI_FILE = cmd.getOptionValue("gui-file", "GUITAR-Default.GUI");
        LOG_FILE = cmd.getOptionValue("log-file", Util.getTimeStamp()+".log");
        LOG_WIDGET_FILE = cmd.getOptionValue("open-win-file", "log_widget.xml");
        CONFIG_FILE = cmd.getOptionValue("config-file", "configuration.xml");
        DELAY = Integer.parseInt(cmd.getOptionValue("delay", "5000"));
    }

    public static String GUI_FILE;
    public static String LOG_FILE;
    public static String LOG_WIDGET_FILE;
    public static String CONFIG_FILE;
    public static int DELAY = 5000;
}
