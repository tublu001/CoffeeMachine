package coffeeMachine.entity;

import coffeeMachine.coffeeStrategy.CoffeeMakingStrategy;
import lombok.Data;

@Data
public class Button {
    private int id;
    private ButtonType type;
    private CoffeeMakingStrategy coffeeStrategy;

    public Button(ButtonType type, CoffeeMakingStrategy coffeeStrategy) {
        this.type = type;
        this.coffeeStrategy = coffeeStrategy;
    }

    public Button(ButtonType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ButtonType getType() {
        return type;
    }

    public void setType(ButtonType type) {
        this.type = type;
    }

    public CoffeeMakingStrategy getCoffeeStrategy() {
        return coffeeStrategy;
    }

    public void setCoffeeStrategy(CoffeeMakingStrategy coffeeStrategy) {
        this.coffeeStrategy = coffeeStrategy;
    }

    public void machineOnOff(CoffeeMachine coffeeMachine) {
        if (this.type == ButtonType.POWER) {
            if (coffeeMachine.getStatus() == MachineStatus.OFF) {
                coffeeMachine.setStatus(MachineStatus.ON);
            } else if (coffeeMachine.getStatus() == MachineStatus.ON) {
                coffeeMachine.setStatus(MachineStatus.OFF);
            } else {
                System.out.println("Machine is in ERROR status");
            }
        } else {
            System.out.println("Press Power Button ");
        }
    }


    public Outlet makeCoffeeStrategy(CoffeeMachine coffeeMachine) throws Exception {
        if (!coffeeStrategy.validateIngredientRequirement(coffeeMachine)) {
            throw new Exception("Ingredients is not available");
        }
        return coffeeStrategy.makeCoffee(coffeeMachine);
    }
}
