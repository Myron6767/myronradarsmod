package space.myron.myronradarsmod.world.blocks.entitites;

import dan200.computercraft.api.peripheral.IPeripheral;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import space.myron.myronradarsmod.cct.PeripheralBase;
import space.myron.myronradarsmod.cct.peripherals.BasicRadarPeripheral;
import space.myron.myronradarsmod.registries.MRSBlockEntitites;
import org.valkyrienskies.core.api.ships.ServerShip;
import space.myron.myronradarsmod.world.blocks.BasicRadarBlock;

import java.util.function.Function;

import static dan200.computercraft.shared.Capabilities.CAPABILITY_PERIPHERAL;


public class BasicRadarBlockEntity extends BasicPeripheralBlockEntity<BasicRadarPeripheral,BasicRadarBlockEntity> {



    public BasicRadarBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(MRSBlockEntitites.baseradar.get(), p_155229_, p_155230_,BasicRadarPeripheral::new);
    }

    private ServerShip ship = null;

    public boolean hasShip(){
        return ship != null;
    }
    public ServerShip getShip(){
        return ship;
    }
    public void tick() {
        assert getLevel() != null;
        if(getLevel().isClientSide) return;
        if(ship == null){
            ship = VSGameUtilsKt.getShipObjectManagingPos((ServerLevel) getLevel(), getBlockPos());


            getLevel().players().forEach((player) ->
                {player.sendSystemMessage(Component.literal("Шипа нету"));}
            );
        }else{
            getLevel().players().forEach((player) ->
                {player.sendSystemMessage(Component.literal("Шип есть"));}
            );
        }

    }
}
