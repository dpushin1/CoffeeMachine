package machine;
import java.util.Scanner;

import static machine.Actions.*;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        water = 400;
        milk = 540;
        coffee = 120;
        cups = 9;
        money = 550;
        while (true){
            System.out.println("\r\nWrite action (buy, fill, take, remaining, exit):");
            String answer = scanner.nextLine();
            if (answer.equals("exit")) {
                break;
            }
            switch (answer){
                case "buy":
                    System.out.println(Actions.buy());
                    break;
                case "fill":
                    if (checkUser()) {
                        System.out.println("You are not a special user. Sorry, you can't fill the machine.");
                        break;
                    }
                    System.out.println(fill());
                    break;
                case "take":
                    if (checkUser()) {
                        System.out.println("You are not a special user. Sorry, you can't give my money.");
                        break;
                    }
                    System.out.println("I gave you $" +money + "\r\n");
                    money = 0;
                    break;
                case "remaining":
                    System.out.println(Actions.coffeeMachineHas(water,milk,coffee,cups,money));
                    break;
                case "back":
                    break;
            }
        }
    }
}
