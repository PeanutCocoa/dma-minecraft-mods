package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import dma.modding.MyCode;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NatureSword extends ItemSword
{
	private final String name = "natureSword";
	
	public NatureSword(ToolMaterial material)
	{
		super(material);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(BaseMod.MODID + "_" + name);
		setCreativeTab(MyCode.karenTab);
	}
	
	public String getName()
	{
		return name;
	}
}