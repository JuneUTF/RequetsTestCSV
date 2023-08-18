package controller;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONObject;

import com.opencsv.exceptions.CsvException;

import model.CSVModel;
import service.ItemFileService;
import service.LocalTimeService;
import service.RequetsService;

public class MainController {

    public static void main(String[] args) throws InterruptedException {
        // ファイルのパースを定義する
        String pathFile = "C:\\Users\\juneu\\Downloads\\test.csv";

        ItemFileService csvFile = new ItemFileService();
        try (Reader reader = Files.newBufferedReader(Paths.get(pathFile));) {
            List<CSVModel> items = csvFile.read(reader);
            System.out.println("リクエストが実行されています。");
            for (CSVModel scvModel : items) {
                System.out.print(scvModel.getRequests());
                System.out.println("リクエスト開始");
                for (int i = 0; i < scvModel.getRequests(); i++) {
                    // URL定義
                    String url = "http://localhost:8080/login";
                    // メソッド定義
                    String methodString = "POST";
                    // JSON型の作成
                    JSONObject json = new JSONObject();
                    json.put("username", "huynh");
                    json.put("password", "1");
                    // リクエストを送信
                    int respCode = RequetsService.requetting(url, methodString, json);
                    System.out.println((i + 1) + "/" + scvModel.getRequests() + ":" + respCode);
                    String millisecond = LocalTimeService.getTimeMilliSecond();
                    System.out.println(millisecond);
                    // 間隔
                    Thread.sleep(scvModel.getInterval());

                }
                // 待ち時間
                System.out.print(scvModel.getRequests());
                System.out.println("リクエスト終了");
                Thread.sleep(scvModel.getWaitingTime());
            }

            System.out.println("終了");
        } catch (CsvException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
