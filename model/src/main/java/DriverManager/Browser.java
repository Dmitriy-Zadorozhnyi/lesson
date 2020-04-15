package DriverManager;

public enum Browser {
    CHROME ("chrome"),
    FIREFOX ("firefox"),
    SAFARI ("safari"),
    OPERA ("opera"),
    IE ("ie"),
    EDGE ("edge");

    private String title;

    Browser(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
