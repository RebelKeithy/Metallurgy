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

public class mod_Bitumen
{
	public static final int meta = 4;
	
	public static Item bitumen = (new UtilityItem(UtilityConfig.itemBitumenID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(meta,1).setItemName("Bitumen").setTabToDisplayOn(CreativeTabs.tabMaterials);
	public static Item tar = (new UtilityItem(UtilityConfig.itemTarID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(meta,2).setItemName("Tar").setTabToDisplayOn(CreativeTabs.tabMaterials);
	
	//Load Recipes
	public static void load()
	{
		ModLoader.addSmelting(bitumen.shiftedIndex, new ItemStack(tar, 1));
		
		ModLoader.addRecipe(new ItemStack(Block.pistonStickyBase, 1), new Object[] {
			"X", "|", Character.valueOf('X'), tar, Character.valueOf('|'), Block.pistonBase
		});
		ModLoader.addRecipe(new ItemStack(Item.magmaCream, 1), new Object[] {
			"X", "|", Character.valueOf('X'), tar, Character.valueOf('|'), Item.blazePowder
		});
	}
}