package firenh.eleanorsenchantments.util;

import java.util.ArrayList;
import java.util.List;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import firenh.eleanorsenchantments.EleanorsEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.DynamicRegistryManager;

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
                EleanorsEnchantments.log("Overpowered enchantment!");
                break;
            }
        }

        return newList;
    } 
}
