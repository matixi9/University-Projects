package Zad1;

public class Mobile extends Device {
    private int screenSize;

    public Mobile(String brand, String model, int year, int screenSize) {
        super(brand, model, year);
        this.screenSize = screenSize;
    }

    public void getInfo(){
        super.getInfo();
        System.out.println("Screen size: " + screenSize);
    }
}
