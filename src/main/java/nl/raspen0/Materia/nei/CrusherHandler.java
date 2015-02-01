package nl.raspen0.Materia.nei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import nl.raspen0.Materia.recipes.CrusherRecipes;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class CrusherHandler extends TemplateRecipeHandler
{
    @Override
    public String getGuiTexture()
    {
        return "materia:textures/gui/Materia_Furnace.png";
    }

    @Override
    public String getRecipeName()
    {
        return "Crusher Recipe";
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass()
    {
        return nl.raspen0.Materia.gui.GuiCrusher.class;
    }

    @Override
    public void loadCraftingRecipes(ItemStack result)
    {
        HashMap<ItemStack, ItemStack> recipes = CrusherRecipes.crushing().getInput(result);

        if ((recipes != null) && (!recipes.isEmpty()))
        {
            for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
            {
                NEICrusherRecipe neiRecipe = new NEICrusherRecipe(recipe.getKey(), recipe.getValue());
                arecipes.add(neiRecipe);
            }

        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient)
    {

        ItemStack result = CrusherRecipes.crushing().getCrushingResult(ingredient);
        if (result != null)
        {
            NEICrusherRecipe neiRecipe = new NEICrusherRecipe(ingredient, result);
            arecipes.add(neiRecipe);
        }

    }
    
    @Override
    public void drawExtras(int recipe) {
        this.drawProgressBar(75, 24, 178, 15, 24, 20, 50, 0);
    }

    private class NEICrusherRecipe extends CachedRecipe
    {

        public ArrayList<PositionedStack> ingredients;
        public PositionedStack result;

        public NEICrusherRecipe(ItemStack input, ItemStack craftingResult)
        {
            result = new PositionedStack(craftingResult, 111, 24);
            ingredients = new ArrayList<PositionedStack>();
            setIngredients(input, craftingResult);
        }

        @Override
        public List<PositionedStack> getIngredients()
        {
            return getCycledIngredients(CrusherHandler.this.cycleticks / 20, ingredients);
        }

        private void setIngredients(ItemStack input, ItemStack output)
        {
            PositionedStack stack = new PositionedStack(input, 51, 6);
            stack.setMaxSize(1);
            ingredients.add(stack);

        }

        @Override
        public PositionedStack getResult()
        {
            return result;
        }

    }
}