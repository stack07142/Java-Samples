/**
 * QuackBehavior 인터페이스를 구현하는 MuteQuack 클래스
 * 오리가 우는 방법의 하나
 */
public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {

        System.out.println("<< 조용~ >>");
    }
}
