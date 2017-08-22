
// 현재 조건(온도와 습도)을 표시하는 디스플레이
public class CurrentConditionDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {

        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {

        this.temperature = temperature;
        this.humidity = humidity;

        // update되면 display를 호출
        display();
    }

    @Override
    public void display() {

        System.out.println("Current conditions : " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
