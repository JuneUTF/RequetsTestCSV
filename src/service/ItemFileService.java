package service;

import java.io.Reader;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import model.CSVModel;

public class ItemFileService {
    /**
     * CSVファイルとのやり取りを行う
     * @param reader ファイルライーダー
     * @return SCVModelのリスト
     * @throws CsvException CSV処理例外
     */
	public List<CSVModel> read(Reader reader) throws CsvException {
	    // CsvToBeanBuilderオブジェクトを作成し、CSVデータをJavaオブジェクトに変換するプロセス
	    CsvToBean<CSVModel> csvToBean = new CsvToBeanBuilder<CSVModel>(reader)
	        .withType(CSVModel.class).build();

	    // CSVデータをCSVModelオブジェクトのリストに変換するプロセスを実行します
	    List<CSVModel> csvModels = csvToBean.parse();

	    //CSVModelオブジェクトのリストを返します
	    return csvModels;
	}

}
