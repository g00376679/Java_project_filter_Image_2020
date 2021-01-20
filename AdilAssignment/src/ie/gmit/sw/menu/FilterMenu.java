package ie.gmit.sw.menu;

import java.util.Scanner;
/**
 * This class implements menu interface and overrides display method
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-06
 */
public final class FilterMenu implements Menu{

    /**
     * this method display the filter menu
     * and accepts filter option from the user
     * @return String the option selected by the user
     */
    @Override
    public String display() {
        Scanner sc = new Scanner(System.in);
        //use of text block
        String filterMenuStr = """
                 |----------------------------------------------------------------|
                 |                 Select Filter to Apply on Image                |
                 |----------------------------------------------------------------|
                 | 1. Identity Filter            | 6. Vertical Lines Filter       |
                 | 2. Edge Detection Filter      | 7. Diagonal Lines Filter       |
                 | 3. Laplacian Filter           | 8. Sobel Horizontal Filter     |
                 | 4. Sharpen Filter             | 9. Sobel Vertical Filter       |
                 | 5. Horizontal Lines Filter    | 10. box Blur Filter            |
                 |----------------------------------------------------------------|
                """;
        System.out.print(filterMenuStr);
        System.out.print("Enter Choice:");
        var filterChoiceStr = sc.nextLine();
        return filterChoiceStr;
    }
    public boolean checkSelectedFilterIsValid(String choice)
    {
        int filterChoice=Integer.parseInt(choice);
        if (!(filterChoice==1 && filterChoice <= 10)) {
           return false;
        }
        return true;
    }
}
