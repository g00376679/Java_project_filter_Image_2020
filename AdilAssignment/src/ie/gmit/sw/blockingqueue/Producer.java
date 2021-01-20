package ie.gmit.sw.blockingqueue;

import java.io.File;
import java.util.ArrayList;

/**
 * This class implements runnable interface,it acts as a producer of files
 * and insert files into buffer
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-06
 */
public class Producer implements Runnable {
	private Buffer buffer;
	private ArrayList<File> fileArrayList;

	/**
	 * parameterized constructor
	 * @param buffer object of Buffer
	 * @param fileArrayList list of Filter record
	 */
	public Producer(Buffer buffer,ArrayList<File> fileArrayList) {
		this.buffer = buffer;
		this.fileArrayList=fileArrayList;
	}

	/**
	 * this method overrides run method of runnable interface
	 * and insert file into LinkedBlockingQueue
	 */
	@Override
	public void run() {
		fileArrayList.forEach(f->buffer.putItem(f));
	}
}