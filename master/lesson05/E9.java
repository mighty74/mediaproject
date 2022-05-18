package lesson05;

import GImage.GImage;

public class E9 {
	public static void main(String[] args)
	{
		 int[] num = new int[10];
	     for(int i = 0; i < 10; i++) {
	    	 String name = "ImageFiles2/2" + Integer.toString(i) + ".bmp";
	    	 GImage img= new GImage(name);
	    	 int width0 = img.getWidth();
	    	 int height0 = img.getHeight();
	    	 for(int l = 0; l < height0; l++) {
	    		 for(int k = 0; k < width0; k++) {
	    			 if(img.pixel[k][l] == 0) {
	    				 num[i] += 1;
	    			 }
	    		 }
	    	 }
	     }
	     double ave = 0;
	     for(int i = 0; i < 10; i++) {
	    	 ave += Math.floor(num[i]/10);
	     }
	     double ss = 0;
	     for(int i = 0; i < 10; i++) {
	    	 ss += Math.floor(Math.pow((double)num[i]-ave, 2.0)/10);
	     }


	     System.out.println("標準偏差-" + (int)Math.sqrt(ss));



	}
}
