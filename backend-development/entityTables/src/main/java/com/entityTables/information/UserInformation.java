package com.entityTables.information;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "user_information")
public class UserInformation    {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_information_id")
    private int userInformationId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "birth_date", nullable = false)
    private String birthDate;

    @Column(name = "mobile_number", nullable = false, length = 10)
    private int mobileNumber;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "company_id", nullable = false)
    private int companyId;

    @Column(name = "identity_proof_id", nullable = false)
    private int identityProofId;

    @Column(name = "gender_id", nullable = false)
    private int genderId;

    @Column(name = "user_created_date_and_time")
    private LocalDateTime userCreatedDateAndTime;

    public int getUserInformationId() {
        return userInformationId;
    }

    public void setUserInformationId(int userInformationId) {
        this.userInformationId = userInformationId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getIdentityProofId() {
        return identityProofId;
    }

    public void setIdentityProofId(int identityProofId) {
        this.identityProofId = identityProofId;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    public LocalDateTime getUserCreatedDateAndTime() {
        return userCreatedDateAndTime;
    }

    public void setUserCreatedDateAndTime(LocalDateTime userCreatedDateAndTime) {
        this.userCreatedDateAndTime = userCreatedDateAndTime;
    }
}
