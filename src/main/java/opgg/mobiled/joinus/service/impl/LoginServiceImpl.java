package opgg.mobiled.joinus.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import opgg.mobiled.joinus.service.LoginService;
import opgg.mobiled.joinus.dao.LoginDao;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Service
public class LoginServiceImpl implements LoginService{
    private LoginDao loginDao;

    @Value("${oauth.clientid}")
    String client_id;

    @Value("${oauth.clientpassword}")
    String client_password;

    @Value("${oauth.redirecturi}")
    String redirect_uri;

    @Autowired
    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    public String postRequestWithToken(String token) throws IOException {
        String result_post = "";

        URL url = new URL ("https://oauth2.googleapis.com/token");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        String jsonInputString = "{'code': '" + token + "', 'client_id': '" + this.client_id + "','client_secret':'" + this.client_password +"','redirect_uri':'" + this.redirect_uri + "','grant_type':'authorization_code'}";
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            result_post = response.toString();
        }
        return result_post;
    }

    public static String getRequestWithAccessToken(String token) throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL("https://www.googleapis.com/oauth2/v3/userinfo?access_token="+token);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        return result.toString();
    }

    public static Map<String,Object> convertJSONstringToMap(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();

        map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});

        return map;
    }

    @Override
    public int OAuthCheck(String token) {
        try {
            String access_token_data = postRequestWithToken(token);
            System.out.println(access_token_data);
            String user_data = getRequestWithAccessToken((String) convertJSONstringToMap(access_token_data).get("access_token"));
            System.out.println(user_data);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 1;
    }
}
