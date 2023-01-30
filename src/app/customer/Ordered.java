package app.customer;

public class Ordered {
    private String menuName;
    private int grade;

    public Ordered(String menuName, int grade) {
        this.menuName = menuName;
        this.grade = grade;
    }

    @Override
    public String toString() {
        if (!isFeedback()) return String.format("%s", menuName);
        return String.format("%s %s", menuName, toStarFormat());
    }

    public String toStarFormat() {
        String star = "★";
        return star.repeat(grade);
    }

    public boolean isFeedback() {
        return grade > 0;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
