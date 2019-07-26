package com.semanticsquare.basics.hospital_managment_system;

public class Billing {

    private static final double DISCOUNT_PLATINUM = 50;
    private static final double DISCOUNT_GOLD = 40;
    private static final double DISCOUNT_SILVER = 30;
    private static final double DISCOUNT_BRONZE = 25;
    private static final double DISCOUNT_DEFAULT = 20;

    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];
        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

        if(patient.isInsured()){
            payments[0] = amount * patientInsurancePlan.getCoverage();
            payments[1] = amount - payments[0];

        
            if (patientInsurancePlan instanceof PlatinumPlan){
                payments[1] -= DISCOUNT_PLATINUM;
            } else if (patientInsurancePlan instanceof GoldPlan){
                payments[1] -= DISCOUNT_GOLD;
            } else if (patientInsurancePlan instanceof SilverPlan){
                payments[1] -= DISCOUNT_SILVER;
            } else if (patientInsurancePlan instanceof BronzePlan){
                payments[1] -= DISCOUNT_BRONZE;    
            } 
        } 
        else {
            payments[1] = amount - DISCOUNT_DEFAULT;
        }   


        return payments;
    }

    public static void main(String[] args) {
        HealthInsurancePlan hip = new PlatinumPlan();
        Patient p = new Patient();
        p.setInsurancePlan(hip);

        double[] payments = Billing.computePaymentAmount(p, 1000.0);
    }

}