package lesson01;

import GImage.GImage;

public class A4 {
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

	     int level=0;
	     int h = height - 2;
	     int w = width - 2;
	     for(int i = 0; i < 2; i++) {
	    	 for(int l = 0; l < width; l++) {

	    		 img.pixel[i][l]=level;
	    		 img.pixel[i+h][l]=level;
	    	 }
	    	 for(int l = 0; l < height; l++) {
	    		 img.pixel[l][i]=level;
	    		 img.pixel[l][i+w]=level;
	    	 }
	     }


	     /**
	      *  Set the file name to "My_ImageA4".
	      */
	     String fileName01 = "My_ImageA4";

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
