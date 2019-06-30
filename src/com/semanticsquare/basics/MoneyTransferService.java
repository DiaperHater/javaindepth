public class MoneyTransferService{

	private CurrencyConverter converter = new CurrencyConverter();

	public double computeTransferAmount(int countryIndex, double usdAmount){
		return converter. computeTransferAmount(countryIndex, usdAmount);
	}
	
	public double computeTransferFee(int countryIndex, double usdAmount){

		double transferAmount = computeTransferAmount(countryIndex, usdAmount);
		double transferFee = transferAmount * 0.02;

		return transferFee;
	}

	public static void main(String[] args){
		MoneyTransferService mts = new MoneyTransferService();


		double transferAmount = mts.computeTransferAmount(0, 1000);
		double transferFee = mts.computeTransferFee(0, 1000);

		System.out.println("Transfer amount = " + transferAmount);
		System.out.println("Transfer Fee = " + transferFee);


	}
}