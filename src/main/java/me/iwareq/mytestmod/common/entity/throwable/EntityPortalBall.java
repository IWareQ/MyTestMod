package me.iwareq.mytestmod.common.entity.throwable;

import me.iwareq.mytestmod.annotation.RequiredForWork;
import me.iwareq.mytestmod.common.entity.hanging.EntityPortal;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPortalBall extends EntityThrowable {

    @RequiredForWork
    public EntityPortalBall(World p_i1776_1_) {
        super(p_i1776_1_);
    }

    public EntityPortalBall(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase);
    }

    @Override
    protected void onImpact(MovingObjectPosition position) {
        if (!worldObj.isRemote)
            worldObj.spawnEntityInWorld(new EntityPortal(this.worldObj, (int) posX, (int) posY, (int) posZ, position.sideHit));

        this.setDead();
    }
}
