package templeRun;

public class Score {
    private String username;
    private Long points;

    public Score(String username, Long points) {
        this.username = username;
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public Long getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return getUsername() + ":\t" + String.valueOf(getPoints());
    }

}
