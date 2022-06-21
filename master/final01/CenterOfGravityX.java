package final01;

import java.util.ArrayList;
import java.util.List;

import GImage.GImage;

public class CenterOfGravityX extends Extract{
	public List<Double> extracted(){
		List<Double> listCenterOfGravityX = new ArrayList<Double>();
		for(int i = 1; i <= 100; i++) {
			String fileName = "FinalImage/" + i + ".bmp";
		    GImage img= new GImage(fileName);
		    listCenterOfGravityX.add(centerOfGravityX(img));
		}
		return listCenterOfGravityX;
	}
	public double centerOfGravityX(GImage img){
		if(img == null) {
			System.out.println("centerOfGravityXでヌルポ");
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
	    		j += l*at;
	    	}
	    }
	    //return (int)Math.round(j/num);
	    return (double)(j/num);
	}
}
