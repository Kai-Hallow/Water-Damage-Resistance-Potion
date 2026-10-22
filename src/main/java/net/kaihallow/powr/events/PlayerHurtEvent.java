package net.kaihallow.powr.events;

import net.kaihallow.powr.effect.ModEffects;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

public class PlayerHurtEvent
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
        if (player.getAirSupply() == 0 && !player.hasEffect(MobEffects.WATER_BREATHING)) return;
        if ((player.getAirSupply() != 0) || !source.is(DamageTypeTags.IS_LIGHTNING)) {
            event.setCanceled(true);
        }

    }
}
