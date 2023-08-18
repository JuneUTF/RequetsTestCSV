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
     * @param reader ファイルリーダー
     * @return SCVModelのリスト
     * @throws CsvException CSV処理例外
     */
    public List<CSVModel> read(Reader reader) throws CsvException {
        CsvToBean<CSVModel> csvToBean = new CsvToBeanBuilder<CSVModel>(reader).withType(CSVModel.class).build();
        return csvToBean.parse();
    }
}
