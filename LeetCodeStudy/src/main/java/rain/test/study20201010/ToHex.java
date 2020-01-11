package rain.test.study20201010;

/**
 * 10进制转为16进制的实现方式
 */

public class ToHex {
    public  static  String  intToHex(int  num){
        StringBuilder sb = new StringBuilder(8);
        String a;
        char []b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while (num!=0){
            sb =sb.append(b[num%16]);
            num =num/16;
        }
        a =sb.reverse().toString();
        return a;

    }

    public static void main(String[] args) {
        System.out.println(intToHex(78));
    }
}
