package final01;

import java.util.ArrayList;
import java.util.List;

import GImage.GImage;

public class Concentration extends Extract{
	public List<Double> extracted(){
		List<Double> listConcentration = new ArrayList<Double>();
		for(int i = 1; i <= 100; i++) {
			String fileName = "FinalImage/" + i + ".bmp";
		    GImage img= new GImage(fileName);
		    listConcentration.add(concentration(img));
		}
		return listConcentration;
	}

	public double concentration(GImage img){
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
	    int count = 0;

	    for(int i = 0; i < height; i++) {
	    	for(int l = 0; l < width; l++) {
	    		if(img.pixel[i][l] == 0) {
	    			count += 1;
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
	    int area = (xmax-xmin+1)*(ymax-ymin+1);
		//return Math.floor((double)count * 1000 / area) / 1000;
	    return (double)count/ area;
	}
}
