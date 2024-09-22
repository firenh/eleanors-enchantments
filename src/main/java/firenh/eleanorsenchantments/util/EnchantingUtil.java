package firenh.eleanorsenchantments.util;

import java.util.ArrayList;
import java.util.List;

import firenh.eleanorsenchantments.EleanorsEnchantments;
import net.minecraft.enchantment.EnchantmentLevelEntry;

public class EnchantingUtil {
    public static List<EnchantmentLevelEntry> generateEnchantments(List<EnchantmentLevelEntry> list, int level) {
        int power = 0;
        List<EnchantmentLevelEntry> newList = new ArrayList<>();

        for (EnchantmentLevelEntry entry : list) {
            int thisEntryPower = EnchantmentPowerUtil.getEnchantmentLevels(entry.enchantment, entry.level);

            if (power + thisEntryPower <= EnchantmentPowerUtil.getMaxLevels()) {
                power += thisEntryPower;
                newList.add(entry);
            } else {
                // EleanorsEnchantments.log("Overpowered enchantment!");
                break;
            }
        }

        if (power < level) {
            for (EnchantmentLevelEntry entry : list) {
                if (entry.level >= entry.enchantment.value().getMaxLevel()) continue;
                EnchantmentLevelEntry newEntry = new EnchantmentLevelEntry(entry.enchantment, entry.level + 1);

                if (power + EnchantmentPowerUtil.getEnchantmentLevels(entry.enchantment, entry.level) <= EnchantmentPowerUtil.getMaxLevels()) {
                    // EleanorsEnchantments.log("Powering up enchantment!");
                    entry = newEntry;
                }
            }
        }

        return newList;
    } 
}
