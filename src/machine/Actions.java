package machine;
import static machine.CheckInput.*;

public class Actions {
    public static int water;
    public static int milk;
    public static int coffee;
    public static int cups;
    public static int money;
    public static String buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");

        String coffeeType = nextLine();
        switch (coffeeType) {
            case "1":  // espresso
                if(enoughType(water, 250, "water")) break;
                if(enoughType(coffee, 16, "coffee")) break;
                if(enoughType(cups, 1, "cups")) break;
                water -= 250;
                coffee -= 16;
                cups -= 1;
                money += 4;
                System.out.println("I have enough resources, making you a coffee!");
                break;
            case "2":  // latte
                if(enoughType(water, 350, "water")) break;
                if(enoughType(milk, 75, "milk")) break;
                if(enoughType(coffee, 20, "coffee")) break;
                if(enoughType(cups, 1, "cups")) break;
                water -= 350;
                milk -= 75;
                coffee -= 20;
                cups -= 1;
                money += 7;
                System.out.println("I have enough resources, making you a coffee!");
                break;
            case "3":  // cappuccino
                if(enoughType(water, 200, "water")) break;
                if(enoughType(milk, 100, "milk")) break;
                if(enoughType(coffee, 12, "coffee")) break;
                if(enoughType(cups, 1, "cups")) break;
                water -= 200;
                milk -= 100;
                coffee -= 12;
                cups -= 1;
                money += 6;
                System.out.println("I have enough resources, making you a cofee!");
                break;
            case "back":
                break;
        }
        return "";
    }

    public static String fill() {
        System.out.println("Write how many ml of water do you want to add:");
        int waterAdd = nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int milkAdd = nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int coffeeAdd = nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cupsAdd = nextInt();
        water += waterAdd;
        milk += milkAdd;
        coffee += coffeeAdd;
        cups += cupsAdd;
        return "";
    }

    public static boolean checkUser() {
        System.out.println("Are you a special user? Confirm your status using a special key.");
        String[] users = new String[3];
        users[0] = "John";
        users[1] = "Danil";
        users[2] = "Mike";
        String key = nextLine();
        String correctKey = users[1] + "123321specialkey";
        return !key.equals(correctKey);
    }

    public static String coffeeMachineHas(int water, int milk, int coffee, int cups, int money) {
        return "The coffee machine has:\r\n" + water + " of water\r\n" + milk + " of milk\r\n" +
                coffee + " of coffee beans\r\n" + cups + " of disposable cups\r\n" + money + " of money\r\n";
    }

    private static boolean enoughType(int have, int need, String type) {
        if (have < need) {
            System.out.println("Sorry, not enough " + type + "!");
            return true;
        }
        return false;
    }

}
