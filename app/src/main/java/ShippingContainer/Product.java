package ShippingContainer;
import java.util.Date;

public class Product {
    public String UPC;
    public String SKU;
    public String displayName;
    public int daysToExpire;

    public Product( String SKU, String UPC, String displayName, int daysToExpire ) {

        if (SKU == null || UPC == null || displayName == null ) {
            throw new IllegalArgumentException("SKU, UPC and displayName may not be null");
        }
        if (daysToExpire < 0) {
            throw new IllegalArgumentException("daysToExpire may not be less than 0. Use 0 to indicate no expiration.");
        }

        this.SKU = SKU;
        this.UPC = UPC;
        this.displayName = displayName;
        this.daysToExpire = daysToExpire;
    }

    public Date getExpirationDateFromStartDate( Date startDate ) {
        if (startDate == null) {
            throw new IllegalArgumentException("No start for expiration period provided");            
        }
        long msToExpire = startDate.getTime() + ((daysToExpire * 1000*60*60*24)) ; //TODO should be a constant somewhere
        return new Date(msToExpire); 

    }

}