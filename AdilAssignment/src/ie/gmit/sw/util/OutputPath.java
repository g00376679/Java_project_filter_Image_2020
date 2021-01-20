package ie.gmit.sw.util;

import java.io.File;
import java.util.Scanner;

/**
 * This class implements Terminal interface and overrides the getInput method
 * and accepts output path from the user
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-06
 */
public final class OutputPath implements Terminal {
    /**
     * this method accepts output path from the user
     *
     * @return File an object of output file
     */
    @Override
    public File getInput() {
        var sc = new Scanner(System.in);
        System.out.println("Enter Output path");
        String outPutImagePath = sc.next();
        File dir = new File(outPutImagePath.replace("\"", ""));
        if (!dir.isDirectory()) {
            System.out.println("Output Directory does not exist:" + dir);
            return null;
        }
        return new File(outPutImagePath.replace("\"", ""));
    }
}
