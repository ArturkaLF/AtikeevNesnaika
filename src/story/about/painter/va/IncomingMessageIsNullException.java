package story.about.painter.va;

public class IncomingMessageIsNullException extends RuntimeException {
    @Override
    public String toString() {
        return "Входящее сообщение отсутсвует";
    }
}
