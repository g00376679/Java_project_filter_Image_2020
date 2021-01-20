package ie.gmit.sw.util;

import java.util.Scanner;

/**
 * This class is used to accept custom kernel matrix from the user
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-06
 */
public class CustomKernelMatrix {

    /**
     * this method accepts the size of the kernel matrix
     * and enter items in the custom kernel matrix
     *
     * @return double[][] a kernel matrix of size*size
     */
    public double[][] acceptInput() {
        var sc = new Scanner(System.in);
        System.out.println("Enter the Size of Kernel Matrix");
        int sizeOfCustomKernelMatrix = sc.nextInt();
        var customKernelMatrix = new double[sizeOfCustomKernelMatrix][sizeOfCustomKernelMatrix];
        for (int i = 0; i < sizeOfCustomKernelMatrix; i++) {
            for (int j = 0; j < sizeOfCustomKernelMatrix; j++) {
                System.out.print("Enter value at index(" + i + ")(" + j + "):");
                customKernelMatrix[i][j] = sc.nextDouble();
            }
        }
        return customKernelMatrix;
    }

}
