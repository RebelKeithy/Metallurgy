package shadow.mods.metallurgy.base;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;

import net.minecraft.client.Minecraft;
import net.minecraft.src.BaseMod;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

public class OreManganese
{
	public static final int meta = 3;

	public static Item ManganeseDust = (new MetallurgyItem(BaseConfig.ItemManganeseDustID, "/shadow/MetallurgyBaseMetals.png")).setIconCoord(3,3).setItemName("ManganeseDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
	public static Item ManganeseBar = (new MetallurgyItem(BaseConfig.ItemManganeseBarID, "/shadow/MetallurgyBaseMetals.png")).setIconCoord(3,4).setItemName("ManganeseBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
	
	public static void load()
	{	
		//Smelting
		FurnaceRecipes.smelting().addSmelting(mod_MetallurgyBaseMetals.BaseMetalsVein.blockID, meta, new ItemStack(ManganeseBar, 1));
		ModLoader.addSmelting(ManganeseDust.shiftedIndex, new ItemStack(ManganeseBar, 1));
			
		//Crusher
		BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyBaseMetals.BaseMetalsVein.blockID, meta, new ItemStack(ManganeseDust, 2));
		BC_CrusherRecipes.smelting().addCrushing(ManganeseBar.shiftedIndex, new ItemStack(ManganeseDust, 1));

		if(mod_MetallurgyCore.hasFantasy)
			FF_EssenceRecipes.essence().addEssenceAmount(ManganeseBar.shiftedIndex, 3);
		 
		//Bricks!
		RecipeHelper.addBrickRecipes(mod_MetallurgyBaseMetals.BaseMetalsBrick.blockID, meta, ManganeseBar);
	}
	
	
}