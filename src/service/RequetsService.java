package service;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class RequetsService {
    /**
     * リクエストを実行し、結果コードを返します。
     * @param strUrl リクエスト先のURL
     * @param method リクエストメソッド（GET、POSTなど）
     * @param json リクエストボディとして送信するJSONオブジェクト
     * @return リクエストの結果コード
     * @throws IOException リクエストの実行中に発生するIO例外
     **/
    public static int requetting(String strUrl, String method, JSONObject json) throws IOException {
        // リクエストを送信するためのURLを定義
        URL url = new URL(strUrl);
        
        // URLへの接続を開始し、HTTPリクエストを生成
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        // リクエストボディを送信するために、出力を許可
        conn.setDoOutput(true);
        
        // リクエストボディの型を設定する
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        
        // リクエストメソッドを設定
        conn.setRequestMethod(method);
        
        // リクエストボディを送信するためのOutputStreamWriterを作成
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
        
        // リクエストボディを書き込む
        writer.write(json.toString());
        writer.close();
        
        // リクエストを実行し、結果コードを取得
        int responseCode = conn.getResponseCode();
        
        // リクエスト結果コードを返す
        return responseCode;
    }
}
