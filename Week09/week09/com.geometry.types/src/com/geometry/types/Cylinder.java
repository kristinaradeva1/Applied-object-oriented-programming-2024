package com.geometry.types;
public class Cylinder extends Circle{
    private int height;

    public Cylinder(int x, int y, int radius, int height) {
        super(x, y, radius);
        setHeight(height);
    }

    public Cylinder() {
        this.height = 0;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height > 0) {
            this.height = height;
        }else{
            this.height = 10;
        }
    }

    @Override
    public String toString() {
        return String.format("Cylinder: " + "%s, height = %d", super.toString(), height);
    }

    @Override
    public int compareTo(Object o) {
        if(o == null) return 1;
        if(!(o instanceof Cylinder)) return 1;
        Cylinder c = (Cylinder) o;
        int baseCompare = super.compareTo(c);
        if(baseCompare != 0)
            return baseCompare;

        return this.height - c.height;
    }

}