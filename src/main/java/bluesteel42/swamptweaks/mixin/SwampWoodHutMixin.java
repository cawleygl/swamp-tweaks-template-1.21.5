package bluesteel42.swamptweaks.mixin;

import bluesteel42.swamptweaks.structure.SwampWoodHutGenerator;
import net.minecraft.structure.StructurePiecesCollector;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.SwampHutStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SwampHutStructure.class)
public class SwampWoodHutMixin {
	@Inject(method = "addPieces", at = @At("HEAD"), cancellable = true)
	private static void injected(StructurePiecesCollector collector, Structure.Context context, CallbackInfo ci) {
		collector.addPiece(new SwampWoodHutGenerator(context.random(), context.chunkPos().getStartX(), context.chunkPos().getStartZ()));
		ci.cancel();
	}
}

