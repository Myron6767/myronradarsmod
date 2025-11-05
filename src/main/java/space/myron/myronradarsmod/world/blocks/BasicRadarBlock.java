package space.myron.myronradarsmod.world.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import space.myron.myronradarsmod.registries.MRSBlockEntitites;
import space.myron.myronradarsmod.world.blocks.entitites.BasicRadarBlockEntity;

public class BasicRadarBlock extends BaseEntityBlock {

    public BasicRadarBlock(Properties prop) {
        super(prop);
    }
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
    @Override
    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return MRSBlockEntitites.baseradar.get().create(blockPos,blockState);
    }



    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (level.isClientSide) return null;

        // Здесь второй аргумент — ожидаемый тип BE (тот, что мы зарегистрировали).
        // Третий аргумент — BlockEntityTicker<? super MyBlockEntity>, поэтому передаём лямбду,
        // приводящую be к MyBlockEntity и вызывающую статический tick.
        BlockEntityTicker<BasicRadarBlockEntity> myTicker = (lvl, pos, st, be) -> be.tick();

        // Вызовем статический protected метод createTickerHelper (унаследован от BaseEntityBlock)
        return createTickerHelper(type, MRSBlockEntitites.baseradar.get(), myTicker);
    }
}


