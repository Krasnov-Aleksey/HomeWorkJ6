public class Laptop {
    int ram;
    int hdd;
    String operatingSystem;
    String color;

    public Laptop(int ram, int hdd, String operatingSystem, String color) {
        this.ram = ram;
        this.hdd = hdd;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "ram=" + ram +
                ", hdd=" + hdd +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
