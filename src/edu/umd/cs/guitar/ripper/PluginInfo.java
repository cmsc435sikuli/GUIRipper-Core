package edu.umd.cs.guitar.ripper;

import java.lang.Class;

public interface PluginInfo {
    public Class<GRipperConfiguration> configType();
    public Class<RipperMain> ripperType();
}
