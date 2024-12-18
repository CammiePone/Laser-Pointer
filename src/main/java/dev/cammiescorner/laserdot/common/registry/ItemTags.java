package dev.cammiescorner.laserdot.common.registry;

import dev.cammiescorner.laserdot.LaserDot;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public class ItemTags {
	public static final TagKey<Item> LASER_POINTERS = TagKey.of(Registry.ITEM_KEY, LaserDot.id("laser_pointers"));
}
