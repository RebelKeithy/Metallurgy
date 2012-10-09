package shadow.mods.metallurgy;
import java.util.Random;
import java.util.Map;
import java.io.File;

import shadow.mods.metallurgy.*;
import shadow.mods.metallurgy.base.ConfigBase;
import shadow.mods.metallurgy.base.MetallurgyBaseMetals;
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

public class mod_Iron
{	
	public static final int meta = 2;

	public static Item IronDust = (new MetallurgyItem(CoreConfig.ItemIronDustID, "/shadow/Overrides.png")).setIconIndex(69).setItemName("IronDust").setCreativeTab(CreativeTabs.tabMaterials);

	public static void load()
	{

		//Smelting
		ModLoader.addSmelting(IronDust.shiftedIndex, new ItemStack(Item.ingotIron, 1));
			
		//Crusher
		BC_CrusherRecipes.smelting().addCrushing(Block.oreIron.blockID, new ItemStack(IronDust, 2));
		BC_CrusherRecipes.smelting().addCrushing(Item.ingotIron.shiftedIndex, new ItemStack(IronDust, 1));

		if(MetallurgyCore.hasFantasy)
			FF_EssenceRecipes.essence().addEssenceAmount(Item.ingotIron.shiftedIndex, 3);
		 
		//Bricks!
		//RecipeHelper.addBrickRecipes(mod_MetallurgyBaseMetals.BaseMetalsBrick.blockID, meta, Item.ingotIron);
	}
	
	
}