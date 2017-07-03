/**
 * QuackBehavior 인터페이스를 구현하는 Squeak 클래스
 * 오리가 우는 방법의 하나
 */
public class Squeak implements QuackBehavior {

    @Override
    public void quack() {

        System.out.println("삑");
    }
}
