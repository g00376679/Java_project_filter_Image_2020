package ie.gmit.sw.model;

import java.io.File;
import java.util.ArrayList;
/**
 * This class contains a list of FilterRecord
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-06
 */
public class FilterRecordList {
    private ArrayList<FilterRecord> filterRecordArrayList;

    /**
     *constructor to initialize the arraylist of FilterRecord
     */
    public FilterRecordList() {
        FilterRecord fm0 = new FilterRecord(0, "NULL", new double[0][0], new File(""));
        FilterRecord fm1 = new FilterRecord(1, "Identity_Filter", FilterMatrix.IdentityMatrix, new File(""));
        FilterRecord fm2 = new FilterRecord(2, "EdgeDetection1_Filter", FilterMatrix.EdgeDetectionMatrixType, new File(""));
        FilterRecord fm3 = new FilterRecord(4, "Laplacian_Filter", FilterMatrix.LaplacianMatrix, new File(""));
        FilterRecord fm4 = new FilterRecord(5, "Sharpen_Filter", FilterMatrix.SharpenMatrix, new File(""));
        FilterRecord fm5 = new FilterRecord(6, "Horizontal_Lines_Filter", FilterMatrix.HorizontalLinesMatrix, new File(""));
        FilterRecord fm6 = new FilterRecord(7, "Vertical_Lines_Filter", FilterMatrix.VerticalLinesMatrix, new File(""));
        FilterRecord fm7 = new FilterRecord(8, "Diagonal_Lines_Filter", FilterMatrix.DiagonalLinesMatrix, new File(""));
        FilterRecord fm8 = new FilterRecord(9, "Sobel_Horizontal_Filter", FilterMatrix.SobelHorizontalMatrix, new File(""));
        FilterRecord fm9 = new FilterRecord(10, "Sobel_Vertical_Filter", FilterMatrix.SobelVerticalMatrix, new File(""));
        FilterRecord fm10 = new FilterRecord(11, "Box_Blur_Filter", FilterMatrix.BoxBlurMatrix, new File(""));
        filterRecordArrayList=new ArrayList<>();
        filterRecordArrayList.add(0, fm0);
        filterRecordArrayList.add(1, fm1);
        filterRecordArrayList.add(2, fm2);
        filterRecordArrayList.add(3, fm3);
        filterRecordArrayList.add(4, fm4);
        filterRecordArrayList.add(5, fm5);
        filterRecordArrayList.add(6, fm6);
        filterRecordArrayList.add(7, fm7);
        filterRecordArrayList.add(8, fm8);
        filterRecordArrayList.add(9, fm9);
        filterRecordArrayList.add(10, fm10);

    }

    /**
     * this method is used to get the item at index from the filter record list
     * @param index index of the filterRecord to be fetched
     * @return FilterRecord object
     */
    public  FilterRecord getRecordAtIndex(int index)
    {
        return filterRecordArrayList.get(index);
    }
}
