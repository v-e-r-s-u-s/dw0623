package dw0623;

import java.util.HashMap;

public class FeeDao {
    // mimic db with static map
    private static final HashMap<String,Fee> FEES = createFeeTypes();

    private static HashMap<String,Fee> createFeeTypes() {
        HashMap<String,Fee> feeTypes = new HashMap<String,Fee>();

        feeTypes.put("Ladder",new Fee("Ladder",1.99,true,true,false));
        feeTypes.put("Chainsaw",new Fee("Chainsaw",1.49,true,false,true));
        feeTypes.put("Jackhammer",new Fee("Jackhammer",2.99,true,false,false));
        
        return feeTypes;
    }

    public static Fee getFeeByType(String toolType) {
        return FEES.get(toolType);
    }
}