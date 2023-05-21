package me.casinoaddon.valuecalculator;

import me.casinoaddon.CasinoAddon;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.text.NumberFormat;
import java.util.Locale;

public class InvValueCalculator {
    private String invValue = "0";
    private String openInvValue = "0";
    private String totalInvValue = "0";
    NumberFormat numberFormat = NumberFormat.getInstance(Locale.GERMAN);
    ItemValueScanner scanner;


    public String getInvValue() {
        return invValue;
    }

    public String getOpenInvValue() {
        return openInvValue;
    }

    public String getTotalInvValue() {
        return totalInvValue;
    }

    public NumberFormat getNumberFormat() {
        return numberFormat;
    }

    public ItemValueScanner getScanner() {
        return scanner;
    }

    public int getCounter() {
        return counter;
    }

    public InvValueCalculator(){
        scanner = new ItemValueScanner();
        CasinoAddon.getInstance().getApi().registerForgeListener(this);
    }
    int counter = 0;
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        counter++;
        if (counter % 20 == 0) {
            long currentInvValue = 0;
            long currentTotalValue = 0;
            try {
                for (int i = 0; i< Minecraft.getMinecraft().thePlayer.openContainer.getInventory().size(); i++) {
                    ItemStack stack = Minecraft.getMinecraft().thePlayer.openContainer.getInventory().get(i);
                    try {
                        currentTotalValue += scanner.determineValue(stack);
                        if(i>=Minecraft.getMinecraft().thePlayer.openContainer.getInventory().size()-36){
                            currentInvValue += scanner.determineValue(stack);
                        }
                    } catch (Exception e) {

                    }
                }
            } catch (Exception e) {}
            totalInvValue = numberFormat.format(currentTotalValue) + "$";
            invValue = numberFormat.format(currentInvValue) + "$";
            openInvValue = numberFormat.format(currentTotalValue-currentInvValue) + "$";
            counter = 0;
        }
    }
}
