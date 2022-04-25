import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.Locale;

public class Translator {

    public String translate(String textToTranslate, String sourceLanguage, String targetLanguage) throws IOException {
        Runtime runtime = Runtime.getRuntime();

        sourceLanguage=getShortLanguage(sourceLanguage);
        targetLanguage=getShortLanguage(targetLanguage);

        Process translate = runtime.exec("curl https://api-free.deepl.com/v2/translate \n "
                    +"-d auth_key=bf134191-82e9-a5b1-7cca-e4508c535581:fx -d \"text="+textToTranslate+"\" \n"
                    +"\"-d source_lang"+sourceLanguage+"\" -d \"target_lang="+targetLanguage+"\"");
        String translated = IOUtils.toString(translate.getInputStream());
        if(translated.length()>45)translated = translated.substring(58,translated.length()-4);

        return translated;
    }

    public String getShortLanguage(String language){
        String shortcutLanguage = "";
        language=language.toLowerCase(Locale.ROOT);

        switch (language) {
            case "english" -> shortcutLanguage = "EN";
            case "german" -> shortcutLanguage = "DE";
            case "french" -> shortcutLanguage = "FR";
            case "bulgarian" -> shortcutLanguage = "BG";
            case "chinese" -> shortcutLanguage = "CA";
            case "czech" -> shortcutLanguage = "CS";
            case "danish" -> shortcutLanguage = "DA";
            case "dutch" -> shortcutLanguage = "NL";
            case "estonian" -> shortcutLanguage = "ET";
            case "finnish" -> shortcutLanguage = "FI";
            case "greek" -> shortcutLanguage = "EL";
            case "hungarian" -> shortcutLanguage = "HU";
            case "italian" -> shortcutLanguage = "IT";
            case "japanese" -> shortcutLanguage = "JA";
            case "latvian" -> shortcutLanguage = "LV";
            case "lithuanian" -> shortcutLanguage = "LT";
            case "polish" -> shortcutLanguage = "PL";
            case "romanian" -> shortcutLanguage = "RO";
            case "russian" -> shortcutLanguage = "RU";
            case "slovak" -> shortcutLanguage = "SK";
            case "slovenian" -> shortcutLanguage = "SL";
            case "spanish" -> shortcutLanguage = "ES";
            case "swedish" -> shortcutLanguage = "SV";
            case "portuguese" -> shortcutLanguage = "PT";
        }

        return shortcutLanguage;
    }
}
