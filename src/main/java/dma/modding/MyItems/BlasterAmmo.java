package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlasterAmmo extends EntityThrowable
{
	float explosionRadius = 2;
    public BlasterAmmo(World par1World)
    {
        super(par1World);
    }
    public BlasterAmmo(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }
    public BlasterAmmo(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
    	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) 
    	{
    	    this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, true);            
    	}


}

