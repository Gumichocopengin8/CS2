//*********************************************************************
//  ImageGen01Color.java         By Dale/Joyce/Weems               Chapter 1
//
//  Demonstrates image generation
//
//*********************************************************************
//package ch01.apps;

// Koki Omori, Keita Nonaka
// 2/5/2018
// Creating images with RGB color


import java.awt.image.*;
import java.awt.Color;
import java.io.*;
import javax.imageio.*;

public class ImageGen01Color {
    public static void main (String[] args) {
        String fileOut = args[0];   // destination file

        // create BufferedImage of SIZE and TYPE
        final int SIDE = 1024;
        final int TYPE = BufferedImage.TYPE_INT_RGB;
        BufferedImage image = new BufferedImage(SIDE, SIDE, TYPE);

        final int LIMIT = 255; // limit of RGB values
        int r, g, b;                 // specific value for R G and B
        Color color;

        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {

                // algorithm
                r = (j*j / (i+1)) % LIMIT;
                g = (i*i / (j+1)) % LIMIT;
                b = (i*j / (LIMIT)) % LIMIT;
                color = new Color(r, g, b);  // creates 'gray' values
                image.setRGB(i, j, color.getRGB());  // saves pixel
            }
        }

        try { // write image to file
            File outputfile = new File(fileOut);
            ImageIO.write(image, "jpg", outputfile);
        }
        catch (IOException e) {
            System.out.println("could not save file ...");
        }
    }
}