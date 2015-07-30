package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.MyCode;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;


public class Coffe extends ItemFood {
	private final String name = "coffe";

	private PotionEffect[] effects;

	public Coffe(String unlocalizedName, int healAmount, float saturationModifier, boolean wolvesFavorite, PotionEffect... effects) {
		super(healAmount, saturationModifier, wolvesFavorite);
		//this.setUnlocalizedName(unlocalizedName);
		//this.setTextureName(BaseMod.MODID + ":" + unlocalizedName);
		setUnlocalizedName(BaseMod.MODID + "_" + name);
		this.setCreativeTab(MyCode.karenTab);
		this.effects = effects;
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		super.onFoodEaten(stack, world, player);

		for (int i = 0; i < this.effects.length; i++) {
			if (!world.isRemote && this.effects[i] != null && this.effects[i].getPotionID() > 0)
				player.addPotionEffect(new PotionEffect(this.effects[i].getPotionID(), this.effects[i].getDuration(), this.effects[i].getAmplifier(), this.effects[i].getIsAmbient(),false));
		}
	}
	public String getName()
	{
		return name;
	}
} 


