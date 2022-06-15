package final01;

import GImage.GImage;

public class HorizontalRunsAverage extends Extract{
	public double extracted(GImage img){
		if(img == null) {
			System.out.println("concentrationでヌルポ");
			return 0;
		}
		int width = img.getWidth();
	    int height = img.getHeight();
	    int ymin = height;
	    int ymax = 0;
	    int count = 0;

	    for(int i = 0; i < height; i++) {
	    	for(int l = 0; l < width-1; l++) {
	    		if(img.pixel[i][l] == 0) {
	    			if(ymin >= i) {
	    				ymin = i;
	    			}
	    			if(ymax <= i) {
	    				ymax = i;
	    			}
	    			if(img.pixel[i][l-1] == 255) {
	    				count += 1;
	    			}
	    		}
	    	}
	    }
	    int y = ymax-ymin+1;

	    return Math.floor((double)count * 1000 / y) / 1000;
	}

}
