import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Package {
    private String departureCity;
    private String arrivalCity;
    private double weight;
    private LocalDateTime creationDateTime;

    public Package(String departureCity, String arrivalCity, double weight, LocalDateTime creationDateTime) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.weight = weight;
        this.creationDateTime = creationDateTime;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public double getWeight() {
        return weight;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    @Override
    public String toString() {
        return "Package{departureCity='" + departureCity + "', arrivalCity='" + arrivalCity + "', weight=" + weight + ", creationDateTime=" + creationDateTime + "}";
    }

    public static void main(String[] args) {
        List<Package> packages = new ArrayList<>();
        packages.add(new Package("Moscow", "Berlin", 2.5, LocalDateTime.of(2023, 7, 10, 14, 30)));
        packages.add(new Package("Paris", "Berlin", 1.2, LocalDateTime.of(2023, 7, 12, 9, 45)));
        packages.add(new Package("London", "Berlin", 3.8, LocalDateTime.of(2023, 7, 11, 16, 20)));
        packages.add(new Package("New York", "Berlin", 5.0, LocalDateTime.of(2023, 7, 9, 11, 0)));

        Package newestPackageToBerlin = packages.stream()
                .filter(pkg -> "Berlin".equals(pkg.getArrivalCity()))
                .max(Comparator.comparing(Package::getCreationDateTime))
                .orElseThrow(() -> new RuntimeException("No packages to Berlin available"));

        System.out.println("Самая новая посылка в Берлин: " + newestPackageToBerlin);
    }
}

