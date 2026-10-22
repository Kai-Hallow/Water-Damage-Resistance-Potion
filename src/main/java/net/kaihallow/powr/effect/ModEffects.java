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
    // Required to register new and custom effects
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, POWR.MODID);

    // To register the custom effect (must do this for each individual effect)
    public static final Holder<MobEffect> WATER_RES_EFFECT = MOB_EFFECTS.register("water_resistance",
            () -> new WaterResistanceEffect(MobEffectCategory.BENEFICIAL, 0x00000000));

    // Allows the class to be called in order to register new effects
    // (I think, I just watched a tutorial man, idk what this does.)
    public static void register(IEventBus eventBus)
    {
        MOB_EFFECTS.register(eventBus);
    }
}
