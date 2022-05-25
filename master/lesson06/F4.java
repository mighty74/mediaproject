package lesson06;

import GImage.GImage;

public class F4 {
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
	    		 if(l > 0 && l < width-1 && i > 0 && i < height-1) {
	    			 int num = img0.pixel[i-1][l-1] + img0.pixel[i-1][l] + img0.pixel[i-1][l+1]
	    					 + img0.pixel[i+1][l-1] + img0.pixel[i+1][l] + img0.pixel[i+1][l+1]
	    					 + img0.pixel[i][l-1] + img0.pixel[i][l+1]
	    					 - 8*img0.pixel[i][l];
	    			 if(num > 255) {
	    				 num = 255;
	    			 }
	    			 if(num < 0) {
	    				 num = 0;
	    			 }
	    			 img.pixel[i][l] = num;
	    		 }
	    		 else {
	    			 img.pixel[i][l] = 0;
	    		 }
	    	 }
	     }



	     /**
	      *  Set the file name to "My_ImageF4".
	      */
	     String fileName01 = "bmp/My_ImageF4";

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
