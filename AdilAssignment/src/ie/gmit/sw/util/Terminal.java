package ie.gmit.sw.util;

import java.io.File;

/**
 * This is a sealed interface which has a public method and a default method
 * which takes input from the terminal and check if the file path exist
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-06
 */
public sealed interface Terminal permits ImagePath, DirectoryPath, OutputPath {

    /**
     * accepts input from the console/terminal
     *
     * @return File an object of file
     */
    File getInput();

    /**
     * this method checks whether the input image file exist or not
     * and display appropriate message
     *
     * @param inputImagePath input image path in string form
     * @return Boolean if the file exist return true else return false
     */
    default Boolean checkIfPathExist(String inputImagePath) {

        File inputImageFile = new File(inputImagePath.replace("\"", ""));
        if (!inputImageFile.exists()) {
            System.out.println("File does not exist: " + inputImagePath);
            return false;
        }
        return true;
    }
}
