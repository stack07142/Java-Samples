/**
 * FlyBehavior 인터페이스를 구현하는 FlyNoWay 클래스
 * 오리가 나는 방법의 하나
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {

        System.out.println("저는 못 날아요");
    }
}
