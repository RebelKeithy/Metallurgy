package shadow.mods.metallurgy.base;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import shadow.mods.metallurgy.BlockDoorMetal;
import shadow.mods.metallurgy.ItemDoorMetal;
import shadow.mods.metallurgy.MetalSet;
import shadow.mods.metallurgy.MetallurgyCore;
import shadow.mods.metallurgy.MetallurgyEnumToolMaterial;
import shadow.mods.metallurgy.MetallurgyItems;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.UpdateManager;
import shadow.mods.metallurgy.mod_Gold;
import shadow.mods.metallurgy.mod_Iron;
import shadow.mods.metallurgy.api.MetallurgyAPI;
import shadow.mods.metallurgy.mystcraft.TerrainSymbol;
import shadow.mods.metallurgy.precious.ConfigPrecious;
import shadow.mods.metallurgy.MetallurgyEnums;
import xcompwiz.mystcraft.api.APICallHandler;
/*
import weaponmod.EnumWeapon;
import weaponmod.ItemBattleAxe;
import weaponmod.ItemFlail;
import weaponmod.ItemHalberd;
import weaponmod.ItemKnife;
import weaponmod.ItemSpear;
import weaponmod.ItemWarhammer;
*/

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingSpecialSpawnEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

@Mod(modid = "MetallurgyBase", name = "Metallurgy Base", dependencies = "after:MetallurgyCore", version = "2.2.3")
@NetworkMod(channels = { "MetallurgyBase" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class MetallurgyBaseMetals {
	
	@SidedProxy(clientSide = "shadow.mods.metallurgy.base.ClientProxy", serverSide = "shadow.mods.metallurgy.base.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance( value = "MetallurgyBase" )
	public static MetallurgyBaseMetals instance;

	public static MetalSet alloys;
	public static MetalSet ores;
	
	public static Block metalFurnace;
	public static Block lantern;
	public static Block ladder;
	
	public static Item spear[] = new Item[7];
	public static Item halberd[] = new Item[7];
	public static Item knife[] = new Item[7];
	public static Item battleaxe[] = new Item[7];
	public static Item warhammer[] = new Item[7];
	public static Item flail[] = new Item[7];
	
	public static Item copperItemDoor;
	public static Block copperDoor;
	
	public static CreativeTabs baseTab;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigBase.init();
		
		//baseTab = MetallurgyCore.getNewCreativeTab("Base Metals", ConfigBase.ItemStartID);
		baseTab = MetallurgyCore.getNewCreativeTab("Base Metals", ConfigBase.ItemStartID + 256 + 150 + 7 + 50 * 4);
		
		alloys = new MetalSet(new AlloyBaseEnum());
		ores = new MetalSet(new OreBaseEnum());
		
		System.out.println("Door ids " + ConfigBase.doorID + " " + ConfigBase.itemDoorID);
		copperItemDoor = new ItemDoorMetal(ConfigBase.itemDoorID, Material.wood, ConfigBase.doorID);
		copperDoor = new BlockDoorMetal(ConfigBase.doorID, Material.wood, ConfigBase.itemDoorID);
		copperDoor.setTextureFile("/shadow/deco.png");
		copperDoor.blockIndexInTexture = 32;
		copperItemDoor.setIconIndex(43);
		

		metalFurnace = new BF_BlockMetalFurnace(ConfigBase.furnaceID, false).setHardness(3.5F).setBlockName("MetalFurnace");
		lantern = new BlockLantern(3010).setHardness(0.1F).setLightValue(0.9375F).setBlockName("Lantern").setCreativeTab(baseTab);
		ladder = new BlockMetalLadder(2011, 48).setBlockName("MetalLadder").setCreativeTab(baseTab);
		
		
		proxy.registerRenderInformation();
		
		MinecraftForge.EVENT_BUS.register(new FurnaceUpgradeRecipes());
		registerWithApi();
		
		
	}

	@Init
	public void load(FMLInitializationEvent event) 
	{
		try {
			Class mystcraftApi = Class.forName("xcompwiz.mystcraft.api.APICallHandler");
			Class ageSymbol = Class.forName("xcompwiz.mystcraft.api.symbol.AgeSymbol");
			Class oreSymbol = Class.forName("shadow.mods.metallurgy.mystcraft.OreSymbol");
			Constructor constructor = oreSymbol.getConstructor(new Class[]{MetalSet.class});
			Method registerSymbol = mystcraftApi.getMethod("registerSymbol", new Class[]{ageSymbol});
			registerSymbol.invoke(mystcraftApi, constructor.newInstance(ores));
		} catch(Exception e) {}
		
		GameRegistry.registerBlock(metalFurnace, shadow.mods.metallurgy.base.BF_BlockMetalFurnaceItem.class);

		GameRegistry.registerBlock(lantern, shadow.mods.metallurgy.base.ItemBlockLantern.class);
		GameRegistry.registerBlock(copperDoor);
		GameRegistry.registerBlock(ladder, shadow.mods.metallurgy.base.ItemBlockMetalLadder.class);
		
		GameRegistry.registerTileEntity(shadow.mods.metallurgy.base.TileEntityLantern.class, "Lantern");
		GameRegistry.registerTileEntity(BF_TileEntityMetalFurnace.class, "metalFurnace");
		
		alloys.load();
		ores.load();
		
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);

		if(ConfigBase.furnacesEnabled)
			FurnaceUpgradeRecipes.load();
		
		
		try {
			Class a = Class.forName("ic2.api.Ic2Recipes");
			ItemStack battery = ic2.api.Items.getItem("reBattery");
			ItemStack ingot = ic2.api.Items.getItem("refinedIronIngot");
			ItemStack generator = ic2.api.Items.getItem("generator");
			GameRegistry.addRecipe(generator, new Object[] {
    			" B ", "III", " F ", Character.valueOf('B'), battery, Character.valueOf('I'), ingot, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 2)
    		});
			GameRegistry.addRecipe(generator, new Object[] {
    			" B ", "III", " F ", Character.valueOf('B'), battery, Character.valueOf('I'), ingot, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 3)
    		});
			
			battery = ic2.api.Items.getItem("chargedReBattery");
			GameRegistry.addRecipe(generator, new Object[] {
	    			" B ", "III", " F ", Character.valueOf('B'), battery, Character.valueOf('I'), ingot, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 2)
	    		});
				GameRegistry.addRecipe(generator, new Object[] {
	    			" B ", "III", " F ", Character.valueOf('B'), battery, Character.valueOf('I'), ingot, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 3)
	    		});
				
		} catch(Exception e) {}
		
		addBalkonsWeapons();
		
		
		
		proxy.addNames();
		
		MetallurgyAPI.addCrusherRecipe(Item.appleRed.shiftedIndex, 0, new ItemStack(Block.dirt));
		MetallurgyAPI.addAbstractorRecipe(Item.appleRed.shiftedIndex, 0, 50);
		MetallurgyAPI.addAbstractorFuel(Item.appleRed.shiftedIndex, 0, 40);
		MetallurgyAPI.addMintingIngot(Block.cobblestone.blockID, 3, "/shadow/MintGold.png");
		
		new UpdateManager("2.2.3", "Base", "http://ladadeda.info/BaseVersion.txt");
	}

	private void addBalkonsWeapons() 
	{
		/*
		ShapedOreRecipe recipe;
		String[] baseMaterials = {"Copper", "Bronze", "Hepatizon", "Angmallen", "Damascus Steel", "Steel"};
		for(int n = 0; n < 6; n++)
		{
	        spear[n] = (new ItemSpear(29000+n, MetallurgyEnums.base[n], EnumWeapon.SPEAR)).setIconIndex(16*5+((n < 3) ? n : n + 1));
	        spear[n].setTextureFile("/shadow/armory.png");
	        recipe = new ShapedOreRecipe(new ItemStack(spear[n], 1), "  #", " X ", "X  ", 'X', Item.stick, '#', "ingot" + baseMaterials[n]);
	        GameRegistry.addRecipe(recipe);
		}

		for(int n = 0; n < 6; n++)
		{
	        halberd[n] = (new ItemHalberd(29006+n, MetallurgyEnums.base[n], EnumWeapon.HALBERD)).setIconIndex(16*4+((n < 3) ? n : n + 1));
	        halberd[n].setTextureFile("/shadow/armory.png");
	        recipe = new ShapedOreRecipe(new ItemStack(halberd[n], 1), " ##", " X#", "X  ", 'X', Item.stick, '#', "ingot" + baseMaterials[n]);
	        GameRegistry.addRecipe(recipe);
		}

		for(int n = 0; n < 6; n++)
		{
	        knife[n] = (new ItemKnife(29012+n, MetallurgyEnums.base[n], EnumWeapon.KNIFE)).setIconIndex(16*1+((n < 3) ? n : n + 1));
	        knife[n].setTextureFile("/shadow/armory.png");
	        recipe = new ShapedOreRecipe(new ItemStack(knife[n], 1), "#X", 'X', Item.stick, '#', "ingot" + baseMaterials[n]);
	        GameRegistry.addRecipe(recipe);
		}

		for(int n = 0; n < 6; n++)
		{
			battleaxe[n] = (new ItemBattleAxe(29018+n, MetallurgyEnums.base[n], EnumWeapon.BATTLEAXE)).setIconIndex(16*3+((n < 3) ? n : n + 1));
			battleaxe[n].setTextureFile("/shadow/armory.png");
	        recipe = new ShapedOreRecipe(new ItemStack(battleaxe[n], 1), "###", "#X#", " X ", 'X', Item.stick, '#', "ingot" + baseMaterials[n]);
	        GameRegistry.addRecipe(recipe);
		}

		for(int n = 0; n < 6; n++)
		{
			warhammer[n] = (new ItemWarhammer(29024+n, MetallurgyEnums.base[n], EnumWeapon.WARHAMMER)).setIconIndex(16*2+((n < 3) ? n : n + 1));
			warhammer[n].setTextureFile("/shadow/armory.png");
	        recipe = new ShapedOreRecipe(new ItemStack(warhammer[n], 1), "#X#", "#X#", " X ", 'X', Item.stick, '#', "ingot" + baseMaterials[n]);
	        GameRegistry.addRecipe(recipe);
		}

		for(int n = 0; n < 6; n++)
		{
			flail[n] = (new ItemFlail(29030+n, MetallurgyEnums.base[n], EnumWeapon.FLAIL, 16*7+n, 16*6+n)).setIconIndex(16*7+n);
			flail[n].setTextureFile("/shadow/armory.png");
	        recipe = new ShapedOreRecipe(new ItemStack(flail[n], 1), "  O", " XO", "X #", 'X', Item.stick, 'O', Item.silk, '#', "ingot" + baseMaterials[n]);
	        GameRegistry.addRecipe(recipe);
		}
		*/
	}

	public void registerWithApi()
	{
		MetallurgyItems.registerItem("copperFurnace", new ItemStack(metalFurnace, 1, 0));
		MetallurgyItems.registerItem("bronzeFurnace", new ItemStack(metalFurnace, 1, 1));
		MetallurgyItems.registerItem("ironFurnace", new ItemStack(metalFurnace, 1, 2));
		MetallurgyItems.registerItem("steelFurnace", new ItemStack(metalFurnace, 1, 3));
	}
	
	@PostInit
	public void load(FMLPostInitializationEvent event) 
	{
		FMLLog.fine("Registering Base ores", "MetallurgyPrecious");
		ores.registerOres();
		alloys.registerOres();
    	
		
	    if(ConfigBase.alloyEnabled[0])
	    	RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[0], 1), "dustCopper", "dustTin");
	    if(ConfigBase.alloyEnabled[1])
	    	RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[1], 1), "dustBronze", "dustGold");
	    if(ConfigBase.alloyEnabled[2])
	    	RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[2], 1), "dustBronze", "dustIron");
	    if(ConfigBase.alloyEnabled[3])
	    	RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[3], 1), "dustGold", "dustIron");
	    if(ConfigBase.alloyEnabled[4])
	    	RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[4], 1), "dustIron", "dustManganese");
	}
}