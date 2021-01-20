package ie.gmit.sw.task;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;


/**
 * This class implements callable interface and calls the File task
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-06
 */
public class FileProcessorTask implements Callable<BufferedImage> {
    private File file;

    /**
     * parameterized constructor
     * @param file input file
     */
    public FileProcessorTask(File file) {
        this.file = file;
    }

    /**
     * this method reads the file and converts to bufferedImage object
     *
     * @param file input file
     * @return BufferedImage of the input file
     */
    private BufferedImage convertFileToBufferedImage(File file) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }

    /**
     * overrides call method of the callable interface
     * calls convertFileToBufferedImage method
     *
     * @return BufferedImage
     * @throws Exception
     */
    @Override
    public BufferedImage call() throws Exception {
        return convertFileToBufferedImage(file);
    }
}
