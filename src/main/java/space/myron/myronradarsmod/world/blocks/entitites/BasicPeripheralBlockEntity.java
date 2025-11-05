package space.myron.myronradarsmod.world.blocks.entitites;

import dan200.computercraft.api.peripheral.IPeripheral;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import space.myron.myronradarsmod.cct.PeripheralBase;

import java.util.function.Function;

import static dan200.computercraft.shared.Capabilities.CAPABILITY_PERIPHERAL;

public abstract class BasicPeripheralBlockEntity<
        P extends PeripheralBase,
        E extends BasicPeripheralBlockEntity<P, E>> extends BlockEntity {

    protected final P peripheral;
    private LazyOptional<IPeripheral> peripheralCap;

    protected BasicPeripheralBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state,
                                         Function<E, P> peripheralFactory) {
        super(type, pos, state);
        //noinspection unchecked
        this.peripheral = peripheralFactory.apply((E) this);
    }

    @Override
    @NotNull
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable net.minecraft.core.Direction side) {
        if (cap == CAPABILITY_PERIPHERAL) {
            if (peripheralCap == null) {
                peripheralCap = LazyOptional.of(() -> peripheral);
            }
            return peripheralCap.cast();
        }
        return super.getCapability(cap, side);
    }
    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        if (peripheralCap != null) peripheralCap.invalidate();
    }
}