package youtube;

import video.Video;

import java.util.List;

public interface YoutubeInterface {
    public List<Video> getAllVideos();

    //Requires getting the actual video from the disk through URL and setting it in disk.
    public Video getVideo(int id);
    public void setVideo(Video video);
}
