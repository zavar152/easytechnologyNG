package zavar30.easytechnology.blocks.machines.double_furnace;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DoubleFurnaceTileEntity extends TileEntityLockable implements ITickable, ISidedInventory
{
	private NonNullList<ItemStack> furnaceItemStacks = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);
	
	private int burnTime;
	private int currentBurnTime;
	private int cookTime;
	private int totalCookTime;
	private int count = 0;
	private boolean stop = false;
	
	private String customName;
	
	@Override
	public int getSizeInventory() 
	{
		return this.furnaceItemStacks.size();
	}

	@Override
	public boolean isEmpty() 
	{
		for(ItemStack stack : this.furnaceItemStacks)
		{
			if(!stack.isEmpty()) return false;
		}
		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index) 
	{
		return this.furnaceItemStacks.get(index);
	}

	@Nullable
	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		return ItemStackHelper.getAndSplit(this.furnaceItemStacks, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) 
	{
		return ItemStackHelper.getAndRemove(this.furnaceItemStacks, index);
	}
	
	@Override
	public void setInventorySlotContents(int index, ItemStack stack)
	{
		ItemStack itemstack = (ItemStack)this.furnaceItemStacks.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
		this.furnaceItemStacks.set(index, stack);
		
		if(stack.getCount() > this.getInventoryStackLimit())
		{
			stack.setCount(this.getInventoryStackLimit());
		}
		if(index == 0 && !flag)
		{
			this.totalCookTime = this.getCookTime(stack);
			this.cookTime = 0;
			this.markDirty();
		}
	}

    public int getCookTime(@Nullable ItemStack stack)
    {
        return 200;
    }
	
	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) 
	{
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory(EntityPlayer player) 
	{
		
	}

	@Override
	public void closeInventory(EntityPlayer player)
	{
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) 
	{
        if (index == 2)
        {
            return false;
        }
        else if (index != 1)
        {
            return true;
        }
        else
        {
            ItemStack itemstack = this.furnaceItemStacks.get(index);
            return isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack) && (itemstack == ItemStack.EMPTY || itemstack.getItem() != Items.BUCKET);
        }
	}

    public static boolean isItemFuel(ItemStack stack)
    {
        return getItemBurnTime(stack) > 0;
    }
    
    @SuppressWarnings({ "deprecation" })
	public static int getItemBurnTime(ItemStack fuel) 
	{
		if(fuel.isEmpty()) return 0;
		else 
		{
			Item item = fuel.getItem();

			if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR) 
			{
				Block block = Block.getBlockFromItem(item);

				if (block == Blocks.WOODEN_SLAB) return 150;
				if (block.getDefaultState().getMaterial() == Material.WOOD) return 300;
				if (block == Blocks.COAL_BLOCK) return 16000;
			}

			if (item instanceof ItemTool && "WOOD".equals(((ItemTool)item).getToolMaterialName())) return 200;
			if (item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName())) return 200;
			if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe)item).getMaterialName())) return 200;
			if (item == Items.STICK) return 100;
			if (item == Items.COAL) return 1600;
			if (item == Items.LAVA_BUCKET) return 20000;
			if (item == Item.getItemFromBlock(Blocks.SAPLING)) return 100;
			if (item == Items.BLAZE_ROD) return 2400;

			return GameRegistry.getFuelValue(fuel);
		}
	}
	
	@Override
	public int getField(int id) 
	{
		switch (id)
        {
            case 0:
                return this.burnTime;
            case 1:
                return this.currentBurnTime;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }
	}

	@Override
	public void setField(int id, int value) 
	{
		 switch (id)
	        {
	            case 0:
	                this.burnTime = value;
	                break;
	            case 1:
	                this.currentBurnTime = value;
	                break;
	            case 2:
	                this.cookTime = value;
	                break;
	            case 3:
	                this.totalCookTime = value;
	        }
	}

	@Override
	public int getFieldCount() 
	{
		return 4;
	}

	@Override
	public void clear() 
	{
        for (int i = 0; i < this.furnaceItemStacks.size(); ++i)
        {
            this.furnaceItemStacks.set(i, ItemStack.EMPTY);
        }
	}

	@Override
	public String getName() 
	{
		return this.hasCustomName() ? this.customName : "container.double_furnace";
	}

	@Override
	public boolean hasCustomName() 
	{
		return this.customName != null && !this.customName.isEmpty();
	}

	public void setCustomName(String customName) 
	{
		this.customName = customName;
	}
	
	@Override
	public ITextComponent getDisplayName() 
	{
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}
	
	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) 
	{
		return new ContainerDoubleFurnace(playerInventory, this);
	}

	@Override
	public String getGuiID() 
	{
		return "easytechnology:double_furnace";
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) 
	{
		return null;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) 
	{
		return this.isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) 
	{
		 if (direction == EnumFacing.DOWN && index == 1)
	        {
	            Item item = stack.getItem();
	            if (item != Items.WATER_BUCKET && item != Items.BUCKET)
	            {
	                return false;
	            }
	        }
	   return true;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
			super.readFromNBT(compound);
			this.furnaceItemStacks = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
			ItemStackHelper.loadAllItems(compound, this.furnaceItemStacks);
			this.burnTime = compound.getInteger("BurnTime");
			this.cookTime = compound.getInteger("CookTime");
			this.totalCookTime = compound.getInteger("CookTimeTotal");
			this.currentBurnTime = getItemBurnTime((ItemStack)this.furnaceItemStacks.get(2));
			
			if(compound.hasKey("CustomName", 8)) this.setCustomName(compound.getString("CustomName"));
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		super.writeToNBT(compound);
		compound.setInteger("BurnTime", (short)this.burnTime);
		compound.setInteger("CookTime", (short)this.cookTime);
		compound.setInteger("CookTimeTotal", (short)this.totalCookTime);
		ItemStackHelper.saveAllItems(compound, this.furnaceItemStacks);
		
		if(this.hasCustomName()) compound.setString("CustomName", this.customName);
		return compound;
	}
	
    public boolean isBurning()
    {
        return this.burnTime > 0;
    }

    @SideOnly(Side.CLIENT)
    public static boolean isBurning(IInventory inventory)
    {
        return inventory.getField(0) > 0;
    }
    
    @Override
	public void update() 
	{
        boolean flag1 = false;
        boolean flag = this.isBurning();

        if (this.isBurning())
        {
            --this.burnTime;
        }

        if (!this.world.isRemote)
        {
        	//System.out.println(stop);
            if (this.isBurning() || this.furnaceItemStacks.get(1) != ItemStack.EMPTY && this.furnaceItemStacks.get(0) != ItemStack.EMPTY && this.furnaceItemStacks.get(3) != ItemStack.EMPTY)
            {
                if (!this.isBurning() && this.canSmelt())
                {
                    this.burnTime = getItemBurnTime(this.furnaceItemStacks.get(1));
                    this.currentBurnTime = this.burnTime;

                    if (this.isBurning())
                    {
                        flag1 = true;

                        if (this.furnaceItemStacks.get(1) != ItemStack.EMPTY)
                        {
                            this.furnaceItemStacks.get(1).setCount(this.furnaceItemStacks.get(1).getCount()-1);
                            if (this.furnaceItemStacks.get(1).getCount() == 0)
                            {
                                this.furnaceItemStacks.set(1, furnaceItemStacks.get(1).getItem().getContainerItem(furnaceItemStacks.get(1)));
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt())
                {
                    ++this.cookTime;

                    if (this.cookTime == this.totalCookTime)
                    {
                        this.cookTime = 0;
                        this.totalCookTime = this.getCookTime(this.furnaceItemStacks.get(0));
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.cookTime = 0;
                }
            }
            else if (!this.isBurning() && this.cookTime > 0)
            {
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
            }
            if (flag != this.isBurning())
            {
                flag1 = true;
            	DoubleFurnaceBlock.setState(this.isBurning(), this.world, this.pos);
            }
        }
        if (flag1)
        {
            this.markDirty();
        }
	}
	
	private boolean canSmelt()
    {
        if (this.furnaceItemStacks.get(0) == ItemStack.EMPTY || this.furnaceItemStacks.get(3).isEmpty())
        {
            return false;
        }
        else
        {
            ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStacks.get(0));
            if (itemstack == ItemStack.EMPTY) return false;
            if (this.furnaceItemStacks.get(2) == ItemStack.EMPTY) return true;
            if (!this.furnaceItemStacks.get(2).isItemEqual(itemstack)) return false;
            int result = furnaceItemStacks.get(2).getCount() + itemstack.getCount();
            return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks.get(2).getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }
	
    public void smeltItem()
    {
    	if(this.furnaceItemStacks.get(3).isEmpty())
    	{
    		stop = true;
    	}
    	else
    	{
    		stop = false;
    	}
        if (this.canSmelt() && !stop)
        {
            ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStacks.get(0));
            count++;
            if(count == 4)
            {
            	this.furnaceItemStacks.get(3).shrink(1);
            	if(this.furnaceItemStacks.get(3).isEmpty())
            	{
            		stop = true;
            	}
            	else
            	{
            		stop = false;
            	}
            	count = 0;
            }
            if(this.furnaceItemStacks.get(2) == ItemStack.EMPTY)
            {
            	itemstack.setCount(itemstack.getCount()+1);
                this.furnaceItemStacks.set(2, itemstack.copy());
                itemstack.setCount(itemstack.getCount()-1);
            }
            else if(this.furnaceItemStacks.get(2).getItem() == itemstack.getItem())
            {
                this.furnaceItemStacks.get(2).setCount(this.furnaceItemStacks.get(2).getCount() + itemstack.getCount()*2); // Forge BugFix: Results may have multiple items
            }

            if (this.furnaceItemStacks.get(0).getItem() == Item.getItemFromBlock(Blocks.SPONGE) && this.furnaceItemStacks.get(0).getMetadata() == 1 && this.furnaceItemStacks.get(1) != ItemStack.EMPTY && this.furnaceItemStacks.get(1).getItem() == Items.BUCKET)
            {
                this.furnaceItemStacks.set(1, new ItemStack(Items.WATER_BUCKET));
            }

            this.furnaceItemStacks.get(0).setCount(this.furnaceItemStacks.get(0).getCount()-1);

            if (this.furnaceItemStacks.get(0).getCount() <= 0)
            {
                this.furnaceItemStacks.set(0, ItemStack.EMPTY);
            }
        }
    }
}
