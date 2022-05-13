package lesson04;

import GImage.GImage;

public class D6 {
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
	     int q = 16;

	     for(int i = 0; i < height; i++) {
	    	 for(int l = 0; l < width; l++) {
	    		double num = Math.floor(img.pixel[i][l]/q);
	    		if(i%4 == 0 && l%4 == 0) {
	    			if(num < 0)
	    				img.pixel[i][l] = 0;
	    			else
	    				img.pixel[i][l] = 255;
	    		}
	    		if(i%4 == 0 && l%4 == 1) {
	    			if(num < 8)
		    			img.pixel[i][l] = 0;
		    		else
		    			img.pixel[i][l] = 255;
	    		}
	    		if(i%4 == 0 && l%4 == 2) {
		    		if(num < 2)
			    		img.pixel[i][l] = 0;
			    	else
			    		img.pixel[i][l] = 255;
		    	}
	    		if(i%4 == 0 && l%4 == 3) {
		    		if(num < 10)
			    		img.pixel[i][l] = 0;
			    	else
			    		img.pixel[i][l] = 255;
		    	}
	    		if(i%4 == 1 && l%4 == 0) {
		    		if(num < 12)
			    		img.pixel[i][l] = 0;
			    	else
			    		img.pixel[i][l] = 255;
		    	}
	    		if(i%4 == 1 && l%4 == 1) {
		    		if(num < 4)
			    		img.pixel[i][l] = 0;
			    	else
			    		img.pixel[i][l] = 255;
		    	}
	    		if(i%4 == 1 && l%4 == 2) {
		    		if(num < 14)
			    		img.pixel[i][l] = 0;
			    	else
			    		img.pixel[i][l] = 255;
		    	}
	    		if(i%4 == 1 && l%4 == 3) {
		    		if(num < 6)
			    		img.pixel[i][l] = 0;
			    	else
			    		img.pixel[i][l] = 255;
		    	}
	    		if(i%4 == 2 && l%4 == 0) {
		    		if(num < 3)
			    		img.pixel[i][l] = 0;
			    	else
			    		img.pixel[i][l] = 255;
		    	}
	    		if(i%4 == 2 && l%4 == 1) {
		    		if(num < 11)
			    		img.pixel[i][l] = 0;
			    	else
			    		img.pixel[i][l] = 255;
		    	}
	    		if(i%4 == 2 && l%4 == 2) {
		    		if(num < 1)
			    		img.pixel[i][l] = 0;
			    	else
			    		img.pixel[i][l] = 255;
		    	}
	    		if(i%4 == 2 && l%4 == 3) {
		    		if(num < 9)
			    		img.pixel[i][l] = 0;
			    	else
			    		img.pixel[i][l] = 255;
		    	}
	    		if(i%4 == 3 && l%4 == 0) {
		    		if(num < 15)
			    		img.pixel[i][l] = 0;
			    	else
			    		img.pixel[i][l] = 255;
		    	}
	    		if(i%4 == 3 && l%4 == 1) {
		    		if(num < 7)
			    		img.pixel[i][l] = 0;
			    	else
			    		img.pixel[i][l] = 255;
		    	}
	    		if(i%4 == 3 && l%4 == 2) {
		    		if(num < 13)
			    		img.pixel[i][l] = 0;
			    	else
			    		img.pixel[i][l] = 255;
		    	}
	    		if(i%4 == 3 && l%4 == 3) {
		    		if(num < 5)
			    		img.pixel[i][l] = 0;
			    	else
			    		img.pixel[i][l] = 255;
		    	}
	    	 }
	     }



	     /**
	      *  Set the file name to "My_ImageD6".
	      */
	     String fileName01 = "bmp/My_ImageD6";

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
