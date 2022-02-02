package foundation_exam;

public abstract class Video implements Cloneable {
    String title;
    String director;
    int year;
    double price;
    int popularity;
    boolean isAvailable = true;

    public Video(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + " by " + director + " from " + year
                + " - borrowed " + popularity + " time(s).";
    }

    public Video copy() throws CloneNotSupportedException {
        return (Video) super.clone();
    }
}
