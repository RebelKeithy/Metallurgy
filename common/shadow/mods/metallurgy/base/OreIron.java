package shadow.mods.metallurgy.base;
import java.util.Random;
import java.util.Map;
import java.io.File;

import shadow.mods.metallurgy.*;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;

import net.minecraft.src.BaseMod;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraft.client.Minecraft;
import net.minecraftforge.oredict.OreDictionary;

public class OreIron
{	
	public static final int meta = 2;

	public static Item IronDust = (new MetallurgyItem(BaseConfig.ItemIronDustID, "/shadow/MetallurgyBaseMetals.png")).setIconCoord(2,3).setItemName("IronDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
	public static void load()
	{

		//Smelting
		FurnaceRecipes.smelting().addSmelting(mod_MetallurgyBaseMetals.BaseMetalsVein.blockID, meta, new ItemStack(Item.ingotIron, 1));
		ModLoader.addSmelting(IronDust.shiftedIndex, new ItemStack(Item.ingotIron, 1));
			
		//Crusher
		BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyBaseMetals.BaseMetalsVein.blockID, meta, new ItemStack(IronDust, 2));
		BC_CrusherRecipes.smelting().addCrushing(Block.oreIron.blockID, new ItemStack(IronDust, 2));
		BC_CrusherRecipes.smelting().addCrushing(Item.ingotIron.shiftedIndex, new ItemStack(IronDust, 1));

		if(mod_MetallurgyCore.hasFantasy)
			FF_EssenceRecipes.essence().addEssenceAmount(Item.ingotIron.shiftedIndex, 3);
		 
		//Bricks!
		RecipeHelper.addBrickRecipes(mod_MetallurgyBaseMetals.BaseMetalsBrick.blockID, meta, Item.ingotIron);
	}
	
	
}