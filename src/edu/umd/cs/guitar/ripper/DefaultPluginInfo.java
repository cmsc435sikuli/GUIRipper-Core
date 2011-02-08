package edu.umd.cs.guitar.ripper;

public class DefaultPluginInfo implements PluginInfo {

    public Class<GRipperConfiguration> configType() {
        return GRipperConfiguration.class;
    }

    public Class<RipperMain> ripperType() {
        return RipperMain.class;
    }

}
