package story.about.painter.mp;

public class IncomingMessageIsNullException extends RuntimeException {
    @Override
    public String toString() {
        return "Входящее сообщение отсутсвует";
    }
}
