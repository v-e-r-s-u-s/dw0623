package dw0623;

public class FeeType {
    private String toolType;
    private Double dailyRentalCharge;
    private Boolean weekdayCharge;
    private Boolean weekendCharge;
    private Boolean holidayCharge;

    public FeeType (String toolType, Double dailyRentalCharge, Boolean weekdayCharge,
        Boolean weekendCharge, Boolean holidayCharge) {
        this.toolType = toolType;
        this.dailyRentalCharge = dailyRentalCharge;
        this.weekdayCharge = weekdayCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }

    public String getToolType() {
        return this.toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public Double getDailyRentalCharge() {
        return this.dailyRentalCharge;
    }

    public void setDailyRentalCharge(Double dailyRentalCharge) {
        this.dailyRentalCharge = dailyRentalCharge;
    }

    public Boolean isWeekdayCharge() {
        return this.weekdayCharge;
    }

    public Boolean getWeekdayCharge() {
        return this.weekdayCharge;
    }

    public void setWeekdayCharge(Boolean weekdayCharge) {
        this.weekdayCharge = weekdayCharge;
    }

    public Boolean isWeekendCharge() {
        return this.weekendCharge;
    }

    public Boolean getWeekendCharge() {
        return this.weekendCharge;
    }

    public void setWeekendCharge(Boolean weekendCharge) {
        this.weekendCharge = weekendCharge;
    }

    public Boolean isHolidayCharge() {
        return this.holidayCharge;
    }

    public Boolean getHolidayCharge() {
        return this.holidayCharge;
    }

    public void setHolidayCharge(Boolean holidayCharge) {
        this.holidayCharge = holidayCharge;
    }
}