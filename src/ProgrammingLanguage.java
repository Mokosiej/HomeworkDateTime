import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProgrammingLanguage {
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
}
