import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.video.VideoWriter;

import java.io.File;
import java.io.IOException;

/**
 * Created by Naga on 07-09-2016.
 */
public class VideoReConsc {
    public void reconstruct(String args) throws IOException, InterruptedException {
        File path = new File(args);
        File[] files = path.listFiles();

        for (int i = 0; i < files.length; i++){
            final MBFImage image = ImageUtilities.readMBF(files[i]);
            DisplayUtilities.displayName(image,"Reconstructed video");

        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        VideoReConsc v = new VideoReConsc();
        try {
            v.reconstruct("output/mainframes");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}