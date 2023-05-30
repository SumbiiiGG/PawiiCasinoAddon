package me.casinoaddon.valuecalculator;

import net.labymod.main.LabyMod;
import net.minecraft.item.ItemStack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemValueScanner {
    public long determineValue(ItemStack stack) {
        if(stack == null){
            return 0;
        }
        return stack.stackSize * determineValueSingleItem(stack);
    }

    private long determineValueSingleItem(ItemStack stack) {
        String displayName = "Item 0$";
        try {
            displayName = stack.getDisplayName();
        } catch (Exception e) {

        }
        String sign = "0$";
        try {
            if(stack.getTagCompound() == null || stack.getTagCompound().getCompoundTag("display") == null || stack.getTagCompound().getCompoundTag("display").getTag("Lore") == null){
                return 0;
            }
            String[] lore = stack.getTagCompound().getCompoundTag("display").getTag("Lore").toString().split("\",");
            for (int i = 0; i < lore.length; i++) {
                if (lore[i].contains("Signiert von")) {
                    sign = lore[i - 1];
                    if(lore[i].contains("Anubis_CBE")){
                        sign = "0$";
                        displayName = stack.getDisplayName().replaceAll("§.", "").replace(" mio", "mio ").replace("mio","m").replaceAll("[^a-zA-Z0-9\\s$?!.,]", "");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long displayValue = getValueFromSting(displayName);
        long signValue = getValueFromSting(sign);
        return Math.max(signValue, displayValue);
    }

    Pattern pattern = Pattern.compile("\\b([0-9.]+)([kKmM]?)\\b");

    private long getValueFromSting(String s) {
        String check = s.toLowerCase().replaceAll("§.", "").replace(" mio", "mio ").replace("mio","m");
        Matcher matcher = pattern.matcher(check);
        long solution = 0;
        while (matcher.find()) {
            String matchedNumber = matcher.group(1);
            String suffix = "$";
            try {
                suffix = matcher.group(2).toLowerCase();
            }catch (Exception e){

            }
            double number = 0;
            try {
                number = Double.parseDouble(matchedNumber);
            } catch (Exception e) {

            }

            if (suffix.equalsIgnoreCase("k")) {
                number *= 1000;
            } else if (suffix.equalsIgnoreCase("m") || suffix.equalsIgnoreCase("mio")) {
                number *= 1000000;
            } else {
                try {
                    number = Double.parseDouble(matchedNumber.replace(",", "").replace(".", ""));
                }catch (Exception e){

                }
            }

            if (number > solution) {
                solution = (long) number;
            }
        }
        if (solution <= 9) {
            solution = 0;
        }
        return solution;
    }
}
