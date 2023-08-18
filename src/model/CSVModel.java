package model;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;

@Data
public class CSVModel {
	/**リクエスト**/
	@CsvBindByName(column = "リクエスト", required = true)
	private int requests;

	/**間隔**/
	@CsvBindByName(column = "間隔", required = true)
	private int interval;

	/**待ち時間**/
	@CsvBindByName(column = "待ち時間", required = true)
	private int waitingTime;

	
}
