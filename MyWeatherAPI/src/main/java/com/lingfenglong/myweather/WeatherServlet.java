package com.lingfenglong.myweather;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.google.gson.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String host = "http://iweather.market.alicloudapi.com";
        String path = "/address";
        String method = "GET";
        String appcode = "f9fa127b9be74400b4e368504763bbb8";

        HttpResponse httpResponse = HttpRequest.get(host + path)
                .header("Authorization", "APPCODE " + appcode)
                .form("needday", "7", "prov", "河北", "city", "石家庄", "area", "裕华区")
                .execute();


        //Map<String, String> querys = new HashMap<>();
        //querys.put("needday", "7");
        //querys.put("prov", URLEncoder.encode("河北", StandardCharsets.UTF_8));
        //querys.put("city", URLEncoder.encode("石家庄", StandardCharsets.UTF_8));
        //querys.put("area", URLEncoder.encode("裕华区", StandardCharsets.UTF_8));
        //
        //StringBuilder params = new StringBuilder();
        //params.append("?");
        //querys.forEach((k, v) -> {
        //    params.append(k).append("=").append(v).append("&");
        //});
        //params.deleteCharAt(params.length() - 1);
        //
        //URL url = new URL(host + path + params);
        //HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //connection.setRequestProperty("Authorization", "APPCODE " + appcode);
        //connection.setRequestMethod(method);
        //connection.setDoInput(true);
        //
        //connection.connect();
        //
        //InputStream inputStream = connection.getInputStream();
        //inputStream.readAllBytes();

        String json = httpResponse.body();

        // 获得json对象
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        // 获取CityInfo
        JsonObject cityInfoJsonObject = jsonObject
                .get("data").getAsJsonObject()
                .get("cityinfo").getAsJsonObject();
        CityInfo cityInfo = gson.fromJson(cityInfoJsonObject, CityInfo.class);
        System.out.println(cityInfo);

        // 获取List<Weather>
        JsonArray day7JsonArray = jsonObject
                .get("data").getAsJsonObject()
                .get("day7").getAsJsonArray();
        ArrayList<Weather> weatherList = new ArrayList<>(7);
        day7JsonArray.getAsJsonArray().asList().forEach(v -> {
            weatherList.add(gson.fromJson(v, Weather.class));
        });
        weatherList.forEach(System.out::println);

        // 存入作用域，转发请求
        request.setAttribute("cityInfo", cityInfo);
        request.setAttribute("weatherList", weatherList);
        request.getRequestDispatcher("/WEB-INF/weather.jsp").forward(request, response);
    }
}