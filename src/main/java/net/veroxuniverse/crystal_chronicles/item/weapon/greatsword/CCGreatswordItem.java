package net.veroxuniverse.crystal_chronicles.item.weapon.greatsword;

import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.spells.IPresetSpellContainer;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.api.spells.SpellData;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import mod.azure.azurelib.common.internal.client.RenderProvider;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.veroxuniverse.crystal_chronicles.item.weapon.AnimatedSwordItem;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class CCGreatswordItem extends AnimatedSwordItem implements IPresetSpellContainer {

    List<SpellData> spellData = null;
    SpellDataRegistryHolder[] spellDataRegistryHolders;

    public CCGreatswordItem(Tier pTier, Properties pProperties, SpellDataRegistryHolder[] spellDataRegistryHolders) {
        super(pTier, pProperties);
        this.spellDataRegistryHolders = spellDataRegistryHolders;
    }

    @Override
    public void createRenderer(Consumer<RenderProvider> consumer) {
        consumer.accept(new RenderProvider() {
            private GreatswordItemRenderer renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (renderer == null)
                    return new GreatswordItemRenderer();
                return this.renderer;
            }
        });
    }

    public List<SpellData> getSpells() {
        if (spellData == null) {
            spellData = Arrays.stream(spellDataRegistryHolders).map(SpellDataRegistryHolder::getSpellData).toList();
            spellDataRegistryHolders = null;
        }
        return spellData;
    }

    @Override
    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }

        if (!ISpellContainer.isSpellContainer(itemStack)) {
            var spells = getSpells();
            var spellContainer = ISpellContainer.create(spells.size(), true, false).mutableCopy();
            spells.forEach(spellData -> spellContainer.addSpell(spellData.getSpell(), spellData.getLevel(), true));
            itemStack.set(ComponentRegistry.SPELL_CONTAINER, spellContainer.toImmutable());
        }
    }

}
