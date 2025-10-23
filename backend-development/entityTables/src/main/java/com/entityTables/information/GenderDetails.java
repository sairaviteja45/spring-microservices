package com.entityTables.information;

import jakarta.persistence.*;

@Entity(name = "gender_details")
public class GenderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gender_details_id")
    private int genderDetailsId;

    @Column(name = "gender", nullable = false)
    private String gender;

    public int getGenderDetailsId() {
        return genderDetailsId;
    }

    public void setGenderDetailsId(int genderDetailsId) {
        this.genderDetailsId = genderDetailsId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
