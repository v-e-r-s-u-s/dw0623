package dw0623;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ToolDaoTest 
{
    @Test
    public void testGetToolByCode() {
        assertEquals("CHNS lookup",ToolDao.getToolByCode("CHNS").getToolCode(),"CHNS");
        assertEquals("LADW lookup",ToolDao.getToolByCode("LADW").getToolCode(),"LADW");
        assertEquals("JAKD lookup",ToolDao.getToolByCode("JAKD").getToolCode(),"JAKD");
        assertEquals("JAKR lookup",ToolDao.getToolByCode("JAKR").getToolCode(),"JAKR");
    }
}
