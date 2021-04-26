package com.ashvxmc.cuboiddungeon;

import com.ashvxmc.cuboiddungeon.renderer.DungeonSnakeEntityRenderer;
import com.ashvxmc.cuboiddungeon.renderer.MarsupialRatEntityRenderer;
import com.ashvxmc.cuboiddungeon.renderer.RheumSlimeEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class CuboidDungeonClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Register Entity renderers
        EntityRendererRegistry.INSTANCE.register(Cuboiddungeon.RHEUM_SLIME,(dispatcher, context) -> new RheumSlimeEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(Cuboiddungeon.MARSUPIAL_RAT, (dispatcher, context) -> new MarsupialRatEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(Cuboiddungeon.DUNGEON_SNAKE, (dispatcher, context) -> new DungeonSnakeEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(Cuboiddungeon.STONE_TALUS, (dispatcher, context) -> new DungeonSnakeEntityRenderer(dispatcher));
    }
}
