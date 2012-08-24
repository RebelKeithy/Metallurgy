package shadow.mods.metallurgy.fantasy;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.BC_CrusherRecipes;
import shadow.mods.metallurgy.MetallurgyItem;
import shadow.mods.metallurgy.MetallurgyWorldGenMinable;
import shadow.mods.metallurgy.RecipeHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class OreRubracium
{
		public static final int meta = 8;
	
		public static Item rubraciumDust = (new MetallurgyItem(FantasyConfig.itemRubraciumDustID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,3).setItemName("RubraciumDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		public static Item rubraciumBar = (new MetallurgyItem(FantasyConfig.itemRubraciumBarID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,4).setItemName("RubraciumBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
			
		//Load Recipes
		public static void load()
		{

			//Smelting
			FurnaceRecipes.smelting().addSmelting(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(rubraciumBar, 1));
			ModLoader.addSmelting(rubraciumDust.shiftedIndex, new ItemStack(rubraciumBar, 1));
			
			//Dust
			BC_CrusherRecipes.smelting().addCrushing(rubraciumBar.shiftedIndex, new ItemStack(rubraciumDust, 1));
			BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(rubraciumDust, 2));

			FF_EssenceRecipes.essence().addEssenceAmount(rubraciumBar.shiftedIndex, 2);
			
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyFantasy.brickMetals.blockID, meta, rubraciumBar);
			
		    /*
		    //Rails!
			ModLoader.addRecipe(new ItemStack(Block.rail, 4), new Object[] {
				"X X", "X|X", "X X", Character.valueOf('X'), rubraciumBar, Character.valueOf('|'), Item.stick
			});
			*/
		}


}