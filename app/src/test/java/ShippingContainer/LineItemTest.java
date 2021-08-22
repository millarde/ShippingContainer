package ShippingContainer;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LineItemTest {

    private LineItem lineItem;
    
    // @Before
    // public void setup() throws Exception {
    //     //need Product object
    //     lineItem = new LineItem("SKU", 1);
    // }

 
    @Test(expected = IllegalArgumentException.class)
    public void getExceptionWithNullProduct() {
        lineItem = new LineItem(null, 1);
    }
 
    // @Test(expected = IllegalArgumentException.class)
    // public void getExceptionWithNoItems() {
    //     lineItem = new LineItem("", 0);
    // }
}