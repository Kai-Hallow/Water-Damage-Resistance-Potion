package net.kaihallow.powr.event;

import net.kaihallow.powr.effect.ModEffects;
import net.kaihallow.powr.potion.ModPotions;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber
public class ModEvents
{
    @SubscribeEvent
    public static void onPlayerHurt(LivingIncomingDamageEvent event)
    {
        //To test if the player is even in the world, if they meet the conditions for the
        //effect to be applied
        if (!(event.getEntity() instanceof Player player)) return;
        if (!player.hasEffect(ModEffects.WATER_RES_EFFECT)) return; //Condition: Player must have potion effect
        if (!player.isInWaterOrRain()) return; //Condition: Player must be wet

        // To see whether the player is hurt by something other than water alone
        DamageSource source = event.getSource();
        if (source.getEntity() != null || source.getDirectEntity() != null)  return;
        //required because otherwise for some reason player will be immune to drowning
        //The second part is to negate this if they have water breathing
        if (player.getAirSupply() == 0) return;
        if ((player.getAirSupply() != 0) || !source.is(DamageTypeTags.IS_LIGHTNING)) {
            event.setCanceled(true);
        }

    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event)
    {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, Items.SALMON, ModPotions.WATER_RES_POTION);
    }


}
