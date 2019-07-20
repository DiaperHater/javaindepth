package com.semanticsquare.basics.hospital_managment_system;

public class HealthInsurancePlan {
    private double coverage;
    private InsuranceBrand offeredBy;

    protected double getCoverage() {
        return coverage;
    }

    protected void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    public InsuranceBrand getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(InsuranceBrand offeredBy) {
        this.offeredBy = offeredBy;
    }
}
