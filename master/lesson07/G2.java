package lesson07;

import GImage.GImage;

public class G2 {
	public static void main(String[] args)
	{
		 String fileName = "ImageFiles3/ABCD0.bmp";
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

	     for(int i = 1; i < height-1; i++) {
	    	 for(int l = 1; l < width-1; l++) {

	    		 if(img.pixel[i][l] == 0) {
	    			 boolean ac = true;
	    			 for(int y = -1; y < 2; y++) {
	    				 for(int x = -1; x < 2; x++) {
	    					 if(!(x == 0 && y == 0)) {
	    						 if(img.pixel[i+y][l+x] == 0) {
	    							 ac = false;
	    							 break;
	    						 }
	    					 }
	    				 }
	    			 }
	    			 if(ac) {
	    				 img0.pixel[i][l] = 255;
	    			 }
	    		 }
	    	 }
	     }
	     for(int i = 1; i < height-1; i++) {
	    	 for(int l = 1; l < width-1; l++) {

	    		 if(img.pixel[i][l] == 255) {
	    			 boolean ac = true;
	    			 for(int y = -1; y < 2; y++) {
	    				 for(int x = -1; x < 2; x++) {
	    					 if(!(x == 0 && y == 0)) {
	    						 if(img.pixel[i+y][l+x] == 255) {
	    							 ac = false;
	    							 break;
	    						 }
	    					 }
	    				 }
	    			 }
	    			 if(ac) {
	    				 img0.pixel[i][l] = 0;
	    			 }
	    		 }
	    	 }
	     }

	     for(int i = 0; i < height; i++) {
	    	 for(int l = 0; l < width; l++) {
	    		 if(i == 0 || l == 0) {
	    			 img0.pixel[i][l] = 0;
	    		 }
	    		 if(i == height-1|| l == width-1) {
	    			 img0.pixel[i][l] = 0;
	    		 }
	    	 }
	     }



	     /**
	      *  Set the file name to "My_ImageG2".
	      */
	     String fileName01 = "bmp/My_ImageG2";

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
