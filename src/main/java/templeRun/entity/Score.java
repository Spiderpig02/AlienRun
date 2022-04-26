package templeRun.entity;

public class Score implements Comparable<Score> {
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

    @Override
    public int compareTo(Score o) {
        return (int) (o.getPoints() - this.getPoints());
    }

}
