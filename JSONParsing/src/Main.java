import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(
                    "/Users/mymac/Downloads/colors.json"));

            JSONObject jsonObject = (JSONObject) obj;

            Iterator it = jsonObject.keySet().iterator();

            while (it.hasNext()) {

                Object key = it.next();

                System.out.print("colorMap.put(\"" + key + "\", \"");

                JSONObject subObj = (JSONObject) jsonObject.get(key);

                System.out.println(subObj.get("color") + "\");");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

