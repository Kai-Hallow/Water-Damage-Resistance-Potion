package net.kaihallow.powr.events;

import net.kaihallow.powr.effect.ModEffects;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

public class PlayerHurtEvent
{
    @SubscribeEvent
    public static void onPlayerHurt(LivingIncomingDamageEvent event)
    {

        if (!(event.getEntity() instanceof Player player)) return;
        if (!player.hasEffect(ModEffects.WATER_RES_EFFECT)) return;
        if (!player.isInWaterOrRain()) return;

        DamageSource source = event.getSource();
        if (source.getEntity() != null || source.getDirectEntity() != null)  return;
        if (player.getAirSupply() == 0) return;
        if ((player.getAirSupply() != 0) || !source.is(DamageTypeTags.IS_LIGHTNING)) {
            event.setCanceled(true);
        }

    }
}
