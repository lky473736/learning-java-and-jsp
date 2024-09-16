public class Methods {
    String name; // 멤버 변수이자 인스턴스 함수
    
    // 생성자 메소드 (인스턴스 될 때 호출 (객체 만들 때 호출))
    Methods() {
        name = "임규연";
        System.out.println("객체가 만들어졌습니다.");
        System.out.printf ("생성자 : %s\n", name);
    }
    
    // 인자가 없는 메소드 
    void printName() {
        System.out.println("parameter가 없습니다.");
        System.out.printf("printfName() : %s\n", name);
    }
    
    // 인자가 하나임 (메소드 오버로딩)
    // 만약에 printName인데 인자가 없다면 위 함수가 실행됨
    // 인자가 있다면 아래 함수가 실행됨
    void printName(String name) { 
        System.out.println("parameter가 하나입니다.");
        System.out.printf("printfName(String name) : %s\n", name);
    }
    
    // 인자의 갯수가 정해져 있지 않음 (가변인자)
    void printName(String...names) { 
        System.out.println("parameter가 여러개입니다.");
        System.out.printf("printfName(String...name)\n");
        
        for (String name : names) { // c++ 문법이랑 비슷한 부분
            System.out.println(name);
        }
    }
    
    // 인자가 두개임
    int calc (int num1, int num2) {
        return num1 + num2;
    }
    
    // main
    public static void main (String[] args) {
        Methods instance = new Methods();
        instance.printName();
        instance.printName("임규연");
        instance.printName("임", "김", "이");
        System.out.printf ("calc : %d", instance.calc(20, 50));
    }
}