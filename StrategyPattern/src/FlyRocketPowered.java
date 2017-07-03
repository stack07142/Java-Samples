/**
 * FlyBehavior 인터페이스를 구현하는 FlyRocketPowered 클래스
 * 오리가 나는 방법의 하나
 */
public class FlyRocketPowered implements FlyBehavior {

    @Override
    public void fly() {

        System.out.println("로켓 추진으로 날아갑니다");
    }
}
