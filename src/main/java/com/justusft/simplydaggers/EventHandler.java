package com.justusft.simplydaggers;

import java.util.Arrays;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
//import scala.actors.threadpool.Arrays;

import com.justusft.simplydaggers.items.ItemModSword;
import com.justusft.simplydaggers.items.ModItems;

import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

@Cancelable
public class EventHandler {
	final ItemStack[] daggers = {ModItems.IS_WoodenDagger,ModItems.IS_StoneDagger,ModItems.IS_IronDagger,ModItems.IS_GoldenDagger,ModItems.IS_DiamondDagger};

	//retain bottle after crafting a dagger
	@SubscribeEvent
	public void craftedPotionDagger(final ItemCraftedEvent event) {
		ItemModSword[] daggers = {ModItems.itemWoodenDagger,ModItems.itemStoneDagger,ModItems.itemIronDagger,ModItems.itemGoldenDagger,ModItems.itemDiamondDagger};
		ItemModSword[] tippedDaggers = {ModItems.itemPoisonWoodenDagger,ModItems.itemPoisonStoneDagger,ModItems.itemPoisonIronDagger,ModItems.itemPoisonGoldenDagger,ModItems.itemPoisonDiamondDagger,ModItems.itemWeakWoodenDagger,ModItems.itemWeakStoneDagger,ModItems.itemWeakIronDagger, ModItems.itemWeakGoldenDagger,ModItems.itemWeakDiamondDagger,ModItems.itemSlowWoodenDagger,ModItems.itemSlowStoneDagger,ModItems.itemSlowIronDagger,ModItems.itemSlowGoldenDagger,ModItems.itemSlowDiamondDagger,ModItems.itemHarmWoodenDagger,ModItems.itemHarmStoneDagger,ModItems.itemHarmIronDagger,ModItems.itemHarmGoldenDagger,ModItems.itemHarmDiamondDagger};
		if(Arrays.asList(tippedDaggers).contains(event.crafting.getItem())) {
			for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
				if(event.craftMatrix.getStackInSlot(i) != null && event.craftMatrix.getStackInSlot(i).getItem() == Items.potionitem) {
					final int slot = i;
					//bottle is delayed because it seems to not work if done immediately
					new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            @Override
				            public void run() {
				            	event.craftMatrix.setInventorySlotContents(slot, new ItemStack(Items.glass_bottle, 1));
				            }
				        }, 
				        10
					);
				}
				//target the dagger
				if(event.craftMatrix.getStackInSlot(i) != null && Arrays.asList(daggers).contains(event.craftMatrix.getStackInSlot(i).getItem())) {
					event.crafting.setItemDamage(event.craftMatrix.getStackInSlot(i).getItemDamage());
					if(event.craftMatrix.getStackInSlot(i).getEnchantmentTagList() != null) {
						event.crafting.setTagCompound(event.craftMatrix.getStackInSlot(i).getTagCompound());
					}
				}
			}
		}
	}
	
	//direct attacking event
	@SubscribeEvent
	public void daggerAttack(final AttackEntityEvent event) {
		for(int i = 0; i < daggers.length; i++) {
			//if entity is attacked with a dagger
			if(event.entityLiving.getHeldItem() != null && event.entityPlayer.getHeldItem().getItem() == daggers[i].getItem()) {
				//daggers have a shorter range; if they attack from too far the event cancels
				if(event.target.getDistanceToEntity(event.entityPlayer) > 2.5) {
					event.setCanceled(true);
					return;
				}
				if(event.target.hurtResistantTime == 0) {
					//cancel out majority of knockback
					double trigRot = (event.entityPlayer.rotationYawHead-90) * (Math.PI/180);
					event.target.velocityChanged = true; //dunno if necessary, or put below, here seems to work ok
					event.target.addVelocity(Math.cos(trigRot) * 0.5, -0.25, Math.sin(trigRot) * 0.5);

					//reset entity's hurtResistantTime after a bit
					//because daggers have a faster cooldown
					new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            @Override
				            public void run() {
				            	event.target.hurtResistantTime = 0;
				            }
				        }, 
				        250
					);
					//Backstab bonus
					double targetYaw = Math.abs(event.target.getRotationYawHead() % 360);
					double playerYaw = Math.abs(event.entityPlayer.rotationYawHead % 360);
					boolean isBehind = Math.abs(targetYaw - playerYaw) < 60 || Math.abs(targetYaw - playerYaw) > 300;

					if(isBehind) {
//						System.out.println("BACKSTAB");
						event.target.attackEntityFrom(DamageSource.causePlayerDamage(event.entityPlayer), 4);
						event.target.playSound("random.successful_hit", 1.0F, 0.5F);
					}
				}
			}
		}
	}
}
