package ShippingContainer;

import java.util.*;

public class App {

    public static void showContents(ShippingContainer sc) {
        System.out.println( "Shipping Container with barcode = " + sc.getBarCode() );
        System.out.println( "Has " + sc.getItemCount() + " line items, which are: ");

        List<LineItem> items = sc.getItems();
        for (LineItem item: items) {
            System.out.println( item.quantity + " of " + item.product.displayName );
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello SSI-Schaefer!\n");

        ShippingContainer sc = new ShippingContainer( "barCodeBARcodeBaRcOdE");

        final String legoSKU = "LEGO87654";
        Product legos = new Product(legoSKU, "1234567890", "LEGO Star Wars Rebel Base", 0);
        LineItem l1 = new LineItem(legos, 7);
        sc.addItem(l1);

        final String stringSKU = "DADD10-42";
        Product strings = new Product(stringSKU, "12344321", "DAddario XL nickel wound guitar strings, 42-10", 0);
        LineItem l2 = new LineItem(strings, 4);
        sc.addItem(l2);

        showContents(sc);

        System.out.println( "\nOOPS! Need more strings...\n");

        sc.changeQuantity( stringSKU, 42 );
        showContents(sc);

        System.out.println( "\nOOPS! Kids didn't mow yard, removing LEGOs...\n"); 

        sc.removeItem( legoSKU );
        showContents(sc);               

        System.out.println("\nHave a great day! Your shipment is on the way!");
    }
}
