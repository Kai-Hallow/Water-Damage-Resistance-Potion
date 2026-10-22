package net.kaihallow.powr.potion;

import net.kaihallow.powr.POWR;
import net.kaihallow.powr.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, POWR.MOD_ID);

    public static final Holder<Potion> WATER_RES_POTION =POTIONS.register("water_res_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.WATER_RES_EFFECT, 3600, 0)));

    public static final Holder<Potion> WATER_RES_POTION_PLUS =POTIONS.register("water_res_potion_plus",
            () -> new Potion(new MobEffectInstance(ModEffects.WATER_RES_EFFECT, 7200, 0)));

    public static final Holder<Potion> WATER_RES_POTION_MAX =POTIONS.register("water_res_potion_max",
            () -> new Potion(new MobEffectInstance(ModEffects.WATER_RES_EFFECT, 12000, 0)));

    public static void register(IEventBus eventBus){POTIONS.register(eventBus);}
}
