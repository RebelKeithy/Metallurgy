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
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0), null, new ItemStack(Item.appleRed, 8)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0), null, new ItemStack(Item.bread, 4)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0), null, new ItemStack(Item.chickenCooked, 8)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0), null, new ItemStack(Item.cookie, 10)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0), null, new ItemStack(Item.melon, 8)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0), null, new ItemStack(Item.arrow, 5)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 27, 0), null, new ItemStack(Item.flintAndSteel, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 27, 0), null, new ItemStack(Item.shears, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.chickenRaw, 17), null, new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.wheat, 17), null, new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.fishRaw, 12), null, new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Block.cloth, 21), null, new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0)));
		}
		else if(villager.getProfession() == 1) // Librarian
		{
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0), null, new ItemStack(Block.glass, 5)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 27, 0), null, new ItemStack(Block.bookShelf, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 10, 1), null, new ItemStack(Item.compass, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 10, 1), null, new ItemStack(Item.pocketSundial, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.paper, 29), null, new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.book, 14), null, new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.writableBook, 1), null, new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0)));
		}
		else if(villager.getProfession() == 2) // priest
		{
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0), null, new ItemStack(Item.expBottle, 4)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0), null, new ItemStack(Item.redstone, 4)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0), null, new ItemStack(Block.glowStone, 3)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 10, 1), null, new ItemStack(Item.eyeOfEnder, 1)));
		}
		if(villager.getProfession() == 3) // Blacksmith
		{
			
		}
		if(villager.getProfession() == 4) // Butcher
		{
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0), null, new ItemStack(Item.beefCooked, 7)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0), null, new ItemStack(Item.porkCooked, 7)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 27, 0), null, new ItemStack(Item.helmetLeather, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 27, 0), null, new ItemStack(Item.plateLeather, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 27, 0), null, new ItemStack(Item.legsLeather, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 27, 0), null, new ItemStack(Item.bootsLeather, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(mod_MetallurgyPrecious.Coin, 64, 0), null, new ItemStack(Item.saddle, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.beefRaw, 17), null, new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.porkRaw, 17), null, new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.coal, 23), null, new ItemStack(mod_MetallurgyPrecious.Coin, 9, 0)));
		}
	}

}
