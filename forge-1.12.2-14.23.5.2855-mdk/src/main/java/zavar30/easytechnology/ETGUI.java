package zavar30.easytechnology;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import zavar30.easytechnology.blocks.machines.double_furnace.ContainerDoubleFurnace;
import zavar30.easytechnology.blocks.machines.double_furnace.DoubleFurnaceTileEntity;
import zavar30.easytechnology.blocks.machines.double_furnace.GUIDoubleFurnace;

public class ETGUI implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == ETConstants.DOUBLE_FURN_GUI) return new ContainerDoubleFurnace(player.inventory, (DoubleFurnaceTileEntity)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}

	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == ETConstants.DOUBLE_FURN_GUI) return new GUIDoubleFurnace(player.inventory, (DoubleFurnaceTileEntity)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}

	public static void load()
	{
	    NetworkRegistry.INSTANCE.registerGuiHandler(EasyTechnology.instance, new ETGUI());
	}
}
