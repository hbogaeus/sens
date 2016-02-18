package se.sensco.sens;


public class Sensor {
    private static int count = 0;

    private int id;
    private int temp;
    private String name;

    public Sensor() {
        this.id = count;
        this.temp = 29;
        this.name = "Temp Name";
        count++;
    }

    public Sensor(int temp, String name) {
        this.id = count;
        this.temp = temp;
        this.name = name;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }

}
