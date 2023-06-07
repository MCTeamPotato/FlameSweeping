package com.teampotato.flamesweeping.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.FireAspectEnchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;

@SuppressWarnings("NullableProblems")
@Mixin(FireAspectEnchantment.class)
public abstract class FireAspectEnchantmentMixin extends Enchantment {

    protected FireAspectEnchantmentMixin(Rarity pRarity, EnchantmentType pCategory, EquipmentSlotType[] pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return canApplyAtEnchantingTable(pStack) || pStack.getItem().canBeDepleted();
    }
}