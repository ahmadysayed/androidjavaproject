package fr.isep.androidjavaone;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;

public class JsonReader {
    public static House convertJsonToObject(Context context) {
        InputStream inputStream = context.getResources().openRawResource(R.raw.housing);

        String jsonString = "";
        try {
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();

            jsonString = new String(data, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  new Gson().fromJson(jsonString, new TypeToken<House>(){}.getType());
    }
}
