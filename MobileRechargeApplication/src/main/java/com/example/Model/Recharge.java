package com.example.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Recharge {

    private int rechargeId;

    @Pattern(
        regexp = "[0-9]{10}",
        message = "Mobile number must contain 10 digits"
    )
    private String mobileNumber;

    @NotBlank(message = "Operator is required")
    private String operator;

    @Min(
        value = 10,
        message = "Minimum recharge amount is 10"
    )
    private double amount;

    private String planType;


    public Recharge() {

    }


    public Recharge(
            int rechargeId,
            String mobileNumber,
            String operator,
            double amount,
            String planType) {

        this.rechargeId = rechargeId;
        this.mobileNumber = mobileNumber;
        this.operator = operator;
        this.amount = amount;
        this.planType = planType;
    }


    public int getRechargeId() {
        return rechargeId;
    }

    public void setRechargeId(int rechargeId) {
        this.rechargeId = rechargeId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }
}