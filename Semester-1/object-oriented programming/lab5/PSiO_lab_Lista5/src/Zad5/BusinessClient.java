package Zad5;

public class BusinessClient extends Client implements CreditCapable {
    private String taxId;
    private String companyName;

    public BusinessClient(String phone, String country, String taxId, String companyName) {
        super(phone, country);
        this.taxId = taxId;
        this.companyName = companyName;
    }

    @Override
    public void createAccount() {
        System.out.println("Business account created: " + companyName + " (Tax ID: " + taxId + ")");
    }

    @Override
    public void deleteAccount() {
        System.out.println("Business account closed.");
    }

    @Override
    public boolean checkCreditworthiness(double amount) {
        return amount <= 100000;
    }
}