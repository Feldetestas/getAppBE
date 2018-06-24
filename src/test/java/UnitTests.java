import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnitTests {
    /**
     * Tests the JsonImport class
     */
    @Test
    public void testJsonImporter(){
       String path = UnitTests.class.getResource("softwareadvice.json").getPath();
       Importer importer = new JsonImporter();
       assertTrue(importer.doImport(path));

    }
    /**
     * Tests the YamlImporter class
     */
    @Test
    public void testYamlImporter(){
        String path = UnitTests.class.getResource("capterra.yaml").getPath();
       Importer importer = new YamlImporter();
       assertTrue(importer.doImport(path));
    }
}
