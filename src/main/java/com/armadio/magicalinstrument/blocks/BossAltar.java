package com.armadio.magicalinstrument.blocks;

import com.armadio.magicalinstrument.MagicalInstrument;
import com.armadio.magicalinstrument.entity.EntityDrummer;
import com.armadio.magicalinstrument.entity.EntityOrc;
import com.armadio.magicalinstrument.lib.Reference;
import com.armadio.magicalinstrument.tileentities.TileEntityBossAltar;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by armaDio on 09/04/2015.
 */
public class BossAltar extends BlockContainer{
    //private TileEntityBossAltar tileEntity;
    private IIcon icon;

    public BossAltar(){
        super(Material.iron);

        //tileEntity = new TileEntityBossAltar();
        this.setHardness(1.5F);
        this.setResistance(5.0F);

        this.setBlockName("bossspawner");
        this.setStepSound(soundTypeAnvil);
        this.setCreativeTab(MagicalInstrument.instTab);
    }

    @Override
    public void registerBlockIcons(IIconRegister p_149651_1_) {
        icon = p_149651_1_.registerIcon(Reference.MOD_ID+":MusicAltarHitTexture");
    }

    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return icon;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        //tileEntity = new TileEntityBossAltar();
        return new TileEntityBossAltar();
    }

    @Override
    public boolean onBlockActivated(World p_149727_1_, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        TileEntityBossAltar tileEntity = ((TileEntityBossAltar) p_149727_1_.getTileEntity(x, y, z));
        if (player.isSneaking() && tileEntity.shouldDrop()) {
            dropBlockAsItem(p_149727_1_, x, y, z, tileEntity.getStackInSlot(0));
            tileEntity.resetInventory();
        } else if (player.getHeldItem() == null && tileEntity.shouldDrop()) {
            activateRitual(p_149727_1_, x, y, z, player.getRNG());
            tileEntity.resetInventory();
        } else if (player.getHeldItem() != null && player.getHeldItem().getUnlocalizedName().equals(Items.nether_star.getUnlocalizedName()) && !tileEntity.shouldDrop()) {
            tileEntity.setInventorySlotContents(0, new ItemStack(player.getCurrentEquippedItem().getItem(), 1));
            player.inventory.consumeInventoryItem(player.getHeldItem().getItem());
        }
        return super.onBlockActivated(p_149727_1_, x, y, z, player, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
    }

    @SideOnly(Side.CLIENT)
    private void activateRitual(World world, int x, int y, int z, Random random) {
        float f1 = x + 0.5F;
        float f2 = y + 1.1F;
        float f3 = z + 0.5F;
        for (int i = 0; i < 100; i++) {
            float f4 = random.nextFloat() * 0.6F - 0.3F;
            float f5 = random.nextFloat() * -0.6F - -0.3F;
            world.spawnParticle("spell", (double) (f1 + f4), (double) f2, (double) (f3 + f5), 0.0D, 0.0D, 0.0D);
            world.spawnParticle("instantSpell", (double) (f1 + f4), (double) f2, (double) (f3 + f5), 0.0D, 0.0D, 0.0D);
        }
        if(!world.isRemote) {

            Entity drummer = new EntityDrummer(world);
            drummer.setPosition(x+random.nextInt(3),y+2,z+random.nextInt(3));
            world.spawnEntityInWorld(drummer);
            Entity orc = new EntityOrc(world);
            orc.setPosition(x-random.nextInt(3),y+2,z-random.nextInt(3));
            world.spawnEntityInWorld(orc);
        }
    }

    @Override
    public boolean addHitEffects(World worldObj, MovingObjectPosition target, EffectRenderer effectRenderer) {
        return super.addHitEffects(worldObj, target, effectRenderer);
    }

    @Override
    public void onBlockPreDestroy(World p_149725_1_, int x, int y, int z, int p_149725_5_) {
        TileEntityBossAltar tileEntity = ((TileEntityBossAltar)p_149725_1_.getTileEntity(x,y,z));
        if(tileEntity.shouldDrop()){
            dropBlockAsItem(p_149725_1_, x, y, z, tileEntity.getStackInSlot(0));
        }
        super.onBlockPreDestroy(p_149725_1_, x, y, z, p_149725_5_);
    }
}
