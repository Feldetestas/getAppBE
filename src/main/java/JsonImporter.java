import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

public class JsonImporter extends Importer<String> {

    public boolean doImport(String location) {
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader(location));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray products =(JSONArray) jsonObject.get("products");

            Iterator<JSONObject> iterator = products.iterator();

            while (iterator.hasNext()) {
                System.out.print("Importing:");
                print(iterator.next());
                System.out.println();

            }
            return true;

        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    private void print(JSONObject product){
        JSONArray categories = (JSONArray) product.get("categories");
        Iterator<String> iterator = categories.iterator();
        System.out.print(" Categories:");
        while(iterator.hasNext()){
            System.out.print(String.format(" %s", iterator.next()));
        }
        if(product.get("twitter")!= null){
            System.out.print(String.format("; Twitter: %s",product.get("twitter")));
        }
        if(product.get("title")!= null){
            System.out.print(String.format("; Title: %s;",product.get("title")));
        }

    }

}
