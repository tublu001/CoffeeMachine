package coffeeMachine.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeMachine {

    private int id;
    private MachineStatus status;
    private String brand;
    private List<Button> buttons;
    private Map<IngredientType, Container> ingredientContainers;
    private IndicatorType indicatorType;
    private List<Outlet> outlets;

    public CoffeeMachine(String brand, List<Button> buttons, Map<IngredientType, Container> ingredientContainers, List<Outlet> outlets) {

        this.brand = brand;
        this.buttons = buttons;
        this.ingredientContainers = ingredientContainers;
        this.indicatorType = IndicatorType.GREEN;
        this.outlets = outlets;
        this.status = MachineStatus.OFF;
    }

    public static CoffeeBuilder getBuilder() {
        return new CoffeeBuilder();
    }

    public MachineStatus getStatus() {
        return status;
    }

    public void setStatus(MachineStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public Map<IngredientType, Container> getIngredientContainers() {
        return ingredientContainers;
    }

    public void setIngredientContainers(Map<IngredientType, Container> ingredientContainers) {
        this.ingredientContainers = ingredientContainers;
    }

    public IndicatorType getIndicatorType() {
        return indicatorType;
    }

    public void setIndicatorType(IndicatorType indicatorType) {
        this.indicatorType = indicatorType;
    }

    public List<Outlet> getOutlets() {
        return outlets;
    }

    public void setOutlets(List<Outlet> outlets) {
        this.outlets = outlets;
    }

    public Outlet makeCoffee(Button button) throws Exception {
        Outlet outlet = null;

        if (status.equals(MachineStatus.OFF)) {
            throw new Exception("Please start machine first !");
        }
        try {

            outlet = button.makeCoffeeStrategy(this);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return outlet;
    }

    public void pressButton(Button button) throws Exception {
        if (button.getType().equals(ButtonType.POWER)) {
            button.machineOnOff(this);
        } else if (button.getType().equals(ButtonType.DRAIN)) {

        } else {
            Outlet outlet = makeCoffee(button);
            dispenseOutlet(button.getType().name(), outlet);
        }
    }

    public void subtractIngredient(IngredientType ingredientType, int quantity) {
        ingredientContainers.get(ingredientType).setCurrentCapacity(
                ingredientContainers.get(ingredientType).getCurrentCapacity() - quantity
        );
    }

    public void dispenseOutlet(String drink, Outlet outlet) {
        System.out.println("Enjoy your " + drink + " dispensing from outlet " + outlet.getOutletNumber());
        printIngredients();
    }

    public void printIngredients() {
        ingredientContainers.forEach(((ingredientType, container) -> System.out.println(ingredientType + "\n" + container.toString())));
    }

    public static class CoffeeBuilder {
        private String brand;
        private List<Button> buttons;
        private Map<IngredientType, Container> IngredientContainers;

        private List<Outlet> outlets;

        public CoffeeMachine build() {
            return new CoffeeMachine(brand, buttons, IngredientContainers, outlets);
        }

        public CoffeeBuilder withBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public CoffeeBuilder addButton(Button button) {
            if (this.buttons == null) {
                this.buttons = new ArrayList<>();
            }
            this.buttons.add(button);
            return this;
        }

        public CoffeeBuilder addIngredientContainers(IngredientType ingredientType, Container container) {
            if (this.IngredientContainers == null) {
                this.IngredientContainers = new HashMap<>();

            }
            this.IngredientContainers.put(ingredientType, container);
            return this;
        }

        public CoffeeBuilder addOutlet(Outlet outlet) {
            if (this.outlets == null) {
                this.outlets = new ArrayList<>();
            }
            this.outlets.add(outlet);
            return this;
        }


    }


}
