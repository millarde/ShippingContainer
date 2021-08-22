package ShippingContainer;

import java.util.Date;


public class LineItem {
    public Product product;
    public int quantity;
    public Date expiresOn; //Product defines days until expiration, this is calculated when item is added

    public LineItem( Product product, int quantity ) {

        if (product == null) {
            throw new IllegalArgumentException("Product may not be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be at least 1");
        }

        this.product = product;
        this.quantity = quantity;
        this.expiresOn = product.getExpirationDateFromStartDate( new Date() );
    }

}