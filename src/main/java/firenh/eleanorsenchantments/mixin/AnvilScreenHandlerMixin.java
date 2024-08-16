package firenh.eleanorsenchantments.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import firenh.eleanorsenchantments.util.AnvilUtil;
import net.minecraft.screen.AnvilScreenHandler;

@Mixin(AnvilScreenHandler.class)
public class AnvilScreenHandlerMixin {
    @ModifyConstant(method = "updateResult", constant = @Constant(intValue = 40))
    private int injected(int value) {
		return Integer.MAX_VALUE;
	}

    @Inject(at = @At("RETURN"), method = "updateResult", cancellable = true)
    public void updateResult(CallbackInfo info) {
        AnvilUtil.updateAnvilResult((AnvilScreenHandler)(Object)this);
    }
}
