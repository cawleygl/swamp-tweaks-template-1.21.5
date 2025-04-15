package bluesteel42.swamptweaks.mixin;

import net.minecraft.entity.ai.goal.EatGrassGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(EatGrassGoal.class)
public interface TimerAccessor {
    @Accessor
    int getTimer();
    @Accessor("timer")
    public void setTimer(int timerValue);

}