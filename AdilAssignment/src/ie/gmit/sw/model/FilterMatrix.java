package ie.gmit.sw.model;

/**
 * This class contains the different kernel matrix
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-02
 */
public class FilterMatrix {
    public static final double[][] IdentityMatrix = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
    };

    public static final double[][] EdgeDetectionMatrixType = {
            {-1, -1, -1},
            {-1, 8, -1},
            {-1, -1, -1}
    };

    public static final double[][] LaplacianMatrix = {
            {0, -1, 0},
            {-1, 4, -1},
            {0, -1, 0}
    };

    public static final double[][] SharpenMatrix = {
            {0, -1, 0},
            {-1, 5, -1},
            {0, -1, 0}
    };
    public static final double[][] HorizontalLinesMatrix = {
            {-1, -1, -1},
            {2, 2, 2},
            {-1, -1, -1}
    };
    public static final double[][] VerticalLinesMatrix = {
            {-1, 2, -1},
            {-1, 2, -1},
            {-1, 2, -1}
    };
    public static final double[][] DiagonalLinesMatrix = {
            {-1, -1, 2},
            {-1, 2, -1},
            {2, -1, -1}
    };
    public static final double[][] SobelHorizontalMatrix = {
            {-1, -2, -1},
            {0, 0, 0},
            {1, 2, 1}
    };
    public static final double[][] SobelVerticalMatrix = {
            {-1, 0, 1},
            {-2, 0, 2},
            {-1, 0, 1}
    };
    public static final double[][] BoxBlurMatrix = {
            {0.11, 0.11, 0.11},
            {0.11, 0.11, 0.11},
            {0.11, 0.11, 0.11}
    };

}
