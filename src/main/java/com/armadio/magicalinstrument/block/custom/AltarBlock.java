package com.armadio.magicalinstrument.block.custom;

import com.armadio.magicalinstrument.block.entity.AltarBlockEntity;
import com.armadio.magicalinstrument.block.entity.ModBlockEntities;
import com.armadio.magicalinstrument.entity.ModEntityTypes;
import com.armadio.magicalinstrument.entity.custom.DrummerEntity;
import com.armadio.magicalinstrument.entity.custom.OrcEntity;
import com.mojang.datafixers.types.templates.Tag;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.Random;

public class AltarBlock extends BaseEntityBlock {
    public AltarBlock(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE = Block.box(1.6, 0, 1.6, 14.4, 12.8, 14.4);

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new AltarBlockEntity(blockPos, blockState);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        BlockEntity entity = level.getBlockEntity(blockPos);
        if(entity instanceof AltarBlockEntity) {
            ItemStack itemStack = player.getItemInHand(interactionHand);
            if(itemStack.is(ItemStack.EMPTY.getItem()) && ((AltarBlockEntity) entity).shouldDrop()){
                activateRitual(level, blockPos.getX(), blockPos.getY(), blockPos.getZ());
                ((AltarBlockEntity) entity).resetInventory();
                return InteractionResult.SUCCESS;
            }
            if (itemStack.is(Items.NETHER_STAR) && !((AltarBlockEntity) entity).shouldDrop()) {
                ((AltarBlockEntity)entity).insertItem(itemStack);
                itemStack.setCount(itemStack.getCount()-1);
                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.FAIL;
    }




    private void activateRitual(Level level, int x, int y, int z) {
        RandomSource random = level.getRandom();
        float f1 = x + 0.5F;
        float f2 = y + 1.1F;
        float f3 = z + 0.5F;
        for (int i = 0; i < 100; i++) {
            float f4 = random.nextFloat() * 0.6F - 0.3F;
            float f5 = random.nextFloat() * -0.6F - -0.3F;
            level.addParticle(ParticleTypes.EFFECT, (double) (f1 + f4), (double) f2, (double) (f3 + f5), 0.0D, 0.0D, 0.0D);
            level.addParticle(ParticleTypes.INSTANT_EFFECT, (double) (f1 + f4), (double) f2, (double) (f3 + f5), 0.0D, 0.0D, 0.0D);
        }
        if(!level.isClientSide){
            double x1;
            double y1;
            double z1;
            BlockPos blockpos1;
            do {
                x1 = x + (random.nextDouble() - random.nextDouble()) * (double)3 + 0.5D;
                y1 = y + random.nextInt(3) - 1;
                z1 = z + (random.nextDouble() - random.nextDouble()) * (double)3 + 0.5D;
                blockpos1 = BlockPos.containing(x1, y1, z1);
            } while (level.noCollision(ModEntityTypes.DRUMMER.get().getAABB(x1, y1, z1)));
            DrummerEntity drummer = ModEntityTypes.DRUMMER.get().spawn((ServerLevel)level, blockpos1, MobSpawnType.TRIGGERED);
            if (drummer != null){
                drummer.spawn();
            }


            do {
                x1 = x + (random.nextDouble() - random.nextDouble()) * (double)3 + 0.5D;
                y1 = y + random.nextInt(3) - 1;
                z1 = z + (random.nextDouble() - random.nextDouble()) * (double)3 + 0.5D;
                blockpos1 = BlockPos.containing(x1, y1, z1);
            } while (level.noCollision(ModEntityTypes.ORC.get().getAABB(x1, y1, z1)));
            OrcEntity orc = ModEntityTypes.ORC.get().spawn((ServerLevel)level, blockpos1, MobSpawnType.TRIGGERED);
            if (orc != null){
                orc.spawn();
            }
        }
    }
}
