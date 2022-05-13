package lesson04;

import GImage.GImage;

public class D1 {
	public static void main(String[] args)
	{
		 String fileName = "Sailboat0.bmp";
	     GImage img= new GImage(fileName);
	     GImage img0= new GImage(fileName);

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


	     for(int i = 0; i < height; i++) {
	    	 for(int l = 0; l < width; l++) {
		    	 if(i >= 100 && i < 130) {
		    		 img.pixel[i][l]=img0.pixel[i+30][l];
		    	 }
		    	 else if(i >= 100 && i < 160) {
		    		 img.pixel[i][l]=img0.pixel[i-30][l];
		    	 }
		    	 else {
		    		 img.pixel[i][l]=img0.pixel[i][l];
		    	 }
	    	 }
	     }



	     /**
	      *  Set the file name to "My_ImageD1".
	      */
	     String fileName01 = "bmp/My_ImageD1";

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
