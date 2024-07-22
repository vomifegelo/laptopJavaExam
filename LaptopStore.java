import java.util.HashSet;
import java.util.Set;

public class LaptopStore {
    private Set<Laptop> laptops;

    public LaptopStore() {
        laptops = new HashSet<>();
        laptops.add(new Laptop("Asus", 8, 512, "Windows", "SpaceGray"));
        laptops.add(new Laptop("Apple", 16, 1024, "MacOS", "Silver"));
        laptops.add(new Laptop("HP", 8, 256, "Windows", "Gray"));
        laptops.add(new Laptop("Lenovo", 12, 512, "Windows", "Black"));
        laptops.add(new Laptop("Asus", 8, 512, "Linux", "White"));
    }

    public Set<Laptop> getLaptops() {
        return laptops;
    }
}
