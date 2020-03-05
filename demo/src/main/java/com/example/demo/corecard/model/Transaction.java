package com.example.demo.corecard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @Column(name = "TransactionID")
    private long transactionId;

    @Column(name = "TransactionTypeCode")
    private String TransactionTypeCode;

    @Column(name = "SerialNumber")
    private String serialNumber;

    @Column(name = "RequestID")
    private String requestId;

    @Column(name = "YearLocal")
    private int yearLocal;

    @Column(name = "BankCode")
    private String bankCode;

    @Column(name = "BatchNo")
    private int batchNo;

    @Column(name = "TransactionDate")
    private int transactionDate;

    @Column(name = "TransactionDateTime")
    private int transactionDateTime;

    @Column(name = "TransactionAmount")
    private double transactionAmount;

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionTypeCode() {
        return TransactionTypeCode;
    }

    public void setTransactionTypeCode(String transactionTypeCode) {
        TransactionTypeCode = transactionTypeCode;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getYearLocal() {
        return yearLocal;
    }

    public void setYearLocal(int yearLocal) {
        this.yearLocal = yearLocal;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public int getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(int batchNo) {
        this.batchNo = batchNo;
    }

    public int getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(int transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(int transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
