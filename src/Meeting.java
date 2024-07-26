import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Meeting {
    private String person1;
    private String person2;
    private LocalDateTime meetingDateTime;

    public Meeting(String person1, String person2, LocalDateTime meetingDateTime) {
        this.person1 = person1;
        this.person2 = person2;
        this.meetingDateTime = meetingDateTime;
    }

    public LocalDateTime getMeetingDateTime() {
        return meetingDateTime;
    }

    @Override
    public String toString() {
        return "Meeting{person1='" + person1 + "', person2='" + person2 + "', meetingDateTime=" + meetingDateTime + "}";
    }

    public static void main(String[] args) {
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
