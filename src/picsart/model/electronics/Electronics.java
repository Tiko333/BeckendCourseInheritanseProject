package picsart.model.electronics;

public abstract class Electronics implements ElectronicsInterface {

    private long id;
    private String model = NOT_INDICATED;
    private String power = NOT_INDICATED;
    private String powerConsumption = NOT_INDICATED;
    private double price = 1D;
    private int year = 2000;

    public abstract void printInfo();

    public Electronics(long id) {
        setId(id);
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        if (id >= 100000000 && id <= 999999999) {
            this.id = id;
            return;
        }
        System.err.println("Id must be bigger than 100000000 and smaller than 999999999: ");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model != null && model.length() != 0) {
            this.model = model;
            return;
        }
        System.err.println("Model must be not blank: ");
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        if (power != null && power.length() != 0) {
            this.power = power;
            return;
        }
        System.err.println("Power must be not blank: ");
    }

    public String getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(String powerConsumption) {
        if (powerConsumption != null && powerConsumption.length() != 0) {
            this.powerConsumption = powerConsumption;
            return;
        }
        System.err.println("Power consumption must be not blank: ");

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
            return;
        }
        System.err.println("Price must be not negative: " + price);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 1990 && year <= 2020) {
            this.year = year;
            return;
        }
        System.err.println("Year must be bigger then 1905 and smaller than 2021: ");
    }



    @Override
    public String toString() {
        return "Id: " + id + " \n" +
                "Model: " + model + " \n" +
                "Power: " + power + " \n" +
                "Power consumption: " + powerConsumption + " \n" +
                "Price: " + price + "$ \n" +
                "Year: " + year + " \n";
    }

    @Override
    public void switchOn() {
        System.out.println(model + " is switched on");
    }

    @Override
    public void switchOff() {
        System.out.println(model + " is switched off");
    }
}
