package com.fabric.interview.dataModel;

public class TaxRelief {
        private String taxReliefId;
        private Boolean isCondoUpgrade;
        private String creditorFiscalCode;
        private String beneficiaryType;
        private NaturalPersonBeneficiary naturalPersonBeneficiary;
        private LegalPersonBeneficiary legalPersonBeneficiary;

    public String getTaxReliefId() {
        return taxReliefId;
    }

    public void setTaxReliefId(String taxReliefId) {
        this.taxReliefId = taxReliefId;
    }

    public Boolean getCondoUpgrade() {
        return isCondoUpgrade;
    }

    public void setCondoUpgrade(Boolean condoUpgrade) {
        isCondoUpgrade = condoUpgrade;
    }

    public String getCreditorFiscalCode() {
        return creditorFiscalCode;
    }

    public void setCreditorFiscalCode(String creditorFiscalCode) {
        this.creditorFiscalCode = creditorFiscalCode;
    }

    public String getBeneficiaryType() {
        return beneficiaryType;
    }

    public void setBeneficiaryType(String beneficiaryType) {
        this.beneficiaryType = beneficiaryType;
    }

    public NaturalPersonBeneficiary getNaturalPersonBeneficiary() {
        return naturalPersonBeneficiary;
    }

    public void setNaturalPersonBeneficiary(NaturalPersonBeneficiary naturalPersonBeneficiary) {
        this.naturalPersonBeneficiary = naturalPersonBeneficiary;
    }

    public LegalPersonBeneficiary getLegalPersonBeneficiary() {
        return legalPersonBeneficiary;
    }

    public void setLegalPersonBeneficiary(LegalPersonBeneficiary legalPersonBeneficiary) {
        this.legalPersonBeneficiary = legalPersonBeneficiary;
    }
}
