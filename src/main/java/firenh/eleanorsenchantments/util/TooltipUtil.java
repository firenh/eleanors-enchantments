package firenh.eleanorsenchantments.util;

import java.util.function.Consumer;

import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class TooltipUtil {
    public static void appendTooltip(ItemEnchantmentsComponent component, Item.TooltipContext context, Consumer<Text> tooltip, TooltipType type) {
        int maxPower = EnchantmentPowerUtil.getMaxLevels();
        int power = 0;

		for (Entry<RegistryEntry<Enchantment>> entry : component.getEnchantmentEntries()) {
            power += EnchantmentPowerUtil.getEnchantmentLevels(entry.getKey(), entry.getIntValue());
        }
		
        if (power > 0) {
            tooltip.accept(
                Text.translatable("eleanorsenchantments.enchantment_levels", power, maxPower)
                .formatted(getTooltipColor(power, maxPower))
            );
        }
    }

    private static Formatting getTooltipColor(int power, int maxPower) {
        if (power == maxPower) return Formatting.DARK_PURPLE;
        if (power > maxPower) return Formatting.LIGHT_PURPLE;
        return Formatting.GRAY;
    }
}