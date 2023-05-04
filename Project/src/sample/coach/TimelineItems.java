package sample.coach;

public class TimelineItems {
    private int id;
    private String exercise;

    public TimelineItems()
    {
        this.id = 0;
        this.exercise = "";
    }

    public TimelineItems(int id, String exercise) {
        this.id = id;
        this.exercise = exercise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }
}
