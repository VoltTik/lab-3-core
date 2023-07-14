package model.money;

public class Currency {

    private String name;
    private float usdCourse;

    public Currency(String name, float usdCourse) {
        this.name = name;
        this.usdCourse = usdCourse;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public float getUsdCourse() {
        return usdCourse;
    }

    public void setUsdCourse(float usdCourse) {
        this.usdCourse = usdCourse;
    }
}
