public class Operator2 {
    public static void main(String[] args) {
        int num1 = 50;
        System.out.printf ("정수 num1 : %d / 정수를 2진수로 : %s\n", num1, Integer.toBinaryString(num1));
        
        int result1 = num1 >> 1; // 오른쪽으로 한칸씩 shift, 2로 나눔
        System.out.printf("num1 >> 1 : %d, %s\n", result1, Integer.toBinaryString(result1)); 
        
        int result2 = num1 << 1; // 왼쪽으로 한칸씩 shift, 2로 곱함
        System.out.printf("num1 << 1 : %d, %s\n", result2, Integer.toBinaryString(result2));
        
        int pwd = 123456;
        int encPwd, decPwd;
        int key = 0x1A253B65; 
        
        System.out.println("암호화 전 비밀번호 : "+pwd); 
        encPwd = pwd ^ key;
        System.out.println("암호화 후 비밀번호 : "+encPwd);
        decPwd = encPwd ^ key;
        System.out.println("복호화 후 비밀번호 : "+decPwd);
    }
}