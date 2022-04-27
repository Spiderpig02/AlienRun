package templeRun.entity;

public class Score implements Comparable<Score> {
    private String username;
    private Long points;

    public Score(String username, Long points) {
        VerifyClass.verifyUsername(username);
        this.username = username;
        if (points > 0) {
            this.points = points;
        } else {
            this.points = 0L;
        }
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
