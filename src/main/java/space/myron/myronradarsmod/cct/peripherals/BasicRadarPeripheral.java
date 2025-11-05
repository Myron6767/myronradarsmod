package space.myron.myronradarsmod.cct.peripherals;

import com.google.common.collect.Sets;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.impl.game.ships.PhysShipImpl;
import space.myron.myronradarsmod.cct.PeripheralBase;
import space.myron.myronradarsmod.world.blocks.entitites.BasicRadarBlockEntity;

import java.util.Objects;
import java.util.Set;

public class BasicRadarPeripheral extends PeripheralBase {

    private final BasicRadarBlockEntity radar;

    public BasicRadarPeripheral(BasicRadarBlockEntity te){
        super("mrs_radar");
        this.radar = te;
    }

    @LuaFunction
    public long getId(){
        if(radar.hasShip()){
            return radar.getShip().getId();
        }
        return -1;
    }
}
