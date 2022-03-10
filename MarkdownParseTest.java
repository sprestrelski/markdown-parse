import static org.junit.Assert.*; 
import org.junit.*; 

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    /*
    @Test
    public void getLinks1() throws IOException{
        List<String> expect = List.of("https://something.com", "some-page.html");
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinks2() throws IOException{
        List<String> expect = List.of("goodbye.com");
        Path fileName = Path.of("new-test.md");
	    String contents = Files.readString(fileName);
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinks3() throws IOException{
        List<String> expect = List.of("google.com");
        Path fileName = Path.of("test-file3.md");
	    String contents = Files.readString(fileName);
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinks4() throws IOException{
        List<String> expect = List.of();
        Path fileName = Path.of("test-file4.md");
	    String contents = Files.readString(fileName);
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testNoImageLinks() throws IOException{
        List<String> expect = List.of("https://something.com", "some-page.html");
        Path fileName = Path.of("tester.md");
        String contents = Files.readString(fileName);
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    */
    @Test
    public void testCodeQuote() throws IOException{
        List<String> expect = List.of("`google.com", "google.com", "ucsd.edu");
        Path fileName = Path.of("lab8_1.md");
        String contents = Files.readString(fileName);
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testNestedEsc() throws IOException{
        List<String> expect = List.of("a.com", "a.com(())", "example.com");
        Path fileName = Path.of("lab8_2.md");
        String contents = Files.readString(fileName);
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testMultiLineLinks() throws IOException{
        List<String> expect = List.of("https://ucsd-cse15l-w22.github.io/");
        Path fileName = Path.of("lab8_3.md");
        String contents = Files.readString(fileName);
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
}  