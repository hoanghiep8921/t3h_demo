package com.example.demo.corecard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "Bank")
@Entity
public class Bank {

    @Id
    @Column(name = "BankID")
    private int bankId;

    @Column(name = "BankCode")
    private String bankCode;

    @Column(name = "LocalName")
    private String localName;

    @Column(name = "EnglishName")
    private String englishName;

    @Column(name = "ShortName")
    private String shortName;

    @Column(name = "Logo")
    private String logo;

    @Column(name = "isDisable")
    private boolean isDisable;

    @Column(name = "UserIDModify")
    private int userIdModify;

    @Column(name = "DateTimeModify")
    private long dateTimeModify;

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean isDisable() {
        return isDisable;
    }

    public void setDisable(boolean disable) {
        isDisable = disable;
    }

    public int getUserIdModify() {
        return userIdModify;
    }

    public void setUserIdModify(int userIdModify) {
        this.userIdModify = userIdModify;
    }

    public long getDateTimeModify() {
        return dateTimeModify;
    }

    public void setDateTimeModify(long dateTimeModify) {
        this.dateTimeModify = dateTimeModify;
    }
}
