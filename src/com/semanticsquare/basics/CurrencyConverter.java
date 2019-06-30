public class CurrencyConverter{
	
	private double[] exchangeRates = {63.0, 3.0, 3.0, 595.5, 18.0, 107.0, 2.0};

	public void setExchangeRates(double[] newExchangeRates){
		exchangeRates = newExchangeRates;
	}

	public void updateExchangeRate(int countryIndex, double rate){
		exchangeRates[countryIndex] = rate;
	}

	public double getExchangeRate(int countryIndex){
		return exchangeRates[countryIndex];
	}

	public double computeTransferAmount(int countryIndex, double usdAmount){
		return usdAmount * exchangeRates[countryIndex];
	}

	public void printCurrencies(){
		System.out.println("All currency exchange rates:");
		System.out.println("----------START------------");
		for (int i = 0; i < exchangeRates.length; i++){
			System.out.format("country index:%d = %f for 1$\n", i, exchangeRates[i]);
		}
		System.out.println("----------END--------------");
	}

		
}