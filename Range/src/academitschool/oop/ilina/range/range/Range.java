package academitschool.oop.ilina.range.range;

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

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    @Override
    public String toString() {
        return "(" + from + "; " + to + ")";
    }

    public Range getIntersectionRange(Range range) {
        if (Math.min(to, range.to) > Math.max(from, range.from)) {
            return new Range(Math.max(from, range.from), Math.min(to, range.to));
        }

        return null;
    }

    public Range[] getCombiningRanges(Range range) {
        if (Math.min(to, range.to) >= Math.max(from, range.from)) {
            Range[] ranges = new Range[1];
            ranges[0] = new Range(Math.min(from, range.from), Math.max(to, range.to));
            return ranges;
        }

        Range[] ranges = new Range[2];
        ranges[0] = this;
        ranges[1] = range;
        return ranges;
    }

    public Range[] getSubtractionRanges(Range range) {
        if (from <= range.from && to >= range.to) {
            return null;
        }

        if (from < range.from && range.from < to) {
            Range[] ranges = new Range[1];
            ranges[0] = new Range(from, range.from);
            return ranges;
        }

        if (range.from < from && from < range.to) {
            Range[] ranges = new Range[1];
            ranges[0] = new Range(range.to, to);
            return ranges;
        }

        if (from > range.from && to > range.to || range.from > from){
            Range[] ranges = new Range[1];
            ranges[0] = new Range(from, to);
            return ranges;
        }

        Range[] ranges = new Range[2];
        ranges[0] = new Range(from, range.from);
        ranges[1] = new Range(range.to, to);
        return ranges;
    }
}
