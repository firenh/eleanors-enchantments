package firenh.eleanorsenchantments.util;

import firenh.eleanorsenchantments.EleanorsEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class EEEnchantmentTags {
    public static final TagKey<Enchantment> EXCLUSIVE = of("exclusive");

    private static TagKey<Enchantment> of(String id) {
		return TagKey.of(RegistryKeys.ENCHANTMENT, EleanorsEnchantments.id(id));
	}
}
