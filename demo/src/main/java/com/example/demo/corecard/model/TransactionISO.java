package com.example.demo.corecard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TransactionISO")
public class TransactionISO {
    @Id
    @Column(name = "TransactionISOID")
    private long transactionISOId;

    @Column(name = "TransactionID")
    private long transactionId;

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

    @Column(name = "CurrencyCode")
    private String currencyCode;

    @Column(name = "CardHolderName")
    private String cardHolderName;

    @Column(name = "CardType")
    private String cardType;

    @Column(name = "ChipApplicationName")
    private String chipApplicationName;

    @Column(name = "ChipApplicationID")
    private String chipApplicationId;

    @Column(name = "ChipTransactionCertificate")
    private String chipTransactionCertificate;

    @Column(name = "MessageTypeID")
    private String messageTypeId;

    @Column(name = "F02PrimaryAccountNumber")
    private String  F02PrimaryAccountNumber;

    @Column(name = "F03ProcessingCode")
    private String  F03ProcessingCode;

    @Column(name = "F04Amount")
    private String  F04Amount;

    @Column(name = "F07TransmissionDateTime")
    private String  F07TransmissionDateTime;

    @Column(name = "F11SystemTrace")
    private String  F11SystemTrace;

    @Column(name = "F12TimeLocal")
    private String  F12TimeLocal;

    @Column(name = "F13DateLocal")
    private String  F13DateLocal;

    @Column(name = "F14DateExpiration")
    private String  F14DateExpiration;

    @Column(name = "F22POSEntryMode")
    private String  F22POSEntryMode;

    @Column(name = "F24NetworkIdentifier")
    private String  F24NetworkIdentifier;

    @Column(name = "F25POSConditionCode")
    private String  F25POSConditionCode;

    @Column(name = "F35TrackIIData")
    private String  F35TrackIIData;

    @Column(name = "F37ReferenceNumber")
    private String  F37ReferenceNumber;

    @Column(name = "F38AuthorizationResponse")
    private String  F38AuthorizationResponse;

    @Column(name = "F39ResponseCode")
    private String  F39ResponseCode;

    @Column(name = "F41CardAcceptorTerminalID")
    private String  F41CardAcceptorTerminalID;

    @Column(name = "F42CardAcceptorAcquirerID")
    private String  F42CardAcceptorAcquirerID;

    @Column(name = "F43CardAcceptorAcquirerName")
    private String  F43CardAcceptorAcquirerName;

    @Column(name = "F45TrackIData")
    private String  F45TrackIData;

    @Column(name = "F48AdditionalNumber")
    private String  F48AdditionalNumber;

    @Column(name = "F52PersonalData")
    private String  F52PersonalData;

    @Column(name = "F53SecurityInformation")
    private String  F53SecurityInformation;

    @Column(name = "F54AdditionalAmounts")
    private String  F54AdditionalAmounts;

    @Column(name = "F55ICCData")
    private String  F55ICCData;

    @Column(name = "F60PrivateUse")
    private String  F60PrivateUse;

    @Column(name = "F61PrivateUse")
    private String  F61PrivateUse;

    @Column(name = "F62PrivateUse")
    private String  F62PrivateUse;

    @Column(name = "F63PrivateUse")
    private String  F63PrivateUse;

    @Column(name = "MerchantID")
    private int  merchantId;

    @Column(name = "BranchCode")
    private String branchCode;

    @Column(name = "TransactionNote")
    private String transactionNote;

    @Column(name = "BillNumber")
    private String billNumber;

    public long getTransactionISOId() {
        return transactionISOId;
    }

    public void setTransactionISOId(long transactionISOId) {
        this.transactionISOId = transactionISOId;
    }
}
