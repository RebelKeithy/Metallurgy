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

public class mod_Phosphorite
{
	public static final int meta = 0;
	
	public static Item phosphorite = (new UtilityItem(UtilityConfig.itemPhosphoriteID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(meta,1).setItemName("Phosphorite").setTabToDisplayOn(CreativeTabs.tabMaterials);
	public static Item phosphorus = (new UtilityItem(UtilityConfig.itemPhosphorousID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(meta,2).setItemName("Phosphorous").setTabToDisplayOn(CreativeTabs.tabMaterials);
	
	//Load Recipes
	public static void load()
	{
		ModLoader.addShapelessRecipe(new ItemStack(phosphorus, 1), new Object[] {phosphorite});
	}

}