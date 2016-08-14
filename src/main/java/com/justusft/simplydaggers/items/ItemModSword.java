package com.justusft.simplydaggers.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;

import com.justusft.simplydaggers.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemModSword extends ItemSword {
	private String daggerID;
	private String potionName;
	private IIcon overlay;
	private IIcon sword;
	public ItemModSword(String unlocalizedName, ToolMaterial material, String id, String pot) {
		super(material);
		daggerID = id;
		potionName = pot;
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Main.MODID + ":" + unlocalizedName);
	}
	
	//Texture overlays for tipped daggers
	@Override
	public IIcon getIconFromDamageForRenderPass(int damage, int pass) {
		if(pass == 0) {
			return this.sword;
		}
		else {
			return this.overlay;
		}
	}
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}
	@Override 
	public void registerIcons(IIconRegister i) {
		this.sword = i.registerIcon("SimplyDaggers:" + daggerID);	
		this.overlay = i.registerIcon("SimplyDaggers:dagger_" + potionName);
	}
	
	//Potion effects on entities
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase player)
    {
		ItemModSword heldDaggerType = null;
		int currentDamage = stack.getItemDamage();
		
    	ItemModSword daggers[][] = {
			{ModItems.itemWoodenDagger, ModItems.itemPoisonWoodenDagger, ModItems.itemWeakWoodenDagger, ModItems.itemSlowWoodenDagger, ModItems.itemHarmWoodenDagger},
			{ModItems.itemStoneDagger, ModItems.itemPoisonStoneDagger, ModItems.itemWeakStoneDagger, ModItems.itemSlowStoneDagger, ModItems.itemHarmStoneDagger},
			{ModItems.itemIronDagger, ModItems.itemPoisonIronDagger, ModItems.itemWeakIronDagger, ModItems.itemSlowIronDagger, ModItems.itemHarmIronDagger},
			{ModItems.itemGoldenDagger, ModItems.itemPoisonGoldenDagger, ModItems.itemWeakGoldenDagger, ModItems.itemSlowGoldenDagger, ModItems.itemHarmGoldenDagger},
			{ModItems.itemDiamondDagger, ModItems.itemPoisonDiamondDagger, ModItems.itemWeakDiamondDagger, ModItems.itemSlowDiamondDagger, ModItems.itemHarmDiamondDagger}
		};
    	ItemModSword daggerTypes[] = {ModItems.itemWoodenDagger, ModItems.itemStoneDagger, ModItems.itemIronDagger, ModItems.itemGoldenDagger, ModItems.itemDiamondDagger};
		
		for(int i = 0; i < daggers.length; i++) {
			for(int j = 0; j < daggers[i].length; j++) {
				if(daggers[i][j] == stack.getItem()) heldDaggerType = daggerTypes[i];
			}
		}
		
		ItemStack stackData = new ItemStack(heldDaggerType, 1, currentDamage + 1);
		stackData.setTagCompound(stack.getTagCompound());
    	if(potionName.equals("poison")) {
    		target.addPotionEffect(new PotionEffect(Potion.poison.id, 440));
    		player.setCurrentItemOrArmor(0, stackData);
    	} else if(potionName.equals("weakness")) {
    		target.addPotionEffect(new PotionEffect(Potion.weakness.id, 1200));
    		player.setCurrentItemOrArmor(0, stackData);
    	} else if(potionName.equals("slowness")) {
    		target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
    		player.setCurrentItemOrArmor(0, stackData);
    	} else if(potionName.equals("harming")) {
    		target.addPotionEffect(new PotionEffect(Potion.harm.id, 1));
    		player.setCurrentItemOrArmor(0, stackData);
    	}
    	stack.damageItem(1, player);
    	if(stack.getItem().getMaxDamage() < stack.getItemDamage()) --stack.stackSize;
        return true;
    }
    
	//Override sword block
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
		return EnumAction.none;
    }
}
