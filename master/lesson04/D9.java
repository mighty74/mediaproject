package lesson04;

import java.util.ArrayList;
import java.util.List;

import GImage.GImage;

public class D9 {
	public static void main(String[] args)
	{
		 String fileName = "Sailboat0.bmp";
	     GImage img= new GImage(fileName);

	     /**
	      * Get the width of the image-file.
	      */
	     int width = img.getWidth();
	     System.out.println("width="+width);

	     /**
	      * Get the height of the image-file.
	      */
	     int height = img.getHeight();
	     System.out.println("height="+height);
	     int[] num = new int[255];

	     for(int i = 0; i < height; i++) {
	    	 for(int l = 0; l < width; l++) {
	    		 num[img.pixel[i][l]] += 1;
	    	 }
	     }

	     List<Integer> x = new ArrayList<>();

	    int a = 0;
	    int k = 0;
	    for(int i = 0; i < num.length; i++) {
	    	a += num[i];
	    	if(a > 256*256*3/10) {
	    		k = i;
	    		break;
	    	}
	    }
	    System.out.println(k);

	    for(int i = 0; i < height; i++) {
	    	 for(int l = 0; l < width; l++) {
	    		 if(k-1 < img.pixel[i][l]) {
	    			 img.pixel[i][l] = 255;
	    		 }
	    		 else {
	    			 img.pixel[i][l] = 0;
	    		 }
	    	 }
	     }






	     /**
	      *  Set the file name to "My_ImageD9".
	      */
	     String fileName01 = "bmp/My_ImageD9";

	     /**
	      *  Set the file type to "bmp".
	      */
	     String fileType01 = "bmp";

	     /**
	      * Output the image-file "My_Image01.bmp".
	      */
	     img.output(fileName01,fileType01);

	     /**
	      * Set the file name to "My_Image01.bmp".
	      */
	     fileName01 +="." + fileType01;
	     System.out.println("Output file:"+fileName01);
	}
}
