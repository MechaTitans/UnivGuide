package tn.mechatitans.forms;

public class subDomain {
    private int points;
    private subDomainType type;
    public subDomain(int points, subDomainType type) {
        this.points = points;
        this.type = type;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public subDomainType getType() {
        return type;
    }

    public void setType(subDomainType type) {
        this.type = type;
    }
}
