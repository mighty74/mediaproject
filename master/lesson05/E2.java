package lesson05;

import GImage.GImage;

public class E2 {
	public static void main(String[] args)
	{
		 String fileName = "ImageFiles2/29.bmp";
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
	     int xmin = width;
	     int xmax = 0;
	     int ymin = height;
	     int ymax = 0;

	     for(int i = 0; i < height; i++) {
	    	 for(int l = 0; l < width; l++) {
	    		 if(img.pixel[i][l] == 0) {
	    			 if(xmin >= l) {
	    				 xmin = l;
	    			 }
	    			 if(xmax <= l) {
	    				 xmax = l;
	    			 }
	    			 if(ymin >= i) {
	    				 ymin = i;
	    			 }
	    			 if(ymax <= i) {
	    				 ymax = i;
	    			 }
	    		 }
	    	 }
	     }

	     System.out.println("xmin-" + xmin);
	     System.out.println("xmax-" + xmax);
	     System.out.println("ymin-" + ymin);
	     System.out.println("ymax-" + ymax);

	     System.out.println("面積-" + (xmax-xmin+1)*(ymax-ymin+1));





	     /**
	      *  Set the file name to "My_ImageE2".
	      */
	     //String fileName01 = "bmp/My_ImageE2";

	     /**
	      *  Set the file type to "bmp".
	      */
	     //String fileType01 = "bmp";

	     /**
	      * Output the image-file "My_Image01.bmp".
	      */
	     //img.output(fileName01,fileType01);

	     /**
	      * Set the file name to "My_Image01.bmp".
	      */
	     //fileName01 +="." + fileType01;
	     //System.out.println("Output file:"+fileName01);
	}
}
