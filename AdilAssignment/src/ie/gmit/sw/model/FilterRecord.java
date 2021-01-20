package ie.gmit.sw.model;

import java.io.File;
/**
 * This class is a record class
 * which have attributes filterId, filterName, filterMatrix, outputPath
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-06
 */
public record FilterRecord(int filterId, String filterName, double[][] filterMatrix, File outputPath)
{

}
