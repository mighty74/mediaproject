package lesson05;

import GImage.GImage;

public class E3 {
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
	     double m = (xmax-xmin+1)*(ymax-ymin+1);
	     int k = (int)(((double)num/m)*100);

	     System.out.println("num-" + num);
	     System.out.println("xmin-" + xmin);
	     System.out.println("xmax-" + xmax);
	     System.out.println("ymin-" + ymin);
	     System.out.println("ymax-" + ymax);

	     System.out.println("面積-" + m);
	     System.out.println("濃度-" + k);



	}
}
