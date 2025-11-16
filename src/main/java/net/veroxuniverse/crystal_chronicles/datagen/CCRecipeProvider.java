package net.veroxuniverse.crystal_chronicles.datagen;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmithingTransformRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;
import net.veroxuniverse.crystal_chronicles.registry.CCItems;

import java.util.concurrent.CompletableFuture;

public class CCRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public CCRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.BRONCHUS_SLAB.get(), CCBlocks.BRONCHUS_PLANKS);
        stairBuilder(CCBlocks.BRONCHUS_STAIRS.get(), Ingredient.of(CCBlocks.BRONCHUS_PLANKS.get())).group("bronchus_planks")
                .unlockedBy("has_bronchus_planks", has(CCBlocks.BRONCHUS_PLANKS.get())).save(pRecipeOutput);
        doorBuilder(CCBlocks.BRONCHUS_DOOR.get(), Ingredient.of(CCBlocks.BRONCHUS_PLANKS.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(CCBlocks.BRONCHUS_PLANKS.get())).save(pRecipeOutput);
        trapdoorBuilder(CCBlocks.BRONCHUS_TRAPDOOR.get(), Ingredient.of(CCBlocks.BRONCHUS_PLANKS.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(CCBlocks.BRONCHUS_PLANKS.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, CCBlocks.BRONCHUS_PRESSURE_PLATE.get(), CCBlocks.BRONCHUS_PLANKS.get());
        buttonBuilder(CCBlocks.BRONCHUS_BUTTON.get(), Ingredient.of(CCBlocks.BRONCHUS_PLANKS.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(CCBlocks.BRONCHUS_PLANKS.get())).save(pRecipeOutput);
        fenceBuilder(CCBlocks.BRONCHUS_FENCE.get(), Ingredient.of(CCBlocks.BRONCHUS_PLANKS.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(CCBlocks.BRONCHUS_PLANKS.get())).save(pRecipeOutput);
        fenceGateBuilder(CCBlocks.BRONCHUS_FENCE_GATE.get(), Ingredient.of(CCBlocks.BRONCHUS_PLANKS.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(CCBlocks.BRONCHUS_PLANKS.get())).save(pRecipeOutput);

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRUSTONE_SLAB.get(), CCBlocks.CRUSTONE);
        stairBuilder(CCBlocks.CRUSTONE_STAIRS.get(), Ingredient.of(CCBlocks.CRUSTONE.get())).group("crustone")
                .unlockedBy("has_crustone", has(CCBlocks.CRUSTONE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRUSTONE_WALL.get(), CCBlocks.CRUSTONE.get());

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRUSTONE_BRICKS_SLAB.get(), CCBlocks.CRUSTONE_BRICKS);
        stairBuilder(CCBlocks.CRUSTONE_BRICKS_STAIRS.get(), Ingredient.of(CCBlocks.CRUSTONE_BRICKS.get())).group("crustone_bricks")
                .unlockedBy("has_crustone_bricks", has(CCBlocks.CRUSTONE_BRICKS.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRUSTONE_BRICKS_WALL.get(), CCBlocks.CRUSTONE_BRICKS.get());

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_CRUSTONE_BRICKS_SLAB.get(), CCBlocks.CRACKED_CRUSTONE_BRICKS);
        stairBuilder(CCBlocks.CRACKED_CRUSTONE_BRICKS_STAIRS.get(), Ingredient.of(CCBlocks.CRUSTONE.get())).group("cracked_crustone_bricks")
                .unlockedBy("has_cracked_crustone_bricks", has(CCBlocks.CRUSTONE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_CRUSTONE_BRICKS_WALL.get(), CCBlocks.CRACKED_CRUSTONE_BRICKS.get());

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_CRUSTONE_SLAB.get(), CCBlocks.POLISHED_CRUSTONE);
        stairBuilder(CCBlocks.POLISHED_CRUSTONE_STAIRS.get(), Ingredient.of(CCBlocks.POLISHED_CRUSTONE.get())).group("polished_crustone")
                .unlockedBy("has_polished_crustone", has(CCBlocks.POLISHED_CRUSTONE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_CRUSTONE_WALL.get(), CCBlocks.POLISHED_CRUSTONE.get());

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_CRUSTONE_SLAB.get(), CCBlocks.CHISELED_CRUSTONE);
        stairBuilder(CCBlocks.CHISELED_CRUSTONE_STAIRS.get(), Ingredient.of(CCBlocks.CHISELED_CRUSTONE.get())).group("chiseled_crustone")
                .unlockedBy("chiseled_crustone_crustone", has(CCBlocks.CHISELED_CRUSTONE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_CRUSTONE_WALL.get(), CCBlocks.CHISELED_CRUSTONE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CCBlocks.FAT_TISSUE_BLOCK.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', CCItems.FAT_TISSUE_BALL.get())
                .unlockedBy("has_fat_tissue_ball", has(CCItems.FAT_TISSUE_BALL.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CCBlocks.EYE_BLOCK.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', CCItems.EYE.get())
                .unlockedBy("has_eye", has(CCItems.EYE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CCBlocks.CELVER_LIGHT.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('B', CCBlocks.CHISELED_CRUSTONE.get())
                .define('A', CCItems.EYE.get())
                .unlockedBy("has_eye", has(CCItems.EYE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CCBlocks.NEURON_BLOCK.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('B', CCItems.NEURON.get())
                .define('A', Blocks.GLOWSTONE)
                .unlockedBy("has_neuron", has(CCItems.NEURON.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CCBlocks.NEURON_TORCH.get())
                .pattern("B")
                .pattern("A")
                .define('B', CCItems.NEURON.get())
                .define('A', CCBlocks.AXON)
                .unlockedBy("has_neuron", has(CCItems.NEURON.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CCBlocks.ROTTEN_FLESH_BLOCK.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', Items.ROTTEN_FLESH)
                .unlockedBy("has_rotten_flesh", has(Items.ROTTEN_FLESH)).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ROTTEN_FLESH, 4)
                .requires(CCBlocks.ROTTEN_FLESH_BLOCK.get())
                .unlockedBy("has_rotten_flesh", has(CCBlocks.ROTTEN_FLESH_BLOCK.get())).save(pRecipeOutput);

        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(ItemRegistry.FIRE_RUNE.get()),
                Ingredient.of(ItemRegistry.PYROMANCER_HELMET.get()),
                Ingredient.of(CCItems.VOLCANITE_SHARD.get()),
                RecipeCategory.COMBAT,
                CCItems.PYROMANCER_HELMET.get()
        )
                .unlocks("has_fire_rune", has(ItemRegistry.FIRE_RUNE.get()))
                .save(pRecipeOutput, "pyromancer_helmet_smithing");
        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(ItemRegistry.FIRE_RUNE.get()),
                Ingredient.of(ItemRegistry.PYROMANCER_CHESTPLATE.get()),
                Ingredient.of(CCItems.VOLCANITE_SHARD.get()),
                RecipeCategory.COMBAT,
                CCItems.PYROMANCER_CHESTPLATE.get()
        )
                .unlocks("has_fire_rune", has(ItemRegistry.FIRE_RUNE.get()))
                .save(pRecipeOutput, "pyromancer_chestplate_smithing");
        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(ItemRegistry.FIRE_RUNE.get()),
                Ingredient.of(ItemRegistry.PYROMANCER_LEGGINGS.get()),
                Ingredient.of(CCItems.VOLCANITE_SHARD.get()),
                RecipeCategory.COMBAT,
                CCItems.PYROMANCER_LEGGINGS.get()
        )
                .unlocks("has_fire_rune", has(ItemRegistry.FIRE_RUNE.get()))
                .save(pRecipeOutput, "pyromancer_leggings_smithing");
        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of( ItemRegistry.FIRE_RUNE.get()),
                Ingredient.of(ItemRegistry.PYROMANCER_BOOTS.get()),
                Ingredient.of(CCItems.VOLCANITE_SHARD.get()),
                RecipeCategory.COMBAT,
                CCItems.PYROMANCER_BOOTS.get()
        )
                .unlocks("has_fire_rune", has(ItemRegistry.FIRE_RUNE.get()))
                .save(pRecipeOutput, "pyromancer_boots_smithing");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CCItems.CHAKRAM.get())
                .pattern(" S ")
                .pattern("SNS")
                .pattern(" S ")
                .define('S', CCItems.VOLCANITE_SHARD.get())
                .define('N', Items.STICK)
                .unlockedBy("has_fire_rune", has(ItemRegistry.FIRE_RUNE.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CCItems.VOLCANITE_SHARD.get(), 1)
                .requires(Items.BLAZE_ROD)
                .requires(ItemRegistry.MITHRIL_INGOT.get())
                .requires(Items.AMETHYST_SHARD)
                .unlockedBy("has_fire_rune", has(ItemRegistry.FIRE_RUNE.get()))
                .save(pRecipeOutput);

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.HOLY_RUNE.get()),
                        Ingredient.of(ItemRegistry.PRIEST_HELMET.get()),
                        Ingredient.of(CCItems.DIVINITE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.PALADIN_HELMET.get()
                )
                .unlocks("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(pRecipeOutput, "paladin_helmet_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.HOLY_RUNE.get()),
                        Ingredient.of(ItemRegistry.PRIEST_CHESTPLATE.get()),
                        Ingredient.of(CCItems.DIVINITE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.PALADIN_CHESTPLATE.get()
                )
                .unlocks("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(pRecipeOutput, "paladin_chestplate_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.HOLY_RUNE.get()),
                        Ingredient.of(ItemRegistry.PRIEST_LEGGINGS.get()),
                        Ingredient.of(CCItems.DIVINITE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.PALADIN_LEGGINGS.get()
                )
                .unlocks("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(pRecipeOutput, "paladin_leggings_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.HOLY_RUNE.get()),
                        Ingredient.of(ItemRegistry.PRIEST_BOOTS.get()),
                        Ingredient.of(CCItems.DIVINITE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.PALADIN_BOOTS.get()
                )
                .unlocks("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(pRecipeOutput, "paladin_boots_smithing");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CCItems.PALADIN_SWORD.get())
                .pattern("S")
                .pattern("S")
                .pattern("N")
                .define('S', CCItems.DIVINITE_SHARD.get())
                .define('N', Items.STICK)
                .unlockedBy("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CCItems.PALADIN_SHIELD.get())
                .pattern("ISI")
                .pattern("ISI")
                .pattern(" I ")
                .define('S', CCItems.DIVINITE_SHARD.get())
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CCItems.DIVINITE_SHARD.get(), 1)
                .requires(ItemRegistry.DIVINE_PEARL.get())
                .requires(ItemRegistry.MITHRIL_INGOT.get())
                .requires(Items.AMETHYST_SHARD)
                .unlockedBy("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(pRecipeOutput);

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.ICE_RUNE.get()),
                        Ingredient.of(ItemRegistry.CRYOMANCER_HELMET.get()),
                        Ingredient.of(CCItems.ICE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.TANK_HELMET.get()
                )
                .unlocks("has_ice_rune", has(ItemRegistry.ICE_RUNE.get()))
                .save(pRecipeOutput, "tank_helmet_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.ICE_RUNE.get()),
                        Ingredient.of(ItemRegistry.CRYOMANCER_CHESTPLATE.get()),
                        Ingredient.of(CCItems.ICE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.TANK_CHESTPLATE.get()
                )
                .unlocks("has_ice_rune", has(ItemRegistry.ICE_RUNE.get()))
                .save(pRecipeOutput, "tank_chestplate_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.ICE_RUNE.get()),
                        Ingredient.of(ItemRegistry.CRYOMANCER_LEGGINGS.get()),
                        Ingredient.of(CCItems.ICE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.TANK_LEGGINGS.get()
                )
                .unlocks("has_ice_rune", has(ItemRegistry.ICE_RUNE.get()))
                .save(pRecipeOutput, "tank_leggings_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.ICE_RUNE.get()),
                        Ingredient.of(ItemRegistry.CRYOMANCER_BOOTS.get()),
                        Ingredient.of(CCItems.ICE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.TANK_BOOTS.get()
                )
                .unlocks("has_ice_rune", has(ItemRegistry.ICE_RUNE.get()))
                .save(pRecipeOutput, "tank_boots_smithing");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CCItems.ICE_HAMMER.get())
                .pattern("SSS")
                .pattern("SIS")
                .pattern(" I ")
                .define('S', CCItems.ICE_SHARD.get())
                .define('I', Items.STICK)
                .unlockedBy("has_ice_rune", has(ItemRegistry.ICE_RUNE.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CCItems.ICE_SHARD.get(), 1)
                .requires(ItemRegistry.FROZEN_BONE_SHARD.get())
                .requires(ItemRegistry.MITHRIL_INGOT.get())
                .requires(Items.AMETHYST_SHARD)
                .unlockedBy("has_ice_rune", has(ItemRegistry.ICE_RUNE.get()))
                .save(pRecipeOutput);

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.ENDER_RUNE.get()),
                        Ingredient.of(ItemRegistry.SHADOWWALKER_HELMET.get()),
                        Ingredient.of(CCItems.VOIDSTONE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.MAGE_HELMET.get()
                )
                .unlocks("has_ender_rune", has(ItemRegistry.ENDER_RUNE.get()))
                .save(pRecipeOutput, "mage_helmet_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.ENDER_RUNE.get()),
                        Ingredient.of(ItemRegistry.SHADOWWALKER_CHESTPLATE.get()),
                        Ingredient.of(CCItems.VOIDSTONE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.MAGE_CHESTPLATE.get()
                )
                .unlocks("has_ender_rune", has(ItemRegistry.ENDER_RUNE.get()))
                .save(pRecipeOutput, "mage_chestplate_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.ENDER_RUNE.get()),
                        Ingredient.of(ItemRegistry.SHADOWWALKER_LEGGINGS.get()),
                        Ingredient.of(CCItems.VOIDSTONE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.MAGE_LEGGINGS.get()
                )
                .unlocks("has_ender_rune", has(ItemRegistry.ENDER_RUNE.get()))
                .save(pRecipeOutput, "mage_leggings_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.ENDER_RUNE.get()),
                        Ingredient.of(ItemRegistry.SHADOWWALKER_BOOTS.get()),
                        Ingredient.of(CCItems.VOIDSTONE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.MAGE_BOOTS.get()
                )
                .unlocks("has_ender_rune", has(ItemRegistry.ENDER_RUNE.get()))
                .save(pRecipeOutput, "mage_boots_smithing");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CCItems.STAFF.get())
                .pattern("S")
                .pattern("N")
                .pattern("N")
                .define('S', CCItems.VOIDSTONE_SHARD.get())
                .define('N', Items.STICK)
                .unlockedBy("has_ender_rune", has(ItemRegistry.ENDER_RUNE.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CCItems.VOIDSTONE_SHARD.get(), 1)
                .requires(Items.ENDER_PEARL)
                .requires(ItemRegistry.MITHRIL_INGOT.get())
                .requires(Items.AMETHYST_SHARD)
                .unlockedBy("has_ender_rune", has(ItemRegistry.ENDER_RUNE.get()))
                .save(pRecipeOutput);

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.BLOOD_RUNE.get()),
                        Ingredient.of(ItemRegistry.CULTIST_HELMET.get()),
                        Ingredient.of(CCItems.HEMALITE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.ROGUE_HELMET.get()
                )
                .unlocks("has_blood_rune", has(ItemRegistry.BLOOD_RUNE.get()))
                .save(pRecipeOutput, "rogue_helmet_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.BLOOD_RUNE.get()),
                        Ingredient.of(ItemRegistry.CULTIST_CHESTPLATE.get()),
                        Ingredient.of(CCItems.HEMALITE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.ROGUE_CHESTPLATE.get()
                )
                .unlocks("has_blood_rune", has(ItemRegistry.BLOOD_RUNE.get()))
                .save(pRecipeOutput, "rogue_chestplate_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.BLOOD_RUNE.get()),
                        Ingredient.of(ItemRegistry.CULTIST_LEGGINGS.get()),
                        Ingredient.of(CCItems.HEMALITE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.ROGUE_LEGGINGS.get()
                )
                .unlocks("has_blood_rune", has(ItemRegistry.BLOOD_RUNE.get()))
                .save(pRecipeOutput, "rogue_leggings_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.BLOOD_RUNE.get()),
                        Ingredient.of(ItemRegistry.CULTIST_BOOTS.get()),
                        Ingredient.of(CCItems.HEMALITE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.ROGUE_BOOTS.get()
                )
                .unlocks("has_blood_rune", has(ItemRegistry.BLOOD_RUNE.get()))
                .save(pRecipeOutput, "rogue_boots_smithing");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CCItems.BLOOD_SCYTHE.get())
                .pattern("SS")
                .pattern("SN")
                .pattern(" N")
                .define('S', CCItems.HEMALITE_SHARD.get())
                .define('N', Items.STICK)
                .unlockedBy("has_blood_rune", has(ItemRegistry.BLOOD_RUNE.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CCItems.HEMALITE_SHARD.get(), 1)
                .requires(ItemRegistry.BLOOD_VIAL.get())
                .requires(ItemRegistry.MITHRIL_INGOT.get())
                .requires(Items.AMETHYST_SHARD)
                .unlockedBy("has_blood_rune", has(ItemRegistry.BLOOD_RUNE.get()))
                .save(pRecipeOutput);

        //

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.NATURE_RUNE.get()),
                        Ingredient.of(ItemRegistry.PLAGUED_HELMET.get()),
                        Ingredient.of(CCItems.FLORALITE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.TOXIC_HELMET.get()
                )
                .unlocks("has_nature_rune", has(ItemRegistry.NATURE_RUNE.get()))
                .save(pRecipeOutput, "toxic_helmet_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.NATURE_RUNE.get()),
                        Ingredient.of(ItemRegistry.PLAGUED_CHESTPLATE.get()),
                        Ingredient.of(CCItems.FLORALITE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.TOXIC_CHESTPLATE.get()
                )
                .unlocks("has_nature_rune", has(ItemRegistry.NATURE_RUNE.get()))
                .save(pRecipeOutput, "toxic_chestplate_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.NATURE_RUNE.get()),
                        Ingredient.of(ItemRegistry.PLAGUED_LEGGINGS.get()),
                        Ingredient.of(CCItems.FLORALITE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.TOXIC_LEGGINGS.get()
                )
                .unlocks("has_nature_rune", has(ItemRegistry.NATURE_RUNE.get()))
                .save(pRecipeOutput, "toxic_leggings_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.NATURE_RUNE.get()),
                        Ingredient.of(ItemRegistry.PLAGUED_BOOTS.get()),
                        Ingredient.of(CCItems.FLORALITE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.TOXIC_BOOTS.get()
                )
                .unlocks("has_nature_rune", has(ItemRegistry.NATURE_RUNE.get()))
                .save(pRecipeOutput, "toxic_boots_smithing");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CCItems.SPEAR.get())
                .pattern(" SS")
                .pattern(" NS")
                .pattern("N  ")
                .define('S', CCItems.FLORALITE_SHARD.get())
                .define('N', Items.STICK)
                .unlockedBy("has_nature_rune", has(ItemRegistry.NATURE_RUNE.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CCItems.FLORALITE_SHARD.get(), 1)
                .requires(Items.POISONOUS_POTATO)
                .requires(ItemRegistry.MITHRIL_INGOT.get())
                .requires(Items.AMETHYST_SHARD)
                .unlockedBy("has_nature_rune", has(ItemRegistry.NATURE_RUNE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CCItems.LIGHTNING_BIDENT.get())
                .pattern(" SS")
                .pattern(" NS")
                .pattern("N  ")
                .define('S', CCItems.VOLTITE_SHARD.get())
                .define('N', Items.STICK)
                .unlockedBy("has_lightning_rune", has(ItemRegistry.LIGHTNING_RUNE.get()))
                .save(pRecipeOutput);

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.LIGHTNING_RUNE.get()),
                        Ingredient.of(ItemRegistry.ELECTROMANCER_HELMET.get()),
                        Ingredient.of(CCItems.VOLTITE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.ELECTROMANCER_HELMET.get()
                )
                .unlocks("has_lightning_rune", has(ItemRegistry.NATURE_RUNE.get()))
                .save(pRecipeOutput, "electromancer_helmet_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.LIGHTNING_RUNE.get()),
                        Ingredient.of(ItemRegistry.ELECTROMANCER_CHESTPLATE.get()),
                        Ingredient.of(CCItems.VOLTITE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.ELECTROMANCER_CHESTPLATE.get()
                )
                .unlocks("has_lightning_rune", has(ItemRegistry.NATURE_RUNE.get()))
                .save(pRecipeOutput, "electromancer_chestplate_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.LIGHTNING_RUNE.get()),
                        Ingredient.of(ItemRegistry.ELECTROMANCER_LEGGINGS.get()),
                        Ingredient.of(CCItems.VOLTITE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.ELECTROMANCER_LEGGINGS.get()
                )
                .unlocks("has_lightning_rune", has(ItemRegistry.NATURE_RUNE.get()))
                .save(pRecipeOutput, "electromancer_leggings_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.LIGHTNING_RUNE.get()),
                        Ingredient.of(ItemRegistry.ELECTROMANCER_BOOTS.get()),
                        Ingredient.of(CCItems.VOLTITE_SHARD.get()),
                        RecipeCategory.COMBAT,
                        CCItems.ELECTROMANCER_BOOTS.get()
                )
                .unlocks("has_lightning_rune", has(ItemRegistry.NATURE_RUNE.get()))
                .save(pRecipeOutput, "electromancer_boots_smithing");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CCItems.VOLTITE_SHARD.get(), 1)
                .requires(ItemRegistry.LIGHTNING_BOTTLE.get())
                .requires(ItemRegistry.MITHRIL_INGOT.get())
                .requires(Items.AMETHYST_SHARD)
                .unlockedBy("has_lightning_rune", has(ItemRegistry.LIGHTNING_RUNE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CCItems.EVOCATION_TWINBLADE.get())
                .pattern(" SE")
                .pattern(" N ")
                .pattern("ES ")
                .define('S', Items.TOTEM_OF_UNDYING)
                .define('E', Items.EMERALD)
                .define('N', Items.STICK)
                .unlockedBy("has_evocation_rune", has(ItemRegistry.EVOCATION_RUNE.get()))
                .save(pRecipeOutput);

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.EVOCATION_RUNE.get()),
                        Ingredient.of(ItemRegistry.ARCHEVOKER_HELMET.get()),
                        Ingredient.of(Items.TOTEM_OF_UNDYING),
                        RecipeCategory.COMBAT,
                        CCItems.EVOKER_HELMET.get()
                )
                .unlocks("has_evocation_rune", has(ItemRegistry.EVOCATION_RUNE.get()))
                .save(pRecipeOutput, "evoker_helmet_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.EVOCATION_RUNE.get()),
                        Ingredient.of(ItemRegistry.ARCHEVOKER_CHESTPLATE.get()),
                        Ingredient.of(Items.TOTEM_OF_UNDYING),
                        RecipeCategory.COMBAT,
                        CCItems.EVOKER_CHESTPLATE.get()
                )
                .unlocks("has_evocation_rune", has(ItemRegistry.EVOCATION_RUNE.get()))
                .save(pRecipeOutput, "evoker_chestplate_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.EVOCATION_RUNE.get()),
                        Ingredient.of(ItemRegistry.ARCHEVOKER_LEGGINGS.get()),
                        Ingredient.of(Items.TOTEM_OF_UNDYING),
                        RecipeCategory.COMBAT,
                        CCItems.EVOKER_LEGGINGS.get()
                )
                .unlocks("has_evocation_rune", has(ItemRegistry.EVOCATION_RUNE.get()))
                .save(pRecipeOutput, "evoker_leggings_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.EVOCATION_RUNE.get()),
                        Ingredient.of(ItemRegistry.ARCHEVOKER_BOOTS.get()),
                        Ingredient.of(Items.TOTEM_OF_UNDYING),
                        RecipeCategory.COMBAT,
                        CCItems.EVOKER_BOOTS.get()
                )
                .unlocks("has_evocation_rune", has(ItemRegistry.EVOCATION_RUNE.get()))
                .save(pRecipeOutput, "evoker_boots_smithing");

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.HOLY_MARBLE_SLAB.get(), CCBlocks.HOLY_MARBLE);
        stairBuilder(CCBlocks.HOLY_MARBLE_STAIRS.get(), Ingredient.of(CCBlocks.HOLY_MARBLE.get())).group("holy_marble")
                .unlockedBy("has_holy_marble", has(CCBlocks.HOLY_MARBLE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.HOLY_MARBLE_WALL.get(), CCBlocks.HOLY_MARBLE.get());

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.HOLY_MARBLE_BRICKS_SLAB.get(), CCBlocks.HOLY_MARBLE_BRICKS);
        stairBuilder(CCBlocks.HOLY_MARBLE_BRICKS_STAIRS.get(), Ingredient.of(CCBlocks.HOLY_MARBLE_BRICKS.get())).group("holy_marble_bricks")
                .unlockedBy("has_holy_marble_bricks", has(CCBlocks.HOLY_MARBLE_BRICKS.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.HOLY_MARBLE_BRICKS_WALL.get(), CCBlocks.HOLY_MARBLE_BRICKS.get());

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_HOLY_MARBLE_SLAB.get(), CCBlocks.CHISELED_HOLY_MARBLE);
        stairBuilder(CCBlocks.CHISELED_HOLY_MARBLE_STAIRS.get(), Ingredient.of(CCBlocks.CHISELED_HOLY_MARBLE.get())).group("chiseled_holy_marble")
                .unlockedBy("has_chiseled_holy_marble", has(CCBlocks.CHISELED_HOLY_MARBLE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_HOLY_MARBLE_WALL.get(), CCBlocks.CHISELED_HOLY_MARBLE.get());

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_HOLY_MARBLE_SLAB.get(), CCBlocks.CRACKED_HOLY_MARBLE);
        stairBuilder(CCBlocks.CRACKED_HOLY_MARBLE_STAIRS.get(), Ingredient.of(CCBlocks.CRACKED_HOLY_MARBLE.get())).group("cracked_holy_marble")
                .unlockedBy("has_cracked_holy_marble", has(CCBlocks.CRACKED_HOLY_MARBLE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_HOLY_MARBLE_WALL.get(), CCBlocks.CRACKED_HOLY_MARBLE.get());

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_HOLY_MARBLE_SLAB.get(), CCBlocks.POLISHED_HOLY_MARBLE);
        stairBuilder(CCBlocks.POLISHED_HOLY_MARBLE_STAIRS.get(), Ingredient.of(CCBlocks.POLISHED_HOLY_MARBLE.get())).group("polished_holy_marble")
                .unlockedBy("has_polished_holy_marble", has(CCBlocks.POLISHED_HOLY_MARBLE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_HOLY_MARBLE_WALL.get(), CCBlocks.POLISHED_HOLY_MARBLE.get());

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.GOLDSTONE_SLAB.get(), CCBlocks.GOLDSTONE);
        stairBuilder(CCBlocks.GOLDSTONE_STAIRS.get(), Ingredient.of(CCBlocks.GOLDSTONE.get())).group("goldstone")
                .unlockedBy("has_goldstone", has(CCBlocks.GOLDSTONE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.GOLDSTONE_WALL.get(), CCBlocks.GOLDSTONE.get());

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.PUMICE_SLAB.get(), CCBlocks.PUMICE);
        stairBuilder(CCBlocks.PUMICE_STAIRS.get(), Ingredient.of(CCBlocks.PUMICE.get())).group("pumice")
                .unlockedBy("has_pumice", has(CCBlocks.PUMICE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.PUMICE_WALL.get(), CCBlocks.PUMICE.get());

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.PUMICE_BRICKS_SLAB.get(), CCBlocks.PUMICE_BRICKS);
        stairBuilder(CCBlocks.PUMICE_BRICKS_STAIRS.get(), Ingredient.of(CCBlocks.PUMICE_BRICKS.get())).group("pumice_bricks")
                .unlockedBy("has_pumice_bricks", has(CCBlocks.PUMICE_BRICKS.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.PUMICE_BRICKS_WALL.get(), CCBlocks.PUMICE_BRICKS.get());

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_PUMICE_SLAB.get(), CCBlocks.CHISELED_PUMICE);
        stairBuilder(CCBlocks.CHISELED_PUMICE_STAIRS.get(), Ingredient.of(CCBlocks.CHISELED_PUMICE.get())).group("chiseled_pumice")
                .unlockedBy("has_chiseled_pumice", has(CCBlocks.CHISELED_PUMICE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_PUMICE_WALL.get(), CCBlocks.CHISELED_PUMICE.get());

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_PUMICE_SLAB.get(), CCBlocks.CRACKED_PUMICE);
        stairBuilder(CCBlocks.CRACKED_PUMICE_STAIRS.get(), Ingredient.of(CCBlocks.CRACKED_PUMICE.get())).group("cracked_pumice")
                .unlockedBy("has_cracked_pumice", has(CCBlocks.CRACKED_PUMICE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_PUMICE_WALL.get(), CCBlocks.CRACKED_PUMICE.get());

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_PUMICE_SLAB.get(), CCBlocks.POLISHED_PUMICE);
        stairBuilder(CCBlocks.POLISHED_PUMICE_STAIRS.get(), Ingredient.of(CCBlocks.POLISHED_PUMICE.get())).group("polished_pumice")
                .unlockedBy("has_polished_pumice", has(CCBlocks.POLISHED_PUMICE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_PUMICE_WALL.get(), CCBlocks.POLISHED_PUMICE.get());

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.PIRITE_SLAB.get(), CCBlocks.PIRITE_BLOCK);
        stairBuilder(CCBlocks.PIRITE_STAIRS.get(), Ingredient.of(CCBlocks.PIRITE_BLOCK.get())).group("pirite_block")
                .unlockedBy("has_pirite_block", has(CCBlocks.PIRITE_BLOCK.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.PIRITE_WALL.get(), CCBlocks.PIRITE_BLOCK.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, CCBlocks.HOLY_MARBLE_BRICKS.get(), 4)
                .pattern("BB")
                .pattern("BB")
                .define('B', CCBlocks.HOLY_MARBLE.get())
                .unlockedBy("has_holy_marble", has(CCBlocks.HOLY_MARBLE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, CCBlocks.PUMICE_BRICKS.get(), 4)
                .pattern("BB")
                .pattern("BB")
                .define('B', CCBlocks.PUMICE.get())
                .unlockedBy("has_pumice", has(CCBlocks.PUMICE.get()))
                .save(pRecipeOutput);

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRUSTONE_STAIRS.get(), CCBlocks.CRUSTONE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRUSTONE_SLAB.get(), CCBlocks.CRUSTONE.get(), 2);
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRUSTONE_WALL.get(), CCBlocks.CRUSTONE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRUSTONE_BRICKS.get(), CCBlocks.CRUSTONE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_CRUSTONE.get(), CCBlocks.CRUSTONE.get());

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRUSTONE_BRICKS_STAIRS.get(), CCBlocks.CRUSTONE_BRICKS.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRUSTONE_BRICKS_SLAB.get(), CCBlocks.CRUSTONE_BRICKS.get(), 2);
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRUSTONE_BRICKS_WALL.get(), CCBlocks.CRUSTONE_BRICKS.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_CRUSTONE_BRICKS.get(), CCBlocks.CRUSTONE_BRICKS.get());

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_CRUSTONE_BRICKS_STAIRS.get(), CCBlocks.CRACKED_CRUSTONE_BRICKS.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_CRUSTONE_BRICKS_SLAB.get(), CCBlocks.CRACKED_CRUSTONE_BRICKS.get(), 2);
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_CRUSTONE_BRICKS_WALL.get(), CCBlocks.CRACKED_CRUSTONE_BRICKS.get());

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_CRUSTONE_STAIRS.get(), CCBlocks.POLISHED_CRUSTONE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_CRUSTONE_SLAB.get(), CCBlocks.POLISHED_CRUSTONE.get(), 2);
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_CRUSTONE_WALL.get(), CCBlocks.POLISHED_CRUSTONE.get());

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_CRUSTONE.get(), CCBlocks.POLISHED_CRUSTONE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_CRUSTONE_STAIRS.get(), CCBlocks.CHISELED_CRUSTONE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_CRUSTONE_SLAB.get(), CCBlocks.CHISELED_CRUSTONE.get(), 2);
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_CRUSTONE_WALL.get(), CCBlocks.CHISELED_CRUSTONE.get());

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.HOLY_MARBLE_STAIRS.get(), CCBlocks.HOLY_MARBLE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.HOLY_MARBLE_SLAB.get(), CCBlocks.HOLY_MARBLE.get(), 2);
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.HOLY_MARBLE_WALL.get(), CCBlocks.HOLY_MARBLE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.HOLY_MARBLE_BRICKS.get(), CCBlocks.HOLY_MARBLE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_HOLY_MARBLE.get(), CCBlocks.HOLY_MARBLE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_HOLY_MARBLE.get(), CCBlocks.HOLY_MARBLE.get());

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.HOLY_MARBLE_BRICKS_STAIRS.get(), CCBlocks.HOLY_MARBLE_BRICKS.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.HOLY_MARBLE_BRICKS_SLAB.get(), CCBlocks.HOLY_MARBLE_BRICKS.get(), 2);
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.HOLY_MARBLE_BRICKS_WALL.get(), CCBlocks.HOLY_MARBLE_BRICKS.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_HOLY_MARBLE.get(), CCBlocks.HOLY_MARBLE_BRICKS.get());

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_HOLY_MARBLE_STAIRS.get(), CCBlocks.CRACKED_HOLY_MARBLE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_HOLY_MARBLE_SLAB.get(), CCBlocks.CRACKED_HOLY_MARBLE.get(), 2);
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_HOLY_MARBLE_WALL.get(), CCBlocks.CRACKED_HOLY_MARBLE.get());

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_HOLY_MARBLE_STAIRS.get(), CCBlocks.POLISHED_HOLY_MARBLE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_HOLY_MARBLE_SLAB.get(), CCBlocks.POLISHED_HOLY_MARBLE.get(), 2);
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_HOLY_MARBLE_WALL.get(), CCBlocks.POLISHED_HOLY_MARBLE.get());

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_HOLY_MARBLE_STAIRS.get(), CCBlocks.CHISELED_HOLY_MARBLE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_HOLY_MARBLE_SLAB.get(), CCBlocks.CHISELED_HOLY_MARBLE.get(), 2);
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_HOLY_MARBLE_WALL.get(), CCBlocks.CHISELED_HOLY_MARBLE.get());

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.HOLY_MARBLE_PILLAR.get(), CCBlocks.HOLY_MARBLE.get());

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.GOLDSTONE_STAIRS.get(), CCBlocks.GOLDSTONE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.GOLDSTONE_SLAB.get(), CCBlocks.GOLDSTONE.get(), 2);
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.GOLDSTONE_WALL.get(), CCBlocks.GOLDSTONE.get());

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.PUMICE_STAIRS.get(), CCBlocks.PUMICE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.PUMICE_SLAB.get(), CCBlocks.PUMICE.get(), 2);
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.PUMICE_WALL.get(), CCBlocks.PUMICE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.PUMICE_BRICKS.get(), CCBlocks.PUMICE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_PUMICE.get(), CCBlocks.PUMICE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_PUMICE.get(), CCBlocks.PUMICE.get());

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.PUMICE_BRICKS_STAIRS.get(), CCBlocks.PUMICE_BRICKS.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.PUMICE_BRICKS_SLAB.get(), CCBlocks.PUMICE_BRICKS.get(), 2);
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.PUMICE_BRICKS_WALL.get(), CCBlocks.PUMICE_BRICKS.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_PUMICE.get(), CCBlocks.PUMICE_BRICKS.get());

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_PUMICE_STAIRS.get(), CCBlocks.CRACKED_PUMICE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_PUMICE_SLAB.get(), CCBlocks.CRACKED_PUMICE.get(), 2);
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_PUMICE_WALL.get(), CCBlocks.CRACKED_PUMICE.get());

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_PUMICE_STAIRS.get(), CCBlocks.POLISHED_PUMICE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_PUMICE_SLAB.get(), CCBlocks.POLISHED_PUMICE.get(), 2);
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_PUMICE_WALL.get(), CCBlocks.POLISHED_PUMICE.get());

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_PUMICE_STAIRS.get(), CCBlocks.CHISELED_PUMICE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_PUMICE_SLAB.get(), CCBlocks.CHISELED_PUMICE.get(), 2);
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_PUMICE_WALL.get(), CCBlocks.CHISELED_PUMICE.get());

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.PIRITE_STAIRS.get(), CCBlocks.PIRITE_BLOCK.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.PIRITE_SLAB.get(), CCBlocks.PIRITE_BLOCK.get(), 2);
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.PIRITE_WALL.get(), CCBlocks.PIRITE_BLOCK.get());

    }
}