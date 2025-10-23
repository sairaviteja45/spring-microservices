package com.entityTables.information;

import jakarta.persistence.*;

@Entity(name = "identity_proof_details")
public class IdentityProofDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identity_proof_id")
    private int identityProofId;

    @Column(name = "identity_proof",nullable = false)
    private String identityProof;

    @Column(name = "identity_proof_number",nullable = false)
    private String identityProofNumber;

    public int getIdentityProofId() {
        return identityProofId;
    }

    public void setIdentityProofId(int identityProofId) {
        this.identityProofId = identityProofId;
    }

    public String getIdentityProof() {
        return identityProof;
    }

    public void setIdentityProof(String identityProof) {
        this.identityProof = identityProof;
    }

    public String getIdentityProofNumber() {
        return identityProofNumber;
    }

    public void setIdentityProofNumber(String identityProofNumber) {
        this.identityProofNumber = identityProofNumber;
    }
}
