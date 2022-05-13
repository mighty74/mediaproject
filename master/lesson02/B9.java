package lesson02;

import GImage.GImage;

public class B9 {
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

	     GImage img0= new GImage(width+2,height+2);
	     System.out.println(img0.getHeight());

	     for(int i = 0; i < height; i++) {
	    	 for(int l = 0; l < width; l++) {
	    		 img0.pixel[i+2][l+2]=255-img.pixel[i][l];
	    	 }
	     }
	     for(int i = 0; i < height; i++) {
	    	 for(int l = 0; l < width; l++) {
	    		 int x = img0.pixel[i][l]+img.pixel[i][l];
	    		 if(x>=255) {
	    			 img0.pixel[i][l]=255;
	    		 }
	    		 else if(x<=0) {
	    			 img0.pixel[i][l]=0;
	    		 }
	    		 else {
	    			 img0.pixel[i][l]=x;
	    		 }
	    	 }
	     }


	     /**
	      *  Set the file name to "My_ImageB9".
	      */
	     String fileName01 = "My_ImageB9";

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
