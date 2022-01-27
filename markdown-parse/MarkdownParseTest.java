import static org.junit.Assert.*; //allows you to use Assert methods in your code
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest { //class header
    @Test //tells JUnit that this method is a test method
    public void addition() { //method header
        assertEquals(2, 1 + 1);//checks that 2 is equal to 1 + 1
    }

    @Test
    public void getLinks1() throws IOException{
        // checks test-file.md
        List<String> expected = List.of("https://something.com", "some-page.html");
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        assertEquals(MarkdownParse.getLinks(contents), expected);
    }

    @Test
    public void getLinks2() throws IOException{
        // checks new-test.md
        List<String> expected = List.of("image.jpg");
        Path fileName = Path.of("new-test.md");
        String contents = Files.readString(fileName);
        assertEquals(MarkdownParse.getLinks(contents), expected);
    }

    @Test
    public void getLinks3() throws IOException{
        List<String> expected = List.of("google.com");
        Path fileName = Path.of("test-file3.md");
        String contents = Files.readString(fileName);
        assertEquals(MarkdownParse.getLinks(contents), expected);
    }

    @Test
    public void getLinks4() throws IOException{
        List<String> expected = List.of();
        Path fileName = Path.of("test-file4.md");
        String contents = Files.readString(fileName);
        assertEquals(MarkdownParse.getLinks(contents), expected);
    }
}