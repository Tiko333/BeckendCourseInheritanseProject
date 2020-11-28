package picsart.model.electronics;

import picsart.exceptions.electronicsException.*;
import picsart.service.IDGenerator;
import picsart.service.StringCheckService;

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
        if (!IDGenerator.checkLength(id)) {
            throw new IDException(id);
        }
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (StringCheckService.checkString(model)) {
           throw new ModelException();
        }
        this.model = model;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        if (StringCheckService.checkString(power)) {
            throw new PowerException();
        }
        this.power = power;
    }

    public String getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(String powerConsumption) {
        if (StringCheckService.checkString(powerConsumption)) {
            throw new PowerConsumptionException();
        }
        this.powerConsumption = powerConsumption;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new PriceException(price);
        }
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1990 || year > 2020) {
            throw new YearException(year);
        }
        this.year = year;
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
