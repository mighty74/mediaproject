package final01;

import java.util.ArrayList;
import java.util.List;

import GImage.GImage;

public class HorizontalRunsdeviation extends Extract{
	public List<Double> extracted(){
		List<Double> listHorizontalRunsdeviation = new ArrayList<Double>();
		for(int i = 1; i <= 100; i++) {
			String fileName = "FinalImage/" + i + ".bmp";
		    GImage img= new GImage(fileName);
		    listHorizontalRunsdeviation.add(horizontalRunsdeviation(img));
		}
		return listHorizontalRunsdeviation;
	}

	public double horizontalRunsdeviation(GImage img){
		if(img == null) {
			System.out.println("horizontalRunsdeviationでヌルポ");
			return 0;
		}
		int width = img.getWidth();
	    int height = img.getHeight();
	    int ymin = height;
	    int ymax = 0;
	    int count = 0;
	    double total = 0;
	    boolean flag = false;
	    List<Integer> n = new ArrayList<Integer>();

	    for(int i = 0; i < height; i++) {
	    	int k = 0;
	    	flag = false;
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
	    				k += 1;
	    				flag = true;
	    			}
	    		}
	    	}
	    	if(flag) {
	    		n.add(k);
	    	}
	    }
	    int y = ymax-ymin+1;
	    double average = (double)count/y;

	    for(int i = 0; i < n.size(); i++) {
	    	total += Math.pow((double)(n.get(i)) - average, 2.0);
	    }

	    //return Math.floor(Math.sqrt(total/y) * 1000) / 1000;
	    return Math.sqrt(total/(double)(y));
	}

}
