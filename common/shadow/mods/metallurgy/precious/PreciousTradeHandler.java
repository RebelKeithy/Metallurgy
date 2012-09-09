package shadow.mods.metallurgy.precious;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.EntityVillager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MerchantRecipe;
import net.minecraft.src.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class PreciousTradeHandler implements IVillageTradeHandler {

	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
		if(villager.getProfession() == 0) // Farmer
		{
			
		}
		else if(villager.getProfession() == 1) // Librarian
		{
			
		}
		else if(villager.getProfession() == 2) // priest
		{
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 9, 1), null, new ItemStack(Item.expBottle, 4)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 9, 1), null, new ItemStack(Item.redstone, 4)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 9, 1), null, new ItemStack(Block.glowStone, 3)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 10, 1), null, new ItemStack(Item.eyeOfEnder, 1)));
		}
		if(villager.getProfession() == 3) // Blacksmith
		{
			
		}
		if(villager.getProfession() == 4) // Butcher
		{
			
		}
	}

}
