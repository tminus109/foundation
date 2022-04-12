public class GrayScaleVideo extends Video {
    GrayScaleVideo(String title, String director, int year) {
        super(title, director, year);
        this.price = 6.99;
    }

    @Override
    public Video copy() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("The Police will find you soon.");
    }
}
