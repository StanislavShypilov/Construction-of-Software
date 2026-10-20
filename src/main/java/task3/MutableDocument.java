package task3;

public class MutableDocument extends Document {
    private String content;

    public MutableDocument(String title, String filePath, String content) {
        super(title, filePath);
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void save() {
        System.out.println("Saving document '" + title + "' to path: " + filePath);
    }
}
