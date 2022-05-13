package lesson04;

import GImage.GImage;

public class D3 {
	public static void main(String[] args)
	{
		 String fileName = "Board0.bmp";
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

	     int set = 0;
	     int setx = 0;


	     for(int i = 0; i < 120; i++) {
	    	 String name = "ImageParts120/block" + Integer.toString(i) + ".bmp";
	    	 GImage img0= new GImage(name);
	    	 int width0 = img0.getWidth();
	    	 int height0 = img0.getHeight();
	    	 if(i % 10 == 0 && i !=0) {
	    		 setx = 0;
	    		 set += height0;
	    	 }
	    	 for(int l = 0; l < height0; l++) {
	    		 for(int k = 0; k < width0; k++) {
	    			 img.pixel[l+set][k+setx]=img0.pixel[l][k];
	    		 }
	    	 }
	    	 setx += width0;
	     }



	     /**
	      *  Set the file name to "My_ImageD3".
	      */
	     String fileName01 = "bmp/My_ImageD3";

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
