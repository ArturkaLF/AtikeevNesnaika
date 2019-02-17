package story.about.painter;

public class IncomingMessageIsNullException extends RuntimeException {
    @Override
    public String toString() {
        return "Входящее сообщение отсутсвует";
    }
}
