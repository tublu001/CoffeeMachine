package coffeeMachine.coffeeStrategy;

import coffeeMachine.entity.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class BlackCoffeeStrategy implements CoffeeMakingStrategy {


    Map<IngredientType, Integer> requiredIngredients;

    public BlackCoffeeStrategy() {
        requiredIngredients = new HashMap<>();
        requiredIngredients.put(IngredientType.MILK, 5);
        requiredIngredients.put(IngredientType.WATER, 5);
        requiredIngredients.put(IngredientType.COFFEE, 2);

    }

    @Override
    public boolean validateIngredientRequirement(CoffeeMachine coffeeMachine) {
        Map<IngredientType, Container> ingredientContainers = coffeeMachine.getIngredientContainers();
        AtomicBoolean possiable = new AtomicBoolean(true);
        requiredIngredients.forEach(((ingredient, reqQuantity) -> {
            if (!ingredientContainers.containsKey(ingredient) || ingredientContainers.get(ingredient).getCurrentCapacity() < reqQuantity) {
                possiable.set(false);
                return;
            }
        }));
        return possiable.get();
    }

    @Override
    public Outlet makeCoffee(CoffeeMachine coffeeMachine) throws Exception {


        boolean outletAvaliable = false;
        Outlet dispenseOutlet = null;
        for (Outlet outlet : coffeeMachine.getOutlets()) {
            if (outlet.getOutletType() == OutletType.HOT_OUTLET) {
                outletAvaliable = true;
                dispenseOutlet = outlet;
            }
        }
        if (!outletAvaliable) throw new Exception("Hot Outlet is not available");
        requiredIngredients.forEach((coffeeMachine::subtractIngredient));
        return dispenseOutlet;
    }
}
