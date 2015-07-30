package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import dma.modding.MyCode;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CampArmor extends ItemArmor
{
	private final String name = "camp";
	private String armorTypeName = "";
	//public void onArmorTick(World world, EntityPlayer player,ItemStack armor){player.addPotionEffect(new PotionEffect(Potion.healthBoost.id,40,4));};
	
	public CampArmor(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
		
		switch (armorType)
		{
		case 0:
			armorTypeName = "Helmet";
			break;
			
		case 1:
			armorTypeName = "Chestplate";
			break;
			
		case 2:
			armorTypeName = "Leggings";
			break;
			
		case 3:
			armorTypeName = "Boots";
			break;
		}
		
		setUnlocalizedName(BaseMod.MODID + "_" + name + armorTypeName);
		setCreativeTab(MyCode.karenTab);
		
		GameRegistry.registerItem(this, (name + armorTypeName));
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (slot == 0 ||slot == 1 || slot == 3)
		{
			return (BaseMod.MODID + ":textures/models/armor/camp_layer_1.png");
		}
		else if (slot == 2)
		{
			return (BaseMod.MODID + ":textures/models/armor/camp_layer_2.png");
		}
		else
		{
			return null;
		}
	}

	public String getName()
	{
		return (name + armorTypeName);
	}
}