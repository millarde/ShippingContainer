package ShippingContainer;

//import java.util.ArrayList;
import java.util.*;

public class ShippingContainer {
    public String barCode;
    public List<LineItem> lineItems = new ArrayList<LineItem>();
    public boolean containerComplete = false;

    public ShippingContainer( String barCode ) {
        if (barCode == null) {
            throw new IllegalArgumentException("Container must have a barCode when created");
        }        
        this.barCode = barCode;
    }

    public void addItem(LineItem item) {
        // if containerComplete, thrown exception as container has been closed to further processing

        lineItems.add(item);
    }
 
    public void removeItem(String SKU) {
        if (SKU == null) {
            throw new IllegalArgumentException("SKU must not be null.");
        }   

        LineItem foundItem = null; 

        for (LineItem item: lineItems) {
            if (item.product.SKU == SKU ) {
                foundItem = item;
                break; // presumption being that we do not allow multiple line items with same SKU
            }
        }

        // perhaps a reason for an exception, but we'll settle for logging for now
        if (foundItem != null) {
            lineItems.remove(foundItem);
        } else {
            System.out.println("Item with SKU " + SKU + " not found in container, no changes made.");     
        }
    }

    public List<LineItem> getItems() {
        return Collections.unmodifiableList(lineItems); // allow callers to see and read list but not change it
    }

    public int getItemCount() {
        return lineItems.size();
    }

    public void changeQuantity( String SKU, int newQty ) {
        if (SKU == null || newQty < 1) {
            throw new IllegalArgumentException("SKU must not be null and newQty or new quantity must be at least one. Use removeItem to remove items from the container.");
        }   

        boolean itemFound = false; 

        for (LineItem item: lineItems) {
            if (item.product.SKU == SKU ) {
                item.quantity = newQty;
                itemFound = true;
                break; // presumption being that we do not allow multiple line items with same SKU
            }
        }

        // perhaps a reason for an exception, but we'll settle for logging for now
        if (!itemFound) {
            System.out.println("Item with SKU " + SKU + " not found in container, no changes made. Use addItem to add new items to the container.");     
        }
    }

    public void completeContainer() {
        // if number of items is zero, throw an exception -- empty container not allowed
        containerComplete = true;
    }

    public String getBarCode() {
        return barCode;
    }
}