package space.myron.myronradarsmod.cct;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.List;

public class PeripheralBase implements IPeripheral {

    protected final List<IComputerAccess> connectedComputers = new ObjectArrayList<>();
    protected final String type;

    public PeripheralBase(String type) {
        this.type = type;
    }

    @Override
    public void detach(@Nullable IComputerAccess computer) {
        connectedComputers.remove(computer);
    }

    @Override
    public void attach(@Nonnull IComputerAccess computer) {
        connectedComputers.add(computer);
    }

    @Override
    public @NotNull String getType() {
        return this.type;
    }

    public boolean equals(IPeripheral iPeripheral) {
        return this == iPeripheral;
    }
}