/*
 * Class: CMSC203 
 * Instructor: Prof. Ahmed Tarek
 * Description: The BevShop provides an array of drinks in three categories: 
 * Coffee, Alcoholic, and Smoothie. These beverages are available in three sizes: 
 * Small, Medium, and Large. Each type of drink starts with a base price, with 
 * additional costs added for size upgrades and specific add-ons tailored to each 
 * beverage type. Your task is to develop a program that operates the BevShop 
 * efficiently, handling the ordering process and pricing dynamically.
 * Due: 12/14/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Due: 12/14/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Hawariyaw Yilma
*/
import java.util.Scanner;

/**
 * Main method to run BevShop
 */
public class BevShopDriverApp {

    public static void main(String[] args) {
        // Declare variables to store order details
        String userName; // Customer's name
        DAY orderDay;    // Day of the order
        int age;         // Customer's age
        int menu;        // Menu choice
        int time;        // Time of the order
        int repeat = 0;  // Variable to determine if the user wants to repeat the order

        // Create a Scanner for user input and a BevShop instance to process orders
        Scanner choice = new Scanner(System.in);
        BevShop run = new BevShop();

        // Display welcome message and prompt for user details
        System.out.println("\t *******  Welcome To The BevShop  *******"
                           + "\n To place an order Please input Time, Name, and Age below"
                           + "\n Name: ");
        userName = choice.nextLine(); // Get customer's name

        System.out.println("Age: ");
        age = choice.nextInt(); // Get customer's age

        System.out.println("Time: ");
        time = choice.nextInt(); // Get the order time

        // Display day selection menu and prompt for the day
        System.out.println("\n Please choose a Number for the day\n"
                           + "1 --------- Monday\n"
                           + "2 --------- Tuesday\n"
                           + "3 --------- Wednesday\n"
                           + "4 --------- Thursday\n"
                           + "5 --------- Friday\n"
                           + "6 --------- Saturday\n"
                           + "7 --------- Sunday");
        menu = choice.nextInt();
        orderDay = day(menu); // Assign the chosen day

        // Start a new order with the provided details
        run.startNewOrder(time, orderDay, userName, age);

        // Loop to allow the user to order multiple beverages
        do {
            // Check if the customer is old enough to order alcoholic beverages
            if (run.isValidAge(age)) {
                menu = 0;
                displayMenu(); // Display the beverage menu
                menu = choice.nextInt();

                // Validate the menu choice
                while (menu > 10 || menu < 1) {
                    System.out.println("!! Invalid Choice pick again !!");
                    menu = choice.nextInt();
                }

                // Handle alcoholic drinks order
                if (menu <= 4) {
                    if (run.isEligibleForMore()) {
                        handleAlcoholOrder(choice, menu, run); // Process alcohol order
                        System.out.println("If you would like to add more drinks to your order please press 1\n"
                                           + "or press any other key to finish order");
                        repeat = choice.nextInt(); // Check if the user wants to order more
                    } else {
                        System.out.println("You have reached the limit for alcoholic drinks.\n"
                                           + "Please start a new order.");
                        System.exit(time);
                    }
                } else if (menu >= 5 && menu <= 7) {
                    handleSmoothieOrder(choice, menu, run); // Process smoothie order
                    System.out.println("If you would like to add more drinks to your order please press 1\n"
                                       + "or press any other key to finish order");
                    repeat = choice.nextInt(); // Check if the user wants to order more
                } else {
                    handleCoffeeOrder(choice, menu, run); // Process coffee order
                    System.out.println("If you would like to add more drinks to your order please press 1\n"
                                       + "or press any other key to finish order");
                    repeat = choice.nextInt(); // Check if the user wants to order more
                }
            } else {
                // For customers under 21, restrict to non-alcoholic beverages
                menu = 0;
                displayMenu(); // Display the beverage menu
                menu = choice.nextInt();

                // Validate the menu choice (restrict to non-alcoholic options)
                while (menu > 10 || menu < 5) {
                    System.out.println("!! Invalid Choice pick again !!");
                    menu = choice.nextInt();
                }

                if (menu >= 5 && menu <= 7) {
                    handleSmoothieOrder(choice, menu, run); // Process smoothie order
                    System.out.println("If you would like to add more drinks to your order please press 1\n"
                                       + "or press any other key to finish order");
                    repeat = choice.nextInt(); // Check if the user wants to order more
                } else {
                    handleCoffeeOrder(choice, menu, run); // Process coffee order
                    System.out.println("If you would like to add more drinks to your order please press 1\n"
                                       + "or press any other key to finish order");
                    repeat = choice.nextInt(); // Check if the user wants to order more
                }
            }
        } while (repeat == 1);

        // Display the details of the current order
        System.out.println(run.getCurrentOrder().toString());
    }

    // Method to assign the appropriate DAY enum value based on user input
    public static DAY day(int x) {
        if (x == 1) return DAY.MONDAY;
        else if (x == 2) return DAY.TUESDAY;
        else if (x == 3) return DAY.WEDNESDAY;
        else if (x == 4) return DAY.THURSDAY;
        else if (x == 5) return DAY.FRIDAY;
        else if (x == 6) return DAY.SATURDAY;
        else if (x == 7) return DAY.SUNDAY;
        else {
            System.out.println("Invalid choice. Please restart your order.");
            System.exit(0);
            return null; // Unreachable code
        }
    }

    // Method to display the beverage menu
    public static void displayMenu() {
        System.out.println("\n\t*******  Alcoholic Drinks  *******\n"
                           + "1-------Dry Martini\n"
                           + "2-------Lemon Drop\n"
                           + "3-------Sangria\n"
                           + "4-------Vodka Tonic\n"
                           + "\n\t*******  Smoothies  *******\n"
                           + "5-------Mango Pineapple Smoothie\n"
                           + "6-------Strawberry Banana Smoothie\n"
                           + "7-------Strawberry Smoothie\n"
                           + "\n\t*******  Coffee  *******\n"
                           + "8-------Light Roast\n"
                           + "9-------Medium Roast\n"
                           + "10-------Dark Roast\n"
                           + "Please select a number from the beverage menu.");
    }

    // Method to display size options
    public static void displaySize() {
        System.out.println("\nPlease Select Size\n"
                           + "1---------Small\n"
                           + "2---------Medium\n"
                           + "3---------Large");
    }

    // Handles processing of alcohol orders
    private static void handleAlcoholOrder(Scanner choice, int menu, BevShop run) {
        displaySize();
        int pick = choice.nextInt();
        SIZE size = pick == 1 ? SIZE.SMALL : pick == 2 ? SIZE.MEDIUM : SIZE.LARGE;

        switch (menu) {
            case 1: run.processAlcoholOrder("Dry Martini", size); break;
            case 2: run.processAlcoholOrder("Lemon Drop", size); break;
            case 3: run.processAlcoholOrder("Sangria", size); break;
            case 4: run.processAlcoholOrder("Vodka Tonic", size); break;
        }
    }

    // Handles processing of smoothie orders
    private static void handleSmoothieOrder(Scanner choice, int menu, BevShop run) {
        System.out.println("Would you like to add protein to your smoothie?\n1-------Yes\n2-------No");
        boolean protein = choice.nextInt() == 1;
        displaySize();
        int pick = choice.nextInt();
        SIZE size = pick == 1 ? SIZE.SMALL : pick == 2 ? SIZE.MEDIUM : SIZE.LARGE;

        switch (menu) {
            case 5: run.processSmoothieOrder("Mango Pineapple Smoothie", size, 2, protein); break;
            case 6: run.processSmoothieOrder("Strawberry Banana Smoothie", size, 3, protein); break;
            case 7: run.processSmoothieOrder("Strawberry Smoothie", size, 1, protein); break;
        }
    }

    // Handles processing of coffee orders
    private static void handleCoffeeOrder(Scanner choice, int menu, BevShop run) {
        System.out.println("Would you like to add an extra shot to your coffee?\n1-------Yes\n2-------No");
        boolean shot = choice.nextInt() == 1;
        System.out.println("Would you like to add extra syrup to your coffee?\n1-------Yes\n2-------No");
        boolean syrup = choice.nextInt() == 1;
        displaySize();
        int pick = choice.nextInt();
        SIZE size = pick == 1 ? SIZE.SMALL : pick == 2 ? SIZE.MEDIUM : SIZE.LARGE;

        switch (menu) {
            case 8: run.processCoffeeOrder("Light Roast", size, shot, syrup); break;
            case 9: run.processCoffeeOrder("Medium Roast", size, shot, syrup); break;
            case 10: run.processCoffeeOrder("Dark Roast", size, shot, syrup); break;
        }
    }
}
