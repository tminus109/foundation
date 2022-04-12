public class Guest {
    String name;
    String address;
    Video video;

    public Guest(String name, String address) {
        this.name = name;
        this.address = address;
        video = null;
    }

    @Override
    public String toString() {
        if (video != null) {
            return name + " is currently borrowing the " + video.title + ".";
        } else {
            return name + " is not borrowing anything currently.";
        }
    }

    public Video steal() throws Exception {
        if (video != null) {
            try {
                return video.copy();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        } else {
            throw new Exception("There is no video available to steal.");
        }
        return null;
    }
}
