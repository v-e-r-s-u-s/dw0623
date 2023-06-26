package dw0623;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private static final String PARSE_DATE_FORMAT = "M/d/yy";

    App app = new App();

    // Test Case 1
    @Test(expected = Exception.class)
    public void testCheckoutWithInvalidDiscount() throws Exception {
        try {
            RentalAgreement contract = app.checkout("JAKR","9/3/15",5,101);
        }
        catch(Exception e) {
            throw e;
        }
    }

    // Extra Test Case
    @Test(expected = Exception.class)
    public void testCheckoutWithInvalidRentalDays() throws Exception {
        try {
            RentalAgreement contract = app.checkout("JAKR","9/3/15",0,0);
        }
        catch(Exception e) {
            throw e;
        }
    }

    // Test Case 2
    @Test
    public void testCheckoutWithLadder() throws Exception {
        try {
            RentalAgreement contract = app.checkout("LADW","7/2/20",3,10);

            String expected = String.join(
                "\n",
                "Tool Code: LADW",
                "Tool Type: Ladder",
                "Tool Brand: Werner",
                "Rental Days: 3",
                "Checkout Date: 07/02/20",
                "Due Date: 07/05/20",
                "Daily Rental Charge: $1.99",
                "Charge Days: 2",
                "Pre-Discount Charge: $3.98",
                "Discount Percent: 10%",
                "Discount Amount: $0.40",
                "Final Charge: $3.58"
            );

            assertEquals("", expected, contract.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Test Case 3
    @Test
    public void testCheckoutWithChainsaw() throws Exception {
        try {
            RentalAgreement contract = app.checkout("CHNS","7/2/15",5,25);

            String expected = String.join(
                "\n",
                "Tool Code: CHNS",
                "Tool Type: Chainsaw",
                "Tool Brand: Stihl",
                "Rental Days: 5",
                "Checkout Date: 07/02/15",
                "Due Date: 07/07/15",
                "Daily Rental Charge: $1.49",
                "Charge Days: 3",
                "Pre-Discount Charge: $4.47",
                "Discount Percent: 25%",
                "Discount Amount: $1.12",
                "Final Charge: $3.35"
            );

            assertEquals("", expected, contract.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Test Case 4
    @Test
    public void testCheckoutWithLaborDay() throws Exception {
        try {
            RentalAgreement contract = app.checkout("JAKD","9/3/15",6,0);

            String expected = String.join(
                "\n",
                "Tool Code: JAKD",
                "Tool Type: Jackhammer",
                "Tool Brand: DeWalt",
                "Rental Days: 6",
                "Checkout Date: 09/03/15",
                "Due Date: 09/09/15",
                "Daily Rental Charge: $2.99",
                "Charge Days: 3",
                "Pre-Discount Charge: $8.97",
                "Discount Percent: 0%",
                "Discount Amount: $0.00",
                "Final Charge: $8.97"
            );

            assertEquals("", expected, contract.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Test Case 5
    @Test
    public void testLongCheckout() throws Exception {
        try {
            RentalAgreement contract = app.checkout("JAKR","7/2/15",9,0);

            String expected = String.join(
                "\n",
                "Tool Code: JAKR",
                "Tool Type: Jackhammer",
                "Tool Brand: Ridgid",
                "Rental Days: 9",
                "Checkout Date: 07/02/15",
                "Due Date: 07/11/15",
                "Daily Rental Charge: $2.99",
                "Charge Days: 6",
                "Pre-Discount Charge: $17.94",
                "Discount Percent: 0%",
                "Discount Amount: $0.00",
                "Final Charge: $17.94"
            );

            assertEquals("", expected, contract.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Test Case 6
    @Test
    public void testCheckout07022020() throws Exception {
        try {
            RentalAgreement contract = app.checkout("JAKD","7/2/20",4,50);

            String expected = String.join(
                "\n",
                "Tool Code: JAKD",
                "Tool Type: Jackhammer",
                "Tool Brand: DeWalt",
                "Rental Days: 4",
                "Checkout Date: 07/02/20",
                "Due Date: 07/06/20",
                "Daily Rental Charge: $2.99",
                "Charge Days: 1",
                "Pre-Discount Charge: $2.99",
                "Discount Percent: 50%",
                "Discount Amount: $1.50",
                "Final Charge: $1.50"
            );

            assertEquals("", expected, contract.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
