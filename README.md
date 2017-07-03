# Java Samples



## ThreadSync
-Thread간 객체 공유<br />
-Thread 동기화

* ThreadEx21
  - Thread간 객체 공유 방법 #1
	- Runnable Interface를 구현한 후 공유할 인스턴스 변수 선언

* ThreadEx22
  - Thread간 객체 공유 방법 #2
	- Thread를 상속받는 클래스에 공유할 객체 타입의 인스턴스 변수를 선언하고, 공유할 객체를 매개변수로 받는 생성자를 선언

* ThreadEx23
  - Thread간 객체 공유의 잘못된 예 
	- Thread를 상속받는 클래스에 공유할 인스턴스 변수 선언

* ThreadEx24
  - Thread 동기화 되지 않은 예제

* ThreadEx25
  - Thread 동기화 (함수 synchronized)

* ThreadEx26
  - wait(), notify(), notifiyAll() 를 사용하여 쓰레드 동기화 효율을 높인다
	- Object에 정의된 메서드이므로 모든 객체에서 호출이 가능하다
	- 동기화 블록(synchronized 블록) 내에서만 사용할 수 있다
	- 보다 효율적인 동기화를 가능하게 한다


## Strategy Pattern
-Strategy Pattern : 알고리즘군을 정의하고 각각을 캡슐화하여 교환해서 사용할 수 있도록 만든다. Strategy Pattern을 활용하면 알고맂므을 사용하는 클라이언트와는 독립적으로 알고리즘을 변경할 수 있다.

![](https://github.com/stack07142/Java-Samples/blob/master/img/StrategyPattern.png)