package firenh.eleanorsenchantments.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import firenh.eleanorsenchantments.enchantment.EEEnchantmentHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.CobwebBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(CobwebBlock.class)
public class CobwebBlockMixin {
    @Inject(at = @At("HEAD"), method = "onEntityCollision", cancellable = true)
    private void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo info) {
        if (entity instanceof LivingEntity livingEntity && EEEnchantmentHelper.hasUnravelling(livingEntity.getEquippedStack(EquipmentSlot.LEGS), livingEntity)) {
            world.breakBlock(pos, true, entity);
        }
    }
}
