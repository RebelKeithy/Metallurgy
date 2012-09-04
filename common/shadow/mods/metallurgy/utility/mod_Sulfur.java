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
import net.minecraftforge.oredict.OreDictionary;
public class mod_Sulfur
{
	public static final int meta = 1;
	
	public static Item sulfur = (new UtilityItem(ConfigUtility.itemSulfurID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(meta,1).setItemName("Sulfur").setTabToDisplayOn(CreativeTabs.tabMaterials);
	
	//Load Recipes
	public static void load()
	{
	}
}