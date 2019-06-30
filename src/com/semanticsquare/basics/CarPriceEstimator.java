import java.time.LocalDate;

public class CarPriceEstimator{
	
	private double getPrice(String makeAndModel, int yearManuatured){
		if(makeAndModel.equalsIgnoreCase("ford escort")){
			return 20000.0;
		}
		if (makeAndModel.equalsIgnoreCase("honda city")) {
			return 25000.0;
		}
		if (makeAndModel.equalsIgnoreCase("toyota camry hibrid")) {
			return 30000.0;
		}

		return 20000.0;
	}


	public double getSalePrice(String makeAndModel, 
								int yearManufactured,
								double milesDriven,
								int airbagsCount,
								boolean hasABS,
								boolean hasEBD,
								boolean hasRearViewCamera,
								boolean hasSunRoof,
								boolean hasAutoAC,
								boolean hasAccidentHistory) {
		
		double salePrice = getPrice(makeAndModel, yearManufactured);
		int currentYear = LocalDate.now().getYear();
		int ageOfCar = currentYear - yearManufactured + 1;
		System.out.format("age of %s is %d\n", makeAndModel, ageOfCar);


		if(ageOfCar <= 10){
			double depricationValue = (salePrice * 0.05) * ageOfCar;
			salePrice -= depricationValue ;
		} else {
			salePrice *= 0.1;
		}
		System.out.println("car price after deprication: " + salePrice);


		if(airbagsCount < 2 || !hasABS || !hasEBD){
			salePrice -= 1000;
		}
		System.out.println("sale price after acounting security features: " + salePrice);

		if(hasRearViewCamera && (hasSunRoof || hasAutoAC)){
			salePrice += 500;
		}
		System.out.println("sale price after acounting comfort features: " + salePrice);


		if(hasAccidentHistory){
			salePrice -= 500;
		}
		System.out.println("sale price after acounting for past accidents: " + salePrice);

		double expectedMilesDriven = ageOfCar * 10000;
		double additionalMiles = milesDriven - expectedMilesDriven;
		if (additionalMiles > 1000 && additionalMiles <= 10_000) {
			salePrice -= 500;
		}else if (additionalMiles > 10_000 && additionalMiles <= 30_000) {
			salePrice -= 1000;
		}else if(additionalMiles >= 30_000){
			salePrice -= 1500;
		}
		System.out.println("sale price after acounting mies driven: " + salePrice);


		return salePrice;
	}

	public static void main(String[] args) {

		System.out.println("Hello");

		CarPriceEstimator carPriceEstimator = new CarPriceEstimator();


		double salePrice = carPriceEstimator.getSalePrice("ford escort", 2019, 105000, 2, false,
										true, true, false, true, true);
	}
}