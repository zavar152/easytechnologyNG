package zavar30.easytechnology.blocks.machines.double_furnace;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import zavar30.easytechnology.ETItems;

public class OrerylliumSlot  extends Slot
{
	public OrerylliumSlot(IInventory inventoryIn, int index, int xPosition, int yPosition)
	{
		super(inventoryIn, index, xPosition, yPosition);
	}

    public boolean isItemValid(ItemStack stack)
    {
        return isOreryllium(stack);
    }

    public int getItemStackLimit(ItemStack stack)
    {
        return isOreryllium(stack) ? 64 : super.getItemStackLimit(stack);
    }

    public static boolean isOreryllium(ItemStack stack)
    {
        return stack.getItem() == ETItems.oreryllium_ingot;
    }
}
