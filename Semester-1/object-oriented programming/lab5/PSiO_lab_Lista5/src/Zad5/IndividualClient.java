package Zad5;

public class IndividualClient extends Client implements CreditCapable {
    private String firstName;
    private String lastName;
    private int age;

    public IndividualClient(String phone, String country, String firstName, String lastName, int age) {
        super(phone, country);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    //private bo metody uzywamy tylko wewnatrz tej klasy
    private boolean isAdult() {
        return age >= 18;
    }

    @Override
    public void createAccount() {
        if (isAdult()) {
            System.out.println("Account created successfully for ADULT: " + firstName + " " + lastName + " (" + country + ")");
        } else {
            System.out.println("Account created successfully for CHILD: " + firstName + " " + lastName + " (" + country + ")");
        }
    }

    @Override
    public void deleteAccount() {
        System.out.println("Individual account closed.");
    }

    @Override
    public boolean checkCreditworthiness(double amount) {
        return isAdult() && amount <= 2000;
    }
}