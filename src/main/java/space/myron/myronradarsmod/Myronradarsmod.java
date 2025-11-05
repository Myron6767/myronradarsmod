package space.myron.myronradarsmod;

import com.mojang.logging.LogUtils;
import dan200.computercraft.api.ComputerCraftAPI;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import space.myron.myronradarsmod.registries.MRSBlockEntitites;
import space.myron.myronradarsmod.registries.MRSBlocks;
import space.myron.myronradarsmod.registries.MRSItems;

@Mod(Myronradarsmod.MODID)
public class Myronradarsmod {

    public static final String MODID = "myronradarsmod";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static Logger getLogger() {return LOGGER;}

    public Myronradarsmod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MRSBlockEntitites.register(modEventBus);
        MRSItems.register(modEventBus);
        MRSBlocks.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        // ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
