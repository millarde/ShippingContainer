package ShippingContainer;

import java.util.Date; 

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    private Product product;
    
    @Before
    public void setup() throws Exception {
        product = new Product("SKU", "UPC", "Frozen shrimp", 30);
    }

    @Test public void productHasSKU() {
        assertNotNull("product has SKU", product.SKU);
    }
    // tests for getters/setters are likely not economically interesting, so no additional ones included
 
    @Test(expected = IllegalArgumentException.class)
    public void getExceptionWithNullArgs() {
        product = new Product(null, "UPC", "LEGOs", 0);
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void getExceptionWithNegativeDaysToExpire() {
        product = new Product("SKU", "UPC", "LEGOs", -42);
    }
}