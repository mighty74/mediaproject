package lesson08;

import GImage.GImage;

public class H2 {
	public static void main(String[] args)
	{
		 String fileName = "Board0.bmp";
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

	     double radius = 40 * Math.sqrt(2);

	     for(int i = 1; i <= 360; i++) {
	    	 drowSqr(img, 150, 200, radius, i);
	     }
	     for(int i = 1; i < height-1; i++) {
	    	 for(int l = 1; l < width-1; l++) {
	    		 if(img.pixel[i][l] == 0){
	    			 int count = 0;
	    			 if(img.pixel[i+1][l] == 0) {
	    				 count += 1;
	    			 }
	    			 else if(img.pixel[i-1][l] == 0) {
	    				 count += 1;
	    			 }
	    			 if(img.pixel[i][l+1] == 0) {
	    				 count += 1;
	    			 }
	    			 else if(img.pixel[i][l-1] == 0) {
	    				 count += 1;
	    			 }
	    			 if(count > 1) {
	    				 img.pixel[i][l] = 255;
	    			 }
	    		 }
	    	 }
	     }
	    int miny = (int)Math.floor(200 - radius);
	    int maxy = (int)Math.floor(200 + radius);

	     for(int i = 1; i < height-1; i++) {
	    	 int count = 0;
	    	 boolean flag = false;
	    	 for(int l = 1; l < width-1; l++) {
	    		 if(img.pixel[i][l] == 0){
	    			 img0.pixel[i][l] = 0;
	    			 if(i == miny || i == maxy) {
		    			 continue;
		    		 }
	    			 if(img.pixel[i][l+1] == 255) {
	    				 count += 1;
	    				 if(count == 1) {
	    					flag = true;
	    				 }
	    				 if(count == 2) {
	    					 flag = false;
	    				 }
	    			 }
	    		 }
	    		 if(flag) {
	    			 img0.pixel[i][l] = 0;
	    		 }
	    	 }
	     }



	     /**
	      *  Set the file name to "My_ImageH2".
	      */
	     String fileName01 = "bmp/My_ImageH2";

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

	public static void drowSqr(GImage img, int x, int y, double r, int a) {

		int i = (int) (Math.floor(r * Math.cos(a * Math.PI / 180)) + x);
		int l = (int) (Math.floor(r * Math.sin(a * Math.PI / 180)) + y);
		img.pixel[l][i] = 0;

	}
}
