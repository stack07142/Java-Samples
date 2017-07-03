/**
 * MallardDuck 클래스
 */
public class MallardDuck extends Duck {

    public MallardDuck() {

        // MallardDuck은 Duck 클래스에서 quackBehavior와 flyBehavior 변수를 상속받는다
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {

        System.out.println("저는 물오리입니다");
    }
}
