package ie.gmit.sw.manager;

import ie.gmit.sw.blockingqueue.Buffer;
import ie.gmit.sw.blockingqueue.Consumer;
import ie.gmit.sw.blockingqueue.Producer;
import ie.gmit.sw.model.FilterRecord;
import ie.gmit.sw.task.BufferedImageProcessorTask;
import ie.gmit.sw.task.ConvolutionTask;
import ie.gmit.sw.task.FileProcessorTask;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * This class is responsible for creating and executing thread task
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-06
 */
public class TaskManager {

    private final static int NO_OF_THREADS = 3;


    /** this method create two thread
     *  insert add remove items from the blockingqueue
     *
     * @param fileArrayList list of files to be inserted into blockingqueue
     * @param filterRecord  it contains filter id, filter name and filter matrix
     */

    public static void addFilesToBlockingQueue(ArrayList<File> fileArrayList,FilterRecord filterRecord) {
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer, fileArrayList);
        Consumer consumer = new Consumer(buffer,fileArrayList,filterRecord);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * this methods creates a thread pool of fixed size
     * invokes the executor service
     * and submits the different task
     * and gets a future object on completion of the task
     * @param file on which the filter will be applied
     * @param selectedFilterRecord  it contains filter id, filter name and filter matrix
     * @return boolean on completion of the task
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static Boolean performTask(File file, FilterRecord selectedFilterRecord) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(NO_OF_THREADS);
        Future<BufferedImage> bufferedImage = executorService.submit(new FileProcessorTask(file));
        Future<BufferedImage> outputBufferedImage = executorService.submit(new ConvolutionTask(bufferedImage.get(), selectedFilterRecord));
        Future<Boolean> booleanFuture = executorService.submit(new BufferedImageProcessorTask(outputBufferedImage.get(), file, selectedFilterRecord.filterName(), selectedFilterRecord.outputPath().getPath()));
        return booleanFuture.get();
    }
}
