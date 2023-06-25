package dw0623;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ToolDaoTest 
{
    @Test
    public void testGetToolByCode() {
        Tool CHNS = new Tool("CHNS","Chainsaw","Stihl");
        assertEquals("Tools should contain a chainsaw.",
            ToolDao.getToolByCode("CHNS").getToolCode(),CHNS.getToolCode());
    }
}
