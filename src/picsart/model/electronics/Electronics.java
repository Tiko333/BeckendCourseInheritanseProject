package picsart.model.electronics;

import picsart.exceptions.electronicsException.*;
import picsart.service.IDGenerator;
import picsart.service.StringCheckService;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Electronics implements ElectronicsInterface {

    private long id;
    private String model = NOT_INDICATED;
    private String power = NOT_INDICATED;
    private String powerConsumption = NOT_INDICATED;
    private double price;
    private int year;
    private String date;

    public abstract void printInfo();

    public Electronics(long id) {
        setId(id);
        setPrice(1D);
        setYear(2000);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateString = format.format(new Date());
        date = dateString;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Id: ").append(id).append(" \n")
                .append("Model: ").append(model).append(" \n")
                .append("Power: ").append(power).append(" \n")
                .append("Power consumption: ").append(powerConsumption).append(" \n")
                .append("Price: ").append(price).append(" \n")
                .append("Year: ").append(year).append(" \n")
                .append("Date: ").append(date).append(" \n").toString();
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
