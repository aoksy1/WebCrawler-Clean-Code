import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TranslatorTest {

    @Test
    public void getTextTranslated() throws IOException {
        Translator translator = new Translator();
        String testValue1 = "Hello World!";
        String testValue2 = "Das ist ein Test!";

        assertEquals("Hallo Welt!", translator.translate(testValue1,"english","german"));
        //assertEquals(translator.translate(testValue2,"german","english"),"This is a test!");
    }

    @Test
    public void getLanguage(){
        Translator translator = new Translator();
        String sampleInputLanguage = "english";

        assertEquals(translator.getShortLanguage(sampleInputLanguage),"EN");
    }
}