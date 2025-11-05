package space.myron.myronradarsmod.registries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import space.myron.myronradarsmod.Myronradarsmod;
import space.myron.myronradarsmod.world.blocks.BasicRadarBlock;

import static space.myron.myronradarsmod.Myronradarsmod.MODID;

public class MRSBlocks {
    private static final DeferredRegister<Block> blocks = DeferredRegister.create(ForgeRegistries.BLOCKS,MODID);

    public static void register(IEventBus bus){
        blocks.register(bus);
        Myronradarsmod.getLogger().info(MODID + "> Blocks registering...");
    }


    public static final RegistryObject<Block> baseradar = blocks.register("basicradarblock",()->new BasicRadarBlock(BlockBehaviour.Properties.of()));

}
