import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<ProgrammingLanguage> languages = new ArrayList<>();
        languages.add(new ProgrammingLanguage("Java", "James Gosling", LocalDate.of(1995, 5, 23)));
        languages.add(new ProgrammingLanguage("Python", "Guido van Rossum", LocalDate.of(1991, 2, 20)));
        languages.add(new ProgrammingLanguage("C", "Dennis Ritchie", LocalDate.of(1972, 1, 1)));
        languages.add(new ProgrammingLanguage("C++", "Bjarne Stroustrup", LocalDate.of(1985, 10, 1)));

        ProgrammingLanguage oldestLanguage = languages.stream()
                .min(Comparator.comparing(ProgrammingLanguage::getFirstReleaseDate))
                .orElseThrow(() -> new RuntimeException("No languages available"));

        System.out.println("Самый старый язык программирования: " + oldestLanguage);


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


        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting("Alice", "Bob", LocalDateTime.of(2023, 7, 10, 14, 0)));
        meetings.add(new Meeting("Charlie", "Dave", LocalDateTime.of(2023, 7, 10, 16, 0)));
        meetings.add(new Meeting("Eve", "Frank", LocalDateTime.of(2023, 7, 10, 15, 0)));

        long totalSeconds = meetings.stream()
                .map(Meeting::getMeetingDateTime)
                .mapToLong(dt -> dt.toLocalTime().toSecondOfDay())
                .sum();

        long averageSeconds = totalSeconds / meetings.size();
        LocalTime averageMeetingTime = LocalTime.ofSecondOfDay(averageSeconds);

        System.out.println("Среднее время начала встреч: " + averageMeetingTime);
    }
}

