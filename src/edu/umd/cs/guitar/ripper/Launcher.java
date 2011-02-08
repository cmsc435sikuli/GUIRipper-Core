package edu.umd.cs.guitar.ripper;

import java.lang.Class;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import org.kohsuke.args4j.CmdLineException;

public class Launcher {
    public static void main(String[] args) {
        try {
            // First argument is the name of the factory class
            if (args.length == 0) {
                throw new CmdLineException("Expected factory class as first argument");
            }
            
            try {
                // Retrieve plugin info from the command line
                Class class_ = Class.forName(args[0]);
                Constructor<PluginInfo> init = class_.getConstructor();
                PluginInfo plugin = init.newInstance();

                String[] pluginArgs = Arrays.copyOfRange(args, 1, args.length);
                RipperMain ripper =
                    PluginFactory.createRipper(pluginArgs, plugin);
                ripper.execute();
            } catch (ClassNotFoundException e) {
                throw new CmdLineException("Could not locate factory class");
            } catch (NoSuchMethodException e) {
                throw new CmdLineException("No such method");
            } catch (IllegalAccessException e) {
                throw new CmdLineException("Illegal access");
            } catch (InvocationTargetException e) {
                throw new CmdLineException("Invocation exception");
            } catch (InstantiationException e) {
                throw new CmdLineException("Invalid class launcher");
            }
        } catch (CmdLineException e) {
            // Crash and die fucker
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
