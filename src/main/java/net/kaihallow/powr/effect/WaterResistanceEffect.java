package net.kaihallow.powr.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class WaterResistanceEffect extends MobEffect
{

    public WaterResistanceEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    //Decides whether or not the effect is applied, in this case the effect will show up
    // but it will only work under the designated condition, in this case, if player is wet.
    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.isInWaterOrRain()) {
            return true;
        }

        //If the player is not wet then it just keeps the effect attached to the
        // entity it was used on
        return super.applyEffectTick(livingEntity, amplifier);
    }

    // Keeps it going for however long the effect is suppost to last
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
