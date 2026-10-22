package net.kaihallow.powr.events;

import net.kaihallow.powr.effect.ModEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

public class PlayerHurtEvent
{
    @SubscribeEvent
    public static void onPlayerHurt(LivingIncomingDamageEvent event)
    {
        if (!(event.getEntity() instanceof Player player)){
            return;
        }
        DamageSource source = event.getSource();

        if (!player.hasEffect(ModEffects.WATER_RES_EFFECT)) {
            return;
        }

        boolean effect = player.isInWater() && player.hasEffect(ModEffects.WATER_RES_EFFECT);
        boolean waterDamage = source.getEntity() == null && !source.is(DamageTypes.DROWN);
        if (waterDamage && effect) {
            event.setCanceled(true);
        }
    }
}
