import TranslatorAPI.Translator;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TranslatorTest {

    @Test
    public void getTextTranslated() throws IOException {
        Translator translator = new Translator();
        String testValue1 = "Hello World!";
        String testValue2 = "Das ist ein Test!";

        assertEquals(translator.translate(testValue1,"english","german"),"Hallo Welt!");
        assertEquals("This is a test!",translator.translate(testValue2,"german","english"));
    }

    @Test
    public void getLanguage(){
        Translator translator = new Translator();
        String sampleInputLanguage = "english";

        assertEquals("EN",translator.getShortLanguage(sampleInputLanguage));
    }
}