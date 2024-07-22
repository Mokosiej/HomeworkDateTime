import java.time.LocalDateTime;

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

        LocalTime averageMeetingTime = meetings.stream()
                .map(Meeting::getMeetingDateTime)
                .map(LocalDateTime::toLocalTime)
                .reduce(LocalTime.MIDNIGHT, (total, time) -> total.plusSeconds(time.toSecondOfDay()),
                        (total1, total2) -> total1.plusSeconds(total2.toSecondOfDay() / meetings.size()));

        System.out.println("Среднее время начала встреч: " + averageMeetingTime);
    }
}

