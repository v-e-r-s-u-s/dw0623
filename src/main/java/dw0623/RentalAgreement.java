package dw0623;

import java.util.Date;
import java.lang.Integer;
import java.lang.Double;

public class RentalAgreement {
    private String toolCode;
    private String toolType;
    private String toolBrand;
    private Integer rentalDays;
    private Date checkoutDate;
    private Date dueDate;
    private Double dailyRentalCharge;
    private Integer chargeDays;
    private Double preDiscountCharge;
    private Integer discountPercent;
    private Double discountAmount;
    private Double finalCharge;

    public RentalAgreement(String toolCode, String toolType, String toolBrand, Integer rentalDays, Date checkoutDate, Date dueDate, Double dailyRentalCharge, Integer chargeDays, Double preDiscountCharge, Integer discountPercent, Double discountAmount, Double finalCharge) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.toolBrand = toolBrand;
        this.rentalDays = rentalDays;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.dailyRentalCharge = dailyRentalCharge;
        this.chargeDays = chargeDays;
        this.preDiscountCharge = preDiscountCharge;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.finalCharge = finalCharge;
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

    public Date getCheckoutDate() {
        return this.checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
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

    public Integer getDiscountPercent() {
        return this.discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
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