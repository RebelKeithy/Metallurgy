package shadow.mods.metallurgy.base;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.lwjgl.opengl.GL11;

import shadow.mods.metallurgy.BC_CrusherRecipes;
import shadow.mods.metallurgy.BlockDoorMetal;
import shadow.mods.metallurgy.ItemDoorMetal;
import shadow.mods.metallurgy.MetalSet;
import shadow.mods.metallurgy.MetallurgyCore;
import shadow.mods.metallurgy.MetallurgyEnumToolMaterial;
import shadow.mods.metallurgy.MetallurgyItem;
import shadow.mods.metallurgy.MetallurgyItems;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.UpdateManager;
import shadow.mods.metallurgy.mod_Gold;
import shadow.mods.metallurgy.mod_Iron;
import shadow.mods.metallurgy.api.MetallurgyAPI;
import shadow.mods.metallurgy.mystcraft.TerrainSymbol;
import shadow.mods.metallurgy.precious.ConfigPrecious;
import shadow.mods.metallurgy.storage.BlockAccessor;
import shadow.mods.metallurgy.storage.BlockStorage;
import shadow.mods.metallurgy.MetallurgyEnums;

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
import net.minecraft.src.CraftingManager;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.IRecipe;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingSpecialSpawnEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

@Mod(modid = "MetallurgyBase", name = "Metallurgy Base", dependencies = "after:MetallurgyCore", version = "2.3.1")
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
	public static Block coloredGlass;
	
	public static Item spear[] = new Item[7];
	public static Item halberd[] = new Item[7];
	public static Item knife[] = new Item[7];
	public static Item battleaxe[] = new Item[7];
	public static Item warhammer[] = new Item[7];
	public static Item flail[] = new Item[7];
	
	public static Item glassDust;
	
	public static Item copperItemDoor;
	public static Block copperDoor;
	
	public static CreativeTabs baseTab;
	
	// Storage Structure Stuff
	public static Block storage;
	public static Block accessor;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigBase.init();
		
		//baseTab = MetallurgyCore.getNewCreativeTab("Base Metals", ConfigBase.ItemStartID);
		baseTab = MetallurgyCore.getNewCreativeTab("Base Metals", ConfigBase.ItemStartID + 256 + 150 + 7 + 50 * 4);
		
		alloys = new MetalSet(new AlloyBaseEnum());
		ores = new MetalSet(new OreBaseEnum());

		try
		{
			copperItemDoor = new ItemDoorMetal(ConfigBase.itemDoorID, Material.wood, ConfigBase.doorID);
			copperDoor = new BlockDoorMetal(ConfigBase.doorID, Material.wood, ConfigBase.itemDoorID);
			copperDoor.setTextureFile("/shadow/deco.png");
			copperDoor.blockIndexInTexture = 32;
			copperItemDoor.setIconIndex(43);
			
			metalFurnace = new BF_BlockMetalFurnace(ConfigBase.furnaceID, false).setHardness(3.5F).setBlockName("MetalFurnace");
			lantern = new BlockLantern(ConfigBase.lanternId).setHardness(0.1F).setLightValue(1F).setBlockName("lantern").setCreativeTab(baseTab);
			ladder = new BlockMetalLadder(ConfigBase.ladderId, 48).setBlockName("MetalLadder").setCreativeTab(baseTab);
			glassDust = new ItemGlassDust(ConfigBase.glassDustId, "/shadow/MetallurgyGlassLanterns.png").setItemName("glassDust").setIconIndex(68).setCreativeTab(baseTab);
			coloredGlass = new BlockColoredGlass(ConfigBase.coloredGlassId, "/shadow/MetallurgyGlassLanterns.png").setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setBlockName("coloredGlass").setCreativeTab(baseTab);
		}
		catch(IllegalArgumentException e)
		{
			MetallurgyCore.blockError(e);
            throw e;
		}
		
		
		// Storage Structure Stuff
		//storage = new BlockStorage(2014);
		//accessor = new BlockAccessor(2015);
		
		proxy.registerRenderInformation();
		
		MinecraftForge.EVENT_BUS.register(new FurnaceUpgradeRecipes());
		registerWithApi();
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	
	@ForgeSubscribe
	public void equip(LivingSpecialSpawnEvent event)
	{
		if(Math.random() > 0.01)
			return;
		
		if(event.entity instanceof EntityZombie)
		{
			((EntityZombie)(event.entity)).setCurrentItemOrArmor(0, new ItemStack(alloys.Sword[alloys.numMetals-1]));
			((EntityZombie)(event.entity)).setCurrentItemOrArmor(1, new ItemStack(alloys.Helmet[alloys.numMetals-1]));
			((EntityZombie)(event.entity)).setCurrentItemOrArmor(2, new ItemStack(alloys.Plate[alloys.numMetals-1]));
			((EntityZombie)(event.entity)).setCurrentItemOrArmor(3, new ItemStack(alloys.Legs[alloys.numMetals-1]));
			((EntityZombie)(event.entity)).setCurrentItemOrArmor(4, new ItemStack(alloys.Boots[alloys.numMetals-1]));
		}
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
		GameRegistry.registerBlock(coloredGlass, shadow.mods.metallurgy.base.ItemBlockColoredGlass.class);
		
		GameRegistry.registerTileEntity(shadow.mods.metallurgy.base.TileEntityLantern.class, "Lantern");
		GameRegistry.registerTileEntity(BF_TileEntityMetalFurnace.class, "metalFurnace");
		
		//GameRegistry.registerBlock(storage);
		//GameRegistry.registerBlock(accessor);
		//GameRegistry.registerTileEntity(shadow.mods.metallurgy.storage.TileEntityStorage.class, "Storage");
		
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
		
		try {
			Class a = Class.forName("weaponmod.BalkonsWeaponMod");
			addBalkonsWeapons();
		} catch(Exception e) {}
		

		IRecipe recipe = new ShapedOreRecipe(new ItemStack(Block.pistonBase, 1),
				"PPP", "SIS", "SRS", 'I', "ingotBronze", 'P', new ItemStack(Block.planks, 1, -1), 'S', Block.cobblestone, 'R', Item.redstone);
		CraftingManager.getInstance().getRecipeList().add(recipe);
		recipe = new ShapedOreRecipe(new ItemStack(Block.pistonBase, 1),
				"PPP", "SIS", "SRS", 'I', "ingotHepatizon", 'P', new ItemStack(Block.planks, 1, -1), 'S', Block.cobblestone, 'R', Item.redstone);
		CraftingManager.getInstance().getRecipeList().add(recipe);
		recipe = new ShapedOreRecipe(new ItemStack(Block.pistonBase, 1),
				"PPP", "SIS", "SRS", 'I', "ingotDamascus Steel", 'P', new ItemStack(Block.planks, 1, -1), 'S', Block.cobblestone, 'R', Item.redstone);
		CraftingManager.getInstance().getRecipeList().add(recipe);
		recipe = new ShapedOreRecipe(new ItemStack(Block.pistonBase, 2),
				"PPP", "SIS", "SRS", 'I', "ingotAngmallen", 'P', new ItemStack(Block.planks, 1, -1), 'S', Block.cobblestone, 'R', Item.redstone);
		CraftingManager.getInstance().getRecipeList().add(recipe);
		recipe = new ShapedOreRecipe(new ItemStack(Block.pistonBase, 2),
				"PPP", "SIS", "SRS", 'I', "ingotSteel", 'P', new ItemStack(Block.planks, 1, -1), 'S', Block.cobblestone, 'R', Item.redstone);
		CraftingManager.getInstance().getRecipeList().add(recipe);
		recipe = new ShapelessOreRecipe(new ItemStack(glassDust, 1, 1), new ItemStack(glassDust, 1, 0), new ItemStack(glassDust, 1, 0));
		CraftingManager.getInstance().getRecipeList().add(recipe);
		
		
		proxy.addNames();
		
		BC_CrusherRecipes.smelting().addCrushing(Block.glass.blockID, new ItemStack(glassDust, 1));
		
		MetallurgyAPI.addCrusherRecipe(Item.appleRed.shiftedIndex, 0, new ItemStack(Block.dirt));
		MetallurgyAPI.addAbstractorRecipe(Item.appleRed.shiftedIndex, 0, 50);
		MetallurgyAPI.addAbstractorFuel(Item.appleRed.shiftedIndex, 0, 40);
		MetallurgyAPI.addMintingIngot(Block.cobblestone.blockID, 3, "/shadow/MintGold.png");
		
		for(int n = 0; n < 8; n++)
			FurnaceRecipes.smelting().addSmelting(glassDust.shiftedIndex, n+1, new ItemStack(coloredGlass, 1, n), 0);
		
		for(int n = 0; n < 8; n++)
			ModLoader.addRecipe(new ItemStack(lantern, 1, n), "SSS", "GTG", "SSS", 'S', Block.cobblestone, 'T', Block.torchWood, 'G', new ItemStack(coloredGlass, 1, n));
		
		recipe = new ShapelessOreRecipe(new ItemStack(glassDust, 1, 1), new ItemStack(glassDust, 1, 0), "dustIron");
		GameRegistry.addRecipe(recipe);
		recipe = new ShapelessOreRecipe(new ItemStack(glassDust, 1, 2), new ItemStack(glassDust, 1, 0), "dustBronze");
		GameRegistry.addRecipe(recipe);
		recipe = new ShapelessOreRecipe(new ItemStack(glassDust, 1, 3), new ItemStack(glassDust, 1, 0), "dustCopper");
		GameRegistry.addRecipe(recipe);
		recipe = new ShapelessOreRecipe(new ItemStack(glassDust, 1, 4), new ItemStack(glassDust, 1, 0), "dustAngmallen");
		GameRegistry.addRecipe(recipe);
		recipe = new ShapelessOreRecipe(new ItemStack(glassDust, 1, 5), new ItemStack(glassDust, 1, 0), "dustGold");
		GameRegistry.addRecipe(recipe);
		recipe = new ShapelessOreRecipe(new ItemStack(glassDust, 1, 6), new ItemStack(glassDust, 1, 0), "dustManganese");
		GameRegistry.addRecipe(recipe);
		recipe = new ShapelessOreRecipe(new ItemStack(glassDust, 1, 7), new ItemStack(glassDust, 1, 0), "dustHepatizon");
		GameRegistry.addRecipe(recipe);
		recipe = new ShapelessOreRecipe(new ItemStack(glassDust, 1, 8), new ItemStack(glassDust, 1, 0), "dustSteel");
		GameRegistry.addRecipe(recipe);
		
		recipe = new ShapedOreRecipe(new ItemStack(ladder, 4, 0), "I I", "III", "I I", 'I', "ingotCopper");
		GameRegistry.addRecipe(recipe);
		recipe = new ShapedOreRecipe(new ItemStack(ladder, 4, 1), "I I", "III", "I I", 'I', "ingotBronze");
		GameRegistry.addRecipe(recipe);
		recipe = new ShapedOreRecipe(new ItemStack(ladder, 4, 2), "I I", "III", "I I", 'I', Item.ingotIron);
		GameRegistry.addRecipe(recipe);
		recipe = new ShapedOreRecipe(new ItemStack(ladder, 4, 3), "I I", "III", "I I", 'I', "ingotSteel");
		GameRegistry.addRecipe(recipe);
		
		new UpdateManager("2.3.1", "Base", "http://ladadeda.info/BaseVersion.txt");
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
		ArrayList<Integer> swordIds = new ArrayList<Integer>();
		
		for(int n = 0; n < ores.numMetals; n++)		
		{
			if(ores.Sword[n] != null)
				swordIds.add(ores.Sword[n].shiftedIndex);
		}
		for(int n = 0; n < alloys.numMetals; n++)		
		{
			if(alloys.Sword[n] != null)
				swordIds.add(alloys.Sword[n].shiftedIndex);
		}
		int[] list = new int[swordIds.size()];
		for(int n = 0; n < list.length; n++)
			list[n] = swordIds.get(n);

		try {
			Class c = Class.forName("me.Golui.SwordPedestal.common.SwordPedestalMain");
			c.getDeclaredMethod("addItems", int[].class).invoke(this, list);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addBalkonsWeapons() 
	{
		ShapedOreRecipe recipe;
		String[] baseMaterials = {"Copper", "Bronze", "Hepatizon", "Angmallen", "Damascus Steel", "Steel"};
		int balkonsID = ConfigBase.balkonsIDs;
		for(int n = 0; n < 6; n++)
		{
	        spear[n] = (new weaponmod.item.ItemSpear(balkonsID+n, MetallurgyEnums.base[n], weaponmod.item.EnumWeapon.SPEAR)).setItemName("Spear" + baseMaterials[n]).setIconIndex(16*5+((n < 3) ? n : n + 1));
	        spear[n].setTextureFile("/shadow/armory.png");
	        recipe = new ShapedOreRecipe(new ItemStack(spear[n], 1), "  #", " X ", "X  ", 'X', Item.stick, '#', "ingot" + baseMaterials[n]);
	        GameRegistry.addRecipe(recipe);
		}

		for(int n = 0; n < 6; n++)
		{
	        halberd[n] = (new weaponmod.item.ItemHalberd(balkonsID+6+n, MetallurgyEnums.base[n], weaponmod.item.EnumWeapon.HALBERD)).setItemName("Halberd" + baseMaterials[n]).setIconIndex(16*4+((n < 3) ? n : n + 1));
	        halberd[n].setTextureFile("/shadow/armory.png");
	        recipe = new ShapedOreRecipe(new ItemStack(halberd[n], 1), " ##", " X#", "X  ", 'X', Item.stick, '#', "ingot" + baseMaterials[n]);
	        GameRegistry.addRecipe(recipe);
		}

		for(int n = 0; n < 6; n++)
		{
	        knife[n] = (new weaponmod.item.ItemKnife(balkonsID+12+n, MetallurgyEnums.base[n], weaponmod.item.EnumWeapon.KNIFE)).setItemName("Knife" + baseMaterials[n]).setIconIndex(16*1+((n < 3) ? n : n + 1));
	        knife[n].setTextureFile("/shadow/armory.png");
	        recipe = new ShapedOreRecipe(new ItemStack(knife[n], 1), "#X", 'X', Item.stick, '#', "ingot" + baseMaterials[n]);
	        GameRegistry.addRecipe(recipe);
		}
		/*
		for(int n = 0; n < 6; n++)
		{
			battleaxe[n] = (new weaponmod.item.ItemBattleAxe(29018+n, MetallurgyEnums.base[n], weaponmod.item.EnumWeapon.BATTLEAXE)).setIconIndex(16*3+((n < 3) ? n : n + 1));
			battleaxe[n].setTextureFile("/shadow/armory.png");
	        recipe = new ShapedOreRecipe(new ItemStack(battleaxe[n], 1), "###", "#X#", " X ", 'X', Item.stick, '#', "ingot" + baseMaterials[n]);
	        GameRegistry.addRecipe(recipe);
		}
		*/
		for(int n = 0; n < 6; n++)
		{
			warhammer[n] = (new weaponmod.item.ItemWarhammer(balkonsID+24+n, MetallurgyEnums.base[n], weaponmod.item.EnumWeapon.WARHAMMER)).setItemName("Warhammer" + baseMaterials[n]).setIconIndex(16*2+((n < 3) ? n : n + 1));
			warhammer[n].setTextureFile("/shadow/armory.png");
	        recipe = new ShapedOreRecipe(new ItemStack(warhammer[n], 1), "#X#", "#X#", " X ", 'X', Item.stick, '#', "ingot" + baseMaterials[n]);
	        GameRegistry.addRecipe(recipe);
		}

		for(int n = 0; n < 6; n++)
		{
			flail[n] = (new weaponmod.item.ItemFlail(balkonsID+30+n, MetallurgyEnums.base[n], weaponmod.item.EnumWeapon.FLAIL, 16*7+((n < 3) ? n : n + 1), 16*6+((n < 3) ? n : n + 1))).setItemName("Flail" + baseMaterials[n]).setIconIndex(16*7+((n < 3) ? n : n + 1));
			flail[n].setTextureFile("/shadow/armory.png");
	        recipe = new ShapedOreRecipe(new ItemStack(flail[n], 1), "  O", " XO", "X #", 'X', Item.stick, 'O', Item.silk, '#', "ingot" + baseMaterials[n]);
	        GameRegistry.addRecipe(recipe);
		}

		class Material implements weaponmod.projectile.ICustomProjectileMaterials
		{
			public final int[] ids = new int []{ 100, 101, 102, 103, 104, 105 };
			
			@Override
			public int[] getAllMaterialIDs() {
				return ids;
			}

			@Override
			public int getMaterialID(ItemStack var1) {
				for(int n = 0; n < 6; n++)
					if(var1.itemID == knife[n].shiftedIndex || var1.itemID == flail[n].shiftedIndex)
						return ids[n];

				return 0;
			}

			@Override
			public float[] getColorFromMaterialID(int var1) {
				if(var1 == ids[0])
					return new float[] {1F, 0.4F, 0.1F};
				if(var1 == ids[1])
					return new float[] {1F, 0.75F, 0.5F};
				if(var1 == ids[2])
					return new float[] {0.45F, 0.35F, 0.45F};
				if(var1 == ids[3])
					return new float[] {0.95F, 0.9F, 0.35F};
				if(var1 == ids[4])
					return new float[] {0.35F, 0.25F, 0.15F};
				if(var1 == ids[5])
					return new float[] {0.65F, 0.65F, 0.65F};
				 
				return new float[] {1F, 1F, 1F};
			}
		}

		weaponmod.projectile.MaterialRegistry.registerCustomProjectileMaterial(new Material());
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