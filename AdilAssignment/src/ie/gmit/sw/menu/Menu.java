package ie.gmit.sw.menu;

/**
 * This is a sealed interface which has a public method display
 * which display the menu on the terminal
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-06
 */
public sealed interface Menu permits MainMenu, FilterMenu {

    String display();
    default boolean checkIfNumber(String choiceStr) {
        if (choiceStr.matches("\\d+")) {
            return true;
        }
        return false;
    }
}
