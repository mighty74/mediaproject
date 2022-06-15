package final01;

import GImage.GImage;

public class Main {
	public static void main(String[] args) {
		//GImage img= new GImage("FinalImage/3.bmp");
		for(int i = 1; i <=3; i++) {
			GImage img= new GImage("FinalImage/" + i + ".bmp");
			printNum(img, i);
		}

	}

	public static void printNum(GImage img, int i) {
		Extract extract = new Concentration();
		double an = extract.extracted(img);
		System.out.print("FinalImage/" + i + ".bmp：濃度--" + an + ", ");

		extract = new Aspect();
		an = extract.extracted(img);
		System.out.print("短形比--" + an + ", ");

		extract = new HorizontalRunsAverage();
		an = extract.extracted(img);
		System.out.print("水平ラ--" + an + ", ");

		extract = new VerticalRunsAverage();
		an = extract.extracted(img);
		System.out.print("垂直ラ--" + an + ", ");

		extract = new HorizontalRunsdeviation();
		an = extract.extracted(img);
		System.out.print("水ラ標--" + an + ", ");

		extract = new VerticalRunsdeviation();
		an = extract.extracted(img);
		System.out.print("垂ラ標--" + an + ", ");

		extract = new CenterOfGravityX();
		an = extract.extracted(img);
		System.out.print("重心X--" + an + ", ");

		extract = new CenterOfGravityY();
		an = extract.extracted(img);
		System.out.println("重心Y--" + an);
	}
}
