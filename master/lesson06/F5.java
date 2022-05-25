package lesson06;

import GImage.GImage;

public class F5 {
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

	     for(int i = 0; i < height; i++) {
	    	 for(int l = 0; l < width; l++) {
	    		 if(i % 4 == 0 && l % 4 == 0) {
	    			 double num = 0;
	    			 for(int k = 0; k < 4; k++) {
	    				 for(int n = 0; n < 4; n++) {
	    					 if(i + k >= height || l + n >= width) {
	    						 break;
	    					 }
	    					 num += img.pixel[i+k][l+n];
	    				 }
	    			 }
	    			 for(int k = 0; k < 4; k++) {
	    				 for(int n = 0; n < 4; n++) {
	    					 if(i + k >= height || l + n >= width) {
	    						 break;
	    					 }
	    					 img.pixel[i+k][l+n] = (int)Math.floor(num/(double)16);
	    				 }
	    			 }
	    		 }
	    	 }
	     }



	     /**
	      *  Set the file name to "My_ImageF5".
	      */
	     String fileName01 = "bmp/My_ImageF5";

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
