package tsuteto.tofufactory.machinerecipe;

import net.minecraft.item.ItemStack;

import tsuteto.tofufactory.api.recipes.RecipeManagers;

public class TofuMachineRecipe {

    public static void initRecipe() {
        RecipeManagers.pulverizerManager = new PulverizerRecipe();
        RecipeManagers.compactorManager = new CompactorRecipe();
        RecipeManagers.cuttingMachineManager = new CuttingMachineRecipe();
    }

    /**
     * Returns a copy of the original stack.
     * GT5 / GT6 compatibility removed.
     */
    public static ItemStack getOreDictStack(ItemStack stack) {
        if (stack == null) return null;
        return stack.copy();
    }
}
