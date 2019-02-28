package story.about.painter.VA;

public enum Mood {
    ANGRY,NORMAL,PLEASED;

    @Override
    public String toString() {
        switch (this){
            case ANGRY:
                return "злой";
            case NORMAL:
                return "обычный";
            case PLEASED:
                return "довольный";
            default:
                return "Настроение";
        }
    }
}
