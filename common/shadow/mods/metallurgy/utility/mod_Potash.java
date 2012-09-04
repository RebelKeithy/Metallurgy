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

public class mod_Potash
{
	public static final int meta = 5;
	
	public static Item potash = (new UtilityItem(ConfigUtility.itemPotashID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(meta,1).setItemName("Potash").setTabToDisplayOn(CreativeTabs.tabMaterials);
	public static Item fertilizer = (new UtilityItemFertilizer(ConfigUtility.itemFertilizerID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(1,2).setItemName("Fertilizer").setTabToDisplayOn(CreativeTabs.tabMaterials);
	
	//Load Recipes
	public static void load()
	{
		ModLoader.addShapelessRecipe(new ItemStack(fertilizer, 4), new Object[] {mod_Phosphorite.phosphorus, mod_Magnesium.magnesium, potash});
	}

	

}