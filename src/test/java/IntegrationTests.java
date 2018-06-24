import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class IntegrationTests {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Tests exception is displayed if the provider is not found
     */
    @Test
    public void testSiteNotFound() {
        String [] args =  {"NoSite","MyPath"};
        Runner.main(args);
        assertEquals("Site not found", outContent.toString());  ;
    }
    /**
     * Tests that the output is not null and contains the import process description.
     */
    @Test
    public void testCallingForCapterra() {
        String path = IntegrationTests.class.getResource("capterra.yaml").getPath();
        String [] args =  {"capterra",path};
        Runner.main(args);
        assertNotEquals("Site not found", outContent.toString());
        assertNotNull(outContent.toString());
    }

}
