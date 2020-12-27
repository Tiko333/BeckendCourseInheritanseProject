package picsart.paths;

public enum FilePaths {
    CAMERA("src/picsart/files/cameras.txt"),
    COMPUTER("src/picsart/files/computers.txt"),
    CONSOLE("src/picsart/files/consoles.txt"),
    LAPTOP("src/picsart/files/laptops.txt"),
    PHONE("src/picsart/files/phones.txt"),
    TV("src/picsart/files/tvs.txt"),
    REFRIGERATOR("src/picsart/files/refrigerators.txt"),
    CONDITIONER("src/picsart/files/conditioners.txt"),
    WASHING_MACHINE("src/picsart/files/washingMachine.txt"),
    COFFEE_MAKER("src/picsart/files/coffeeMaker.txt"),
    VACUUM_CLEANER("src/picsart/files/vacuumCleaner.txt"),
    MICROWAVE("src/picsart/files/microwave.txt"),
    SPEAKER("src/picsart/files/speakers.txt"),
    REGISTRATION("src/picsart/files/registration.txt");

    String value;

    FilePaths(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
