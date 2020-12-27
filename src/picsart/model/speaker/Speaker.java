package picsart.model.speaker;

import picsart.exceptions.speakerExceptions.*;
import picsart.model.electronics.Electronics;
import picsart.service.StringCheckService;

import java.util.Objects;

public class Speaker extends Electronics implements SpeakerInterface {
    private String frequency;
    private String interfaceType;

    public Speaker(long id) {
        super(id);
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        if (StringCheckService.checkString(frequency)) {
            throw new FrequencyException();
        }
        this.frequency = frequency;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        if (StringCheckService.checkString(interfaceType)) {
            throw new InterfaceTypeException();
        }
        this.interfaceType = interfaceType;
    }

    @Override
    public void play() {
        System.out.println("Playing:");
    }

    @Override
    public void stop() {
        System.out.println("Stop:");
    }

    @Override
    public void pause() {
        System.out.println("Pause:");
    }

    @Override
    public void next() {
        System.out.println("Next:");
    }

    @Override
    public void previous() {
        System.out.println("Previous:");
    }

    @Override
    public void printInfo() {
        System.out.println(new StringBuilder()
                .append("\n Camera model: ").append(getModel()).append(" \n")
                .append(" Frequency: ").append(frequency).append(" \n")
                .append(" Price: ").append(getPrice()).append(" \n").toString());
    }

    @Override
    public String toString() {
        return super.toString() + new StringBuilder()
                .append("Frequency: ").append(getFrequency()).append(" \n")
                .append("InterfaceType: ").append(getInterfaceType()).append(" \n").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speaker speaker = (Speaker) o;
        return Objects.equals(frequency, speaker.frequency) &&
                Objects.equals(interfaceType, speaker.interfaceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frequency, interfaceType);
    }
}
