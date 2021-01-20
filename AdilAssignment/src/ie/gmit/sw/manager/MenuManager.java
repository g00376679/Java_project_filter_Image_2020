package ie.gmit.sw.manager;

import ie.gmit.sw.menu.FilterMenu;
import ie.gmit.sw.menu.MainMenu;
import ie.gmit.sw.model.FilterRecord;
import ie.gmit.sw.model.FilterRecordList;
import ie.gmit.sw.util.CustomKernelMatrix;
import ie.gmit.sw.util.DirectoryPath;
import ie.gmit.sw.util.ImagePath;
import ie.gmit.sw.util.OutputPath;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is the Main Menu Manager class
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-06
 */
public class MenuManager {

    MainMenu mainMenu;
    ImagePath imagePath;
    DirectoryPath directoryPath;
    OutputPath outputPath;
    FilterMenu filterMenu;
    CustomKernelMatrix customKernelMatrix;
    public MenuManager()
    {
            mainMenu=new MainMenu();
            imagePath=new ImagePath();
            directoryPath=new DirectoryPath();
            outputPath=new OutputPath();
            filterMenu=new FilterMenu();
            customKernelMatrix=new CustomKernelMatrix();
    }
    /**
     * this method display the main menu until the user exit from the menu
     *
     */
    public void displayMenu() {
        int choice=-1;
        while (choice!=4) {
            String choiceStr = mainMenu.display();
            if (!mainMenu.checkIfNumber(choiceStr)) {
                System.out.println("Invalid Choice: not a number");
            }
            else {
                choice = Integer.parseInt(choiceStr);
                switch (choice) {
                    case 1 -> selectImageDirectory();
                    case 2 -> selectSingleImage();
                    case 3 -> addCustomFilter();
                    case 4 -> mainMenu.exit();
                    default -> System.out.println("Invalid Choice");
                }
            }
        }
    }

    /**
     * This method handles the various user input
     * like Image directory path, output directory path and filter selected
     * and put file to the blockingqueue
     *
     */
    private void selectImageDirectory() {
        File inputDirFile = directoryPath.getInput();
        if (inputDirFile == null)
            return;
        File outputPathFile= outputPath.getInput();
        if (outputPathFile == null)
            return;
        String selectedFilterIndex = filterMenu.display();
        //if selected invalid filter
        if (!filterMenu.checkIfNumber(selectedFilterIndex)) {
            System.out.println("Invalid Filter Choice: not a number");
            return;
        }
        if(!filterMenu.checkSelectedFilterIsValid(selectedFilterIndex))
        {
            System.out.println("Invalid Filter Choice");
            return;
        }

        File[] fileList = inputDirFile.listFiles((dir1, name) -> name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".gif"));
        ArrayList<File> DirFileArrayList = new ArrayList<>(Arrays.asList(fileList));

        FilterRecord selectedFilterRecord = new FilterRecordList().getRecordAtIndex(Integer.parseInt(selectedFilterIndex));
        FilterRecord newFilterRecord=new FilterRecord(selectedFilterRecord.filterId(),selectedFilterRecord.filterName(), selectedFilterRecord.filterMatrix(), outputPathFile);
        TaskManager.addFilesToBlockingQueue(DirFileArrayList,newFilterRecord);

    }

    /**
     * This method handles the various user input
     * like Image  path, output directory path and filter selected
     * and put file to the blockingqueue
     */
    private void selectSingleImage()
    {
        File inputImageFile = imagePath.getInput();
        if (inputImageFile == null) return;
        if(!imagePath.checkIfImageFile(inputImageFile)) return;

        File outputPathFile= outputPath.getInput();
        if (outputPathFile == null) return;

        String selectedFilterIndex = filterMenu.display();
        //if selected invalid filter
        if (!filterMenu.checkIfNumber(selectedFilterIndex)) {
            System.out.println("Invalid Filter Choice: not a number");
            return;
        }
        if(!filterMenu.checkSelectedFilterIsValid(selectedFilterIndex))
        {
            System.out.println("Invalid Filter Choice");
            return;
        }

        FilterRecord selectedFilterRecord = new FilterRecordList().getRecordAtIndex(Integer.parseInt(selectedFilterIndex));
        FilterRecord newFilterRecord=new FilterRecord(selectedFilterRecord.filterId(),selectedFilterRecord.filterName(), selectedFilterRecord.filterMatrix(), outputPathFile);

        TaskManager.addFilesToBlockingQueue(new ArrayList<>(Arrays.asList(inputImageFile)),newFilterRecord);
    }

    /**
     * This method handles the various user input
     * like Image  path, output directory path and a custom filter matrix
     * and put file to the blockingqueue
     */
    private void addCustomFilter() {
        double[][] customFilterMatrix = customKernelMatrix.acceptInput();

        File inputImageFile = imagePath.getInput();
        if (inputImageFile == null) return;

        File outputPathFile= outputPath.getInput();
        if (outputPathFile == null) return;

        FilterRecord newFilterRecord=new FilterRecord(999,"Custom_Filter", customFilterMatrix,outputPathFile);
        TaskManager.addFilesToBlockingQueue(new ArrayList<>(Arrays.asList(inputImageFile)),newFilterRecord);
    }

}

