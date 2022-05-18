package lesson05;

import GImage.GImage;

public class E6 {
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

	     int num = 0;
	     for(int i = 0; i < height-1; i++) {
	    	 for(int l = 0; l < width; l++) {
	    		 if(img.pixel[i][l] == 255 && img.pixel[i+1][l] == 0) {
	    			 num += 1;
	    		 }
	    	 }
	     }

	     System.out.println("垂直方向ラン数-" + num);



	}
}
