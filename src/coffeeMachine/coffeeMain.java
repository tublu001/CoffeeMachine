package coffeeMachine;

import coffeeMachine.controller.CoffeeMachineController;
import coffeeMachine.entity.Button;
import coffeeMachine.entity.CoffeeMachine;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class coffeeMain {

    public static void main(String[] args) {

        CoffeeMachineController controller = new CoffeeMachineController();

//        Call a method in controller that first build a coffee Machine

        CoffeeMachine coffeeMachine = controller.BuildCoffeeMachine();
        Scanner scanner = new Scanner(System.in);


        boolean programState = true;

        while (programState) {
            System.out.println("Current machine state :- " + controller.getState(coffeeMachine));
            List<Button> buttonList = controller.getButtonsList(coffeeMachine);
            AtomicInteger index = new AtomicInteger();
            buttonList.forEach(button -> System.out.println(index.getAndIncrement() + " " + button.getType()));
            int choice = scanner.nextInt();
            try {
                controller.pressButton(coffeeMachine, buttonList.get(choice));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        }


    }
}
