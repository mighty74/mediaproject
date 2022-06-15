package final01;

import java.util.ArrayList;
import java.util.List;

import GImage.GImage;

public class VerticalRunsdeviation extends Extract{
	public double extracted(GImage img){
		if(img == null) {
			System.out.println("concentrationでヌルポ");
			return 0;
		}
		int width = img.getWidth();
	    int height = img.getHeight();
	    int xmin = width;
	    int xmax = 0;
	    int count = 0;
	    double total = 0;
	    boolean flag = false;
	    List<Integer> n = new ArrayList<Integer>();

	    for(int l = 0; l < width; l++) {
	    	int k = 0;
	    	flag = false;
	    	for(int i = 0; i < height-1; i++) {
	    		if(img.pixel[i][l] == 0) {
	    			if(xmin >= l) {
	    				xmin = l;
	    			}
	    			if(xmax <= l) {
	    				xmax = l;
	    			}
	    			if(img.pixel[i-1][l] == 255) {
	    				count += 1;
	    				k += 1;
	    				flag = true;
	    			}
	    		}
	    	}
	    	if(flag) {
	    		n.add(k);
	    	}
	    }

	    int x = xmax-xmin+1;
	    double average = (double)count/x;

	    for(int i = 0; i < n.size(); i++) {
	    	total += Math.pow(n.get(i) - average, 2.0);
	    }

	    return Math.floor(Math.sqrt(total/x) * 1000) / 1000;
	}

}
