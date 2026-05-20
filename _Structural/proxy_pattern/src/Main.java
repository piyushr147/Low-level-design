import video.Video;
import youtube.concreteClass.Youtube;
import youtube.proxy.YoutubeProxy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        YoutubeProxy youtubeProxy = new YoutubeProxy(new Youtube());

        youtubeProxy.setVideo(new Video(1,"lucky bisht",4));
        youtubeProxy.setVideo(new Video(2,"armed forces",4));
        youtubeProxy.setVideo(new Video(3,"cricket top 10 moments",4));

        for(Video video: youtubeProxy.getAllVideos()){
            System.out.println(video.title);
        }
        System.out.println(youtubeProxy.getVideo(1).title);
        System.out.println(youtubeProxy.getVideo(1).title);
    }
}