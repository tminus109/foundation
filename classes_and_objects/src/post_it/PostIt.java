package post_it;

public class PostIt {
    String backgroundColor;
    String text;
    String textColor;

    PostIt(String backgroundColor, String text, String textColor) {
        this.backgroundColor = backgroundColor;
        this.text = text;
        this.textColor = textColor;
    }

    public static void main(String[] args) {
        PostIt postIt = new PostIt("orange", "Idea 1", "blue");
        PostIt postIt1 = new PostIt("pink", "Awesome", "black");
        PostIt postIt2 = new PostIt("yellow", "Superb!", "green");
    }
}
