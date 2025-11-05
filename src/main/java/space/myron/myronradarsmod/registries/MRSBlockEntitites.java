package space.myron.myronradarsmod.registries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import space.myron.myronradarsmod.Myronradarsmod;
import space.myron.myronradarsmod.world.blocks.BasicRadarBlock;
import space.myron.myronradarsmod.world.blocks.entitites.BasicRadarBlockEntity;

import static space.myron.myronradarsmod.Myronradarsmod.MODID;

public class MRSBlockEntitites {
    private static final DeferredRegister<BlockEntityType<?>> blocksentities = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES,MODID);

    public static void register(IEventBus bus){
        blocksentities.register(bus);
        Myronradarsmod.getLogger().info(MODID + "> BlocksEntities registering...");
    }



    public static final RegistryObject<BlockEntityType<BasicRadarBlockEntity>>
            baseradar = blocksentities.register("basicradarblockentity",
            () -> BlockEntityType.Builder.of(
                    BasicRadarBlockEntity::new,
                    MRSBlocks.baseradar.get()
            ).build(null)
    );

}
