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
            int level = EnchantmentPowerUtil.getEnchantmentLevels(((ItemStack)(Object)this));
            if (level < EnchantmentPowerUtil.getMaxLevels()) info.setReturnValue(((ItemStack)(Object)this).getOrDefault(DataComponentTypes.RARITY, Rarity.COMMON));
            if (level == EnchantmentPowerUtil.getMaxLevels()) info.setReturnValue(Rarity.RARE);
            if (level > EnchantmentPowerUtil.getMaxLevels()) info.setReturnValue(Rarity.EPIC);
        }
    }
}
