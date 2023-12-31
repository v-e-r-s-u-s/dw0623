package dw0623;

public class App 
{
    public RentalAgreement checkout(String toolCode, String checkoutDate,
        Integer rentalDays, Integer discount) throws Exception {

        // verify discount between 0-100
        if (discount < 0 || discount > 100) {
            throw new Exception("Discount must be in the range 0-100.");
        }

        // verify rental days > 0
        if (rentalDays <= 0) {
            throw new Exception("Rental Days must be greater than 0.");
        }

        // construct rental agreement
        RentalAgreement contract = new RentalAgreement(toolCode, checkoutDate, rentalDays, discount);
        contract.execute();

        return contract;
    }
}
