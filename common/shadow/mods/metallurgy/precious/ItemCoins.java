package shadow.mods.metallurgy.precious;

import java.util.List;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;

public class ItemCoins extends Item
{
	private String texturePath = "/shadow/Overrides.png";

    public ItemCoins(int i)
    {
        super(i);
    }

    @Override
    public String getTextureFile()
    {
        return texturePath;
    }

}
