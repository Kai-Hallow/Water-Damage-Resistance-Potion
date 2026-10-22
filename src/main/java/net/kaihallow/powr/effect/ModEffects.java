package net.kaihallow.powr.effect;

import net.kaihallow.powr.POWR;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects
{
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, POWR.MODID);

    public static final Holder<MobEffect> WATER_RES_EFFECT = MOB_EFFECTS.register("water_resistance",
            () -> new WaterResistanceEffect(MobEffectCategory.BENEFICIAL, 0x00000000));

    public static void register(IEventBus eventBus)
    {
        MOB_EFFECTS.register(eventBus);
    }
}
