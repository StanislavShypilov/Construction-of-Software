package task3;

public abstract class Document {
    protected final String title;
    protected final String filePath;

    public Document(String title, String filePath) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Назва документа не може бути порожньою.");
        }
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("Шлях до файлу не може бути порожнім.");
        }
        this.title = title;
        this.filePath = filePath;
    }

    public String getTitle() {
        return title;
    }

    public String getFilePath() {
        return filePath;
    }

    public abstract String getContent();
}
