package com.semanticsquare.basics.hospital_managment_system;

public class Patient extends User {
    private long patientId;
    private boolean insured;
    private HealthInsurancePlan healthInsurancePlan;


    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public HealthInsurancePlan getInsurancePlan() {
        return healthInsurancePlan;
    }

    public void setInsurancePlan(HealthInsurancePlan healthInsurancePlan) {
        this.healthInsurancePlan = healthInsurancePlan;
    }
}
