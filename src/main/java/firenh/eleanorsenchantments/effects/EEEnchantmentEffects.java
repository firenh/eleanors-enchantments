package firenh.eleanorsenchantments.effects;

import net.minecraft.enchantment.effect.AllOfEnchantmentEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EEEnchantmentEffects {
    public static void init() {
        Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, "all_of", AllOfEnchantmentEffects.EntityEffects.CODEC);
    }
}
