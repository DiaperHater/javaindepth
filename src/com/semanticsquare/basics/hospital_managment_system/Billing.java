package com.semanticsquare.basics.hospital_managment_system;

public class Billing {

    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];
        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

        if (patientInsurancePlan instanceof PlatinumPlan){
            
        }
        if (patientInsurancePlan instanceof GoldPlan){

        }
        if (patientInsurancePlan instanceof SilverPlan){

        }
        if (patientInsurancePlan instanceof BronzePlan){

        }

        // your logic

        return payments;
    }

    public static void main(String[] args) {
        HealthInsurancePlan hip = new PlatinumPlan();
        Patient p = new Patient();
        p.setInsurancePlan(hip);

        double[] payments = Billing.computePaymentAmount(p, 1000.0);
    }

}