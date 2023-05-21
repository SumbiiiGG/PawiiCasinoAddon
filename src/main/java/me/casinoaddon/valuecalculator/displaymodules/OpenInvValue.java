package me.casinoaddon.valuecalculator.displaymodules;

import me.casinoaddon.CasinoAddon;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

public class OpenInvValue extends SimpleModule {
    @Override
    public String getDisplayName() {
        return "Offenes-Inv-Wert";
    }

    @Override
    public String getDisplayValue() {
        return CasinoAddon.getInstance().getValueCalculator().getOpenInvValue();
    }

    @Override
    public String getDefaultValue() {
        return "0$";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.PAPER);
    }

    @Override
    public void loadSettings() {

    }

    @Override
    public String getSettingName() {
        return "Offenes-Inv-Wert";
    }

    @Override
    public String getControlName() {
        return "Offenes-Inv-Wert";
    }

    @Override
    public String getDescription() {
        return "Zeigt den wert des Inventares an das du gerade geöffnet hast (z.B. eine Kiste oder ein /invsee)";
    }

    @Override
    public int getSortingId() {
        return 0;
    }
    @Override
    public ModuleCategory getCategory() {
        return ModuleCategoryRegistry.CATEGORY_INFO;
    }
}
