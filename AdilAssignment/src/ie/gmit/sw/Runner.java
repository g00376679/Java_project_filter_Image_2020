package ie.gmit.sw;

import ie.gmit.sw.manager.MenuManager;
/**
 * This is the Application starter class
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-06
 */
public class Runner {
    /**
     * This method is used to create an object of MenuManager
     * and calls displayMenu method
     *
     * @param args no use
     */
    public static void main(String[] args) {
        MenuManager menuManager =new MenuManager();
        menuManager.displayMenu();
    }
}
