package lesson03;

import GImage.GImage;

public class C9 {
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


	     for(int i = 0; i < ((height-30)/25)+1; i++) {
	    	 for(int l= 0; l < 31; l++) {
	    		 if(30 + l + i*25 >= 0 &&
	    			30 + l + i*25 < height &&
	    			5 - l + i*15 >= 0 &&
	    			5 - l + i*15 < width) {
	    			 img.pixel[30 + l + i*25][5 - l + i*15]=0;
	    		 }
	    		 if(30 + l + 30 + i*25 >= 0 &&
	    			30 + l + 30 + i*25 < height &&
	    			5 - l + 30 + i*15 >= 0 &&
	    			5 - l + 30 + i*15 < width) {
	    			 img.pixel[30 + l + 30 + i*25][5 - l + 30 + i*15]=0;
	    		 }
	    		 if(30 + l + i*25 >= 0 &&
	 	    		30 + l + i*25 < height &&
	 	    		5 + l + i*15 >= 0 &&
	 	    		5 + l + i*15 < width) {
	    			 img.pixel[30 + l + i*25][5 + l + i*15]=0;
	    		 }
	    		 if(30 + l + 30 + i*25 >= 0 &&
	 	    		30 + l + 30 + i*25 < height &&
	 	    		5 + l - 30 + i*15 >= 0 &&
	 	    				5 + l - 30 + i*15 < width) {
	    			img.pixel[30 + l + 30 + i*25][5 + l - 30 + i*15]=0;
	    		 }
	    		 for(int k = 0; k < 30 - l; k++) {
	    			if(60 - l + i*25 >= 0 &&
	    				60 - l + i*25 < height &&
	    				5-k+ i*15 >= 0 &&
	    				5-k+ i*15 < width) {
	    				img.pixel[60 - l + i*25][5-k+ i*15]=255;
	    			}
	    			if(60 + l + i*25 >= 0 &&
	 	    			60 + l + i*25 < height &&
	 	    			5 + k+ i*15 >= 0 &&
	 	    			5 + k+ i*15 < width) {
	    				img.pixel[60 + l + i*25][5 + k+ i*15]=255;
	 	    		}
	    			if(60 - l + i*25 >= 0 &&
	   					60 - l + i*25< height &&
	   					5 + k+ i*15 >= 0 &&
	   					5 + k+ i*15 < width) {
	    				img.pixel[60 - l + i*25][5 + k+ i*15]=255;
		 	    	}
	    			if(60 + l + i*25 >= 0 &&
	    				60 + l + i*25< height &&
	    				5 - k+ i*15 >= 0 &&
	    				5 - k+ i*15 < width) {
	    				img.pixel[60 + l + i*25][5 - k+ i*15]=255;
	    			}
				 }
	 		}
	     }



	     /**
	      *  Set the file name to "My_ImageC9".
	      */
	     String fileName01 = "My_ImageC9";

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
