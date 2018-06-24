import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ImporterTests {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void testSiteNotFound() {
        String [] args =  {"NoSite","MyPath"};
        Runner.main(args);
        assertEquals("Site not found", outContent.toString());  ;
    }
    @Test
    public void testJsonImporter(){
       String path = ImporterTests.class.getResource("softwareadvice.json").getPath();
       Importer importer = new JsonImporter();
       assertTrue(importer.doImport(path));

    }
    @Test
    public void testYamlImporter(){
        String path = ImporterTests.class.getResource("capterra.yaml").getPath();
       Importer importer = new YamlImporter();
       assertTrue(importer.doImport(path));
    }
}
