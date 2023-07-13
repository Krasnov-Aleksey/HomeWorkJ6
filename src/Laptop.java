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

    @Override
    public int hashCode() {
        return ram+7*hdd+operatingSystem.hashCode()+13*color.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Laptop)){
            return false;
        }
        Laptop laptop = (Laptop) obj;
        return ram == laptop.ram && hdd == laptop.hdd && operatingSystem.equalsIgnoreCase(laptop.operatingSystem)&&color.equalsIgnoreCase(laptop.color);
    }
}
