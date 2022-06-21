package final01;

import java.util.ArrayList;
import java.util.List;

import GImage.GImage;

public class Aspect extends Extract{
	public List<Double> extracted(){
		List<Double> listAspect = new ArrayList<Double>();
		for(int i = 1; i <= 100; i++) {
			String fileName = "FinalImage/" + i + ".bmp";
		    GImage img= new GImage(fileName);
		    listAspect.add(aspect(img));
		}
		return listAspect;
	}
	public double aspect(GImage img){
		if(img == null) {
			System.out.println("aspectでヌルポ");
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

	    //return Math.floor((double)y * 1000 / x) / 1000;
	    return (double)y / x;
	}
}
