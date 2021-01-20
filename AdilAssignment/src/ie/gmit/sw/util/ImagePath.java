package ie.gmit.sw.util;

import ie.gmit.sw.model.ImageFileType;

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
public final class ImagePath implements Terminal {
    /**
     * this method accepts input path from the user
     *
     * @return File an object of input file
     */
    @Override
    public File getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Input Image path");
        String inputImagePath = sc.nextLine();
        if (!checkIfPathExist(inputImagePath)) {
            return null;
        }
        var inputImageFile = new File(inputImagePath.replace("\"", ""));
        return inputImageFile;
    }

    /**
     * this method checks if the input file is an image file or not
     *
     * @param file input file
     * @return Boolean
     */
    public Boolean checkIfImageFile(File file) {
        Boolean flag = false;
        for (ImageFileType imageFileType : ImageFileType.values()) {
            if (file.getName().toLowerCase().endsWith(imageFileType.toString().toLowerCase()))
                flag = true;
        }
        if (flag == false)
            System.out.println("Not an Image File.");
        return flag;
    }
}
