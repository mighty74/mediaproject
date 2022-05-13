package lesson03;

import GImage.GImage;

public class C6 {
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


	     for(int i = 0; i < 8; i++) {
	    	 for(int l= 0; l < 31; l++) {
	 			img.pixel[30 + l + i*40][40 - l + i*30]=0;
	 		    img.pixel[30 + l + 30 + i*40][40 - l + 30 + i*30]=0;
	 		    img.pixel[30 + l + i*40][40 + l + i*30]=0;
	 		    img.pixel[30 + l + 30 + i*40][40 + l - 30 + i*30]=0;
	 		}
	     }



	     /**
	      *  Set the file name to "My_ImageC6".
	      */
	     String fileName01 = "My_ImageC6";

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
