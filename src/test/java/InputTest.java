import Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {
    Input input = new Input();
    String website = "aau.at";
    String sourceLanguage = "english";
    String targetLanguage = "german";
    int depth = 3;

    @Test
    public void setAndGetInputWebsite(){
        input.setWebsite(website);

        assertEquals("https://aau.at", input.getWebsite());
    }

    @Test
    public void setAndGetInputDepth(){
        input.setDepth(3);

        assertEquals(depth, input.getDepth());
    }

    @Test
    public void setAndGetInputSourceLanguage(){
        input.setSourceLanguage(sourceLanguage);

        assertEquals(sourceLanguage, input.getSourceLanguage());
    }

    @Test
    public void setAndGetInputTargetLanguage(){
        input.setTargetLanguage(targetLanguage);

        assertEquals(targetLanguage, input.getTargetLanguage());
    }
}
