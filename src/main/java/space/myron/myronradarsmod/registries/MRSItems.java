package space.myron.myronradarsmod.registries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import space.myron.myronradarsmod.Myronradarsmod;

import static space.myron.myronradarsmod.Myronradarsmod.MODID;

public class MRSItems {
    private static final DeferredRegister<Item> items = DeferredRegister.create(ForgeRegistries.ITEMS,MODID);

    public static void register(IEventBus bus){
        items.register(bus);
        Myronradarsmod.getLogger().info(MODID + "> Items registering...");
    }

    public static final RegistryObject<BlockItem> basicradarblockitem = items.register("basicradarblockitem",()->new BlockItem(MRSBlocks.baseradar.get(),new Item.Properties()));

}
