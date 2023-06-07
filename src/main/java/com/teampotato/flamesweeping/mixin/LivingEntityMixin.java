package com.teampotato.flamesweeping.mixin;

import net.minecraft.world.damagesource.CombatTracker;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow public abstract CombatTracker getCombatTracker();

    @Inject(method = "actuallyHurt", at = @At("HEAD"))
    private void actuallyHurt(DamageSource source, float amount, CallbackInfo ci) {
        Entity sourceEntity = source.getEntity();
        if (sourceEntity instanceof LivingEntity && source.getDirectEntity() != null) {
            int aspect = EnchantmentHelper.getFireAspect((LivingEntity) sourceEntity);
            LivingEntity mob = getCombatTracker().getMob();
            if (mob.isAlive() && aspect > 0 && !mob.isOnFire()) mob.setSecondsOnFire(4 * aspect);
        }
    }
}
