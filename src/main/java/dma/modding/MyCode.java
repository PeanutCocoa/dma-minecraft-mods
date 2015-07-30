package dma.modding;

import dma.modding.MyBlocks.NatureBlock;
import dma.modding.MyBlocks.NatureOre;
import dma.modding.MyItems.Bagel;
import dma.modding.MyItems.BlasterRifle;
import dma.modding.MyItems.CampArmor;
import dma.modding.MyItems.CheeseSlice;
import dma.modding.MyItems.Coffe;
import dma.modding.MyItems.ExampleBasicItem;
import dma.modding.MyItems.NatureArmor;
import dma.modding.MyItems.NatureIngot;
import dma.modding.MyItems.NatureSword;
import dma.modding.MyItems.Pizza;
import dma.modding.MyItems.Tea;
import dma.modding.Other.ExampleCreativeTab;
import dma.modding.Other.KarenTab;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

// Imports Go Here


// Class
public class MyCode
{
	// Declarations Go Here
	public static Block natureOre;
	public static Item cheeseSlice;
	public static Item pizza;
	public static ItemArmor campHelmet;
	public static ItemArmor campChestplate;
	public static ItemArmor campLeggings;
	public static ItemArmor campBoots;
	public static Item natureSword;
	public static Item natureIngot;
	public static Item blasterRifle = new BlasterRifle();
	public static Block natureBlock;
	public static ItemArmor natureHelmet;
	public static ItemArmor natureChestplate;
	public static ItemArmor natureLeggings;
	public static ItemArmor natureBoots;
	public static Item coffe;
	public static Item bagel;
	public static Item tea;
	
	// Creative Tab Declarations
	public static CreativeTabs karenTab = new KarenTab(BaseMod.MODID);
		
	//Material Declarations
	public static ArmorMaterial campArmorMaterial = EnumHelper.addArmorMaterial("campArmorMaterial", "wurscht", 20, new int[] {5, 10, 10, 5}, 80);
	public static ToolMaterial natureToolMaterial = EnumHelper.addToolMaterial("natureToolMaterial", 3, 500, 5.0F, 18F, 12);
	public static ArmorMaterial natureArmorMaterial = EnumHelper.addArmorMaterial("natureArmorMaterial", "wurscht", 20, new int[] {5, 10, 10, 5}, 80);

	// Functions
	public static void CreateBlocks()
	{
		natureOre = new NatureOre();
		natureBlock = new NatureBlock();
	}
	
	public static void CreateItems()
	{
		//cheeseSlice = new CheeseSlice();
		GameRegistry.registerItem(cheeseSlice = new CheeseSlice("cheeseSlice", 6, 3.0f, false), "cheeseSlice");
		//pizza = new Pizza();
		GameRegistry.registerItem(pizza = new Pizza("pizza", 6, 5.0f, false), "pizza");
		GameRegistry.registerItem(coffe = new Coffe("coffe", 2, 0.2f, false,
			    new PotionEffect(Potion.moveSpeed.id, 1200, 10),
			    new PotionEffect(Potion.jump.id, 600, 20),
			    new PotionEffect(Potion.resistance.id,500, 5),
			    new PotionEffect(Potion.regeneration.id, 200, 1))
			    .setAlwaysEdible(), "coffe");
		GameRegistry.registerItem(bagel = new Bagel("bagel", 6, 5.0f, false), "bagel");
		GameRegistry.registerItem(tea = new Tea("tea", 6, 5.0f, false), "tea");
		
		campHelmet = new CampArmor(campArmorMaterial, 0, 0); 
		campChestplate = new CampArmor(campArmorMaterial, 0, 1);
		campLeggings = new CampArmor(campArmorMaterial, 0, 2);
		campBoots = new CampArmor(campArmorMaterial, 0, 3);
		natureHelmet = new NatureArmor(natureArmorMaterial, 0, 0); 
		natureChestplate = new NatureArmor(natureArmorMaterial, 0, 1);
		natureLeggings = new NatureArmor(natureArmorMaterial, 0, 2);
		natureBoots = new NatureArmor(natureArmorMaterial, 0, 3);
		natureSword=new NatureSword(natureToolMaterial);
		natureIngot = new NatureIngot();
		GameRegistry.registerItem(blasterRifle, "blasterRifle");
	}
	
	public static void CreateRecipes()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.grass), new Object[]{new ItemStack(Blocks.dirt)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.blaze_rod), new Object []{new ItemStack(Items.flint), new ItemStack(Items.gunpowder), new ItemStack(Items.stick), new ItemStack(Items.iron_ingot)});
		GameRegistry.addShapelessRecipe(new ItemStack(natureIngot,9), new Object []{new ItemStack(natureBlock)});
		GameRegistry.addRecipe(new ItemStack(Blocks.beacon), new Object[]{
			"AAA",
			"ABA",
			"CDC",
			'A', Blocks.glass,'B',Blocks.emerald_block,'C',Blocks.obsidian,'D',Blocks.glowstone});
		GameRegistry.addRecipe(new ItemStack(Items.bed), new Object[]{
			"   ",
			"AAB",
			"CDC",
			'A', Items.feather,'B', Blocks.wool,'C', Blocks.planks,'D', Blocks.wooden_slab});
		GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.ghast_tear),50);
		GameRegistry.addSmelting(natureOre, new ItemStack(natureIngot),50);
		
		GameRegistry.addRecipe(new ItemStack(Blocks.red_mushroom_block), new Object[]{
			"AAA",
			"AAA",
			"AAA",
			'A',Blocks.red_mushroom});
		GameRegistry.addRecipe(new ItemStack(pizza), new Object[]{
			"AAA",
			"BCB",
			"AAA",
			'A',Items.bread,'B',Items.cooked_porkchop,'C',cheeseSlice});
		
		ItemStack Riptide = new ItemStack(Items.diamond_sword);
		Riptide.addEnchantment(Enchantment.sharpness,5);
		Riptide.addEnchantment(Enchantment.knockback,5);
		Riptide.addEnchantment(Enchantment.fireAspect,5);
		Riptide.addEnchantment(Enchantment.looting,5);
		Riptide.addEnchantment(Enchantment.smite,5);
		Riptide.addEnchantment(Enchantment.baneOfArthropods,5);
		Riptide.addEnchantment(Enchantment.unbreaking,5);
		Riptide.addEnchantment(Enchantment.looting,5);
		
		GameRegistry.addShapelessRecipe(Riptide, new Object[]{new ItemStack(Items.diamond_sword), new ItemStack(Items.gold_ingot)});
		GameRegistry.addShapelessRecipe(new ItemStack(cheeseSlice), new Object[]{new ItemStack(Items.milk_bucket), new ItemStack(Items.milk_bucket), new ItemStack(Items.milk_bucket)});
		GameRegistry.addRecipe(new ItemStack(campHelmet), new Object[]{
			"AAA",
			"B B",
			"   ",
			'A', new ItemStack(Items.dye,1,14),'B',Items.leather});
		GameRegistry.addRecipe(new ItemStack(campChestplate), new Object[]{
			"B B",
			"BAB",
			"BBB",
			'A', new ItemStack(Items.dye,1,14),'B',Items.leather});
		GameRegistry.addRecipe(new ItemStack(campLeggings), new Object[]{
			"BBB",
			"B B",
			"A A",
			'A', new ItemStack(Items.dye,1,14),'B',Items.leather});
		GameRegistry.addRecipe(new ItemStack(campBoots), new Object[]{
			"   ",
			"A A",
			"B B",
			'A', new ItemStack(Items.dye,1,14),'B',Items.leather});
		GameRegistry.addRecipe(new ItemStack(natureBlock), new Object[]{
			"AAA",
			"AAA",
			"AAA",
			'A', new ItemStack(natureIngot)});
		GameRegistry.addRecipe(new ItemStack(natureSword), new Object[]{
			" A ",
			" A ",
			" B ",
			'A', new ItemStack(natureIngot),'B',Items.stick});
		GameRegistry.addShapelessRecipe(new ItemStack(coffe), new Object[]{new ItemStack(Items.dye,1,3), new ItemStack(Items.milk_bucket), new ItemStack(Items.sugar)});
		GameRegistry.addRecipe(new ItemStack(bagel), new Object[]{
			"AAA",
			"A A",
			"AAA",
			'A',Items.bread});
		GameRegistry.addShapelessRecipe(new ItemStack(tea), new Object[]{new ItemStack(Blocks.leaves), new ItemStack(Items.sugar), new ItemStack(Items.water_bucket)});
		GameRegistry.addRecipe(new ItemStack(natureHelmet), new Object[]{
			"AAA",
			"A A",
			"   ",
			'A', new ItemStack(natureIngot)});
		GameRegistry.addRecipe(new ItemStack(natureChestplate), new Object[]{
			"A A",
			"AAA",
			"AAA",
			'A', new ItemStack(natureIngot)});
		GameRegistry.addRecipe(new ItemStack(natureLeggings), new Object[]{
			"AAA",
			"A A",
			"A A",
			'A', new ItemStack(natureIngot)});
		GameRegistry.addRecipe(new ItemStack(natureBoots), new Object[]{
			"   ",
			"A A",
			"A A",
			'A', new ItemStack(natureIngot)});
		
		
	}
	
	public static void RenderItems()
	{
RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
	    
		// Blocks
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(natureOre), 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((NatureOre) natureOre).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(natureBlock), 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((NatureBlock) natureBlock).getName(), "inventory"));
		// Items
    	renderItem.getItemModelMesher().register(cheeseSlice, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((CheeseSlice) cheeseSlice).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(pizza, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((Pizza) pizza).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(campHelmet, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((CampArmor) campHelmet).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(campChestplate, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((CampArmor) campChestplate).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(campLeggings, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((CampArmor) campLeggings).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(campBoots, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((CampArmor) campBoots).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(natureSword, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((NatureSword) natureSword).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(natureIngot, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((NatureIngot) natureIngot).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(blasterRifle, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((BlasterRifle) blasterRifle).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(natureHelmet, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((NatureArmor) natureHelmet).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(natureChestplate, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((NatureArmor) natureChestplate).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(natureLeggings, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((NatureArmor) natureLeggings).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(natureBoots, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((NatureArmor) natureBoots).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(coffe, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((Coffe) coffe).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(bagel, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((Bagel) bagel).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(tea, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((Tea) tea).getName(), "inventory"));

	}
}