import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.Locale;

public class Translator {
    public String[] translate(String[] textToTranslate, String sourceLanguage, String targetLanguage) throws IOException {
        String[] translated = new String[textToTranslate.length];
        Runtime runtime = Runtime.getRuntime();
        sourceLanguage=getShortLanguage(sourceLanguage);
        targetLanguage=getShortLanguage(targetLanguage);
        for(int i=0;i<textToTranslate.length;i++){
            Process translate = runtime.exec("curl https://api-free.deepl.com/v2/translate \n "
                    +"-d auth_key=bf134191-82e9-a5b1-7cca-e4508c535581:fx -d \"text="+textToTranslate[i]+"\" \n"
                    +"\"-d source_lang"+sourceLanguage+"\" -d \"target_lang="+targetLanguage+"\"");
            translated[i] = IOUtils.toString(translate.getInputStream());
            translated[i] = translated[i].substring(58,translated[i].length()-4);
            System.out.println(translated[i]);
        }
        return translated;
    }
    public String getShortLanguage(String language){
        String shortLanguage = "";
        language=language.toLowerCase(Locale.ROOT);
        switch (language){
            case "english":
                shortLanguage="EN";
                break;
            case "german":
                shortLanguage="DE";
                break;
        }
        return shortLanguage;
    }
}
