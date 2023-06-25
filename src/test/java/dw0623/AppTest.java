package dw0623;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    App app = new App();

    @Test(expected = Exception.class)
    public void testCheckoutWithInvalidDiscount() throws Exception {
        try {
            RentalAgreement contract = app.checkout("JAKR","9/3/15",5,101);
        }
        catch(Exception e) {
            throw e;
        }
    }

    @Test
    public void testCheckoutWithLadder() throws Exception {
        try {
            RentalAgreement contract = app.checkout("LADW","07/02/20",3,10);
            contract.print();
        }
        catch (Exception e) {
            //System.out.println("Caught exception : " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
