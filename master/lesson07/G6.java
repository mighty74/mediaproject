package lesson07;

import GImage.GImage;

public class G6 {
	public static void main(String[] args)
	{
		 String fileName = "ImageFiles3/CAT20.bmp";
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
	    		 if(img.pixel[i][l] == 0) {
	    			 int y = i - 100;
	    			 int x = l - 130;
	    			 img0.pixel[i][l] = 255;
	    			 if(!(y < 0 || x < 0)) {
	    				 img0.pixel[y][x] = 0;
	    			 }
	    		 }
	    	 }
	     }



	     /**
	      *  Set the file name to "My_ImageG6".
	      */
	     String fileName01 = "bmp/My_ImageG6";

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
