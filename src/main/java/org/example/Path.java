package org.example;

// POJO Class с путями
public class Path {
    private final String from;
    private final String to;
    public Path(String from, String to) {
        this.from = from;
        this.to = to;
    }
    public String getFrom() {
        return from;
    }
    public String getTo() {
        return to;
    }
}