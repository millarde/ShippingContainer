package ShippingContainer;

import java.util.Date; 

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShippingContainerTest {

    private ShippingContainer container;
    
    @Before
    public void setup() throws Exception {
        container = new ShippingContainer("IHaveABarCode");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getExceptionWithNullBarCode() {
        container = new ShippingContainer(null);
    }

    @Test public void containerCanReceiveItems() {
        Product legos = new Product("LEGO87654", "1234567890", "LEGOs", 0);
        LineItem in = new LineItem(legos, 7);

        container.addItem(in);
        int numItems = container.getItemCount();

        assertEquals("got back one list item", 1, numItems);
    }    
}
