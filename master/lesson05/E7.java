package lesson05;

import GImage.GImage;

public class E7 {
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
	     int xmin = width;
	     int xmax = 0;
	     int ymin = height;
	     int ymax = 0;

	     for(int i = 0; i < height; i++) {
	    	 for(int l = 0; l < width; l++) {
	    		 if(img.pixel[i][l] == 0) {
	    			 num += 1;
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
	     int X = xmax-xmin+1;
	     int Y = ymax-ymin+1;
	     double j = 0;
	     for(int i = 0; i < Y; i++) {
	    	 for(int l = 0; l < X; l++) {
	    		 int at = 0;
	    		 if(img.pixel[i+ymin][l+xmin] == 0) {
	    			 at = 1;
	    		 }
	    		 if(img.pixel[i+ymin][l+xmin] == 255) {
	    			 at = 0;
	    		 }
	    		 j += i*at;
	    	 }
	     }
	     int answer = (int)Math.floor(j/num);
	     System.out.println("num-" + num);
	     System.out.println("X-" + X);
	     System.out.println("Y-" + Y);

	     System.out.println("重心Y-" + answer);



	}
}
