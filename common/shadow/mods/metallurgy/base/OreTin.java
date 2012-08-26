package shadow.mods.metallurgy.base;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.BC_CrusherRecipes;
import shadow.mods.metallurgy.MetallurgyItem;
import shadow.mods.metallurgy.MetallurgyWorldGenMinable;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.mod_MetallurgyCore;
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
import net.minecraftforge.oredict.OreDictionary;

public class OreTin
{
	public static final int meta = 1;
	
	public static Item TinDust = (new MetallurgyItem(BaseConfig.ItemTinDustID, "/shadow/MetallurgyBaseMetals.png")).setIconCoord(1,3).setItemName("TinDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
	public static Item TinBar = (new MetallurgyItem(BaseConfig.ItemTinBarID, "/shadow/MetallurgyBaseMetals.png")).setIconCoord(1,4).setItemName("TinBar").setTabToDisplayOn(CreativeTabs.tabMaterials);

	public static void load() 
	{
		//Smelting
		FurnaceRecipes.smelting().addSmelting(mod_MetallurgyBaseMetals.BaseMetalsVein.blockID, meta, new ItemStack(TinBar, 1));
		ModLoader.addSmelting(TinDust.shiftedIndex, new ItemStack(TinBar, 1));
			
		//Crusher
		BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyBaseMetals.BaseMetalsVein.blockID, meta, new ItemStack(TinDust, 2));
		BC_CrusherRecipes.smelting().addCrushing(TinBar.shiftedIndex, new ItemStack(TinDust, 1));

		if(mod_MetallurgyCore.hasFantasy)
			FF_EssenceRecipes.essence().addEssenceAmount(TinBar.shiftedIndex, 1);
		 
		//Bricks!
		RecipeHelper.addBrickRecipes(mod_MetallurgyBaseMetals.BaseMetalsBrick.blockID, meta, TinBar);
	}
	
}