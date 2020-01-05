public class CountDigitOne {


    public static void main(String[] args) {
        System.out.println(countDigitOne(100));
    }
    public static   int countDigitOne(int n) {
        int cnt = 0;
        int mul =1;
        int left =n;
        int right =0;
        if(n==0) {
            return 0;
        }
        while(left>0) {
            int digit = left%10;
            left/=10;
            if(digit == 1) {
                cnt+=left*mul;
                cnt+=right+1;
            }
            else if(digit<1) {
                cnt+=left*mul;
            }
            else {
                cnt+=(left+1)*mul;
            }
            right+=digit*mul;
            mul*=10;
        }
        return cnt;
    }
}
