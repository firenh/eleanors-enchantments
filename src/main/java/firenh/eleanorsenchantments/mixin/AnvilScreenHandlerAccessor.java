package firenh.eleanorsenchantments.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.screen.Property;
 
@Mixin(AnvilScreenHandler.class)
public interface AnvilScreenHandlerAccessor {
    @Accessor("levelCost")
    public Property getLevelCostProperty();

    @Accessor
    public int getRepairItemUsage();
    
    @Accessor("repairItemUsage")
    public void setRepairItemUsage(int repairItemUsage);
}
