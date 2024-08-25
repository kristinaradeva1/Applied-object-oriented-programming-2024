package test;

import traffic.TrafficLight;

public class TrafficLightTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long duration = start;
        while(duration - start > 90_000) {
            duration = System.currentTimeMillis();
            for(TrafficLight l : TrafficLight.values()) {
                long currentTime = System.currentTimeMillis();
                System.out.println(l);
                int lightDuration = l.getDuration();
                while(currentTime - duration < lightDuration) {
                    currentTime = System.currentTimeMillis();
                }
                duration = System.currentTimeMillis();
            }
        }
    }
}
