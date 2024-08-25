package traffic;

public enum TrafficLight {
    RED(15_000),
    GREEN(20_000),
    YELLOW(3_000);

    private int duration;
    private TrafficLight(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
