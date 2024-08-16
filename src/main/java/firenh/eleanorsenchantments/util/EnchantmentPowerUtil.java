package firenh.eleanorsenchantments.util;

import firenh.eleanorsenchantments.EleanorsEnchantments;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.EnchantmentTags;

public class EnchantmentPowerUtil {
    public static final int LEVELS_FOR_MAX_ENCHANTMENT = 20;
    public static final int MAX_LEVELS = 50;

    public static int getEnchantmentLevels(ItemStack itemStack) {
        if (itemStack.isOf(Items.ENCHANTED_BOOK)) {
            // EleanorsEnchantments.LOGGER.info("is enchanted book!");
            return getEnchantmentLevels(itemStack.get(DataComponentTypes.STORED_ENCHANTMENTS));
        }

        if (!itemStack.hasEnchantments()) return -1;
        return getEnchantmentLevels(EnchantmentHelper.getEnchantments(itemStack));
    }

    public static int getEnchantmentLevels(ItemEnchantmentsComponent component) {
        int power = 0;

        for (Entry<RegistryEntry<Enchantment>> entry : component.getEnchantmentEntries()) {
            power += EnchantmentPowerUtil.getEnchantmentLevels(entry.getKey(), entry.getIntValue());
        }

        return power;
    }

    public static int getEnchantmentLevels(RegistryEntry<Enchantment> enchantment, int level) {
        int x = -(level - enchantment.value().getMaxLevel());
        int levels = (int) Math.ceil((double) LEVELS_FOR_MAX_ENCHANTMENT * Math.pow(2, -x));
        if (enchantment.isIn(EnchantmentTags.CURSE)) levels = -1 * (levels / 2);
        return levels;
    }

    public static int getMaxLevels() {
        return MAX_LEVELS;
    }
} 