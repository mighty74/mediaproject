package final01;

import java.util.ArrayList;
import java.util.List;

import GImage.GImage;

public class VerticalRunsdeviation extends Extract{
	public List<Double> extracted(){
		List<Double> listVerticalRunsdeviation = new ArrayList<Double>();
		for(int i = 1; i <= 100; i++) {
			String fileName = "FinalImage/" + i + ".bmp";
		    GImage img= new GImage(fileName);
		    listVerticalRunsdeviation.add(verticalRunsdeviation(img));
		}
		return listVerticalRunsdeviation;
	}

	public double verticalRunsdeviation(GImage img){
		if(img == null) {
			System.out.println("verticalRunsdeviationでヌルポ");
			return 0;
		}
		int width = img.getWidth();
	    int height = img.getHeight();
	    int xmin = width;
	    int xmax = 0;
	    int count = 0;
	    double total = 0;
	    List<Integer> n = new ArrayList<Integer>();

	    for(int l = 0; l < width; l++) {
	    	for(int i = 0; i < height; i++) {
	    		if(img.pixel[i][l] == 0) {
	    			if(xmin >= l) {
	    				xmin = l;
	    			}
	    			if(xmax <= l) {
	    				xmax = l;
	    			}
	    		}
	    	}
	    }
	    for(int l = xmin; l <= xmax; l++) {
	    	 int k = 0;
	    	 for(int i = 1; i < height; i++) {
	    		 if(img.pixel[i-1][l] == 255 && img.pixel[i][l] == 0) {
   				 count += 1;
   				 k += 1;
	    		 }
	    	 }
	    	 n.add(k);
	     }

	    int x = xmax-xmin+1;
	    double average = (double)count/x;

	    for(int i = 0; i < n.size(); i++) {
	    	total += Math.pow((double)(n.get(i)) - average, 2.0);
	    }

	    //return Math.floor(Math.sqrt(total/x) * 1000) / 1000;
	    return Math.sqrt(total/(double)(x));
	}

}
