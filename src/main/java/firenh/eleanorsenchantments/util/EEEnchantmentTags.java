package firenh.eleanorsenchantments.util;

import firenh.eleanorsenchantments.EleanorsEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class EEEnchantmentTags {
    public static final TagKey<Enchantment> EXCLUSIVE = of("exclusive");
    public static final TagKey<Enchantment> MAX_LEVELS_075 = of("max_levels_075");
    public static final TagKey<Enchantment> MAX_LEVELS_125 = of("max_levels_125");
    public static final TagKey<Enchantment> MAX_LEVELS_150 = of("max_levels_150");

    private static TagKey<Enchantment> of(String id) {
		return TagKey.of(RegistryKeys.ENCHANTMENT, EleanorsEnchantments.id(id));
	}
}
