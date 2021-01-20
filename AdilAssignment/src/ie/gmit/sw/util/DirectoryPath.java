package ie.gmit.sw.util;

import java.io.File;
import java.util.Scanner;

/**
 * This class implements Terminal interface and overrides the getInput method
 * and accepts input path from the user
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-06
 */
public final class DirectoryPath implements Terminal {
    /**
     * this method accepts input image directory
     * and checks if the directory exist or not
     *
     * @return File an object of dir file
     */
    @Override
    public File getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Input Image Directory");
        String dirPath = sc.next();
        File dir = new File(dirPath.replace("\"", ""));
        if (!dir.isDirectory()) {
            System.out.println("Directory does not exist:" + dir);
            return null;
        }
        return dir;
    }
}
