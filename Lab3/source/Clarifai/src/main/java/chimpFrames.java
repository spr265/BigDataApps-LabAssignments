import org.openimaj.feature.local.list.LocalFeatureList;
import org.openimaj.feature.local.matcher.FastBasicKeypointMatcher;
import org.openimaj.feature.local.matcher.LocalFeatureMatcher;
import org.openimaj.feature.local.matcher.consistent.ConsistentLocalFeatureMatcher2d;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.feature.local.engine.DoGSIFTEngine;
import org.openimaj.image.feature.local.keypoints.Keypoint;
import org.openimaj.math.geometry.transforms.estimation.RobustAffineTransformEstimator;
import org.openimaj.math.model.fit.RANSAC;
import org.openimaj.video.Video;
import org.openimaj.video.xuggle.XuggleVideo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class chimpFrames{
    static Video<MBFImage> video;
    //    VideoDisplay<MBFImage> display = VideoDisplay.createVideoDisplay(video);
    static List<MBFImage> imageList = new ArrayList<MBFImage>();
    static List<Long> timeStamp = new ArrayList<Long>();
    static List<Double> mainPoints = new ArrayList<Double>();
    public static void main(String args[]){
        String path = "input/chimp.mkv";
        Frames(path);
        //MainFrames();
    }

    public static void Frames(String path){
        video = new XuggleVideo(new File(path));
        System.out.println("Frame Rate : " + video.getFPS());
        System.out.println("No of Frame : " + video.countFrames());
        System.out.println("Length : "+video.getWidth());
//        VideoDisplay<MBFImage> display = VideoDisplay.createVideoDisplay(video);
        int j=0;
        for (MBFImage mbfImage : video) {
            BufferedImage bufferedFrame = ImageUtilities.createBufferedImageForDisplay(mbfImage);
            j++;
            String name = "output/chimpFrames/new" + j + ".jpg";
            File outputFile = new File(name);

            try {

                ImageIO.write(bufferedFrame, "jpg", outputFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
            MBFImage b = mbfImage.clone();
            imageList.add(b);
            timeStamp.add(video.getTimeStamp());
        }
    }

    }


