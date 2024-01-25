package me.iwareq.mytestmod.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.iwareq.mytestmod.MyTestMod;
import me.iwareq.mytestmod.common.CommonProxy;
import me.iwareq.mytestmod.common.block.tile.TileEntitySchematicChest;
import me.iwareq.mytestmod.common.tab.MyTestTab;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import static me.iwareq.mytestmod.MyTestMod.MOD_ID;

public class BlockSchematicChest extends BlockContainer {

    @SideOnly(Side.CLIENT)
    private IIcon icon;

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
        this.icon = register.registerIcon(MOD_ID + ":schematic_chest");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        return this.icon;
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
