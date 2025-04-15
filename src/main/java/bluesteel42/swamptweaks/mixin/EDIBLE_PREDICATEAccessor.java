package bluesteel42.swamptweaks.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.function.Predicate;

@Mixin(EatGrassGoal.class)
public interface EDIBLE_PREDICATEAccessor {
    @Accessor
    Predicate<BlockState> getEDIBLE_PREDICATE();
    @Accessor("EDIBLE_PREDICATE")
    public void setEDIBLE_PREDICATE(Predicate<BlockState> timerValue);

}