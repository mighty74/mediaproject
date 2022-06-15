package final01;

import GImage.GImage;

public class CenterOfGravityY extends Extract{
	public double extracted(GImage img){
		if(img == null) {
			System.out.println("concentrationでヌルポ");
			return 0;
		}
		int width = img.getWidth();
	    int height = img.getHeight();

	    int num = 0;
	    int xmin = width;
	    int xmax = 0;
	    int ymin = height;
	    int ymax = 0;

	    for(int i = 0; i < height; i++) {
	    	for(int l = 0; l < width; l++) {
	    		if(img.pixel[i][l] == 0) {
	    			num += 1;
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
	    int X = xmax-xmin+1;
	    int Y = ymax-ymin+1;
	    double j = 0;
	    for(int i = 0; i < Y; i++) {
	    	for(int l = 0; l < X; l++) {
	    		int at = 0;
	    		if(img.pixel[i+ymin][l+xmin] == 0) {
	    			at = 1;
	    		}
	    		if(img.pixel[i+ymin][l+xmin] == 255) {
	    			at = 0;
	    		}
	    		j += i*at;
	    	}
	    }
	    return (int)Math.round(j/num);
	}

}
