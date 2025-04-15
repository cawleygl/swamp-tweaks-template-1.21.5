package bluesteel42.swamptweaks.mixin;

import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(EatGrassGoal.class)
public interface MobAccessor {
    @Accessor
    MobEntity getMob();
    @Accessor("mob")
    public void setMob(MobEntity mobValue);
}