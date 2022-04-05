import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TranslatorTest {
    Translator translator = new Translator();

    @Test
    public void getTextTranslated() throws IOException {
        String[] testValues = {"Hello World!", "Das ist ein Test!"};

        assertEquals(translator.translate(testValues,"english","german")[0],"Hallo Welt!");
        assertEquals(translator.translate(testValues,"german","english")[1],"This is a test!");
    }

    @Test
    public void getLanguage(){
        String sampleInputLanguage = "english";

        assertEquals(translator.getShortLanguage(sampleInputLanguage),"EN");
    }
}