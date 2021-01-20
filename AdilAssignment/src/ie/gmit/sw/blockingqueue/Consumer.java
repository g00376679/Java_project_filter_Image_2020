package ie.gmit.sw.blockingqueue;

import ie.gmit.sw.manager.TaskManager;
import ie.gmit.sw.model.FilterRecord;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
/**
 * This class implements runnable interface,it acts as a consumer of files
 * and remove files from the buffer
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-06
 */
public class Consumer implements Runnable{
    private Buffer buffer;
    private FilterRecord filterRecord;
    private ArrayList<File> fileArrayList;

    /**
     * parameterized constructor
     * @param buffer object of Buffer
     * @param fileArrayList list of file
     * @param filterRecord contains details of filter id, filter name, filter matrix
     */
    public Consumer(Buffer buffer,ArrayList<File> fileArrayList,FilterRecord filterRecord) {
        this.buffer = buffer;
        this.filterRecord=filterRecord;
        this.fileArrayList=fileArrayList;
    }

    /**
     * this method overrides run method of runnable interface
     * retrieves and removes file from LinkedBlockingQueue
     */
    @Override
    public void run() {
      for(int i=0;i<fileArrayList.size();i++)
      {
            try {
                TaskManager.performTask(buffer.getItem(),filterRecord);
                Thread.sleep(1000);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
