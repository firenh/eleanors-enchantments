package firenh.eleanorsenchantments.util;

import firenh.eleanorsenchantments.EleanorsEnchantments;
import firenh.eleanorsenchantments.mixin.AnvilScreenHandlerAccessor;
import firenh.eleanorsenchantments.mixin.ForgingScreenHandlerAccessor;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.AnvilScreenHandler;

public class AnvilUtil {
    public static boolean updateAnvilResult (AnvilScreenHandler screenHandler) {
        // EleanorsEnchantments.log("repairItemUsage: " + ((AnvilScreenHandlerAccessor)screenHandler).getRepairItemUsage());
        ((AnvilScreenHandlerAccessor)screenHandler).setRepairItemUsage(0);

        ItemStack outputItem = ((ForgingScreenHandlerAccessor)screenHandler).getOutput().getStack(0);
        int enchantingLevels = EnchantmentPowerUtil.getEnchantmentLevels(outputItem);
        // EleanorsEnchantments.LOGGER.info("enchantingLevels: " + enchantingLevels);
        if (enchantingLevels > 0 && enchantingLevels > EnchantmentPowerUtil.getMaxLevels()) {
            ((ForgingScreenHandlerAccessor) screenHandler).getOutput().setStack(0, ItemStack.EMPTY);
            ((AnvilScreenHandlerAccessor) screenHandler).getLevelCostProperty().set(-1);    
            return true;
        }

        outputItem.apply(DataComponentTypes.REPAIR_COST, 0, i -> 0);
        ((ForgingScreenHandlerAccessor) screenHandler).getOutput().setStack(0, outputItem);
        ((AnvilScreenHandlerAccessor) screenHandler).getLevelCostProperty().set(enchantingLevels > 0 ? enchantingLevels : 1);    
        return true;
    }
}
