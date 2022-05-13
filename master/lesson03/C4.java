package lesson03;

import GImage.GImage;

public class C4 {
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

	     for(int l= 0; l < 31; l++) {
		    img.pixel[160 + l][140 - l]=0;
		    for(int k = 0; k < 30 - l; k++) {
		    	 img.pixel[190 - l ][140-k]=0;
		    }
		 }
	     for(int l= 0; l < 31; l++) {
	    	img.pixel[160 + l + 30][140 - l + 30]=0;
	    	for(int k = 0; k < 30 - l; k++) {
	    		 img.pixel[190 + l ][140 + k]=0;
	    	}
	     }
	     for(int l= 0; l < 31; l++) {
    		 img.pixel[160 + l][140 + l]=0;
    		 for(int k = 0; k < 30 - l; k++) {
	    		 img.pixel[190 - l ][140 + k]=0;
	    	}
    	 }
	     for(int l= 0; l < 31; l++) {
    		 img.pixel[160 + l + 30][140 + l - 30]=0;
    		 for(int k = 0; k < 30 - l; k++) {
	    		 img.pixel[190 + l ][140 - k]=0;
	    	}
    	 }



	     /**
	      *  Set the file name to "My_ImageC4".
	      */
	     String fileName01 = "My_ImageC4";

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
