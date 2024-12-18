package dev.cammiescorner.laserdot.common.registry;

import dev.cammiescorner.laserdot.LaserDot;
import net.minecraft.entity.EntityType;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public class EntityTags {
	public static final TagKey<EntityType<?>> THIN_ENTITIES = TagKey.of(Registry.ENTITY_TYPE_KEY, LaserDot.id("thin_entities"));
}
