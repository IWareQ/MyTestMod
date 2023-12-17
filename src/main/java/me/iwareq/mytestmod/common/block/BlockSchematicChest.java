package me.iwareq.mytestmod.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.iwareq.mytestmod.MyTestMod;
import me.iwareq.mytestmod.Tags;
import me.iwareq.mytestmod.common.CommonProxy;
import me.iwareq.mytestmod.common.block.tile.TileEntitySchematicChest;
import me.iwareq.mytestmod.common.tab.MyTestTab;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockSchematicChest extends BlockContainer {

    private IIcon sideIcon, frontIcon, topIcon;

    public BlockSchematicChest() {
        super(Material.cake);
        this.setBlockName("schematic_chest");
        this.setCreativeTab(MyTestTab.INSTANCE);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntitySchematicChest();
    }


    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
        this.topIcon = register.registerIcon(Tags.MODID + ":chest_top");
        this.sideIcon = register.registerIcon(Tags.MODID + ":chest_side");
        this.frontIcon = register.registerIcon(Tags.MODID + ":chest_front");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        if (side >= 2 && side <= 5) {
            if (meta == side || (meta == 0 && side == 3)) return frontIcon;
            return sideIcon;
        }

        return topIcon;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        int rotation = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        int[] meta = {2, 5, 3, 4};
        world.setBlockMetadataWithNotify(x, y, z, meta[rotation], 3);
    }

    @Override
    public boolean onBlockActivated(World worldIn, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ) {
        if (worldIn.isRemote) return true;

        TileEntity tile = worldIn.getTileEntity(x, y, z);
        if (tile instanceof TileEntitySchematicChest)
            player.openGui(MyTestMod.instance, CommonProxy.GUI_SCHEMATIC_CHEST, worldIn, x, y, z);

        return true;
    }
}
