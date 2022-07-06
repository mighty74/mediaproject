package final01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import GImage.GImage;

public class Main {
	//各特徴量を保持しているリスト
	private static List<Double> listConcentration = new ArrayList<Double>();
	private static List<Double> listAspect = new ArrayList<Double>();
	private static List<Double> listHorizontalRunsAverage = new ArrayList<Double>();
	private static List<Double> listVerticalRunsAverage = new ArrayList<Double>();
	private static List<Double> listHorizontalRunsdeviation = new ArrayList<Double>();
	private static List<Double> listVerticalRunsdeviation = new ArrayList<Double>();
	private static List<Double> listCenterOfGravityX = new ArrayList<Double>();
	private static List<Double> listCenterOfGravityY = new ArrayList<Double>();

	//各正規化した特徴量を保持しているリスト
	private static List<Double> listNormalizationConcentration = new ArrayList<Double>();
	private static List<Double> listNormalizationAspect = new ArrayList<Double>();
	private static List<Double> listNormalizationHorizontalRunsAverage = new ArrayList<Double>();
	private static List<Double> listNormalizationVerticalRunsAverage = new ArrayList<Double>();
	private static List<Double> listNormalizationHorizontalRunsdeviation = new ArrayList<Double>();
	private static List<Double> listNormalizationVerticalRunsdeviation = new ArrayList<Double>();
	private static List<Double> listNormalizationCenterOfGravityX = new ArrayList<Double>();
	private static List<Double> listNormalizationCenterOfGravityY = new ArrayList<Double>();

	//Stringとして全ての抽出特徴量名を保持
	private static String[] featureValue = new String[8];
	//検索結果のsort後上から10個の距離を順に格納
	private static List<Double> difnum = new ArrayList<Double>();


	public static void main(String[] args) {
		//Extract：特徴量計算を行うクラスの親クラス
		//濃度の特徴量を計算してリストに格納
		Extract extract = new Concentration();
		listConcentration = extract.extracted();

		//濃度の短形比を計算してリストに格納
		extract = new Aspect();
		listAspect = extract.extracted();

		//濃度の水平ランを計算してリストに格納
		extract = new HorizontalRunsAverage();
		listHorizontalRunsAverage = extract.extracted();

		//濃度の垂直ランを計算してリストに格納
		extract = new VerticalRunsAverage();
		listVerticalRunsAverage = extract.extracted();

		//濃度の水平ラン標準偏差を計算してリストに格納
		extract = new HorizontalRunsdeviation();
		listHorizontalRunsdeviation = extract.extracted();

		//濃度の垂直ラン標準偏差を計算してリストに格納
		extract = new VerticalRunsdeviation();
		listVerticalRunsdeviation = extract.extracted();

		//濃度の重心Xを計算してリストに格納
		extract = new CenterOfGravityX();
		listCenterOfGravityX = extract.extracted();

		//濃度の重心Yを計算してリストに格納
		extract = new CenterOfGravityY();
		listCenterOfGravityY = extract.extracted();

		//各特徴量をprintする
//		for(int i = 1; i <=100; i++) {
//			GImage img= new GImage("FinalImage/" + i + ".bmp");
//			printNum(i);
//		}

		//正規化するクラス
		Normalization normalization = new Normalization();
		//各特徴量が格納されているリストに対して正規化を行う
		listNormalizationConcentration = normalization.normalization(listConcentration);
		listNormalizationAspect = normalization.normalization(listAspect);
		listNormalizationHorizontalRunsAverage = normalization.normalization(listHorizontalRunsAverage);
		listNormalizationVerticalRunsAverage = normalization.normalization(listVerticalRunsAverage);
		listNormalizationHorizontalRunsdeviation = normalization.normalization(listHorizontalRunsdeviation);
		listNormalizationVerticalRunsdeviation = normalization.normalization(listVerticalRunsdeviation);
		listNormalizationCenterOfGravityX = normalization.normalization(listCenterOfGravityX);
		listNormalizationCenterOfGravityY = normalization.normalization(listCenterOfGravityY);

		//全ての抽出特徴量名を格納
		featureValue[0] = "濃度";
		featureValue[1] = "短形比";
		featureValue[2] = "水平ラ";
		featureValue[3] = "垂直ラ";
		featureValue[4] = "水ラ標";
		featureValue[5] = "垂ラ標";
		featureValue[6] = "重心X";
		featureValue[7] = "重心Y";

		//終了指定があるまでwhile
		while(true) {
			//Scannerの準備
			Scanner scanner = new Scanner(System.in);
			System.out.print("file番号,exit = -1");
			System.out.print("入力してください > ");
		    //入力された内容をインスタンスから取得
			int filename = Integer.parseInt(scanner.nextLine());
			//-1が入力された時にScannerを閉じてwhile抜ける
			if(filename == -1) {
				scanner.close();
				break;
			}

		    System.out.print("濃度:0 短形比:1 水平ラ:2 垂直ラ:3 水ラ標:4 垂ラ標:5 重心X:6 重心Y:7(空白なし)");
			System.out.print("入力してください > ");
		    //入力された内容をインスタンスから取得
		    String input = scanner.nextLine();
		    //入力文字列を一文字ずつ配列に格納
		    String[] in = input.split("");

		    //類似検索を行った結果上位10個をリストとして保持
		    List<Integer> sim = Simurate(filename, in);
		    //結果をcsvファイルに描画
		    exportCSV(sim, filename, in);
		    //指定ディレクトリの中に類似検索結果ファイルを出力
		    printImage(sim);
		    //結果をprintする
			for(int k: sim) {
				System.out.println(k) ;
			}

		}

	}

	/**
	 * 入力画像に対する全ての特徴量をprintするメソッド
	 * @param i
	 */
	public static void printNum(int i) {
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

	/**
	 * csvに描画するメソッド
	 * @param sim：類似検索結果
	 * @param filename：検索キー
	 * @param in：全ての抽出特徴量名
	 */
	public static void exportCSV(List<Integer> sim, int filename, String[] in) {
		try {
			//描画先csvを確保
			FileWriter fw = new FileWriter("test.csv", false);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			//各情報の見出しを作る
			pw.print("検索キー");
			pw.print(",");
			pw.println(filename + ".bmp");
			pw.print("順位");
			pw.print(",");
			pw.print("画像番号");
			for(String i : in) {
				pw.print(",");
				pw.print(featureValue[Integer.parseInt(i)]);
			}
			pw.print(",");
			pw.print("検索キーとの距離");
			pw.println();
			//ここからデータを入れる
			for(int i = 0; i < sim.size(); i++) {
				//リストの格納順が類似順
				pw.print((i+1) + "位");
				pw.print(",");
				pw.print(sim.get(i) + ".bmp");
				for(String k : in) {
					pw.print(",");
					//特徴量を格納しているリストを呼ぶ
					String str = Integer.toString(Integer.parseInt(k) + 10);
					//各特徴量を描画
					pw.print(serect(str).get(sim.get(i)-1));
				}
				pw.print(",");
				//difnumには類似順に距離が格納されている
				pw.print(difnum.get(i));
				pw.println();
			}
			//閉じる
			pw.close();
		}
		//エラー処理
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}


	/**
	 * 類似検索結果を返すメソッド
	 * @param i：検索キー
	 * @param strs：計算に用いる特徴量の種類が格納
	 * @return
	 */
	public static List<Integer> Simurate(int i, String[] strs) {
		//全ての距離を格納するリスト
		List<Double> dif = new ArrayList<Double>();
		//初期値をセット
		for(int k = 0; k < 100; k++) {
			dif.add(0.0);
		}
		//正規化特徴量の種類分計算を行う
		for(int l = 0; l < strs.length; l++) {
			//検索キーの正規化特徴量を取得
			double pos = serect(strs[l]).get(i-1);
			//全ての画像に対して計算を行う
			for(int k = 0; k < 100; k++) {
				//追加する値を計算(2乗している状態)
				double add =Math.pow(pos - serect(strs[l]).get(k), 2);
				//対象箇所に追加する
				dif.set(k, dif.get(k)+add);
			}
		}
		//全ての画像との距離を計算する
		for(int k = 0; k < 100; k++) {
			//現在リストに格納されている値は2乗されている状態なので平方根を計算し書き換え
			double temp = Math.sqrt(dif.get(k));
			dif.set(k, temp);
		}
		//距離のリストをコピー(sortした後に配列の番地を得るため)
		List<Double> oridif = (List<Double>)((ArrayList)dif).clone();
		//小さい順にsortする
		Collections.sort(dif);
		//返す類似度上位のリストを作成
		List<Integer> an= new ArrayList<Integer>();
		//フィールドで持っている距離を保持しているリストを初期化
		difnum = new ArrayList<Double>();
		//上位10個を取り出す(自分同士の距離も計算しているので一番小さい値は0になるのでそれを除く)
		for(int k = 1; k <= 10; k++) {
			//参照箇所の値がどの画像に対応しているかを取得
			int d = oridif.indexOf(dif.get(k));
			//距離を追加
			difnum.add(dif.get(k));
			//System.out.println(dif.get(k)); //確認用
			//類似検索結果に追加
			an.add(d+1);
		}
		return an;
	}

	/**
	 * 入力文字に対応するリストを返す
	 * @param str：入力文字(一文字)
	 * @return
	 */
	public static List<Double> serect(String str) {
		List<Double> select = new ArrayList<Double>();
		switch(str) {
			case "0":
				select = listNormalizationConcentration;
				break;
			case "1":
				select = listNormalizationAspect;
				break;
			case "2":
				select = listNormalizationHorizontalRunsAverage;
				break;
			case "3":
				select = listNormalizationVerticalRunsAverage;
				break;
			case "4":
				select = listNormalizationHorizontalRunsdeviation;
				break;
			case "5":
				select = listNormalizationVerticalRunsdeviation;
				break;
			case "6":
				select = listNormalizationCenterOfGravityX;
				break;
			case "7":
				select = listNormalizationCenterOfGravityY;
				break;
			case "10":
				select = listConcentration;
				break;
			case "11":
				select = listAspect;
				break;
			case "12":
				select = listHorizontalRunsAverage;
				break;
			case "13":
				select = listVerticalRunsAverage;
				break;
			case "14":
				select = listHorizontalRunsdeviation;
				break;
			case "15":
				select = listVerticalRunsdeviation;
				break;
			case "16":
				select = listCenterOfGravityX;
				break;
			case "17":
				select = listCenterOfGravityY;
				break;
		}

		return select;

	}

	/**
	 * 画像を別ディレクトリに抽出するメソッド
	 * @param sim
	 */
	public static void printImage(List<Integer> sim) {
		try{
			//抽出先フォルダを指定
			File file = new File("Final");
			//格納されているファイルリストを取得
			File[] fileList = file.listFiles();
			//空出なかったら
			if (fileList != null) {
				//要素を削除
				for (int i = 0; i < fileList.length; i++) {
					//System.out.println(fileList[i].getName()); //確認用
					//".DS_Store"も存在するので例外処理
					if(fileList[i].getName().equals(".DS_Store")) {
						continue;
					}
					else {
						Files.delete(Paths.get("Final/"+ fileList[i].getName()));
					}
			    }
			}
		}
		//エラー処理
		catch(IOException e){
			System.out.println(e);
		}
		//類似検索結果から画像を描画
		for(int i : sim) {
			GImage img= new GImage("FinalImage/" + i + ".bmp");
			/**
		      *  Set the file name to "i".
		      */
		     String fileName01 = "Final/" + i ;

		     /**
		      *  Set the file type to "bmp".
		      */
		     String fileType01 = "bmp";

		     /**
		      * Output the image-file "i.bmp".
		      */
		     img.output(fileName01,fileType01);
		}
	}
}
