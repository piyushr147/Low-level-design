import video.Video;
import youtube.concreteClass.Youtube;
import youtube.proxy.YoutubeProxy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Youtube youtube = new Youtube();
        YoutubeProxy youtubeProxy = new YoutubeProxy(youtube);

        youtubeProxy.setVideo(new Video(1,"lucky bisht",4));
        youtubeProxy.setVideo(new Video(2,"armed forces",4));
        youtubeProxy.setVideo(new Video(3,"cricket top 10 moments",4));

        for(Video video: youtube.getAllVideos()){
            System.out.println(video.title);
        }
        System.out.println(youtubeProxy.getVideo(1).title);
    }
}