import java.util.ArrayList;

public class WeatherData implements Subject {

    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {

        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {

        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {

        observers.remove(o);
    }

    @Override
    public void notifyObservers() {

        for (Observer o : observers) {

            o.update(temperature, humidity, pressure);
        }
    }

    // 가상 스테이션으로부터 갱신된 측정치를 받으면 옵저버들에게 알린다
    public void measurementsChanged() {

        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {

        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }
}
