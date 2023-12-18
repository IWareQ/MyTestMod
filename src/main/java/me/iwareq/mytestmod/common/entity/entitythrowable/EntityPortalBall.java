package me.iwareq.mytestmod.common.entity.entitythrowable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPortalBall extends EntityThrowable {

    public EntityPortalBall(World p_i1774_1_, EntityLivingBase p_i1774_2_)
    {
        super(p_i1774_1_, p_i1774_2_);
    }

    @Override
    protected void onImpact(MovingObjectPosition p_70184_1_) {

    }
}
