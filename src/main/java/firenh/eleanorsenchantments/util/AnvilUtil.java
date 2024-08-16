package firenh.eleanorsenchantments.util;

import firenh.eleanorsenchantments.mixin.AnvilScreenHandlerAccessor;
import firenh.eleanorsenchantments.mixin.ForgingScreenHandlerAccessor;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.AnvilScreenHandler;

public class AnvilUtil {
    public static boolean updateAnvilResult (AnvilScreenHandler screenHandler) {
        ItemStack outputItem = ((ForgingScreenHandlerAccessor)screenHandler).getOutput().getStack(0);
        int enchantingLevels = EnchantmentPowerUtil.getEnchantmentLevels(outputItem);
        // EleanorsEnchantments.LOGGER.info("enchantingLevels: " + enchantingLevels);
        if (enchantingLevels > EnchantmentPowerUtil.getMaxLevels()) {
            ((ForgingScreenHandlerAccessor) screenHandler).getOutput().setStack(0, ItemStack.EMPTY);
            ((AnvilScreenHandlerAccessor) screenHandler).getLevelCostProperty().set(-1);    
            return true;
        }

        ((AnvilScreenHandlerAccessor) screenHandler).getLevelCostProperty().set(enchantingLevels);    
        return true;
    }
}
