package bluesteel42.swamptweaks.mixin;

import net.minecraft.structure.SwampHutGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SwampHutGenerator.class)
public interface HasWitchAccessor {
    @Accessor
    boolean getHasWitch();
    @Accessor("hasWitch")
    public void setHasWitch(boolean hasWitchValue);
}