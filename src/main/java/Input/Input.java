package Input;

public class Input {
    private String website;
    private int depth;
    private String sourceLanguage;
    private String targetLanguage;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = "http://" + website;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(String sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public void setTargetLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage;
    }
}
