package edu.umd.cs.guitar.ripper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class PluginFactory {

    public static RipperMain createRipper(String[] args, PluginInfo plugin)
        throws CmdLineException, NoSuchMethodException,
               InstantiationException, IllegalAccessException,
               InvocationTargetException
    {
        // Find constructor for the configuration
        Constructor<GRipperConfiguration> pluginInit =
            plugin.configType().getConstructor();
        GRipperConfiguration configuration = pluginInit.newInstance();

        // Parse the command line arguments into this configuration
        CmdLineParser parser = new CmdLineParser(configuration);
        parser.parseArgument(args);

        // Create the RipperMain with this configuration
        Constructor<RipperMain> ripperInit =
            plugin.ripperType().getConstructor(GRipperConfiguration.class);
        return ripperInit.newInstance(configuration);
    }

}
