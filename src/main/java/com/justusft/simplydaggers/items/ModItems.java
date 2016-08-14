package com.justusft.simplydaggers.items;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public final class ModItems {
	public static ToolMaterial woodenDagger  = EnumHelper.addToolMaterial("woodenDagger" , 0, 59  , 1.0F, -3.0F, 15);
	public static ToolMaterial stoneDagger   = EnumHelper.addToolMaterial("stoneDagger"  , 0, 131 , 1.0F, -2.0F, 5);
	public static ToolMaterial ironDagger    = EnumHelper.addToolMaterial("ironDagger"   , 0, 250 , 1.0F,  -1.0F, 14);
	public static ToolMaterial goldenDagger  = EnumHelper.addToolMaterial("goldenDagger" , 0, 32  , 1.0F, -3.0F, 10);
	public static ToolMaterial diamondDagger = EnumHelper.addToolMaterial("diamondDagger", 0, 1561, 1.0F,  0.0F, 22);
	
	//Below here could be done dynamically but I'm not sure if that's better
	public static ItemModSword itemWoodenDagger  = new ItemModSword("wooden_dagger" , woodenDagger , "wooden_dagger" , "empty");
	public static ItemModSword itemStoneDagger   = new ItemModSword("stone_dagger"  , stoneDagger  , "stone_dagger"  , "empty");
	public static ItemModSword itemIronDagger    = new ItemModSword("iron_dagger"   , ironDagger   , "iron_dagger"   , "empty");
	public static ItemModSword itemGoldenDagger  = new ItemModSword("golden_dagger" , goldenDagger , "golden_dagger" , "empty");
	public static ItemModSword itemDiamondDagger = new ItemModSword("diamond_dagger", diamondDagger, "diamond_dagger", "empty");
	
	public static ItemStack IS_WoodenDagger  = new ItemStack(itemWoodenDagger );
	public static ItemStack IS_StoneDagger   = new ItemStack(itemStoneDagger  );
	public static ItemStack IS_IronDagger    = new ItemStack(itemIronDagger   );
	public static ItemStack IS_GoldenDagger  = new ItemStack(itemGoldenDagger );
	public static ItemStack IS_DiamondDagger = new ItemStack(itemDiamondDagger);
	
	public static ItemModSword itemPoisonWoodenDagger  = new ItemModSword("poison_wooden_dagger" , woodenDagger , "wooden_dagger" , "poison");
	public static ItemModSword itemPoisonStoneDagger   = new ItemModSword("poison_stone_dagger"  , stoneDagger  , "stone_dagger"  , "poison");
	public static ItemModSword itemPoisonIronDagger    = new ItemModSword("poison_iron_dagger"   , ironDagger   , "iron_dagger"   , "poison");
	public static ItemModSword itemPoisonGoldenDagger  = new ItemModSword("poison_golden_dagger" , goldenDagger , "golden_dagger" , "poison");
	public static ItemModSword itemPoisonDiamondDagger = new ItemModSword("poison_diamond_dagger", diamondDagger, "diamond_dagger", "poison");
	
	public static ItemModSword itemWeakWoodenDagger  = new ItemModSword("weak_wooden_dagger" , woodenDagger , "wooden_dagger" , "weakness");
	public static ItemModSword itemWeakStoneDagger   = new ItemModSword("weak_stone_dagger"  , stoneDagger  , "stone_dagger"  , "weakness");
	public static ItemModSword itemWeakIronDagger    = new ItemModSword("weak_iron_dagger"   , ironDagger   , "iron_dagger"   , "weakness");
	public static ItemModSword itemWeakGoldenDagger  = new ItemModSword("weak_golden_dagger" , goldenDagger , "golden_dagger" , "weakness");
	public static ItemModSword itemWeakDiamondDagger = new ItemModSword("weak_diamond_dagger", diamondDagger, "diamond_dagger", "weakness");

	public static ItemModSword itemSlowWoodenDagger  = new ItemModSword("slow_wooden_dagger" , woodenDagger , "wooden_dagger" , "slowness");
	public static ItemModSword itemSlowStoneDagger   = new ItemModSword("slow_stone_dagger"  , stoneDagger  , "stone_dagger"  , "slowness");
	public static ItemModSword itemSlowIronDagger    = new ItemModSword("slow_iron_dagger"   , ironDagger   , "iron_dagger"   , "slowness");
	public static ItemModSword itemSlowGoldenDagger  = new ItemModSword("slow_golden_dagger" , goldenDagger , "golden_dagger" , "slowness");
	public static ItemModSword itemSlowDiamondDagger = new ItemModSword("slow_diamond_dagger", diamondDagger, "diamond_dagger", "slowness");

	public static ItemModSword itemHarmWoodenDagger  = new ItemModSword("harm_wooden_dagger" , woodenDagger , "wooden_dagger" , "harming");
	public static ItemModSword itemHarmStoneDagger   = new ItemModSword("harm_stone_dagger"  , stoneDagger  , "stone_dagger"  , "harming");
	public static ItemModSword itemHarmIronDagger    = new ItemModSword("harm_iron_dagger"   , ironDagger   , "iron_dagger"   , "harming");
	public static ItemModSword itemHarmGoldenDagger  = new ItemModSword("harm_golden_dagger" , goldenDagger , "golden_dagger" , "harming");
	public static ItemModSword itemHarmDiamondDagger = new ItemModSword("harm_diamond_dagger", diamondDagger, "diamond_dagger", "harming");

	public static final void init() {
		GameRegistry.addRecipe(IS_WoodenDagger , " A", "B ", 'A', Blocks.planks     , 'B', Items.stick);
		GameRegistry.addRecipe(IS_StoneDagger  , " A", "B ", 'A', Blocks.cobblestone, 'B', Items.stick);
		GameRegistry.addRecipe(IS_IronDagger   , " A", "B ", 'A', Items.iron_ingot  , 'B', Items.stick);
		GameRegistry.addRecipe(IS_GoldenDagger , " A", "B ", 'A', Items.gold_ingot  , 'B', Items.stick);
		GameRegistry.addRecipe(IS_DiamondDagger, " A", "B ", 'A', Items.diamond     , 'B', Items.stick);

		GameRegistry.addShapelessRecipe(new ItemStack(itemPoisonWoodenDagger , 1, 0), new ItemStack(itemWoodenDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8196));
		GameRegistry.addShapelessRecipe(new ItemStack(  itemWeakWoodenDagger , 1, 0), new ItemStack(itemWoodenDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8232));
		GameRegistry.addShapelessRecipe(new ItemStack(  itemSlowWoodenDagger , 1, 0), new ItemStack(itemWoodenDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8234));
		GameRegistry.addShapelessRecipe(new ItemStack(  itemHarmWoodenDagger , 1, 0), new ItemStack(itemWoodenDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8268));

		GameRegistry.addShapelessRecipe(new ItemStack(itemPoisonStoneDagger , 1, 0), new ItemStack(itemStoneDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8196));
		GameRegistry.addShapelessRecipe(new ItemStack(  itemWeakStoneDagger , 1, 0), new ItemStack(itemStoneDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8232));
		GameRegistry.addShapelessRecipe(new ItemStack(  itemSlowStoneDagger , 1, 0), new ItemStack(itemStoneDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8234));
		GameRegistry.addShapelessRecipe(new ItemStack(  itemHarmStoneDagger , 1, 0), new ItemStack(itemStoneDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8268));

		GameRegistry.addShapelessRecipe(new ItemStack(itemPoisonIronDagger , 1, 0), new ItemStack(itemIronDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8196));
		GameRegistry.addShapelessRecipe(new ItemStack(  itemWeakIronDagger , 1, 0), new ItemStack(itemIronDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8232));
		GameRegistry.addShapelessRecipe(new ItemStack(  itemSlowIronDagger , 1, 0), new ItemStack(itemIronDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8234));
		GameRegistry.addShapelessRecipe(new ItemStack(  itemHarmIronDagger , 1, 0), new ItemStack(itemIronDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8268));

		GameRegistry.addShapelessRecipe(new ItemStack(itemPoisonGoldenDagger , 1, 0), new ItemStack(itemGoldenDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8196));
		GameRegistry.addShapelessRecipe(new ItemStack(  itemWeakGoldenDagger , 1, 0), new ItemStack(itemGoldenDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8232));
		GameRegistry.addShapelessRecipe(new ItemStack(  itemSlowGoldenDagger , 1, 0), new ItemStack(itemGoldenDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8234));
		GameRegistry.addShapelessRecipe(new ItemStack(  itemHarmGoldenDagger , 1, 0), new ItemStack(itemGoldenDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8268));

		GameRegistry.addShapelessRecipe(new ItemStack(itemPoisonDiamondDagger , 1, 0), new ItemStack(itemDiamondDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8196));
		GameRegistry.addShapelessRecipe(new ItemStack(  itemWeakDiamondDagger , 1, 0), new ItemStack(itemDiamondDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8232));
		GameRegistry.addShapelessRecipe(new ItemStack(  itemSlowDiamondDagger , 1, 0), new ItemStack(itemDiamondDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8234));
		GameRegistry.addShapelessRecipe(new ItemStack(  itemHarmDiamondDagger , 1, 0), new ItemStack(itemDiamondDagger, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potionitem, 1, 8268));

		GameRegistry.registerItem(itemWoodenDagger , "wooden_dagger" );
		GameRegistry.registerItem(itemStoneDagger  , "stone_dagger"  );
		GameRegistry.registerItem(itemIronDagger   , "iron_dagger"   );
		GameRegistry.registerItem(itemGoldenDagger , "golden_dagger" );
		GameRegistry.registerItem(itemDiamondDagger, "diamond_dagger");
		
		GameRegistry.registerItem(itemPoisonWoodenDagger , "poison_wooden_dagger" );
		GameRegistry.registerItem(itemPoisonStoneDagger  , "poison_stone_dagger"  );
		GameRegistry.registerItem(itemPoisonIronDagger   , "poison_iron_dagger"   );
		GameRegistry.registerItem(itemPoisonGoldenDagger , "poison_golden_dagger" );
		GameRegistry.registerItem(itemPoisonDiamondDagger, "poison_diamond_dagger");
		
		GameRegistry.registerItem(itemWeakWoodenDagger , "weak_wooden_dagger" );
		GameRegistry.registerItem(itemWeakStoneDagger  , "weak_stone_dagger"  );
		GameRegistry.registerItem(itemWeakIronDagger   , "weak_iron_dagger"   );
		GameRegistry.registerItem(itemWeakGoldenDagger , "weak_golden_dagger" );
		GameRegistry.registerItem(itemWeakDiamondDagger, "weak_diamond_dagger");
		
		GameRegistry.registerItem(itemSlowWoodenDagger , "slow_wooden_dagger" );
		GameRegistry.registerItem(itemSlowStoneDagger  , "slow_stone_dagger"  );
		GameRegistry.registerItem(itemSlowIronDagger   , "slow_iron_dagger"   );
		GameRegistry.registerItem(itemSlowGoldenDagger , "slow_golden_dagger" );
		GameRegistry.registerItem(itemSlowDiamondDagger, "slow_diamond_dagger");
		
		GameRegistry.registerItem(itemHarmWoodenDagger , "harm_wooden_dagger" );
		GameRegistry.registerItem(itemHarmStoneDagger  , "harm_stone_dagger"  );
		GameRegistry.registerItem(itemHarmIronDagger   , "harm_iron_dagger"   );
		GameRegistry.registerItem(itemHarmGoldenDagger , "harm_golden_dagger" );
		GameRegistry.registerItem(itemHarmDiamondDagger, "harm_diamond_dagger");
	}
}
