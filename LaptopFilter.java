import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LaptopFilter {
    public static void main(String[] args) {
        LaptopStore store = new LaptopStore();
        Scanner scanner = new Scanner(System.in);
        Map<String, String> criteria = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("0 - Завершить выбор критериев");

        while (true) {
            System.out.print("Выберите критерий: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (option == 0) {
                break;
            }

            switch (option) {
                case 1:
                    System.out.println("Доступные варианты ОЗУ: ");
                    store.getLaptops().stream()
                        .map(Laptop::getRam)
                        .distinct()
                        .forEach(ram -> System.out.println(ram + " GB"));
                    System.out.print("Введите значение ОЗУ (в ГБ): ");
                    String ram = scanner.nextLine();
                    criteria.put("ram", ram);
                    break;
                case 2:
                    System.out.println("Доступные варианты объема ЖД: ");
                    store.getLaptops().stream()
                        .map(Laptop::getStorage)
                        .distinct()
                        .forEach(storage -> System.out.println(storage + " GB"));
                    System.out.print("Введите значение объема ЖД (в ГБ): ");
                    String storage = scanner.nextLine();
                    criteria.put("storage", storage);
                    break;
                case 3:
                    System.out.println("Доступные операционные системы: ");
                    store.getLaptops().stream()
                        .map(Laptop::getOs)
                        .distinct()
                        .forEach(System.out::println);
                    System.out.print("Введите операционную систему: ");
                    String os = scanner.nextLine();
                    criteria.put("os", os);
                    break;
                case 4:
                    System.out.println("Доступные цвета: ");
                    store.getLaptops().stream()
                        .map(Laptop::getColor)
                        .distinct()
                        .forEach(System.out::println);
                    System.out.print("Введите цвет: ");
                    String color = scanner.nextLine();
                    criteria.put("color", color);
                    break;
                default:
                    System.out.println("Неверный критерий.");
                    break;
            }
        }

        Set<Laptop> filteredLaptops = filterLaptops(store.getLaptops(), criteria);
        System.out.println("Отфильтрованные ноутбуки:");
        filteredLaptops.forEach(System.out::println);
    }

    private static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, String> criteria) {
        return laptops.stream().filter(laptop -> {
            boolean matches = true;
            if (criteria.containsKey("ram")) {
                matches &= String.valueOf(laptop.getRam()).equals(criteria.get("ram"));
            }
            if (criteria.containsKey("storage")) {
                matches &= String.valueOf(laptop.getStorage()).equals(criteria.get("storage"));
            }
            if (criteria.containsKey("os")) {
                matches &= laptop.getOs().equalsIgnoreCase(criteria.get("os"));
            }
            if (criteria.containsKey("color")) {
                matches &= laptop.getColor().equalsIgnoreCase(criteria.get("color"));
            }
            return matches;
        }).collect(Collectors.toSet());
    }
}
