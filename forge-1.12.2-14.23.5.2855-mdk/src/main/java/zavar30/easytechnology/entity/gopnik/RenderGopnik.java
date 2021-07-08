package zavar30.easytechnology.entity.gopnik;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import zavar30.easytechnology.ETConstants;

public class RenderGopnik extends RenderLiving<EntityGopnik>
{
	
	public RenderGopnik(RenderManager rendermanagerIn) 
	{
		super(rendermanagerIn, new ModelGopnik(), 1.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGopnik entity) 
	{
		return ETConstants.GOPNIK;
	}
	
	@Override
	protected float interpolateRotation(float prevYawOffset, float yawOffset, float partialTicks) 
	{
		return super.interpolateRotation(prevYawOffset, yawOffset, partialTicks);
	}
}
