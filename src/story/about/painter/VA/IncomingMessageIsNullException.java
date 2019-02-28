package story.about.painter.VA;

public class IncomingMessageIsNullException extends RuntimeException {
    @Override
    public String toString() {
        return "Входящее сообщение отсутсвует";
    }
}
