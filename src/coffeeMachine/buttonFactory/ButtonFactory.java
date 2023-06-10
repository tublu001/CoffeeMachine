package coffeeMachine.buttonFactory;

import coffeeMachine.coffeeStrategy.BlackCoffeeStrategy;
import coffeeMachine.entity.Button;
import coffeeMachine.entity.ButtonType;

import static coffeeMachine.entity.ButtonType.*;


public class ButtonFactory {

    public static Button getButton(ButtonType type) {
        return switch (type) {
            case POWER -> new Button(POWER);
            case NORMAL_COFFEE -> null;
            case BLACK_COFFEE -> new Button(BLACK_COFFEE, new BlackCoffeeStrategy());
            case DRAIN -> new Button(DRAIN);
        };


    }
}
