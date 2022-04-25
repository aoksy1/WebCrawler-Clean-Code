import org.junit.jupiter.api.Test;

import java.io.IOException;

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

        assertEquals(input.getWebsite(),"http://aau.at");
    }

    @Test
    public void setAndGetInputDepth(){
        input.setDepth(3);

        assertEquals(input.getDepth(),depth);
    }

    @Test
    public void setAndGetInputSourceLanguage(){
        input.setSourceLanguage(sourceLanguage);

        assertEquals(input.getSourceLanguage(),sourceLanguage);
    }

    @Test
    public void setAndGetInputTargetLanguage(){
        input.setTargetLanguage(targetLanguage);

        assertEquals(input.getTargetLanguage(),targetLanguage);
    }
}
