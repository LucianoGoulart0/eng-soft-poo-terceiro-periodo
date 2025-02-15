package com.fag.dto;

import java.math.BigDecimal;

public class ConsultResponseDTO {
    
    private String assignor;

    private String settleDate;

    private String dueDate;

    private String endHour;

    private String initeHour;

    private String nextSettle;

    private String digitable;

    private BigDecimal transactionId;

    private BigDecimal type;

    private BigDecimal value;

    private String errorCode;

    private String message;

    private BigDecimal status;

    private RegisterDataDTO registerData;

    public String getAssignor() {
        return assignor;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getEndHour() {
        return endHour;
    }

    public String getIniteHour() {
        return initeHour;
    }

    public String getNextSettle() {
        return nextSettle;
    }

    public String getDigitable() {
        return digitable;
    }

    public BigDecimal getTransactionId() {
        return transactionId;
    }

    public BigDecimal getType() {
        return type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public BigDecimal getStatus() {
        return status;
    }

    public RegisterDataDTO getRegisterData() {
        return registerData;
    }

    public void setAssignor(String assignor) {
        this.assignor = assignor;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public void setIniteHour(String initeHour) {
        this.initeHour = initeHour;
    }

    public void setNextSettle(String nextSettle) {
        this.nextSettle = nextSettle;
    }

    public void setDigitable(String digitable) {
        this.digitable = digitable;
    }

    public void setTransactionId(BigDecimal transactionId) {
        this.transactionId = transactionId;
    }

    public void setType(BigDecimal type) {
        this.type = type;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
    }

    public void setRegisterData(RegisterDataDTO registerData) {
        this.registerData = registerData;
    }
}
