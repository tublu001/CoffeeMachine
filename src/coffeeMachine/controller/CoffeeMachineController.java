package coffeeMachine.controller;

import coffeeMachine.buttonFactory.ButtonFactory;
import coffeeMachine.entity.*;

import java.util.List;

public class CoffeeMachineController {

    CoffeeMachine coffeeMachine;

    public CoffeeMachine BuildCoffeeMachine() {
        coffeeMachine = CoffeeMachine.getBuilder()
                .withBrand("LG")
                .addButton(ButtonFactory.getButton(ButtonType.BLACK_COFFEE))
                .addButton(ButtonFactory.getButton(ButtonType.POWER))
                .addButton(ButtonFactory.getButton(ButtonType.DRAIN))
                .addIngredientContainers(IngredientType.MILK, new Container(20, 5, 10))
                .addIngredientContainers(IngredientType.WATER, new Container(20, 5, 10))
                .addIngredientContainers(IngredientType.COFFEE, new Container(20, 5, 10))
                .addOutlet(new Outlet(5, 1, OutletType.HOT_OUTLET))
                .addOutlet(new Outlet(5, 2, OutletType.COLD_OUTLET))
                .build();
        return coffeeMachine;
    }


    public MachineStatus getState(CoffeeMachine coffeeMachine) {

        return coffeeMachine.getStatus();
    }

    public List<Button> getButtonsList(CoffeeMachine coffeeMachine) {
        return coffeeMachine.getButtons();
    }

    public void pressButton(CoffeeMachine coffeeMachine, Button button) throws Exception {
        coffeeMachine.pressButton(button);
    }

    public ButtonType checkPressedButton(String pressedButton) {
        List<Button> buttonList = coffeeMachine.getButtons();
        if (buttonList.contains(ButtonType.BLACK_COFFEE)) {
            return ButtonType.BLACK_COFFEE;
        } else if (buttonList.contains(ButtonType.NORMAL_COFFEE)) {
            return ButtonType.NORMAL_COFFEE;
        } else if (buttonList.contains(ButtonType.DRAIN)) {
            return ButtonType.DRAIN;
        }
        return ButtonType.POWER;
    }


}
