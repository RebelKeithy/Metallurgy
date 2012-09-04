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

public class mod_Magnesium
{
	public static final int meta = 3;
	
	public static Item magnesium = (new UtilityItem(ConfigUtility.itemMagnesiumID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(meta,1).setItemName("Magnesium").setTabToDisplayOn(CreativeTabs.tabMaterials);
	
	//Load Recipes
	public static void load()
	{
	}
}