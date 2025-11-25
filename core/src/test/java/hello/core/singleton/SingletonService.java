package hello.core.singleton;

public class SingletonService {

  // static 영역에 객체를 딱 1개만 생성해둔다.
  private static final SingletonService instance = new SingletonService();

  public static SingletonService getInstance() {
    // 인스턴스 참조는 이곳에서만 가능하다.
    return instance;
  }

  // 프라이빗 생성자(클래스 내부에서만 생성 가능), 외부에서 생성 불가능
  private SingletonService() {

  }

  public void logic() {
    System.out.println("싱글톤 객체 로직 호출");
  }


}
