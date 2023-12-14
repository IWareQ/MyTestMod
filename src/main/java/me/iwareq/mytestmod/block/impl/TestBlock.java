package me.iwareq.mytestmod.block.impl;

import me.iwareq.mytestmod.block.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TestBlock extends Block {

    public TestBlock() {
        super(Material.cake);
        this.setBlockName("Test block");
//        this.setCreativeTab(BlockRegistry.TABS);
        this.setCreativeTab(CreativeTabs.tabFood);
        this.setHardness(15F);
        this.setResistance(10F);
        this.setHarvestLevel("pickaxe", 3);
        this.setLightLevel(15F);
//        this.setBlockTextureName("mytestmod:TestBlock");
    }
}
