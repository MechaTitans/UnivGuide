package tn.mechatitans.forms;

public class Domain {
    private int points;
    private DomainType type;
    public Domain(int points, DomainType type) {
        this.points = points;
        this.type = type;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public DomainType getType() {
        return type;
    }

    public void setType(DomainType type) {
        this.type = type;
    }
}
