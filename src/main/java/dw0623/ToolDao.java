package dw0623;

import java.util.HashMap;

public class ToolDao {
    // mimic db with static map
    private static final HashMap<String,Tool> TOOLS = createTools();

    private static HashMap<String,Tool> createTools() {
        HashMap<String,Tool> tools = new HashMap<String,Tool>();

        tools.put("CHNS",new Tool("CHNS","Chainsaw","Stihl"));
        tools.put("LADW",new Tool("LADW","Ladder","Werner"));
        tools.put("JAKD",new Tool("JAKD","Jackhammer","DeWalt"));
        tools.put("JAKR",new Tool("JAKR","Jackhammer","Ridgid"));
        
        return tools;
    }

    public static Tool getToolByCode(String toolCode) {
        return TOOLS.get(toolCode);
    }
}