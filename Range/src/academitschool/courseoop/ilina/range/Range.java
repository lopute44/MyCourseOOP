package academitschool.courseoop.ilina.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public Range() {
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

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersectionRanges(Range range) {
        Range intersectionRanges = new Range();
        if (this.getFrom() <= range.getFrom()) {
            if (this.getTo() <= range.getFrom()) {
                return null;
            } else {
                intersectionRanges.setFrom(range.getFrom());
                intersectionRanges.setTo(Math.min(this.getTo(), range.getTo()));
                return intersectionRanges;
            }
        } else {
            if (range.getTo() <= this.getFrom()) {
                return null;
            } else {
                intersectionRanges.setFrom(this.getFrom());
                intersectionRanges.setTo(Math.min(range.getTo(), this.getTo()));
                return intersectionRanges;
            }
        }
    }
}
