import java.time.LocalDateTime;

public class Package {
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

}

