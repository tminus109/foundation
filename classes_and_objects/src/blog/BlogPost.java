package blog;

public class BlogPost {
    String authorName, title, text, publicationDate;

    BlogPost(String authorName, String title, String text, String publicationDate) {
        this.authorName = authorName;
        this.title = title;
        this.text = text;
        this.publicationDate = publicationDate;
    }

    public static void main(String[] args) {
        BlogPost blogPost1 = new BlogPost(
                "John Doe",
                "Lorem Ipsum",
                "Lorem ipsum dolor sit amet",
                "2000.05.04.");

        BlogPost blogPost2 = new BlogPost(
                "Tim Urban",
                "Wait but why",
                "A popular long-form, stick-figure-illustrated blog about almost everything.",
                "2010.10.10.");

        BlogPost blogPost3 = new BlogPost(
                "William Turton",
                "One Engineer Is Trying to Get IBM to Reckon With Trump",
                "Daniel Hanley, a cyber-security engineer at IBM, doesn’t want to be the center of attention.\n" +
                        "When I asked to take his picture outside one of IBM’s New York City offices,\n" +
                        "he told me that he wasn’t really into the whole organizer profile thing.",
                "2017.03.28.");
    }
}
