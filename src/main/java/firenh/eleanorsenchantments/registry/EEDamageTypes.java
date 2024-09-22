package firenh.eleanorsenchantments.registry;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class EEDamageTypes {
    public static final RegistryKey<DamageType> BRUTALUTY = of("brutality");

    private static RegistryKey<DamageType> of(String id) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.ofVanilla(id));
    }
}
