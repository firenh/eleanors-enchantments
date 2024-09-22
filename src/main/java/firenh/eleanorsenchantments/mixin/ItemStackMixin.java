package firenh.eleanorsenchantments.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import firenh.eleanorsenchantments.util.EnchantmentPowerUtil;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;

@Mixin(ItemStack.class)
public class ItemStackMixin {
    @Inject(at = @At("HEAD"), method = "getRarity", cancellable = true)
    public void getRarity(CallbackInfoReturnable<Rarity> info) {
        if (((ItemStack)(Object)this).hasEnchantments()) {
            Rarity rarity = ((ItemStack)(Object)this).getOrDefault(DataComponentTypes.RARITY, Rarity.COMMON);
            int level = EnchantmentPowerUtil.getEnchantmentLevels(((ItemStack)(Object)this));
            int maxLevels = EnchantmentPowerUtil.getMaxLevels();
            int rarityBoost = 0;

            if (level > maxLevels) rarityBoost = 3;
            else if (level == maxLevels) rarityBoost = 2;
            else if (level > maxLevels / 2) rarityBoost = 1;

            int newRarity = rarity.ordinal() + rarityBoost;
            if (newRarity > 3) newRarity = 3;
            info.setReturnValue(Rarity.values()[newRarity]);
        }
    }
}
