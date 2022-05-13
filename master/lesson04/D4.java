package lesson04;

import GImage.GImage;

public class D4 {
	public static void main(String[] args)
	{
		 String fileName = "Sailboat0.bmp";
	     GImage img= new GImage(fileName);
	     GImage img0= new GImage(256, 256);

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

	     int max = 0;

	    for(int i = 0; i < num.length; i++) {
	    	if(num[i] > max) {
	    		max = num[i];
	    	}
	    }

	    System.out.println(max);

	    for(int i = 0; i < num.length; i++){
	    	 for(int l = 0; l < Math.floor(num[i]*256/max); l++) {
	    		 img0.pixel[255-l][i] = 255;
	    	 }
	     }



	     /**
	      *  Set the file name to "My_ImageD4".
	      */
	     String fileName01 = "bmp/My_ImageD4";

	     /**
	      *  Set the file type to "bmp".
	      */
	     String fileType01 = "bmp";

	     /**
	      * Output the image-file "My_Image01.bmp".
	      */
	     img0.output(fileName01,fileType01);

	     /**
	      * Set the file name to "My_Image01.bmp".
	      */
	     fileName01 +="." + fileType01;
	     System.out.println("Output file:"+fileName01);
	}
}
