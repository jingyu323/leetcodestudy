import java.util.Arrays;

public class Rexmatch {

  public static void main(String[] args) {
    System.out.println("--》》" + new Rexmatch().isMatch("a", "ab*a"));
  }

    /**
     *
     * @param s  原始串
     * @param p 带星号啥的
     * @return
     */
    public boolean isMatch(String s, String p) {

        int ls = s.length(), lp = p.length();
        boolean[][] dp = new boolean[ls + 1][lp + 1];  //
        dp[0][0]  = true;

        //初始化第一行
        for(int j=2;j<=lp;j++){
            dp[0][j] =   dp[0][j-2] &&  p.charAt(j-1)== '*';

      System.out.println(dp[0][j]);
        }

        for(int i = 1; i <= ls; i++) {
            for(int j = 1; j <= lp; j++) {

                int m = i - 1, n = j - 1;
                if(p.charAt(n) == '*'){
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] && (s.charAt(m) == p.charAt(n - 1) || p.charAt(n - 1) == '.');

                }else if( s.charAt(m) == p.charAt(n) || p.charAt(n) == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }


            }
        }

return   dp[ls][lp];

      }



}
