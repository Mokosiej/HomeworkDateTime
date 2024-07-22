import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class ProgrammingLanguage {
    private String name;
    private String author;
    private LocalDate firstReleaseDate;

    public ProgrammingLanguage(String name, String author, LocalDate firstReleaseDate) {
        this.name = name;
        this.author = author;
        this.firstReleaseDate = firstReleaseDate;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getFirstReleaseDate() {
        return firstReleaseDate;
    }

    @Override
    public String toString() {
        return "ProgrammingLanguage{name='" + name + "', author='" + author + "', firstReleaseDate=" + firstReleaseDate + "}";
    }

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
    }
}

