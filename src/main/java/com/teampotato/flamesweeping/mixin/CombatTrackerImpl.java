package com.teampotato.flamesweeping.mixin;

import com.teampotato.flamesweeping.api.ExtendedCombatTracker;
import net.minecraft.world.damagesource.CombatTracker;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CombatTracker.class)
public class CombatTrackerImpl implements ExtendedCombatTracker {
    @Shadow @Final private LivingEntity mob;

    @Override
    public LivingEntity flameSweeping$getMob() {
        return this.mob;
    }
}
