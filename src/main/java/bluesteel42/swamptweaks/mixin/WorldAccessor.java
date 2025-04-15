package bluesteel42.swamptweaks.mixin;

import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(EatGrassGoal.class)
public interface WorldAccessor {
    @Accessor
    World getWorld();
    @Accessor("world")
    public void setWorld(World worldValue);

}