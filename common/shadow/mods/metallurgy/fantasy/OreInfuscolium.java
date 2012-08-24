package shadow.mods.metallurgy.fantasy;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.BC_CrusherRecipes;
import shadow.mods.metallurgy.MetallurgyItem;
import shadow.mods.metallurgy.MetallurgyWorldGenMinable;
import shadow.mods.metallurgy.RecipeHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class OreInfuscolium
{
		public static final int meta = 2;
	
		public static Item infuscoliumDust = (new MetallurgyItem(FantasyConfig.itemInfuscoliumDustID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,3).setItemName("InfuscoliumDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		public static Item infuscoliumBar = (new MetallurgyItem(FantasyConfig.itemInfuscoliumBarID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,4).setItemName("InfuscoliumBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		//Load Recipes
		public static void load()
		{

			//Smelting
			FurnaceRecipes.smelting().addSmelting(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(infuscoliumBar, 1));
			ModLoader.addSmelting(infuscoliumDust.shiftedIndex, new ItemStack(infuscoliumBar, 1));
			
			//Dust
			BC_CrusherRecipes.smelting().addCrushing(infuscoliumBar.shiftedIndex, new ItemStack(infuscoliumDust, 1));
			BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(infuscoliumDust, 2));

			FF_EssenceRecipes.essence().addEssenceAmount(infuscoliumBar.shiftedIndex, 2);
			
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyFantasy.brickMetals.blockID, meta, infuscoliumBar);

		    /*
		    //Rails!
			ModLoader.addRecipe(new ItemStack(Block.rail, 4), new Object[] {
				"X X", "X|X", "X X", Character.valueOf('X'), infuscoliumBar, Character.valueOf('|'), Item.stick
			});
			*/
		}


}