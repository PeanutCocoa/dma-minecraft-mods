package dma.modding.MyBlocks;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import dma.modding.MyCode;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NatureOre extends Block 
{
	private final String name = "natureOre";
	
    public NatureOre ()
    {
    	super(Material.rock);
    	GameRegistry.registerBlock(this, name);
    	setUnlocalizedName(BaseMod.MODID + "_" + name);
    	setCreativeTab(MyCode.karenTab);
    	setStepSound(soundTypeStone);
    	this.setHarvestLevel("pickaxe",2);
    }
    
	public String getName()
	{
		return name;
	}
}