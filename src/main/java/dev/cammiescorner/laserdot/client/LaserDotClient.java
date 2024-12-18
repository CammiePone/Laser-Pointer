package dev.cammiescorner.laserdot.client;

import dev.cammiescorner.laserdot.LaserDot;
import dev.cammiescorner.laserdot.client.particles.LaserDotParticle;
import dev.cammiescorner.laserdot.client.renderer.LaserItemRenderer;
import dev.cammiescorner.laserdot.common.items.LaserPointerItem;
import dev.cammiescorner.laserdot.common.registry.ModParticles;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.Item;
import net.minecraft.resource.ResourceType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.resource.loader.api.ResourceLoader;

public class LaserDotClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer mod) {
		for(Item item : Registry.ITEM) {
			if(item instanceof LaserPointerItem) {
				Identifier itemId = Registry.ITEM.getId(item);
				LaserItemRenderer itemRenderer = new LaserItemRenderer(itemId);
				ResourceLoader.get(ResourceType.CLIENT_RESOURCES).registerReloader(itemRenderer);
				BuiltinItemRendererRegistry.INSTANCE.register(item, itemRenderer);
				ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> {
					out.accept(new ModelIdentifier(LaserDot.id(itemId.getPath() + "_gui"), "inventory"));
					out.accept(new ModelIdentifier(LaserDot.id(itemId.getPath() + "_handheld"), "inventory"));
				});
			}
		}

		ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
			registry.register(LaserDot.id("particle/red_laser_dot"));
			registry.register(LaserDot.id("particle/green_laser_dot"));
			registry.register(LaserDot.id("particle/blue_laser_dot"));
			registry.register(LaserDot.id("particle/yellow_laser_dot"));
			registry.register(LaserDot.id("particle/purple_laser_dot"));
		}));

		ParticleFactoryRegistry.getInstance().register(ModParticles.RED_LASER_DOT, LaserDotParticle.Factory::new);
		ParticleFactoryRegistry.getInstance().register(ModParticles.GREEN_LASER_DOT, LaserDotParticle.Factory::new);
		ParticleFactoryRegistry.getInstance().register(ModParticles.BLUE_LASER_DOT, LaserDotParticle.Factory::new);
		ParticleFactoryRegistry.getInstance().register(ModParticles.YELLOW_LASER_DOT, LaserDotParticle.Factory::new);
		ParticleFactoryRegistry.getInstance().register(ModParticles.PURPLE_LASER_DOT, LaserDotParticle.Factory::new);
	}
}
