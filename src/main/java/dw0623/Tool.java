package dw0623;

public class Tool {
    private String toolCode;
    private String toolType;
    private String toolBrand;

    public Tool (String toolCode, String toolType, String toolBrand) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.toolBrand = toolBrand;
    }

    public String getToolCode() {
        return this.toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public String getToolType() {
        return this.toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public String getToolBrand() {
        return this.toolBrand;
    }

    public void setToolBrand(String toolCode) {
        this.toolBrand = toolBrand;
    }
}