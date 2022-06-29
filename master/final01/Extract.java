package final01;

import java.util.List;

/**
 * 特徴量計算を行う親クラス
 * @author horikousuke
 *
 */
public abstract class Extract {
	//数値が格納されたリストを返す
	public abstract List<Double> extracted();
}