package lesson03;

import GImage.GImage;

public class C3 {
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
	     /**
	     for(int i = 0; i < 2; i++) {
	    	 for(int l= 0; l < 31; l++) {
	    		 img.pixel[160 + l + i*30][140 - l + i*30]=0;
	    	 }
	     }
	     for(int i = 0; i < 2; i++) {
	    	 for(int l= 0; l < 31; l++) {
	    		 img.pixel[160 + l + i*30][140 + l - i*30]=0;
	    	 }
	     }
	     **/
	     line(img, 160, 140, 60);



	     /**
	      *  Set the file name to "My_ImageC3".
	      */
	     String fileName01 = "My_ImageC3";

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

	public static void line(GImage img, int y, int x, int r) {
		for(int l= 0; l < 31; l++) {
		    img.pixel[y + l][x - l]=0;
		    img.pixel[y + l + r/2][x - l + r/2]=0;
		    img.pixel[y + l][x + l]=0;
		    img.pixel[y + l + r/2][x + l - r/2]=0;
		}
		return;
	}

}
