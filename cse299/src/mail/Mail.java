package mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class Mail {

    public boolean isSendEmail(String email,String newPassword) {
        boolean isSuccess = false;
        try{
            String url = "http://localhost/?key=cse299&email="+email+"&password="+newPassword;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject myResponse = new JSONObject(response.toString());
            if(myResponse.getBoolean("result")){
                isSuccess = true;
            }
        }catch(IOException | JSONException e){
            System.out.println(e);
        }
        return isSuccess;
    }

}
