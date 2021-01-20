package ie.gmit.sw.task;

import ie.gmit.sw.model.FilterRecord;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.Callable;

/**
 * This class implements callable interface and performs convolution task
 *
 * @author Muhammad Adil
 * @version 1.0
 * @since 2020-01-06
 */
public class ConvolutionTask implements Callable<BufferedImage> {

    private BufferedImage input;
    private int order;
    private double[][] kernel;
    private FilterRecord filterRecord;

    /**
     * paramterised constructor
     * @param input object of BufferedImage
     * @param order size of the kernel matrix
     * @param kernel filter matrix
     */
    public ConvolutionTask(BufferedImage input, int order, double[][] kernel) {
        this.input = input;
        this.order = order;
        this.kernel = kernel;
    }

    /**
     * parameterized constructor
     * @param input object of BufferedImage
     * @param filterRecord object of FilterRecord
     */
    public ConvolutionTask(BufferedImage input, FilterRecord filterRecord) {
        this.input = input;
        this.filterRecord = filterRecord;
        this.order = filterRecord.filterMatrix().length;
        this.kernel = filterRecord.filterMatrix();
    }

    /**
     * overrides call method of callable interface
     * calls performConvolution method
     *
     * @return BufferedImage of the output
     * @throws Exception
     */
    @Override
    public BufferedImage call() throws Exception {
        return performConvolution();
    }

    /**
     * perform convolution on the Image matrix using the kernel matrix
     *
     * @return BufferedImage of the output image
     */
    private BufferedImage performConvolution() {
        BufferedImage output;

        int WIDTH = input.getWidth();
        int HEIGHT = input.getHeight();
        output = new BufferedImage(WIDTH, HEIGHT, input.getType());
        System.out.println("[*] Rendering the image...");
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                Color  color = writePixel(x, y);
                output.setRGB(x, y, color.getRGB());
            }
        }
        return output;

    }

    /**
     * this method writes pixel at specific index of the Image matrix
     *
     * @param x row index of a pixel
     * @param y column index of a pixel
     * @return Color the new color of the pixel at index x,y
     */
    private Color writePixel(int x, int y) {
        double multi_factor = 1.0;
        int WIDTH = input.getWidth();
        int HEIGHT = input.getHeight();
        float red = 0f, green = 0f, blue = 0f;
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                // Calculating X and Y coordinates of the pixel to be multiplied with current kernel element
                // In case of edges of image the '% WIDTH' wraps the image and the pixel from opposite edge is used
                int imageX = (x - order / 2 + i + WIDTH) % WIDTH;
                int imageY = (y - order / 2 + j + HEIGHT) % HEIGHT;

                int RGB = input.getRGB(imageX, imageY);
                int R = (RGB >> 16) & 0xff; // Red Value
                int G = (RGB >> 8) & 0xff;    // Green Value
                int B = (RGB) & 0xff;        // Blue Value

                // The RGB is multiplied with current kernel element and added on to the variables red, blue and green
                red += (R * kernel[i][j]);
                green += (G * kernel[i][j]);
                blue += (B * kernel[i][j]);
            }
        }
        int outR, outG, outB;
        // The value is truncated to 0 and 255 if it goes beyond
        outR = Math.min(Math.max((int) (red * multi_factor), 0), 255);
        outG = Math.min(Math.max((int) (green * multi_factor), 0), 255);
        outB = Math.min(Math.max((int) (blue * multi_factor), 0), 255);
        // Pixel is written to output image

        return new Color(outR, outG, outB);
    }
}
