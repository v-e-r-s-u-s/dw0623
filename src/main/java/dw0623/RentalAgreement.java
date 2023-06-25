package dw0623;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.lang.Integer;
import java.lang.Double;

public class RentalAgreement {
    private static final String DATE_FORMAT = "MM/dd/yy";

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

    public void print() {
        StringBuilder builder = new StringBuilder();

        builder.append("Tool Code: ").append(toolCode).append("\n")
        .append("Tool Type:").append(toolType).append("\n")
        .append("Tool Brand:").append(toolBrand).append("\n")
        .append("Rental Days:").append(rentalDays.toString()).append("\n")
        .append("Checkout Date:").append(checkoutDate.toString()).append("\n")
        .append("Due Date:").append(dueDate.toString()).append("\n")
        .append("Daily Rental Charge:").append(dailyRentalCharge.toString()).append("\n")
        .append("Charge Days:").append(chargeDays.toString()).append("\n")
        .append("Pre-Discount Charge:").append(preDiscountCharge.toString()).append("\n")
        .append("Discount Percent:").append(discountPercent.toString()).append("\n")
        .append("Discount Amount:").append(discountAmount.toString()).append("\n")
        .append("Final Charge:").append(finalCharge.toString());

        System.out.println(builder.toString());
    }

    // calculatd values are set upon execution to separate business logic
    public RentalAgreement(String toolCode, String checkoutDate,
        Integer rentalDays, Integer discount) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

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