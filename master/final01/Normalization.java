package final01;

import java.util.ArrayList;
import java.util.List;

public class Normalization{
	public List<Double> normalization(List<Double> at){
		double num = 0;
		for(int i = 0; i < 100; i++) {
			num += at.get(i)/100;
		}
		double average = num;

		double n = 0;//標準偏差の^2
		for(int i = 0; i < at.size(); i++) {
		    n += Math.pow(at.get(i) - average, 2.0) / 100;
		}
		List<Double> an = new ArrayList<Double>();
		for(int i = 0; i < at.size(); i++) {
		    an.add((double)(at.get(i) - average) / (double)(Math.sqrt(n)));
		}
		return an;
	}
}
