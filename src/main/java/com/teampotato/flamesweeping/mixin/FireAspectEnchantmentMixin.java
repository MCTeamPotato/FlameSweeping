package com.teampotato.flamesweeping.mixin;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.FireAspectEnchantment;
import org.spongepowered.asm.mixin.Mixin;

@SuppressWarnings("NullableProblems")
@Mixin(FireAspectEnchantment.class)
public abstract class FireAspectEnchantmentMixin extends Enchantment {

    protected FireAspectEnchantmentMixin(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot[] pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return canApplyAtEnchantingTable(pStack) || pStack.getItem().canBeDepleted();
    }
}