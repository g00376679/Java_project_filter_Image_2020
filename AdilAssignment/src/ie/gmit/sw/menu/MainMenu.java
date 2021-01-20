package ie.gmit.sw.menu;

import java.util.Scanner;

/**
 * This class implements menu interface and overrides display method
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-06
 */
public final class MainMenu implements Menu {

    /**
     * this method display the main menu
     * and accepts menu option from the user
     *
     * @return String the option selected by the user
     */
    @Override
    public String display() {
        Scanner sc = new Scanner(System.in);
        //text block
        String mainMenuStr = """
                       
                |----------------------------------------------------------------|
                |                 Welcome To Image Filtering_System              |
                |----------------------------------------------------------------|
                |1. Enter Image directory                                        |
                |2. Select Single Image                                          |
                |3. Add a Custom Filter                                          |
                |4. Exit                                                         |
                |----------------------------------------------------------------|
                """;
        System.out.print(mainMenuStr);
        System.out.print("Enter Choice:");
        var choice = sc.nextLine();
        return choice;
    }

    /**
     * This method terminate the program with exit status 0
     */
    public void exit() {
        System.out.println("Program Terminated");
        System.exit(0);
    }

    /**
     * this method check if the user selection is a number
     *
     * @param choiceStr user selection from main menu
     * @return boolean return true if the choiceStr matches the regular expression else return false
     */

}
