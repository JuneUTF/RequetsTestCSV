package service;

import java.time.LocalDateTime;

public class LocalTimeService {
	/**
     * 現在のミリ秒単位の時間を取得します。
     * @return 現在の時間（ミリ秒単位）
     **/
	public static String getTimeMilliSecond() {
		 // 現在のローカル時間を取得します
		LocalDateTime currentTime = LocalDateTime.now();
		 // 時間、分、秒を取得します
        int hour = currentTime.getHour();
        int minute = currentTime.getMinute();
        int second = currentTime.getSecond();
        // ナノ秒をミリ秒に変換します
        int millisecond = currentTime.getNano() / 1000000;
     // 時間情報を文字列として結合して返します
        return hour+":"+minute+":"+second+":"+millisecond;
	}
}
