package me.iwareq.mytestmod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

public class Recipes {
    private static final ArrayList<Recipe> list = new ArrayList<>();

    static {
        addRecipe(new ItemStack[]{
                new ItemStack(Items.coal, 1, 1),
                new ItemStack(Items.coal, 1, 1),
                new ItemStack(Items.coal, 1, 1),

                new ItemStack(Items.coal, 1, 1),
                new ItemStack(Items.coal, 1, 1),
                new ItemStack(Items.coal, 1, 1),

                new ItemStack(Items.coal, 1, 1),
                new ItemStack(Items.coal, 1, 1),
                new ItemStack(Items.coal, 1, 1),
            },
            new ItemStack(Blocks.coal_block, 1, 0));
    }

    public static boolean addRecipe(ItemStack[] input, ItemStack output) {
        return list.add(new Recipe(input, output));
    }

    public static Recipe getRecipe(ItemStack[] input) {
        if (list.isEmpty()) return null;
        if (input == null) return null;

        for (Recipe recipe : list) {
            if (isMatchRecipe(input, recipe))
                return recipe;
        }
        return null;
    }

    public static boolean isMatchRecipe(ItemStack[] input, Recipe recipe){
        boolean result = true;
        for (int i = 0; i < 9; ++i) {
            result = isMatch(recipe.input[i], input[i]);
            if (!result) break;
        }
        return result;
    }

    public static boolean isMatch(ItemStack itemStack, ItemStack input) {
        return itemStack != null
            && input != null
            && itemStack.getItem() == input.getItem()
            && (itemStack.getItemDamage() == OreDictionary.WILDCARD_VALUE || input.getItemDamage() == itemStack.getItemDamage())
            && (!itemStack.hasTagCompound() || ItemStack.areItemStackTagsEqual(itemStack, input))
            && 0 <= input.stackSize - itemStack.stackSize;
    }
}
