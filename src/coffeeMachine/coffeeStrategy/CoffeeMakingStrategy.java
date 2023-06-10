package coffeeMachine.coffeeStrategy;

import coffeeMachine.entity.CoffeeMachine;
import coffeeMachine.entity.Outlet;

public interface CoffeeMakingStrategy {

    boolean validateIngredientRequirement(CoffeeMachine coffeeMachine);

    Outlet makeCoffee(CoffeeMachine coffeeMachine) throws Exception;
}
