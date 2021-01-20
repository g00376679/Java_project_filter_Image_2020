package ie.gmit.sw.blockingqueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * This class acts as a Buffer which creates LinkedBlockingQueue of size 5
 * and perform insert and remove operation on the LinkedBlockingQueue
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-06
 */
public class Buffer {

    private static final int SIZE_OF_BLOCKING_QUEUE = 5;
    private BlockingQueue<File> fileBlockingQueue = new LinkedBlockingDeque<>(SIZE_OF_BLOCKING_QUEUE);

    /**
     * this method retrieve and removes file from the LinkedBlockingQueue
     *
     * @return File object on which the convolution will be performed
     */
    public File getItem() {
        File file = null;
        try {
            file = fileBlockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * this method insert file into the LinkedBlockingQueue
     *
     * @param file object to be inserted
     */
    public void putItem(File file) {
        try {
            fileBlockingQueue.put(file);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
