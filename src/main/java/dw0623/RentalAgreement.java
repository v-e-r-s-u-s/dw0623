package dw0623;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.lang.Integer;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.lang.Double;

public class RentalAgreement {
    private static final String PARSE_DATE_FORMAT = "M/d/yy";
    private static final String PRINT_DATE_FORMAT = "MM/dd/yy";

    private String toolCode;
    private String toolType;
    private String toolBrand;
    private Integer rentalDays;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private Double dailyRentalCharge;
    private Integer chargeDays;
    private Double preDiscountCharge;
    private Double discountPercent;
    private Double discountAmount;
    private Double finalCharge;

    // calculatd values are set upon execution to separate business logic
    public RentalAgreement(String toolCode, String checkoutDate,
        Integer rentalDays, Integer discount) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(PARSE_DATE_FORMAT);

        Tool tool = ToolDao.getToolByCode(toolCode);
        Fee fee = FeeDao.getFeeByType(tool.getToolType());

        this.toolCode = tool.getToolCode();
        this.toolType = tool.getToolType();
        this.toolBrand = tool.getToolBrand();
        this.rentalDays = rentalDays;
        this.checkoutDate = LocalDate.parse(checkoutDate,dateFormatter);
        this.dailyRentalCharge = fee.getDailyRentalCharge();
        this.discountPercent = discount / 100.0;
    }

    public void execute() {
        this.dueDate = checkoutDate.plusDays(rentalDays);
        this.chargeDays = FeeCalculator.calculateChargeDays(rentalDays,checkoutDate,toolType);
        this.preDiscountCharge = chargeDays * dailyRentalCharge;
        this.discountAmount = preDiscountCharge * discountPercent;
        this.finalCharge = preDiscountCharge - discountAmount;
    }

    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(PRINT_DATE_FORMAT);
        DecimalFormat currencyFormatter = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        currencyFormatter.setRoundingMode(RoundingMode.HALF_UP);
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();

        return String.join(
            "\n",
            "Tool Code: " + toolCode,
            "Tool Type: " + toolType,
            "Tool Brand: " + toolBrand,
            "Rental Days: " + rentalDays.toString(),
            "Checkout Date: " + dateFormatter.format(checkoutDate),
            "Due Date: " + dateFormatter.format(dueDate),
            "Daily Rental Charge: " + currencyFormatter.format(dailyRentalCharge),
            "Charge Days: " + chargeDays.toString(),
            "Pre-Discount Charge: " + currencyFormatter.format(preDiscountCharge),
            "Discount Percent: " + percentFormatter.format(discountPercent),
            "Discount Amount: " + currencyFormatter.format(discountAmount),
            "Final Charge: " + currencyFormatter.format(finalCharge)
        );
    }

    public void print() {
        System.out.println(this.toString());
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

    public void setToolBrand(String toolBrand) {
        this.toolBrand = toolBrand;
    }

    public Integer getRentalDays() {
        return this.rentalDays;
    }

    public void setRentalDays(Integer rentalDays) {
        this.rentalDays = rentalDays;
    }

    public LocalDate getCheckoutDate() {
        return this.checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Double getDailyRentalCharge() {
        return this.dailyRentalCharge;
    }

    public void setDailyRentalCharge(Double dailyRentalCharge) {
        this.dailyRentalCharge = dailyRentalCharge;
    }

    public Integer getChargeDays() {
        return this.chargeDays;
    }

    public void setChargeDays(Integer chargeDays) {
        this.chargeDays = chargeDays;
    }

    public Double getPreDiscountCharge() {
        return this.preDiscountCharge;
    }

    public void setPreDiscountCharge(Double preDiscountCharge) {
        this.preDiscountCharge = preDiscountCharge;
    }

    public Double getDiscountPercent() {
        return this.discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Double getDiscountAmount() {
        return this.discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getFinalCharge() {
        return this.finalCharge;
    }

    public void setFinalCharge(Double finalCharge) {
        this.finalCharge = finalCharge;
    }
}