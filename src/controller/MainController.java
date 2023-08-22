package controller; 

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.exceptions.CsvException;

import model.CSVModel;
import service.ItemFileService;
import service.RequetsService; 

public class MainController {

    public static void main(String[] args) throws InterruptedException {
    	/** ロガー. */
    	Logger logger = LoggerFactory.getLogger(MainController.class);
        // ファイルのパースを定義する
		// ファイル処理のサービスクラスのインスタンス化
        ItemFileService csvFile = new ItemFileService(); 
        // ファイルを読み込むためのReaderを準備
        try (Reader reader = Files.newBufferedReader(Paths.get(args[0]));){  
        	// CSVファイルから読み込んだデータを格納するリストを取得
            List<CSVModel> items = csvFile.read(reader);  
            logger.info("リクエストが実行されています。");
            for (CSVModel scvModel : items) {  // リスト内の各SCVModelに対して処理を実行
                logger.info(scvModel.getRequests()+"リクエスト開始");
                for (int i = 0;i<scvModel.getRequests();i++) {
                    //メソッド定義
                    String methodString = "POST";
                    //Object JSON型の作成
                    JSONObject json = new JSONObject();
                    json.put("username", "huynh");
                    json.put("password", "1");
                   //リクエストを送信
                    int respCode = RequetsService.requetting(args[1],methodString,json);
                    logger.info((i+1)+"/"+scvModel.getRequests()+":"+respCode);
                 // 指定された間隔でスレッドを一時停止
                    Thread.sleep(scvModel.getInterval());  
                }
                logger.info(scvModel.getRequests()+"リクエスト終了");
                // 待ち時間を設定してスレッドを一時停止
                Thread.sleep(scvModel.getWaitingTime());  
            }
            logger.info("終了");
            //リクエストを送信する時、例外のトレースを出力
        } catch (IOException e) {
        	logger.info("リクエストの送信がエラーなりました。");
            e.printStackTrace();  
        	//CSVファイル関連の例外のトレースを出力
        } catch (CsvException e) {
        	logger.info("CSVファイル関連がエラーなりました。");
            e.printStackTrace();   
        }
    }
}
