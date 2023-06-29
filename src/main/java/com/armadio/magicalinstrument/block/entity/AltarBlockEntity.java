package com.armadio.magicalinstrument.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;

public class AltarBlockEntity extends BlockEntity {
    ItemStackHandler itemHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot){
            setChanged();
        }
    };


    public AltarBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.ALTAR.get(), blockPos, blockState);
        itemHandler.insertItem(0, Items.AIR.getDefaultInstance(), false);
    }


    @Override
    protected void saveAdditional(CompoundTag nbt){
        nbt.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt){
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
    }

    public boolean insertItem(ItemStack itemStack){
        if(this.itemHandler.getStackInSlot(0).is(Items.AIR)){
            this.itemHandler.setStackInSlot(0, itemStack.copyWithCount(1));
            return true;
        }else{
            return false;
        }
    }

    public boolean shouldDrop(){
        return itemHandler.getStackInSlot(0).is(Items.NETHER_STAR);
    }

    public void resetInventory(){
        itemHandler.setStackInSlot(0,new ItemStack(Items.AIR));
    }

}
