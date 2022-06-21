package final01;

import java.util.ArrayList;
import java.util.List;

import GImage.GImage;

public class VerticalRunsAverage extends Extract{
	public List<Double> extracted(){
		List<Double> listVerticalRunsAverage = new ArrayList<Double>();
		for(int i = 1; i <= 100; i++) {
			String fileName = "FinalImage/" + i + ".bmp";
		    GImage img= new GImage(fileName);
		    listVerticalRunsAverage.add(verticalRunsAverage(img));
		}
		return listVerticalRunsAverage;
	}
	public double verticalRunsAverage(GImage img){
		if(img == null) {
			System.out.println("verticalRunsAverageでヌルポ");
			return 0;
		}
		int width = img.getWidth();
	    int height = img.getHeight();
	    int xmin = width;
	    int xmax = 0;
	    int count = 0;

	    for(int i = 0; i < height-1; i++) {
	    	for(int l = 0; l < width; l++) {
	    		if(img.pixel[i][l] == 0) {
	    			if(xmin >= l) {
	    				xmin = l;
	    			}
	    			if(xmax <= l) {
	    				xmax = l;
	    			}
	    			if(img.pixel[i-1][l] == 255) {
	    				count += 1;
	    			}
	    		}
	    	}
	    }
	    int x = xmax-xmin+1;

	    //return Math.floor((double)count * 1000 / x) / 1000;
	    return (double)(count) / (double)(x);
	}

}
