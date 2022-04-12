public class Main {
    public static void main(String[] args) throws Exception {
        VideoStore videoStore = new VideoStore();

        Guest guest = new Guest("John Smith", "H2W 3T6 London, UK");
        Guest guest1 = new Guest("Joe Holmes", "J6Y 1G4 London, Uk");
        Guest guest2 = new Guest("Alice Cooper", "K8F 9O9 Birmingham, UK");

        videoStore.addGuest(guest);
        videoStore.addGuest(guest1);
        videoStore.addGuest(guest2);

        Video video = new GrayScaleVideo("Spider", "Will Smith", 2000);
        Video video1 = new ColoredVideo("Anaconda", "Jeremy Holmes", 2022);
        Video video2 = new GrayScaleVideo("Piranha", "Joey Wilde", 1979);

        videoStore.addVideo(video);
        videoStore.addVideo(video1);
        videoStore.addVideo(video2);

        System.out.println(guest);
        videoStore.borrow(guest, video1);
        System.out.println(guest);
        System.out.println();

        System.out.println(video);
        System.out.println(video.isAvailable);
        System.out.println();

        System.out.println(videoStore);
        System.out.println();

        Video coloredVideoCopy = video1.copy();
        System.out.println(video1);
        System.out.println(coloredVideoCopy);
        System.out.println();

        guest.video = guest.steal();
        System.out.println(guest.video);
        System.out.println();

        System.out.println(videoStore.getMostOftenBorrowed());
        System.out.println();

        videoStore.borrow(guest2, video2);
        System.out.println(guest2);
        System.out.println(video2.isAvailable);
        videoStore.returnVideo(guest2);
        System.out.println(guest2);
        System.out.println(video2.isAvailable);
        System.out.println();

//        Video grayScaleVideoCopy = video.copy();
//        guest1.steal();
    }
}
