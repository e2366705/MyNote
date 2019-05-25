package com.example.demo.test;


import com.google.gson.*;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadJSON {
    public static void main(String[] args) {
        try {

            //建立一个JSON的解析器
            //可用解析器解析字符串或者输入流
            JsonParser parser = new JsonParser();

            //建立一个JSON对象
            JsonObject object = (JsonObject) parser.parse(new FileReader("test.json"));

            //读取对象值
            //由键索引键值，并依据键值数据类型，转换其格式
            System.out.println("cat=" + object.get("cat").getAsString());

            System.out.println("pop=" + object.get("pop").getAsBoolean());

            //读取数组
            JsonArray array = object.get("languages").getAsJsonArray();
            for (int i = 0; i < array.size(); i++) {
                System.out.println("-----------");
                JsonObject subObject = array.get(i).getAsJsonObject();
                System.out.println("id=" + subObject.get("id").getAsInt());
                System.out.println("name=" + subObject.get("name").getAsString());
                System.out.println("ide=" + subObject.get("ide").getAsString());
            }

        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void mainn() throws FileNotFoundException {

        // 创建json数据
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("cat", "it");

        JsonArray jArray = new JsonArray();

        JsonObject lan1 = new JsonObject();
        lan1.addProperty("id", 1);
        lan1.addProperty("name", "java");
        lan1.addProperty("ide", "eclipse");
        jArray.add(lan1);

        JsonObject lan2 = new JsonObject();
        lan2.addProperty("id", 2);
        lan2.addProperty("name", "C++");
        lan2.addProperty("ide", "VC6.0");
        jArray.add(lan2);

        JsonObject lan3 = new JsonObject();
        lan3.addProperty("id", 3);
        lan3.addProperty("name", "C#");
        lan3.addProperty("ide", "Visual Studio");
        jArray.add(lan3);

        JsonObject lan4 = new JsonObject();
        lan4.addProperty("id", 4);
        lan4.addProperty("name", "Swift");
        lan4.addProperty("ide", "Xcode");
        jArray.add(lan4);

        jsonObject.add("languages", jArray);
        jsonObject.addProperty("pop", true);
        System.out.println(jsonObject);

        File jsonFile = new File("test.json");
        try {
            jsonFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(jsonFile);
            OutputStreamWriter osq = new OutputStreamWriter(fos);
            BufferedWriter bfw = new BufferedWriter(osq);
            bfw.write(jsonObject.toString());

            bfw.close();
            osq.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
