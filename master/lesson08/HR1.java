package lesson08;

import java.util.Random;

import GImage.GImage;

public class HR1 {
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

	     Random rand = new Random();

	     //drowSqr(img, 150, 200, radius, height, width, 0);
	     for(int i = 0; i < 12; i++) {
	    	 int radius = rand.nextInt(40) + 10;
	    	 int x = rand.nextInt(width);
	    	 int y = rand.nextInt(height);
	    	 drowSqr(img, x, y, radius, height, width, 0);

	    	 radius = rand.nextInt(40) + 10;
	    	 x = rand.nextInt(width);
	    	 y = rand.nextInt(height);
	    	 drowSqr(img, x, y, radius, height, width, 255);
	     }



	     /**
	      *  Set the file name to "My_ImageHR1".
	      */
	     String fileName01 = "bmp/My_ImageHR1";

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

	public static void drowSqr(GImage img, int x, int y, int r, int height, int width, int color) {
		int range = 2*r;
		int pointX = x-r;
		int pointY = y-r;
		for(int i = 0; i <= range; i++) {//y
			for(int l = 0; l <= range; l++) {//x
				if(height < pointY+i+1 || width < pointX+l+1 || 0 > pointX+l  || 0 > pointY+i) {
					continue;
				}
				int dif = (int)((Math.pow(pointX+l-x, 2)+Math.pow(pointY+i-y, 2)));
				if(dif <  (int)(Math.pow(r+1, 2))) {
					img.pixel[pointY+i][pointX+l] = 0;
				}
				if(color != 0) {
					if(dif < (int)(Math.pow(r, 2))) {
						img.pixel[pointY+i][pointX+l] = color;
					}
				}
			}
		}

	}
}
