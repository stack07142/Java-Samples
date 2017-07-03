/**
 * FlyBehavior 인터페이스를 구현하는 FlyWithWings 클래스
 * 오리가 나는 방법의 하나
 */
public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {

        System.out.println("날개로 날고 있어요!");
    }
}
