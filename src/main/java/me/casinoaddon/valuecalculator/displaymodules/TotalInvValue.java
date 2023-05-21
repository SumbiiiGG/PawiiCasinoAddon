package me.casinoaddon.valuecalculator.displaymodules;

import me.casinoaddon.CasinoAddon;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.ingamegui.enums.EnumModuleFormatting;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

public class TotalInvValue extends SimpleModule {
    @Override
    public String getDisplayName() {
        return "Gesamt-Inv-Wert";
    }

    @Override
    public String getDisplayValue() {
        return CasinoAddon.getInstance().getValueCalculator().getTotalInvValue();
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
        return "Gesamt-Inv-Wert";
    }

    @Override
    public String getControlName() {
        return "Gesamt-Inv-Wert";
    }

    @Override
    public String getDescription() {
        return "Zeigt den Wert der Casino Gewinne in deinem Inventar + Im offenem Inventar an";
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
