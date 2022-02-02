package foundation_exam;

import java.util.ArrayList;
import java.util.List;

public class VideoStore {
    List<Guest> guests;
    List<Video> videos;

    public VideoStore() {
        this.guests = new ArrayList<>();
        this.videos = new ArrayList<>();
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public void addVideo(Video video) {
        videos.add(video);
    }

    public void borrow(Guest guest, Video video) throws Exception {
        if (guest.video != null) {
            throw new Exception("The guest already has a video borrowed.");
        } else if (!video.isAvailable) {
            throw new Exception("The video is currently not available.");
        } else {
            video.isAvailable = false;
            guest.video = video;
            guest.video.popularity++;
        }
    }

    public void returnVideo(Guest guest) {
        guest.video.isAvailable = true;
        guest.video = null;
    }

    public Video getMostOftenBorrowed() {
        int maxPopularity = 0;
        Video mostOftenBorrowed = null;
        for (Video video : videos) {
            if (video.popularity > maxPopularity) {
                maxPopularity = video.popularity;
                mostOftenBorrowed = video;
            }
        }
        return mostOftenBorrowed;
    }

    public int countAvailableVideos() {
        int availableVideoCount = 0;
        for (Video video : videos) {
            if (video.isAvailable) {
                availableVideoCount++;
            }
        }
        return availableVideoCount;
    }

    public int countGuests() {
        return guests.size();
    }

    public String toString() {
        return "The store has " + countAvailableVideos() + " video(s) available right now and "
                + countGuests() + " guest(s) registered.";
    }
}
