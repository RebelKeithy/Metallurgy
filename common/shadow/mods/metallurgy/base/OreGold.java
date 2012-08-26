package shadow.mods.metallurgy.base;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;

import net.minecraft.client.Minecraft;
import net.minecraft.src.BaseMod;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.oredict.OreDictionary;

public class OreGold
{
	public static final int meta = 4;
		
	public static Item GoldDust = (new MetallurgyItem(BaseConfig.ItemGoldDustID, "/shadow/MetallurgyBaseMetals.png")).setIconCoord(4,3).setItemName("GoldDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
	public static Item GoldCoin = (new MetallurgyItem(BaseConfig.ItemGoldCoinID, "/shadow/MetallurgyPreciousMetalsCoins.png")).setIconCoord(1,0).setItemName("GoldCoin").setTabToDisplayOn(CreativeTabs.tabMisc);
	public static Item GoldCoin9 = (new MetallurgyItem(BaseConfig.ItemGoldCoin9ID, "/shadow/MetallurgyPreciousMetalsCoins.png")).setIconCoord(1,1).setItemName("GoldCoin9").setTabToDisplayOn(CreativeTabs.tabMisc);
	public static Item GoldCoin81 = (new MetallurgyItem(BaseConfig.ItemGoldCoin81ID, "/shadow/MetallurgyPreciousMetalsCoins.png")).setIconCoord(1,2).setItemName("GoldCoin81").setTabToDisplayOn(CreativeTabs.tabMisc);
	
	public static void load()
	{
		
		//Coins
		ModLoader.addSmelting(GoldDust.shiftedIndex, new ItemStack(Item.ingotGold, 1));
		ModLoader.addSmelting(Item.ingotGold.shiftedIndex, new ItemStack(GoldCoin9, 1));
		ModLoader.addSmelting(GoldCoin9.shiftedIndex, new ItemStack(Item.ingotGold, 1));

		//Smelting
		FurnaceRecipes.smelting().addSmelting(mod_MetallurgyBaseMetals.BaseMetalsVein.blockID, meta, new ItemStack(Item.ingotGold, 1));
		ModLoader.addSmelting(GoldDust.shiftedIndex, new ItemStack(Item.ingotGold, 1));
			
		//Crusher
		BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyBaseMetals.BaseMetalsVein.blockID, meta, new ItemStack(GoldDust, 2));
		BC_CrusherRecipes.smelting().addCrushing(Item.ingotGold.shiftedIndex, new ItemStack(GoldDust, 1));

		if(mod_MetallurgyCore.hasFantasy)
			FF_EssenceRecipes.essence().addEssenceAmount(Item.ingotGold.shiftedIndex, 6);
		 
		RecipeHelper.addBrickRecipes(mod_MetallurgyBaseMetals.BaseMetalsBrick.blockID, meta, Item.ingotGold);
		
		RecipeHelper.addStorageRecipe(GoldCoin9, GoldCoin);
		RecipeHelper.addStorageRecipe(GoldCoin81, GoldCoin9);
	}
	
}