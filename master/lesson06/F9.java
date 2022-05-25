package lesson06;

import java.util.ArrayList;
import java.util.List;

import GImage.GImage;

public class F9 {
	public static void main(String[] args)
	{
		 String fileName = "Sailboat0.bmp";
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

	     for(int i = 0; i < height; i++) {
	    	 for(int l = 0; l < width; l++) {
	    		 if(l > 0 && l < width-1 && i > 0 && i < height-1) {
	    			List<Integer> t = new ArrayList<>();
		    		for(int k = -1; k < 2; k++) {
			    		for(int n = -1; n < 2; n++) {
			    			t.add(img0.pixel[i+k][l+n]);
			    		}
			    	}
		    		int x = sort(t);
			    	img.pixel[i][l] = x;
	    		 }
	    		 else {
	    			 img.pixel[i][l] = 0;
	    		 }
	    	 }
	     }



	     /**
	      *  Set the file name to "My_ImageF9".
	      */
	     String fileName01 = "bmp/My_ImageF9";

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

	public static int sort(List<Integer> num) {
		int temp;
		for(int i = 0; i < num.size(); i++){
            for(int j = 0; j< num.size() -i -1; j ++){
                if(num.get(j) > num.get(j + 1)){
                    temp = num.get(j);
                    num.set(j, num.get(j + 1));
                    num.set(j + 1, temp);
                }
            }
        }
		return num.get(num.size()/2);
	}

}
