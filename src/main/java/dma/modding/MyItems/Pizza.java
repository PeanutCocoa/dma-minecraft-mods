package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import dma.modding.MyCode;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Pizza extends ItemFood
{
	private final String name = "pizza";
	private PotionEffect[] effects;
	
	public Pizza(String unlocalizedName, int healAmount, float saturationModifier, boolean wolvesFavorite)

	{
	super(healAmount, saturationModifier, wolvesFavorite);	
	//this.setUnlocalizedName(unlocalizedName);
	setUnlocalizedName(BaseMod.MODID + "_" + name);
	this.setCreativeTab(MyCode.karenTab);
		
	}
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		super.onFoodEaten(stack, world, player);
	}
	public String getName()
	{
		return name;
	}
}