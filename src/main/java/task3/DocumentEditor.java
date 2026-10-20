package task3;

public class DocumentEditor {
    public void appendWatermarkAndSave(MutableDocument doc, String watermark) {
        doc.setContent(doc.getContent() + " [Watermark: " + watermark + "]");
        doc.save();
    }
}
