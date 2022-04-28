package lesson01;

import GImage.GImage;

public class A5 {
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

	     GImage img0= new GImage(width+4,height+4);
	     System.out.println("test"+img0.getWidth()+img0.getHeight());

	     int level=0;
	     for(int i = 0; i < height; i++) {
	    	 for(int l = 0; l < width; l++) {
	    		 img0.pixel[i+2][l+2]=img.pixel[i][l];
	    	 }
	     }


	     /**
	      *  Set the file name to "My_ImageA5".
	      */
	     String fileName01 = "My_ImageA5";

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
