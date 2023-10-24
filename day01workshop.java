import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> cart = new ArrayList<>();

        System.out.println("Welcome to your shopping cart");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equals("list")) {
                listItems(cart);
            } else if (input.startsWith("add ")) {
                String itemsToAdd = input.substring(4);
                addItems(cart, itemsToAdd);
            } else if (input.startsWith("delete ")) {
                int itemIndex = Integer.parseInt(input.substring(7)) - 1;
                deleteItem(cart, itemIndex);
            } else {
                System.out.println("Please use 'list', 'add', or 'delete'.");
            }
        }
    }

    private static void listItems(ArrayList<String> cart) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty");
        } else {
            for (int i = 0; i < cart.size(); i++) {
                System.out.println((i + 1) + ". " + cart.get(i));
            }
        }
    }

    private static void addItems(ArrayList<String> cart, String itemsToAdd) {
        String[] items = itemsToAdd.split(", ");
        for (String item : items) {
            if (!cart.contains(item)) {
                cart.add(item);
                System.out.println(item + " added to cart");
            } else {
                System.out.println("Item '" + item + "' is already in the cart.");
            }
        }
    }

    private static void deleteItem(ArrayList<String> cart, int itemIndex) {
        if (itemIndex >= 0 && itemIndex < cart.size()) {
            String removedItem = cart.remove(itemIndex);
            System.out.println(removedItem + " removed from cart");
        } else {
            System.out.println("Incorrect item index");
        }
    }
};