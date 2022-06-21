package final01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import GImage.GImage;

public class Main {
	private static List<Double> listConcentration = new ArrayList<Double>();
	private static List<Double> listAspect = new ArrayList<Double>();
	private static List<Double> listHorizontalRunsAverage = new ArrayList<Double>();
	private static List<Double> listVerticalRunsAverage = new ArrayList<Double>();
	private static List<Double> listHorizontalRunsdeviation = new ArrayList<Double>();
	private static List<Double> listVerticalRunsdeviation = new ArrayList<Double>();
	private static List<Double> listCenterOfGravityX = new ArrayList<Double>();
	private static List<Double> listCenterOfGravityY = new ArrayList<Double>();
	private static List<Double> listNormalizationAspect = new ArrayList<Double>();
	private static List<Double> listNormalizationHorizontalRunsAverage = new ArrayList<Double>();
	private static List<Double> listNormalizationVerticalRunsAverage = new ArrayList<Double>();
	private static List<Double> listNormalizationHorizontalRunsdeviation = new ArrayList<Double>();
	private static List<Double> listNormalizationVerticalRunsdeviation = new ArrayList<Double>();
	private static List<Double> listNormalizationCenterOfGravityX = new ArrayList<Double>();
	private static List<Double> listNormalizationCenterOfGravityY = new ArrayList<Double>();

	private static List<Double> listNormalizationConcentration = new ArrayList<Double>();
	public static void main(String[] args) {
		//GImage img= new GImage("FinalImage/3.bmp");
		Extract extract = new Concentration();
		listConcentration = extract.extracted();

		extract = new Aspect();
		listAspect = extract.extracted();

		extract = new HorizontalRunsAverage();
		listHorizontalRunsAverage = extract.extracted();

		extract = new VerticalRunsAverage();
		listVerticalRunsAverage = extract.extracted();

		extract = new HorizontalRunsdeviation();
		listHorizontalRunsdeviation = extract.extracted();

		extract = new VerticalRunsdeviation();
		listVerticalRunsdeviation = extract.extracted();

		extract = new CenterOfGravityX();
		listCenterOfGravityX = extract.extracted();

		extract = new CenterOfGravityY();
		listCenterOfGravityY = extract.extracted();

		for(int i = 1; i <=1; i++) {
			GImage img= new GImage("FinalImage/" + i + ".bmp");
			printNum(img, i);
		}
		Normalization normalization = new Normalization();
		listNormalizationConcentration = normalization.normalization(listConcentration);
		listNormalizationAspect = normalization.normalization(listAspect);
		listNormalizationHorizontalRunsAverage = normalization.normalization(listHorizontalRunsAverage);
		listNormalizationVerticalRunsAverage = normalization.normalization(listVerticalRunsAverage);
		listNormalizationHorizontalRunsdeviation = normalization.normalization(listHorizontalRunsdeviation);
		listNormalizationVerticalRunsdeviation = normalization.normalization(listVerticalRunsdeviation);
		listNormalizationCenterOfGravityX = normalization.normalization(listCenterOfGravityX);
		listNormalizationCenterOfGravityY = normalization.normalization(listCenterOfGravityY);
		exportCSV(listNormalizationConcentration, listNormalizationAspect, listNormalizationHorizontalRunsAverage,
				listNormalizationVerticalRunsAverage, listNormalizationHorizontalRunsdeviation, listNormalizationVerticalRunsdeviation,
				listNormalizationCenterOfGravityX, listNormalizationCenterOfGravityY);
//		for(int i = 0; i < 1; i++) {
//			System.out.println("正規化した");
//			System.out.print("FinalImage/" + (i+1) + ".bmp：濃度--" + listNormalizationConcentration.get(i) + ", ");
//			System.out.print("短形比--" + listNormalizationAspect.get(i) + ", ");
//			System.out.print("水平ラ--" + listNormalizationHorizontalRunsAverage.get(i) + ", ");
//			System.out.print("垂直ラ--" + listNormalizationVerticalRunsAverage.get(i) + ", ");
//			System.out.print("水ラ標--" + listNormalizationHorizontalRunsdeviation.get(i) + ", ");
//			System.out.print("垂ラ標--" + listNormalizationVerticalRunsdeviation.get(i) + ", ");
//			System.out.print("重心X--" + listNormalizationCenterOfGravityX.get(i) + ", ");
//			System.out.println("重心Y--" + listNormalizationCenterOfGravityY.get(i));
//		}

	}

	public static void printNum(GImage img, int i) {
		double concentration = Math.floor(listConcentration.get(i-1) * 1000) / 1000;
		double aspect = Math.floor(listAspect.get(i-1) * 1000) / 1000;
		double horizontalRunsAverage = Math.floor(listHorizontalRunsAverage.get(i-1) * 1000) / 1000;
		double verticalRunsAverage = Math.floor(listVerticalRunsAverage.get(i-1) * 1000) / 1000;
		double horizontalRunsdeviation = Math.floor(listHorizontalRunsdeviation.get(i-1) * 1000) / 1000;
		double verticalRunsdeviation = Math.floor(listVerticalRunsdeviation.get(i-1) * 1000) / 1000;
		double centerOfGravityX = (int)Math.round(listCenterOfGravityX.get(i-1));
		double centerOfGravityY = (int)Math.round(listCenterOfGravityY.get(i-1));
		System.out.print("FinalImage/" + i + ".bmp：濃度--" + concentration + ", ");
		System.out.print("短形比--" + aspect + ", ");
		System.out.print("水平ラ--" + horizontalRunsAverage + ", ");
		System.out.print("垂直ラ--" + verticalRunsAverage + ", ");
		System.out.print("水ラ標--" + horizontalRunsdeviation + ", ");
		System.out.print("垂ラ標--" + verticalRunsdeviation + ", ");
		System.out.print("重心X--" + centerOfGravityX + ", ");
		System.out.println("重心Y--" + centerOfGravityY);
	}

	public static void exportCSV(List<Double> Con, List<Double> As, List<Double> HRA,
			List<Double> VRA, List<Double> HR, List<Double> VR, List<Double> CX, List<Double> CY) {
		try {
			FileWriter fw = new FileWriter("test.csv", false);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			pw.print("元");
			pw.print(",");
			pw.print("濃度");
			pw.print(",");
			pw.print("短形比");
			pw.print(",");
			pw.print("水平ラ");
			pw.print(",");
			pw.print("垂直ラ");
			pw.print(",");
			pw.print("水ラ標");
			pw.print(",");
			pw.print("垂ラ標");
			pw.print(",");
			pw.print("重心X");
			pw.print(",");
			pw.print("重心Y");
			pw.println();
			for(int i = 0; i < Con.size(); i++) {
				pw.print((i+1));
				pw.print(",");
				pw.print(Con.get(i));
				pw.print(",");
				pw.print(As.get(i));
				pw.print(",");
				pw.print(HRA.get(i));
				pw.print(",");
				pw.print(VRA.get(i));
				pw.print(",");
				pw.print(HR.get(i));
				pw.print(",");
				pw.print(VR.get(i));
				pw.print(",");
				pw.print(CX.get(i));
				pw.print(",");
				pw.print(CY.get(i));
				pw.println();
			}

			pw.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
