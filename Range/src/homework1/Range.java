package homework1;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLengthRange() {
        return to - from;
    }

    public boolean isInside(double number) {
        double firstBorder = getFrom();
        double secondBorder = getTo();

        return number >= firstBorder && number <= secondBorder;
    }
}
