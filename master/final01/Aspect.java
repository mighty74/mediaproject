package final01;

import GImage.GImage;

public class Aspect extends Extract{
	public double extracted(GImage img){
		if(img == null) {
			System.out.println("concentrationでヌルポ");
			return 0;
		}
		int width = img.getWidth();

	    int height = img.getHeight();
	    int xmin = width;
	    int xmax = 0;
	    int ymin = height;
	    int ymax = 0;

	    for(int i = 0; i < height; i++) {
	    	for(int l = 0; l < width; l++) {
	    		if(img.pixel[i][l] == 0) {
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
	    int x = xmax-xmin+1;
	    int y = ymax-ymin+1;

	    return Math.floor((double)y * 1000 / x) / 1000;
	}
}
