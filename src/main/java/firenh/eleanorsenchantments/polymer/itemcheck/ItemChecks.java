package firenh.eleanorsenchantments.polymer.itemcheck;

import eu.pb4.polymer.core.api.item.PolymerItemUtils;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;

public class ItemChecks {
    public static void init() {
        PolymerItemUtils.ITEM_CHECK.register(itemStack -> shouldGoThroughPolymer(itemStack));
    }

    public static boolean shouldGoThroughPolymer(ItemStack itemStack) {
        return hasEnchantments(itemStack);
    }

    public static boolean hasEnchantments(ItemStack itemStack) {
        return EnchantmentHelper.hasEnchantments(itemStack);
    }
}
