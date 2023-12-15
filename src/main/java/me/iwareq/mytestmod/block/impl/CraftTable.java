package me.iwareq.mytestmod.block.impl;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.iwareq.mytestmod.block.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class CraftTable extends Block {

    private IIcon sideIcon;
    private IIcon frontIcon;
    private IIcon topIcon;

    public CraftTable() {
        super(Material.cake);
        this.setBlockName("craft_table");
        this.setCreativeTab(BlockRegistry.TABS);
        this.setHardness(15F);
        this.setResistance(10F);
        this.setHarvestLevel("pickaxe", 3);
        this.setLightLevel(15F);
        this.setBlockTextureName("mytestmod:craftTableFront");
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister reg) {
        frontIcon = reg.registerIcon("mytestmod:craftTableFront");
        sideIcon = reg.registerIcon("mytestmod:craftTableSide");
        topIcon = reg.registerIcon("mytestmod:craftTableTop");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void onBlockPlacedBy(World worldIn, int x, int y, int z, EntityLivingBase placer, ItemStack itemIn) {
        super.onBlockPlacedBy(worldIn, x, y, z, placer, itemIn);

        int dir = (MathHelper.floor_double((double)(placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3);
        int[] r = {2, 5, 3, 4};
        worldIn.setBlockMetadataWithNotify(x, y, z, r[dir], 3);

    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        ForgeDirection dir = ForgeDirection.getOrientation(side);
        ForgeDirection blockDir = ForgeDirection.getOrientation(meta);

        if (side == 0 || side == 1) return topIcon;
        if (blockDir == dir) return frontIcon;
        return sideIcon;
    }
}
