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
        boolean cursesPresent = false;

		for (Entry<RegistryEntry<Enchantment>> entry : component.getEnchantmentEntries()) {
            int newPower = EnchantmentPowerUtil.getEnchantmentLevels(entry.getKey(), entry.getIntValue());
            power += newPower;
            if (newPower < 0) cursesPresent = true;
        }
		
        if (power != 0 || cursesPresent) {
            tooltip.accept(
                Text.translatable("eleanorsenchantments.enchantment_levels", power, maxPower)
                .formatted(getTooltipColor(power, maxPower, cursesPresent))
            );
        }
    }

    private static Formatting getTooltipColor(int power, int maxPower, boolean cursesPresent) {
        if (power == maxPower) return Formatting.DARK_PURPLE;
        if (power > maxPower) return Formatting.LIGHT_PURPLE;
        if (power < 0) return Formatting.DARK_RED;
        if (power > maxPower / 2) return Formatting.BLUE;
        return Formatting.GRAY;
    }
}