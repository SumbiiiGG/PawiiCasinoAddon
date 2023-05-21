package me.casinoaddon;

import me.casinoaddon.nearcheck.displaymodules.AutoNearDisplayModule;
import me.casinoaddon.nearcheck.AutoNearChecker;
import me.casinoaddon.valuecalculator.InvValueCalculator;
import me.casinoaddon.valuecalculator.displaymodules.InvValue;
import me.casinoaddon.valuecalculator.displaymodules.OpenInvValue;
import me.casinoaddon.valuecalculator.displaymodules.TotalInvValue;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.SettingsElement;

import java.util.List;

public class CasinoAddon extends LabyModAddon {
    private static CasinoAddon instance;
    InvValueCalculator valueCalculator;
    AutoNearChecker autoNearChecker;

    public AutoNearChecker getAutoNearChecker() {
        return autoNearChecker;
    }

    public InvValueCalculator getValueCalculator() {
        return valueCalculator;
    }

    public static CasinoAddon getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        autoNearChecker = new AutoNearChecker();
        valueCalculator = new InvValueCalculator();
        this.getApi().registerForgeListener(this);
        this.getApi().registerModule(new InvValue());
        this.getApi().registerModule(new OpenInvValue());
        this.getApi().registerModule(new TotalInvValue());
        this.getApi().registerModule(new AutoNearDisplayModule());
    }

    @Override
    public void loadConfig() {

    }

    @Override
    protected void fillSettings(List<SettingsElement> list) {

    }
}
