package shadow.mods.metallurgy.utility;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.MetallurgyWorldGenMinable;

import net.minecraft.client.Minecraft;
import net.minecraft.src.BaseMod;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;

public class mod_Saltpeter
{
	public static final int meta = 2;
	
	public static Item saltpeter = (new UtilityItem(ConfigUtility.itemSaltpeterID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(meta,1).setItemName("Saltpeter").setTabToDisplayOn(CreativeTabs.tabMaterials);
	
	//Load Recipes
	public static void load()
	{
		ModLoader.addShapelessRecipe(new ItemStack(Item.gunpowder, 4), new Object[] {new ItemStack(Item.coal, 1, 1), saltpeter, mod_Sulfur.sulfur});
	}
}