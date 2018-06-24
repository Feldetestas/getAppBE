import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class YamlImporter extends Importer<String> {

    public boolean doImport(String location) {
        try {
            Yaml yaml = new Yaml();
            File initialFile = new File(location);
            InputStream in = new FileInputStream(initialFile);

            Iterable<Object> itr = yaml.loadAll(in);
            for (Object elements : itr) {
                print((ArrayList<LinkedHashMap>)elements);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void print(ArrayList<LinkedHashMap> elements){
        elements.forEach(element->{
            System.out.print("Importing:");
            System.out.print(String.format(" Name:%s;",element.get("name")));
            System.out.print(String.format(" Categories:%s;",element.get("tags")));
            System.out.print(String.format(" Twitter:%s;",element.get("twitter")));
            System.out.println();
        });
    }
}
