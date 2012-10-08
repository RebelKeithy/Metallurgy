package shadow.mods.metallurgy.precious;

import java.util.Random;

import shadow.mods.metallurgy.MetallurgyCore;
import shadow.mods.metallurgy.base.MetallurgyBaseMetals;

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
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 9, 0), new ItemStack(Item.appleRed, 8)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 9, 0), new ItemStack(Item.bread, 4)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 9, 0), new ItemStack(Item.chickenCooked, 8)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 9, 0), new ItemStack(Item.cookie, 10)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 9, 0), new ItemStack(Item.melon, 8)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 9, 0), new ItemStack(Item.arrow, 5)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 27, 0), new ItemStack(Item.flintAndSteel, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 27, 0), new ItemStack(Item.shears, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.chickenRaw, 17), new ItemStack(MetallurgyPrecious.Coin, 9, 0)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.wheat, 17), new ItemStack(MetallurgyPrecious.Coin, 9, 0)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.fishRaw, 12), new ItemStack(MetallurgyPrecious.Coin, 9, 0)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Block.cloth, 21), new ItemStack(MetallurgyPrecious.Coin, 9, 0)));
		}
		else if(villager.getProfession() == 1) // Librarian
		{
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 9, 0), new ItemStack(Block.glass, 5)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 27, 0), new ItemStack(Block.bookShelf, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 10, 1), new ItemStack(Item.compass, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 10, 1), new ItemStack(Item.pocketSundial, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.paper, 29), new ItemStack(MetallurgyPrecious.Coin, 9, 0)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.book, 14), new ItemStack(MetallurgyPrecious.Coin, 9, 0)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.writableBook, 1), new ItemStack(MetallurgyPrecious.Coin, 9, 0)));
		}
		else if(villager.getProfession() == 2) // priest
		{
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 9, 0), new ItemStack(Item.expBottle, 4)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 9, 0), new ItemStack(Item.redstone, 4)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 9, 0), new ItemStack(Block.glowStone, 3)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 10, 1), new ItemStack(Item.eyeOfEnder, 1)));
		}
		if(villager.getProfession() == 3) // Blacksmith
		{
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 9, 1), new ItemStack(Item.helmetDiamond, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 19, 1), new ItemStack(Item.plateDiamond, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 13, 1), new ItemStack(Item.legsDiamond, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 9, 1), new ItemStack(Item.bootsDiamond, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 13, 1), new ItemStack(Item.swordDiamond, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 11, 1), new ItemStack(Item.pickaxeDiamond, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 11, 1), new ItemStack(Item.axeDiamond, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 7, 1), new ItemStack(Item.shovelDiamond, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 7, 1), new ItemStack(Item.hoeDiamond, 1)));
			//Chain
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 6, 1), new ItemStack(Item.helmetChain, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 14, 1), new ItemStack(Item.plateChain, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 10, 1), new ItemStack(Item.legsChain, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 6, 1), new ItemStack(Item.bootsChain, 1)));
			//Iron
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 5, 1), new ItemStack(Item.helmetSteel, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 13, 1), new ItemStack(Item.plateSteel, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 9, 1), new ItemStack(Item.legsSteel, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 5, 1), new ItemStack(Item.bootsSteel, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 10, 1), new ItemStack(Item.swordSteel, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 8, 1), new ItemStack(Item.pickaxeSteel, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 7, 1), new ItemStack(Item.axeSteel, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 5, 1), new ItemStack(Item.shovelSteel, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 5, 1), new ItemStack(Item.hoeSteel, 1)));
			//Bars
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.ingotIron, 1, 0), new ItemStack(MetallurgyPrecious.Coin, 3, 1)));
			if(MetallurgyCore.hasBase)
			{
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyBaseMetals.ores.Bar[0], 5), new ItemStack(MetallurgyPrecious.Coin, 6, 0)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyBaseMetals.ores.Bar[1], 5), new ItemStack(MetallurgyPrecious.Coin, 6, 0)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyBaseMetals.alloys.Bar[0], 5), new ItemStack(MetallurgyPrecious.Coin, 12, 0)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyBaseMetals.ores.Bar[2], 5), new ItemStack(MetallurgyPrecious.Coin, 3, 1)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyBaseMetals.alloys.Bar[4], 5), new ItemStack(MetallurgyPrecious.Coin, 6, 1)));
				
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 3, 1), new ItemStack(MetallurgyBaseMetals.ores.Helmet[0], 1, 0)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 10, 1), new ItemStack(MetallurgyBaseMetals.ores.Plate[0], 1, 0)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 6, 1), new ItemStack(MetallurgyBaseMetals.ores.Legs[0], 1, 0)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 3, 1), new ItemStack(MetallurgyBaseMetals.ores.Boots[0], 1, 0)));
	
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 7, 1), new ItemStack(MetallurgyBaseMetals.ores.Sword[0], 1, 0)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 5, 1), new ItemStack(MetallurgyBaseMetals.ores.Pickaxe[0], 1, 0)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 4, 1), new ItemStack(MetallurgyBaseMetals.ores.Axe[0], 1, 0)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 2, 1), new ItemStack(MetallurgyBaseMetals.ores.Shovel[0], 1, 0)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 2, 1), new ItemStack(MetallurgyBaseMetals.ores.Hoe[0], 1, 0)));
	
				//Bronze
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 4, 1), new ItemStack(MetallurgyBaseMetals.alloys.Helmet[0], 1, 0)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 12, 1), new ItemStack(MetallurgyBaseMetals.alloys.Plate[0], 1, 0)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 8, 1), new ItemStack(MetallurgyBaseMetals.alloys.Legs[0], 1, 0)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 4, 1), new ItemStack(MetallurgyBaseMetals.alloys.Boots[0], 1, 0)));
	
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 9, 1), new ItemStack(MetallurgyBaseMetals.alloys.Sword[0], 1, 0)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 7, 1), new ItemStack(MetallurgyBaseMetals.alloys.Pickaxe[0], 1, 0)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 6, 1), new ItemStack(MetallurgyBaseMetals.alloys.Axe[0], 1, 0)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 4, 1), new ItemStack(MetallurgyBaseMetals.alloys.Shovel[0], 1, 0)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 4, 1), new ItemStack(MetallurgyBaseMetals.alloys.Hoe[0], 1, 0)));
	
				//Steel
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 7, 1), new ItemStack(MetallurgyBaseMetals.alloys.Helmet[4], 1, 4)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 15, 1), new ItemStack(MetallurgyBaseMetals.alloys.Plate[4], 1, 4)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 11, 1), new ItemStack(MetallurgyBaseMetals.alloys.Legs[4], 1, 4)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 7, 1), new ItemStack(MetallurgyBaseMetals.alloys.Boots[4], 1, 4)));
	
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 12, 1), new ItemStack(MetallurgyBaseMetals.alloys.Sword[4], 1)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 10, 1), new ItemStack(MetallurgyBaseMetals.alloys.Pickaxe[4], 1)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 9, 1), new ItemStack(MetallurgyBaseMetals.alloys.Axe[4], 1)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 7, 1), new ItemStack(MetallurgyBaseMetals.alloys.Shovel[4], 1)));
				recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 7, 1), new ItemStack(MetallurgyBaseMetals.alloys.Hoe[4], 1)));
			}
		}
		if(villager.getProfession() == 4) // Butcher
		{
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 9, 0), new ItemStack(Item.beefCooked, 7)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 9, 0), new ItemStack(Item.porkCooked, 7)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 27, 0), new ItemStack(Item.helmetLeather, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 27, 0), new ItemStack(Item.plateLeather, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 27, 0), new ItemStack(Item.legsLeather, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 27, 0), new ItemStack(Item.bootsLeather, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(MetallurgyPrecious.Coin, 64, 0), new ItemStack(Item.saddle, 1)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.beefRaw, 17), new ItemStack(MetallurgyPrecious.Coin, 9, 0)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.porkRaw, 17), new ItemStack(MetallurgyPrecious.Coin, 9, 0)));
			recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.coal, 23), new ItemStack(MetallurgyPrecious.Coin, 9, 0)));
		}
	}

}
