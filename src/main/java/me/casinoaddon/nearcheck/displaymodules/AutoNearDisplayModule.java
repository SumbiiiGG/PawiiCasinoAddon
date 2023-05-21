package me.casinoaddon.nearcheck.displaymodules;

import me.casinoaddon.CasinoAddon;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.ingamegui.moduletypes.SimpleTextModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

public class AutoNearDisplayModule extends SimpleTextModule {
    @Override
    public String[] getValues() {
        return CasinoAddon.getInstance().getAutoNearChecker().getPlayerValues();
    }

    @Override
    public String[] getDefaultValues() {
        return new String[0];
    }

    @Override
    public String[] getKeys() {
        return CasinoAddon.getInstance().getAutoNearChecker().getPlayerNameKeys();
    }

    @Override
    public String[] getDefaultKeys() {
        return new String[0];
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.REDSTONE);
    }

    @Override
    public void loadSettings() {

    }

    @Override
    public String getSettingName() {
        return "Auto-Near-Checker";
    }

    @Override
    public String getControlName() {
        return "Auto-Near-Checker";
    }

    @Override
    public String getDescription() {
        return "Zeigt dir eine Liste mit Spielern in deiner Nähe an";
    }
    @Override
    public ModuleCategory getCategory() {
        return ModuleCategoryRegistry.CATEGORY_INFO;
    }
    @Override
    public int getSortingId() {
        return 0;
    }
}
