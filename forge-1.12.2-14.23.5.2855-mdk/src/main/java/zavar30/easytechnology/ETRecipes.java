package zavar30.easytechnology;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;

public class ETRecipes
{
	private static String[] recipes = {"boer", "boer_col","boer_case","boer_main","boer_controller","boeryllium_block","seed_block","simple_pack",
			"golden_pack","boeryllium_pickaxe","boeryllium_sword","boeryllium_spade","boeryllium_axe","boeryllium_hoe","boeryllium_helmet",
			"boeryllium_chestplate","boeryllium_leggings","boeryllium_boots","seed","seed_golden","machine_controller"};
	
	public static void load()
	{ 
		FurnaceRecipes.instance().addSmelting(ETItems.boeryllium_ingot_raw, new ItemStack(ETItems.boeryllium_ingot), 1.0F);
		FurnaceRecipes.instance().addSmelting(ETItems.oreryllium_ingot_raw, new ItemStack(ETItems.oreryllium_ingot), 1.0F);
		
	  	for(int y = 0; y < recipes.length; y++)
	  	{
	  		CraftingHelper.register(new ResourceLocation(ETConstants.MODID, recipes[y]), (IRecipeFactory) (context, json) -> CraftingHelper.getRecipe(json, context));
	  	}
	}
}