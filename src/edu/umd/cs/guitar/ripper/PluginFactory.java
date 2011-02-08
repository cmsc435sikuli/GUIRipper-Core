package edu.umd.cs.guitar.ripper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.cli.ParseException;

public class PluginFactory {

    public static RipperMain createRipper(String[] args, PluginInfo plugin)
        throws ParseException, NoSuchMethodException, InstantiationException,
               IllegalAccessException, InvocationTargetException
    {
        // Find constructor for the configuration
        Constructor<GRipperConfiguration> pluginInit =
            plugin.configType().getConstructor();
        GRipperConfiguration configuration = pluginInit.newInstance();

        configuration.parseArguments(args);

        // Create the RipperMain with this configuration
        Constructor ripperInit =
            plugin.ripperType().getConstructor(GRipperConfiguration.class);
        return (RipperMain) ripperInit.newInstance(configuration);
    }

}
