package net.lipskiii.oneforall.block.custom;

import net.lipskiii.oneforall.block.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class NonFlammableRotatedPillarBlock extends RotatedPillarBlock {
    public NonFlammableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }


    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, Level level, BlockPos pos, Player player, ItemStack stack,
                                           ToolAction toolAction) {
        if(stack.getItem() instanceof AxeItem) {
            if(state.is(BlockInit.FIERY_LOG.get())) {
                return BlockInit.STRIPPED_FIERY_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(BlockInit.FIERY_WOOD.get())) {
                return BlockInit.STRIPPED_FIERY_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }
        return super.getToolModifiedState(state, level, pos, player, stack, toolAction);
    }
}
