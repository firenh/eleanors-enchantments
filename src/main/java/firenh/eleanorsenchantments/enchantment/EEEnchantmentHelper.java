package firenh.eleanorsenchantments.enchantment;

import org.apache.commons.lang3.mutable.MutableFloat;

import firenh.eleanorsenchantments.EleanorsEnchantments;
import firenh.eleanorsenchantments.registry.EEEnchantmentTags;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;

public class EEEnchantmentHelper {
    public static boolean hasUnravelling(ItemStack stack, LivingEntity user) {
        for (Entry<RegistryEntry<Enchantment>> entry : stack.getEnchantments().getEnchantmentEntries()) {
            if (entry.getKey().isIn(EEEnchantmentTags.DESTROYS_COBWEBS)) {
                return true;
            };
        }
 
        return false;
	}
}
