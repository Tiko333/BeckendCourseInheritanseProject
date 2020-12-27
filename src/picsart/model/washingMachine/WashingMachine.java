package picsart.model.washingMachine;

import picsart.exceptions.washingMachineExceptions.*;
import picsart.model.electronics.Electronics;
import picsart.service.StringCheckService;

import java.util.Objects;

public class WashingMachine extends Electronics implements WashingMachineInterface {
    private String typeOfInstallation;
    private String downloadType;
    private String maximumDownload;
    private String programs;
    private String dimensions;
    private boolean display;
    private int weight;
    private String program;
    private int timer;

    public WashingMachine(long id) {
        super(id);
    }

    public String getTypeOfInstallation() {
        return typeOfInstallation;
    }

    public void setTypeOfInstallation(String typeOfInstallation) {
        if (StringCheckService.checkString(typeOfInstallation)) {
            throw new TypeOfInstallationException();
        }
        this.typeOfInstallation = typeOfInstallation;
    }

    public String getDownloadType() {
        return downloadType;
    }

    public void setDownloadType(String downloadType) {
        if (StringCheckService.checkString(downloadType)) {
            throw new DownloadTypeException();
        }
        this.downloadType = downloadType;
    }

    public String getMaximumDownload() {
        return maximumDownload;
    }

    public void setMaximumDownload(String maximumDownload) {
        if (StringCheckService.checkString(maximumDownload)) {
            throw new MaximumDownloadException();
        }
        this.maximumDownload = maximumDownload;
    }

    public String getPrograms() {
        return programs;
    }

    public void setPrograms(String programs) {
        if (StringCheckService.checkString(programs)) {
            throw new ProgramsException();
        }
        this.programs = programs;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        if (StringCheckService.checkString(dimensions)) {
            throw new DimensionsException();
        }
        this.dimensions = dimensions;
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight < 1) {
            throw new WeightException(weight);
        }
        this.weight = weight;
    }

    @Override
    public void setProgram(String program) {
        this.program = program;
        System.out.println("Program: " + program);
    }

    @Override
    public void setTimer(int time) {
        timer = time;
    }

    @Override
    public void start() {
        System.out.println(new StringBuilder("Starting program: ").append(program)
                .append(" timer: ").append(timer).toString());
    }

    @Override
    public void printInfo() {
        System.out.println(new StringBuilder()
                .append("\n Model: ").append(getModel()).append(" \n")
                .append(" Maximum download: ").append(maximumDownload).append(" \n")
                .append(" Price: ").append(getPrice()).append(" \n").toString());
    }

    @Override
    public String toString() {
        return super.toString() + new StringBuilder()
                .append("Type of installation: ").append(typeOfInstallation).append(" \n")
                .append("Download type: ").append(downloadType).append(" \n")
                .append("Maximum download: ").append(maximumDownload).append(" \n")
                .append("Programs:").append(programs).append(" \n")
                .append("Dimensions: ").append(dimensions).append(" \n")
                .append("Display: ").append(display ? "yes" : "no").append(" \n")
                .append("Weight: ").append(weight).append(" \n").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WashingMachine that = (WashingMachine) o;
        return display == that.display &&
                weight == that.weight &&
                Objects.equals(typeOfInstallation, that.typeOfInstallation) &&
                Objects.equals(downloadType, that.downloadType) &&
                Objects.equals(maximumDownload, that.maximumDownload) &&
                Objects.equals(programs, that.programs) &&
                Objects.equals(dimensions, that.dimensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfInstallation, downloadType, maximumDownload, programs, dimensions, display, weight);
    }
}
