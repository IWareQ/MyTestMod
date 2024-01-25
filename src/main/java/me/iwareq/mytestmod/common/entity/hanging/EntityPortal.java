package me.iwareq.mytestmod.common.entity.hanging;

import me.iwareq.mytestmod.annotation.RequiredForWork;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityPortal extends EntityHanging {

    @RequiredForWork
    public EntityPortal(World p_i1588_1_) {
        super(p_i1588_1_);
    }

    public EntityPortal(World p_i1589_1_, int p_i1589_2_, int p_i1589_3_, int p_i1589_4_, int p_i1589_5_) {
        super(p_i1589_1_, p_i1589_2_, p_i1589_3_, p_i1589_4_, p_i1589_5_);
        this.setDirection(p_i1589_5_);
    }

    @Override
    public int getWidthPixels() {
        return 16;
    }

    @Override
    public int getHeightPixels() {
        return 32;
    }

    @Override
    public void onBroken(Entity p_110128_1_) {}

    @Override
    public void onCollideWithPlayer(EntityPlayer entityIn) {
        if (entityIn.getEntityWorld().isRemote) return;
        entityIn.timeUntilPortal = 20 * 5;
        entityIn.travelToDimension(-1);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        return true;
    }
}
