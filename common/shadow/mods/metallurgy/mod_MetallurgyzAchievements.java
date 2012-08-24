package shadow.mods.metallurgy;
/*package net.minecraft.src;
import java.util.Random;
import net.minecraft.src.forge.*;

public class mod_MetallurgyzAchievements extends BaseModMp
{	
	
		@MLProp(name="AchAdamantineID", info="The Achievement ID for obtaining Adamantine", min=0)
		public static int AchAdamantineID = 1741;
		@MLProp(name="AchBronzeID", info="The Achievement ID for obtaining Bronze", min=0)
		public static int AchBronzeID = 1730;
		@MLProp(name="AchCopperID", info="The Achievement ID for obtaining Copper", min=0)
		public static int AchCopperID = 1728;
		@MLProp(name="AchIronID", info="The Achievement ID for obtaining Iron", min=0)
		public static int AchIronID = 1731;
		@MLProp(name="AchManganeseID", info="The Achievement ID for obtaining Manganese", min=0)
		public static int AchManganeseID = 1732;
		@MLProp(name="AchMithrilID", info="The Achievement ID for obtaining Mithril", min=0)
		public static int AchMithrilID = 1739;
		@MLProp(name="AchOrichalcumID", info="The Achievement ID for obtaining Orichalcum", min=0)
		public static int AchOrichalcumID = 1740;
		@MLProp(name="AchSteelID", info="The Achievement ID for obtaining Steel", min=0)
		public static int AchSteelID = 1733;
		@MLProp(name="AchTinID", info="The Achievement ID for obtaining Tin", min=0)
		public static int AchTinID = 1729;
		
		@MLProp(name="AchZincID", info="The Achievement ID for obtaining Zinc", min=0)
		public static int AchZincID = 1748;
		@MLProp(name="AchBrassID", info="The Achievement ID for obtaining Brass", min=0)
		public static int AchBrassID = 1747;
		@MLProp(name="AchSilverID", info="The Achievement ID for obtaining Silver", min=0)
		public static int AchSilverID = 1742;
		@MLProp(name="AchGoldID", info="The Achievement ID for obtaining Gold", min=0)
		public static int AchGoldID = 1743;
		@MLProp(name="AchPlatinumID", info="The Achievement ID for obtaining Platinum", min=0)
		public static int AchPlatinumID = 1744;
		@MLProp(name="AchElectrumID", info="The Achievement ID for obtaining Electrum", min=0)
		public static int AchElectrumID = 1745;
		
		//Move to proper metals when they are implemented
		@MLProp(name="AchHepatizonID", info="The Achievement ID for obtaining Hepatizon", min=0)
		public static int AchHepatizonID = 1734;
		@MLProp(name="AchAngmallenID", info="The Achievement ID for obtaining Angmallen", min=0)
		public static int AchAngmallenID = 1735;
		@MLProp(name="AchQuicksilverID", info="The Achievement ID for obtaining Quicksilver", min=0)
		public static int AchQuicksilverID = 1736;
		@MLProp(name="AchGaladiumID", info="The Achievement ID for obtaining Galadium", min=0)
		public static int AchGaladiumID = 1737;
		@MLProp(name="AchCelenegilID", info="The Achievement ID for obtaining Celenegil", min=0)
		public static int AchCelenegilID = 1738;
		//
		
		public static Achievement AchMineAdamantine;
		public static Achievement AchMakeBronze;
		public static Achievement AchMineCopper;
		public static Achievement AchMineIron;
		public static Achievement AchMineManganese;
		public static Achievement AchMineMithril;
		public static Achievement AchMineOrichalcum;
		public static Achievement AchMakeSteel;
		public static Achievement AchMineTin;
		
		public static Achievement AchMineZinc;
		public static Achievement AchMakeBrass;
		public static Achievement AchMineSilver;
		public static Achievement AchMineGold;
		public static Achievement AchMinePlatinum;
		public static Achievement AchMakeElectrum;
		
		//Move to proper metals when they are implemented
		public static Achievement AchMakeHepatizon;
		public static Achievement AchMakeAngmallen;
		public static Achievement AchMakeQuicksilver;
		public static Achievement AchMakeGaladium;
		public static Achievement AchMakeCelenegil;
		//
	
	
	public void load(){
		AchMineCopper = (new Achievement(AchCopperID, "It Begins..", 8, 1, mod_MetallurgyOreCopper.CopperOre, AchievementList.buildBetterPickaxe)).setIndependent().registerAchievement();
		AchMineIron = (new Achievement(AchIronID, "Iron Man", 8, 2, mod_MetallurgyOreIron.IronOre, AchievementList.buildBetterPickaxe)).setIndependent().registerAchievement();
		AchMineManganese = (new Achievement(AchManganeseID, "Non-Toxic", 10, 2, mod_MetallurgyOreManganese.ManganeseOre, AchMineIron)).setIndependent().registerAchievement();
		AchMineMithril = (new Achievement(AchMithrilID, "To Kazud-dum!", 8, 3, mod_MetallurgyOreMithril.MithrilOre, AchievementList.buildBetterPickaxe)).setIndependent().registerAchievement();
		AchMineOrichalcum = (new Achievement(AchOrichalcumID, "Green is Good", 10, 3, mod_MetallurgyOreOrichalcum.OrichalcumOre, AchMineMithril)).setIndependent().registerAchievement();
		AchMineTin = (new Achievement(AchTinID, "Heartless", 10, 1, mod_MetallurgyOreTin.TinOre, AchMineCopper)).setIndependent().registerAchievement();
		AchMineAdamantine = (new Achievement(AchAdamantineID, "Hell yea!", 12, 3, mod_MetallurgyOreAdamantine.AdamantineOre, AchMineOrichalcum)).setIndependent().registerAchievement();
		AchMakeBronze = (new Achievement(AchBronzeID, "Nice Tan", 12, 1, mod_MetallurgyOreBronze.BronzeBar, AchMineTin)).setIndependent().registerAchievement();
		AchMakeSteel = (new Achievement(AchSteelID, "Real Steel", 12, 2, mod_MetallurgyOreSteel.SteelBar, AchMineManganese)).setIndependent().registerAchievement();
		
		AchMineZinc = (new Achievement(AchZincID, "Balanced Breakfast", 8, 5, mod_MetallurgyOreZinc.ZincOre, AchievementList.buildBetterPickaxe)).setIndependent().registerAchievement();
		AchMakeBrass = (new Achievement(AchBrassID, "High Ranking", 10, 5, mod_MetallurgyOreBrass.BrassBar, AchMineZinc)).setIndependent().registerAchievement();
		AchMineSilver = (new Achievement(AchSilverID, "Hi-yo Silver!", 12, 5, mod_MetallurgyOreSilver.SilverOre, AchMakeBrass)).setIndependent().registerAchievement();
		AchMineGold = (new Achievement(AchGoldID, "Golden Opportunity", 14, 5, mod_MetallurgyOreGold.GoldOre, AchMineSilver)).setIndependent().registerAchievement();
		AchMinePlatinum = (new Achievement(AchPlatinumID, "Going Platinum", 16, 5, mod_MetallurgyOrePlatinum.PlatinumOre, AchMineGold)).setIndependent().registerAchievement();
		AchMakeElectrum = (new Achievement(AchElectrumID, "Electrifying", 14, 6, mod_MetallurgyOreBrass.BrassBar, AchMineGold)).setIndependent().registerAchievement();
		
		//Move to proper metals when they are implemented
		AchMakeHepatizon = (new Achievement(AchHepatizonID, "Chopped Liver", 8, 4, mod_MetallurgyOreSteel.SteelBar, AchievementList.buildBetterPickaxe)).setIndependent().registerAchievement();
		AchMakeAngmallen = (new Achievement(AchAngmallenID, "Gold Plated", 10, 4, mod_MetallurgyOreSteel.SteelBar, AchMakeHepatizon)).setIndependent().registerAchievement();
		AchMakeQuicksilver = (new Achievement(AchQuicksilverID, "Not Mercury", 12, 4, mod_MetallurgyOreSteel.SteelBar, AchMakeAngmallen)).setIndependent().registerAchievement();
		AchMakeGaladium = (new Achievement(AchGaladiumID, "The Grass is Always Greener", 16, 4, mod_MetallurgyOreSteel.SteelBar, AchMakeQuicksilver)).setIndependent().registerAchievement();
		AchMakeCelenegil = (new Achievement(AchCelenegilID, "Minty!", 14, 4, mod_MetallurgyOreSteel.SteelBar, AchMakeGaladium)).setIndependent().registerAchievement();
		//
		
		ModLoader.AddAchievementDesc(AchMineAdamantine, "Hell Yea!", "Mine a vein of Adamantine Ore.");
		ModLoader.AddAchievementDesc(AchMakeBronze, "Nice Tan", "Make a Bronze Bar.");
		ModLoader.AddAchievementDesc(AchMineCopper, "It Begins..", "Mine a vein of Copper Ore.");
		ModLoader.AddAchievementDesc(AchMineIron, "Iron Man", "Mine a vein of Iron Ore.");
		ModLoader.AddAchievementDesc(AchMineManganese, "Non-Toxic", "Mine a vein of Manganese Ore.");
		ModLoader.AddAchievementDesc(AchMineMithril, "To Kazud-dum!", "Mine a vein of Mithril Ore.");
		ModLoader.AddAchievementDesc(AchMineOrichalcum, "Green is Good", "Mine a vein of Orichalcum Ore.");
		ModLoader.AddAchievementDesc(AchMakeSteel, "Real Steel", "Make a Steel Bar.");
		ModLoader.AddAchievementDesc(AchMineTin, "Heartless", "Mine a vein of Tin Ore.");
		
		ModLoader.AddAchievementDesc(AchMineZinc, "Balanced Breakfast", "Mine a vein of Zinc Ore.");
		ModLoader.AddAchievementDesc(AchMakeBrass, "High Ranking", "Make a Brass Bar.");
		ModLoader.AddAchievementDesc(AchMineSilver, "Hi-yo Silver!", "Mine a vein of Silver Ore.");
		ModLoader.AddAchievementDesc(AchMineGold, "Golden Opportunity", "Mine a vein of Gold Ore.");
		ModLoader.AddAchievementDesc(AchMinePlatinum, "Going Platinum", "Mine a vein of Platinum Ore.");
		ModLoader.AddAchievementDesc(AchMakeElectrum, "Electrifying", "Make an Electrum Bar.");
		
		//Move to proper metals when they are implemented
		ModLoader.AddAchievementDesc(AchMakeHepatizon, "Chopped Liver", "Make a Hepatizon Bar.");
		ModLoader.AddAchievementDesc(AchMakeAngmallen, "Gold Plated", "Make an Angmallen Bar.");
		ModLoader.AddAchievementDesc(AchMakeQuicksilver, "Not Mercury", "Make a Quicksilver Bar.");
		ModLoader.AddAchievementDesc(AchMakeGaladium, "The Grass is Always Greener", "Make a Galadium Bar.");
		ModLoader.AddAchievementDesc(AchMakeCelenegil, "Minty!", "Make a Celengil Bar.");
		//
	}

	public void TakenFromFurnace(EntityPlayer entityplayer, ItemStack itemstack)
	{
	        boolean flag = false;
	        if(itemstack.itemID == mod_MetallurgyOreBronze.BronzeBar.shiftedIndex)
	        {
	                entityplayer.addStat(AchMakeBronze, 1);
	                flag = true;
	        }
	        if(itemstack.itemID == mod_MetallurgyOreBrass.BrassBar.shiftedIndex)
	        {
	                entityplayer.addStat(AchMakeBrass, 1);
	                flag = true;
	        }
	        if(itemstack.itemID == mod_MetallurgyOreSteel.SteelBar.shiftedIndex)
	        {
	                entityplayer.addStat(AchMakeSteel, 1);
	                flag = true;
	        }
	}
	
	public String getVersion(){
		return "1.0.0"; 
	}
}*/