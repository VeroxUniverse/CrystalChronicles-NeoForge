package net.veroxuniverse.crystal_chronicles.datagen;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;
import net.veroxuniverse.crystal_chronicles.registry.CCItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CCRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public CCRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        // ==========================================================================================
        // 1. WOOD
        // ==========================================================================================
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.BRONCHUS_SLAB.get(), CCBlocks.BRONCHUS_PLANKS);
        stairBuilder(CCBlocks.BRONCHUS_STAIRS.get(), Ingredient.of(CCBlocks.BRONCHUS_PLANKS.get())).group("bronchus_planks")
                .unlockedBy("has_bronchus_planks", has(CCBlocks.BRONCHUS_PLANKS.get())).save(pRecipeOutput);
        doorBuilder(CCBlocks.BRONCHUS_DOOR.get(), Ingredient.of(CCBlocks.BRONCHUS_PLANKS.get())).group("bronchus")
                .unlockedBy("has_bronchus_planks", has(CCBlocks.BRONCHUS_PLANKS.get())).save(pRecipeOutput);
        trapdoorBuilder(CCBlocks.BRONCHUS_TRAPDOOR.get(), Ingredient.of(CCBlocks.BRONCHUS_PLANKS.get())).group("bronchus")
                .unlockedBy("has_bronchus_planks", has(CCBlocks.BRONCHUS_PLANKS.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, CCBlocks.BRONCHUS_PRESSURE_PLATE.get(), CCBlocks.BRONCHUS_PLANKS.get());
        buttonBuilder(CCBlocks.BRONCHUS_BUTTON.get(), Ingredient.of(CCBlocks.BRONCHUS_PLANKS.get())).group("bronchus")
                .unlockedBy("has_bronchus_planks", has(CCBlocks.BRONCHUS_PLANKS.get())).save(pRecipeOutput);
        fenceBuilder(CCBlocks.BRONCHUS_FENCE.get(), Ingredient.of(CCBlocks.BRONCHUS_PLANKS.get())).group("bronchus")
                .unlockedBy("has_bronchus_planks", has(CCBlocks.BRONCHUS_PLANKS.get())).save(pRecipeOutput);
        fenceGateBuilder(CCBlocks.BRONCHUS_FENCE_GATE.get(), Ingredient.of(CCBlocks.BRONCHUS_PLANKS.get())).group("bronchus")
                .unlockedBy("has_bronchus_planks", has(CCBlocks.BRONCHUS_PLANKS.get())).save(pRecipeOutput);

        // ==========================================================================================
        // 2. STONE
        // ==========================================================================================
        generateStoneFamily(pRecipeOutput, CCBlocks.CRUSTONE, CCBlocks.CRUSTONE_STAIRS, CCBlocks.CRUSTONE_SLAB, CCBlocks.CRUSTONE_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.CRUSTONE_BRICKS, CCBlocks.CRUSTONE_BRICKS_STAIRS, CCBlocks.CRUSTONE_BRICKS_SLAB, CCBlocks.CRUSTONE_BRICKS_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.CRACKED_CRUSTONE_BRICKS, CCBlocks.CRACKED_CRUSTONE_BRICKS_STAIRS, CCBlocks.CRACKED_CRUSTONE_BRICKS_SLAB, CCBlocks.CRACKED_CRUSTONE_BRICKS_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.POLISHED_CRUSTONE, CCBlocks.POLISHED_CRUSTONE_STAIRS, CCBlocks.POLISHED_CRUSTONE_SLAB, CCBlocks.POLISHED_CRUSTONE_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.CHISELED_CRUSTONE, CCBlocks.CHISELED_CRUSTONE_STAIRS, CCBlocks.CHISELED_CRUSTONE_SLAB, CCBlocks.CHISELED_CRUSTONE_WALL);

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRUSTONE_BRICKS.get(), CCBlocks.CRUSTONE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_CRUSTONE.get(), CCBlocks.CRUSTONE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_CRUSTONE.get(), CCBlocks.POLISHED_CRUSTONE.get());

        generateStoneFamily(pRecipeOutput, CCBlocks.THUNDERSTONE, CCBlocks.THUNDERSTONE_STAIRS, CCBlocks.THUNDERSTONE_SLAB, CCBlocks.THUNDERSTONE_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.THUNDERSTONE_BRICKS, CCBlocks.THUNDERSTONE_BRICKS_STAIRS, CCBlocks.THUNDERSTONE_BRICKS_SLAB, CCBlocks.THUNDERSTONE_BRICKS_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.POLISHED_THUNDERSTONE, CCBlocks.POLISHED_THUNDERSTONE_STAIRS, CCBlocks.POLISHED_THUNDERSTONE_SLAB, CCBlocks.POLISHED_THUNDERSTONE_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.CHISELED_THUNDERSTONE, CCBlocks.CHISELED_THUNDERSTONE_STAIRS, CCBlocks.CHISELED_THUNDERSTONE_SLAB, CCBlocks.CHISELED_THUNDERSTONE_WALL);

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.THUNDERSTONE_BRICKS.get(), CCBlocks.THUNDERSTONE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_THUNDERSTONE.get(), CCBlocks.THUNDERSTONE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_THUNDERSTONE.get(), CCBlocks.POLISHED_THUNDERSTONE.get());
        create4x4Recipe(pRecipeOutput, CCBlocks.THUNDERSTONE_BRICKS, CCBlocks.THUNDERSTONE, "has_thunderstone");

        generateStoneFamily(pRecipeOutput, CCBlocks.BISMITE, CCBlocks.BISMITE_STAIRS, CCBlocks.BISMITE_SLAB, CCBlocks.BISMITE_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.BISMITE_BRICKS, CCBlocks.BISMITE_BRICKS_STAIRS, CCBlocks.BISMITE_BRICKS_SLAB, CCBlocks.BISMITE_BRICKS_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.POLISHED_BISMITE, CCBlocks.POLISHED_BISMITE_STAIRS, CCBlocks.POLISHED_BISMITE_SLAB, CCBlocks.POLISHED_BISMITE_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.CHISELED_BISMITE, CCBlocks.CHISELED_BISMITE_STAIRS, CCBlocks.CHISELED_BISMITE_SLAB, CCBlocks.CHISELED_BISMITE_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.CRACKED_BISMITE, CCBlocks.CRACKED_BISMITE_STAIRS, CCBlocks.CRACKED_BISMITE_SLAB, CCBlocks.CRACKED_BISMITE_WALL);

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.BISMITE_BRICKS.get(), CCBlocks.BISMITE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.POLISHED_BISMITE.get(), CCBlocks.BISMITE.get());
        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CHISELED_BISMITE.get(), CCBlocks.POLISHED_BISMITE.get());
        create4x4Recipe(pRecipeOutput, CCBlocks.BISMITE_BRICKS, CCBlocks.BISMITE, "has_bismite");

        generateStoneFamily(pRecipeOutput, CCBlocks.HOLY_MARBLE, CCBlocks.HOLY_MARBLE_STAIRS, CCBlocks.HOLY_MARBLE_SLAB, CCBlocks.HOLY_MARBLE_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.HOLY_MARBLE_BRICKS, CCBlocks.HOLY_MARBLE_BRICKS_STAIRS, CCBlocks.HOLY_MARBLE_BRICKS_SLAB, CCBlocks.HOLY_MARBLE_BRICKS_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.CHISELED_HOLY_MARBLE, CCBlocks.CHISELED_HOLY_MARBLE_STAIRS, CCBlocks.CHISELED_HOLY_MARBLE_SLAB, CCBlocks.CHISELED_HOLY_MARBLE_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.CRACKED_HOLY_MARBLE, CCBlocks.CRACKED_HOLY_MARBLE_STAIRS, CCBlocks.CRACKED_HOLY_MARBLE_SLAB, CCBlocks.CRACKED_HOLY_MARBLE_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.POLISHED_HOLY_MARBLE, CCBlocks.POLISHED_HOLY_MARBLE_STAIRS, CCBlocks.POLISHED_HOLY_MARBLE_SLAB, CCBlocks.POLISHED_HOLY_MARBLE_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.GOLDSTONE, CCBlocks.GOLDSTONE_STAIRS, CCBlocks.GOLDSTONE_SLAB, CCBlocks.GOLDSTONE_WALL);

        stonecutterResultFromBase(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.HOLY_MARBLE_PILLAR.get(), CCBlocks.HOLY_MARBLE.get());
        create4x4Recipe(pRecipeOutput, CCBlocks.HOLY_MARBLE_BRICKS, CCBlocks.HOLY_MARBLE, "has_holy_marble");

        generateStoneFamily(pRecipeOutput, CCBlocks.PUMICE, CCBlocks.PUMICE_STAIRS, CCBlocks.PUMICE_SLAB, CCBlocks.PUMICE_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.PUMICE_BRICKS, CCBlocks.PUMICE_BRICKS_STAIRS, CCBlocks.PUMICE_BRICKS_SLAB, CCBlocks.PUMICE_BRICKS_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.CHISELED_PUMICE, CCBlocks.CHISELED_PUMICE_STAIRS, CCBlocks.CHISELED_PUMICE_SLAB, CCBlocks.CHISELED_PUMICE_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.CRACKED_PUMICE, CCBlocks.CRACKED_PUMICE_STAIRS, CCBlocks.CRACKED_PUMICE_SLAB, CCBlocks.CRACKED_PUMICE_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.POLISHED_PUMICE, CCBlocks.POLISHED_PUMICE_STAIRS, CCBlocks.POLISHED_PUMICE_SLAB, CCBlocks.POLISHED_PUMICE_WALL);
        generateStoneFamily(pRecipeOutput, CCBlocks.PYRITE, CCBlocks.PYRITE_STAIRS, CCBlocks.PYRITE_SLAB, CCBlocks.PYRITE_WALL);

        create4x4Recipe(pRecipeOutput, CCBlocks.PUMICE_BRICKS, CCBlocks.PUMICE, "has_pumice");

        // ==========================================================================================
        // 3. BISMUTH
        // ==========================================================================================
        generateBismuthFamily(pRecipeOutput, CCBlocks.BLUE_BISMUTH, CCBlocks.BLUE_BISMUTH_STAIRS, CCBlocks.BLUE_BISMUTH_SLAB, CCBlocks.BLUE_BISMUTH_WALL, CCBlocks.BLUE_BISMUTH_BRICKS, CCBlocks.BLUE_BISMUTH_BRICKS_STAIRS, CCBlocks.BLUE_BISMUTH_BRICKS_SLAB, CCBlocks.BLUE_BISMUTH_BRICKS_WALL, CCBlocks.BLUE_BISMUTH_CRYSTAL, "blue");
        generateBismuthFamily(pRecipeOutput, CCBlocks.PURPLE_BISMUTH, CCBlocks.PURPLE_BISMUTH_STAIRS, CCBlocks.PURPLE_BISMUTH_SLAB, CCBlocks.PURPLE_BISMUTH_WALL, CCBlocks.PURPLE_BISMUTH_BRICKS, CCBlocks.PURPLE_BISMUTH_BRICKS_STAIRS, CCBlocks.PURPLE_BISMUTH_BRICKS_SLAB, CCBlocks.PURPLE_BISMUTH_BRICKS_WALL, CCBlocks.PURPLE_BISMUTH_CRYSTAL, "purple");
        generateBismuthFamily(pRecipeOutput, CCBlocks.VIOLET_BISMUTH, CCBlocks.VIOLET_BISMUTH_STAIRS, CCBlocks.VIOLET_BISMUTH_SLAB, CCBlocks.VIOLET_BISMUTH_WALL, CCBlocks.VIOLET_BISMUTH_BRICKS, CCBlocks.VIOLET_BISMUTH_BRICKS_STAIRS, CCBlocks.VIOLET_BISMUTH_BRICKS_SLAB, CCBlocks.VIOLET_BISMUTH_BRICKS_WALL, CCBlocks.VIOLET_BISMUTH_CRYSTAL, "violet");
        generateBismuthFamily(pRecipeOutput, CCBlocks.YELLOW_BISMUTH, CCBlocks.YELLOW_BISMUTH_STAIRS, CCBlocks.YELLOW_BISMUTH_SLAB, CCBlocks.YELLOW_BISMUTH_WALL, CCBlocks.YELLOW_BISMUTH_BRICKS, CCBlocks.YELLOW_BISMUTH_BRICKS_STAIRS, CCBlocks.YELLOW_BISMUTH_BRICKS_SLAB, CCBlocks.YELLOW_BISMUTH_BRICKS_WALL, CCBlocks.YELLOW_BISMUTH_CRYSTAL, "yellow");
        generateBismuthFamily(pRecipeOutput, CCBlocks.RAINBOW_BISMUTH, CCBlocks.RAINBOW_BISMUTH_STAIRS, CCBlocks.RAINBOW_BISMUTH_SLAB, CCBlocks.RAINBOW_BISMUTH_WALL, CCBlocks.RAINBOW_BISMUTH_BRICKS, CCBlocks.RAINBOW_BISMUTH_BRICKS_STAIRS, CCBlocks.RAINBOW_BISMUTH_BRICKS_SLAB, CCBlocks.RAINBOW_BISMUTH_BRICKS_WALL, CCBlocks.RAINBOW_BISMUTH_CRYSTAL, "rainbow");

        // ==========================================================================================
        // 4. SPECIALS
        // ==========================================================================================
        create4x4Recipe(pRecipeOutput, CCBlocks.FAT_TISSUE_BLOCK, CCItems.FAT_TISSUE_BALL, "has_fat_tissue_ball");
        create4x4Recipe(pRecipeOutput, CCBlocks.ROTTEN_FLESH_BLOCK, () -> Items.ROTTEN_FLESH, "has_rotten_flesh");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ROTTEN_FLESH, 4)
                .requires(CCBlocks.ROTTEN_FLESH_BLOCK.get())
                .unlockedBy("has_rotten_flesh", has(CCBlocks.ROTTEN_FLESH_BLOCK.get()))
                .save(pRecipeOutput,  CrystalChronicles.MODID + ":rotten_flesh_block_uncrafting");

        // ==========================================================================================
        // 5. SMITHING
        // ==========================================================================================
        registerKnightSmithing(pRecipeOutput, ItemRegistry.FIRE_RUNE, CCItems.VOLCANITE_SHARD, ItemRegistry.PYROMANCER_HELMET, CCItems.FIRE_KNIGHT_HELMET, "fire");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.FIRE_RUNE, CCItems.VOLCANITE_SHARD, ItemRegistry.PYROMANCER_CHESTPLATE, CCItems.FIRE_KNIGHT_CHESTPLATE, "fire");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.FIRE_RUNE, CCItems.VOLCANITE_SHARD, ItemRegistry.PYROMANCER_LEGGINGS, CCItems.FIRE_KNIGHT_LEGGINGS, "fire");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.FIRE_RUNE, CCItems.VOLCANITE_SHARD, ItemRegistry.PYROMANCER_BOOTS, CCItems.FIRE_KNIGHT_BOOTS, "fire");

        registerKnightSmithing(pRecipeOutput, ItemRegistry.HOLY_RUNE, CCItems.DIVINITE_SHARD, ItemRegistry.PRIEST_HELMET, CCItems.HOLY_KNIGHT_HELMET, "holy");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.HOLY_RUNE, CCItems.DIVINITE_SHARD, ItemRegistry.PRIEST_CHESTPLATE, CCItems.HOLY_KNIGHT_CHESTPLATE, "holy");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.HOLY_RUNE, CCItems.DIVINITE_SHARD, ItemRegistry.PRIEST_LEGGINGS, CCItems.HOLY_KNIGHT_LEGGINGS, "holy");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.HOLY_RUNE, CCItems.DIVINITE_SHARD, ItemRegistry.PRIEST_BOOTS, CCItems.HOLY_KNIGHT_BOOTS, "holy");

        registerKnightSmithing(pRecipeOutput, ItemRegistry.ICE_RUNE, CCItems.ICE_SHARD, ItemRegistry.CRYOMANCER_HELMET, CCItems.ICE_KNIGHT_HELMET, "ice");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.ICE_RUNE, CCItems.ICE_SHARD, ItemRegistry.CRYOMANCER_CHESTPLATE, CCItems.ICE_KNIGHT_CHESTPLATE, "ice");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.ICE_RUNE, CCItems.ICE_SHARD, ItemRegistry.CRYOMANCER_LEGGINGS, CCItems.ICE_KNIGHT_LEGGINGS, "ice");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.ICE_RUNE, CCItems.ICE_SHARD, ItemRegistry.CRYOMANCER_BOOTS, CCItems.ICE_KNIGHT_BOOTS, "ice");

        registerKnightSmithing(pRecipeOutput, ItemRegistry.ENDER_RUNE, CCItems.VOIDSTONE_SHARD, ItemRegistry.SHADOWWALKER_HELMET, CCItems.ENDER_MAGE_HELMET, "ender");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.ENDER_RUNE, CCItems.VOIDSTONE_SHARD, ItemRegistry.SHADOWWALKER_CHESTPLATE, CCItems.ENDER_MAGE_CHESTPLATE, "ender");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.ENDER_RUNE, CCItems.VOIDSTONE_SHARD, ItemRegistry.SHADOWWALKER_LEGGINGS, CCItems.ENDER_MAGE_LEGGINGS, "ender");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.ENDER_RUNE, CCItems.VOIDSTONE_SHARD, ItemRegistry.SHADOWWALKER_BOOTS, CCItems.ENDER_MAGE_BOOTS, "ender");

        registerKnightSmithing(pRecipeOutput, ItemRegistry.BLOOD_RUNE, CCItems.HEMALITE_SHARD, ItemRegistry.CULTIST_HELMET, CCItems.BLOOD_KNIGHT_HELMET, "blood");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.BLOOD_RUNE, CCItems.HEMALITE_SHARD, ItemRegistry.CULTIST_CHESTPLATE, CCItems.BLOOD_KNIGHT_CHESTPLATE, "blood");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.BLOOD_RUNE, CCItems.HEMALITE_SHARD, ItemRegistry.CULTIST_LEGGINGS, CCItems.BLOOD_KNIGHT_LEGGINGS, "blood");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.BLOOD_RUNE, CCItems.HEMALITE_SHARD, ItemRegistry.CULTIST_BOOTS, CCItems.BLOOD_KNIGHT_BOOTS, "blood");

        registerKnightSmithing(pRecipeOutput, ItemRegistry.NATURE_RUNE, CCItems.FLORALITE_SHARD, ItemRegistry.PLAGUED_HELMET, CCItems.NATURE_KNIGHT_HELMET, "nature");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.NATURE_RUNE, CCItems.FLORALITE_SHARD, ItemRegistry.PLAGUED_CHESTPLATE, CCItems.NATURE_KNIGHT_CHESTPLATE, "nature");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.NATURE_RUNE, CCItems.FLORALITE_SHARD, ItemRegistry.PLAGUED_LEGGINGS, CCItems.NATURE_KNIGHT_LEGGINGS, "nature");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.NATURE_RUNE, CCItems.FLORALITE_SHARD, ItemRegistry.PLAGUED_BOOTS, CCItems.NATURE_KNIGHT_BOOTS, "nature");

        registerKnightSmithing(pRecipeOutput, ItemRegistry.LIGHTNING_RUNE, CCItems.VOLTITE_SHARD, ItemRegistry.ELECTROMANCER_HELMET, CCItems.LIGHTNING_KNIGHT_HELMET, "lightning");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.LIGHTNING_RUNE, CCItems.VOLTITE_SHARD, ItemRegistry.ELECTROMANCER_CHESTPLATE, CCItems.LIGHTNING_KNIGHT_CHESTPLATE, "lightning");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.LIGHTNING_RUNE, CCItems.VOLTITE_SHARD, ItemRegistry.ELECTROMANCER_LEGGINGS, CCItems.LIGHTNING_KNIGHT_LEGGINGS, "lightning");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.LIGHTNING_RUNE, CCItems.VOLTITE_SHARD, ItemRegistry.ELECTROMANCER_BOOTS, CCItems.LIGHTNING_KNIGHT_BOOTS, "lightning");

        registerKnightSmithing(pRecipeOutput, ItemRegistry.EVOCATION_RUNE, () -> Items.TOTEM_OF_UNDYING, ItemRegistry.ARCHEVOKER_HELMET, CCItems.EVOCATION_KNIGHT_HELMET, "evocation");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.EVOCATION_RUNE, () -> Items.TOTEM_OF_UNDYING, ItemRegistry.ARCHEVOKER_CHESTPLATE, CCItems.EVOCATION_KNIGHT_CHESTPLATE, "evocation");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.EVOCATION_RUNE, () -> Items.TOTEM_OF_UNDYING, ItemRegistry.ARCHEVOKER_LEGGINGS, CCItems.EVOCATION_KNIGHT_LEGGINGS, "evocation");
        registerKnightSmithing(pRecipeOutput, ItemRegistry.EVOCATION_RUNE, () -> Items.TOTEM_OF_UNDYING, ItemRegistry.ARCHEVOKER_BOOTS, CCItems.EVOCATION_KNIGHT_BOOTS, "evocation");
    }

    private void generateStoneFamily(RecipeOutput output, Supplier<? extends Block> base, Supplier<? extends Block> stairs, Supplier<? extends Block> slab, Supplier<? extends Block> wall) {
        String name = base.get().getName().getString().toLowerCase().replace(" ", "_");
        slab(output, RecipeCategory.BUILDING_BLOCKS, slab.get(), base.get());
        stairBuilder(stairs.get(), Ingredient.of(base.get())).group(name).unlockedBy("has_" + name, has(base.get())).save(output);
        wall(output, RecipeCategory.BUILDING_BLOCKS, wall.get(), base.get());

        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, stairs.get(), base.get());
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, slab.get(), base.get(), 2);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, wall.get(), base.get());
    }

    private void generateBismuthFamily(RecipeOutput output, Supplier<? extends Block> chiseled, Supplier<? extends Block> cStairs, Supplier<? extends Block> cSlab, Supplier<? extends Block> cWall, Supplier<? extends Block> bricks, Supplier<? extends Block> bStairs, Supplier<? extends Block> bSlab, Supplier<? extends Block> bWall, Supplier<? extends Block> crystal, String color) {
        generateStoneFamily(output, chiseled, cStairs, cSlab, cWall);
        generateStoneFamily(output, bricks, bStairs, bSlab, bWall);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bricks.get(), 4)
                .pattern("BB").pattern("BB")
                .define('B', crystal.get())
                .unlockedBy("has_" + color + "_crystal", has(crystal.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("crystal_chronicles", color + "_bismuth_bricks_from_crystal"));

        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, chiseled.get(), bricks.get());
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, chiseled.get(), crystal.get());
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, bricks.get(), crystal.get());
    }

    private void create4x4Recipe(RecipeOutput output, Supplier<? extends ItemLike> result, Supplier<? extends ItemLike> ingredient, String criterionName) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get(), 4)
                .pattern("BB").pattern("BB")
                .define('B', ingredient.get())
                .unlockedBy(criterionName, has(ingredient.get()))
                .save(output);
    }

    private void registerKnightSmithing(RecipeOutput output, Supplier<? extends Item> rune,
                                        Supplier<? extends Item> shard, Supplier<? extends Item> baseItem,
                                        Supplier<? extends Item> result, String name) {

        String resultName = BuiltInRegistries.ITEM.getKey(result.get()).getPath();

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(rune.get()),
                        Ingredient.of(baseItem.get()),
                        Ingredient.of(shard.get()),
                        RecipeCategory.COMBAT,
                        result.get())
                .unlocks("has_" + name + "_rune", has(rune.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("crystal_chronicles",
                        resultName + "_smithing"));
    }

    protected static void stonecutterResultFromBase(RecipeOutput recipeOutput, RecipeCategory pCategory, ItemLike pResult, ItemLike pMaterial) {
        stonecutterResultFromBase(recipeOutput, pCategory, pResult, pMaterial, 1);
    }

    protected static void stonecutterResultFromBase(RecipeOutput recipeOutput, RecipeCategory pCategory, ItemLike pResult, ItemLike pMaterial, int resultCount) {
        SingleItemRecipeBuilder bismuthItemRecipeBuilder = SingleItemRecipeBuilder.stonecutting(Ingredient.of(new ItemLike[]{pMaterial}), pCategory, pResult, resultCount).unlockedBy(getHasName(pMaterial), has(pMaterial));
        String conversionRecipeName = getConversionRecipeName(pResult, pMaterial);
        bismuthItemRecipeBuilder.save(recipeOutput, CrystalChronicles.MODID + ":stonecutting/" + conversionRecipeName + "_stonecutting");
    }

    protected static String getConversionRecipeName(ItemLike pResult, ItemLike pIngredient) {
        String conversionOutput = getItemName(pResult);
        return conversionOutput + "_from_" + getItemName(pIngredient);
    }
}