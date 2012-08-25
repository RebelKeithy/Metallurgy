package shadow.mods.metallurgy;
/*package net.minecraft.src;
import java.util.Random;
import net.minecraft.src.forge.*;

public class MetallurgyBlockVein extends Block
	implements ITextureProvider
{
	&public String texturePath;
    protected MetallurgyBlockVein(int i, String s, Material material) {
        super(i, material.iron);
        texturePath = s;
    }
    
    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
    		entityplayer.addStat(mod_Copper.AchMineCopper, 1);
    		super.harvestBlock(world, entityplayer, i, j, k, l);
	}
    
	public int idDropped(int i, Random random) {
    switch (i){
	    case 0: return mod_Copper.CopperOre.shiftedIndex; //Copper Vein
	    case 1: return mod_Tin.TinOre.shiftedIndex; //Tin Vein
	    case 2: return mod_Iron.IronOre.shiftedIndex; //Iron Vein
	    case 3: return mod_Manganese.ManganeseOre.shiftedIndex; //Manganese Vein
	    case 4: return mod_Mithril.MithrilOre.shiftedIndex; //Mithril Vein
	    case 5: return mod_Orichalcum.OrichalcumOre.shiftedIndex; //Orichalcum Vein
	    case 6: return mod_Adamantine.AdamantineOre.shiftedIndex; //Adamantine Vein
	    case 7: return mod_Zinc.ZincOre.shiftedIndex; //Adamantine Vein
	    case 8: return mod_Silver.SilverOre.shiftedIndex; //Adamantine Vein
	    case 9: return mod_Gold.GoldOre.shiftedIndex; //Adamantine Vein
	    case 10: return mod_Platinum.PlatinumOre.shiftedIndex; //Adamantine Vein
	    default: return Item.arrow.shiftedIndex;
    	}
    }
	
	public int quantityDropped(Random random)
    {
            return 1 + random.nextInt(1);	
    }
	
	public int getBlockTextureFromSideAndMetadata(int i, int j) {
	        switch (j) {
	        case 0: return 0; //Copper Vein
	        case 1: return 1; //Tin Vein
	        case 2: return 3; //Iron Vein
	        case 3: return 5; //Manganese Vein
	        case 4: return 6; //Mithril Vein
	        case 5: return 7; //Orichalcum Vein
	        case 6: return 8; //Adamantine Vein
	        case 7: return 10; //Zinc Vein
	        case 8: return 12; //Silver Vein
	        case 9: return 13; //Gold Vein
	        case 10: return 14; //Platinum Vein
	        default: return 1;
	        }
	}
	
	public String getTextureFile()
    {		
		return texturePath;
    }
	
    protected int damageDropped(int i) {
        return i;
    }
}*/