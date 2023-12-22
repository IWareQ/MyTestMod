package me.iwareq.mytestmod.common.entity.entitythrowable;

import me.iwareq.mytestmod.common.entity.entityhanging.EntityPortal;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPortalBall extends EntityThrowable {

    public EntityPortalBall(World world) {
        super(world);
    }

    public EntityPortalBall(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase);
    }

    @Override
    protected void onImpact(MovingObjectPosition position) {
        if(!worldObj.isRemote){
            worldObj.spawnEntityInWorld(new EntityPortal(this.worldObj, (int) posX, (int) posY, (int) posZ, position.sideHit));
        }
        this.setDead();
    }
}
