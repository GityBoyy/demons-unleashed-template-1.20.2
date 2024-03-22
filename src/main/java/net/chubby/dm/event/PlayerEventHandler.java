package net.chubby.dm.event;


import net.chubby.dm.init.ModFoods;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;

public class PlayerEventHandler
{
    public static void init(){
        UseItemCallback.EVENT.register((player, world, hand) -> {
            ItemStack itemStack = player.getStackInHand(hand);
            Item item = itemStack.getItem();
            if(player.eatFood(world, itemStack)== Items.MILK_BUCKET.getDefaultStack()){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA));
            }
            if(player.eatFood(world,itemStack)== ModFoods.BOILED_MILK_BUCKET.getDefaultStack()){
                player.clearStatusEffects();
            }
            return TypedActionResult.consume(itemStack);
        });
    }
}
