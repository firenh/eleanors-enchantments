package firenh.eleanorsenchantments.mixin;

import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import firenh.eleanorsenchantments.util.TooltipUtil;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.item.Item;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

@Mixin(ItemEnchantmentsComponent.class)
public class ItemEnchantmentsComponentMixin {
    @Inject(at = @At("RETURN"), method = "appendTooltip")
    public void appendTooltip(Item.TooltipContext context, Consumer<Text> tooltip, TooltipType type, CallbackInfo info) {
        TooltipUtil.appendTooltip((ItemEnchantmentsComponent)(Object)this, context, tooltip, type);
    }

}
