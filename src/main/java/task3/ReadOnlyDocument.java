package task3;

public class ReadOnlyDocument extends Document {
    private final String content;

    public ReadOnlyDocument(String title, String filePath, String content) {
        super(title, filePath);
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
