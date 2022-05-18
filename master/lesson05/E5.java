package lesson05;

import GImage.GImage;

public class E5 {
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
	     for(int i = 0; i < height; i++) {
	    	 for(int l = 0; l < width-1; l++) {
	    		 if(img.pixel[i][l] == 255 && img.pixel[i][l+1] == 0) {
	    			 num += 1;
	    		 }
	    	 }
	     }

	     System.out.println("水平方向ラン数-" + num);



	}
}
