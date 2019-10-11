import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YanghuiAngile {

  public static void main(String[] args) {

      System.out.println("请输入行数");
      Scanner scanner =  new Scanner(System.in);
      int rowNums  = scanner.nextInt();
      System.out.println(generate(rowNums));



  }

  public static  List<List<Integer>> generate(int numRows){
      List<List<Integer>> res = new ArrayList<List<Integer>>();

      // 处理为0的场景
      if(numRows == 0 ){
          return res;
      }

      res.add(new ArrayList<Integer>());
      res.get(0).add(1);

      //处理大于1的场景

      for( int rowNum=1;rowNum <numRows;rowNum++){
          List<Integer>  preRow = res.get(rowNum -1);
          List<Integer>  curRow = new ArrayList<Integer>();

          //前后都加一
          curRow.add(1);
          for(int j=1;j<rowNum;j++){//遍历的时候从1开始，取上一个
              curRow.add(preRow.get(j-1)+preRow.get(j));  //这个取法就很巧妙，遍历上一行 恰好从节点一开始取数据

          }
          curRow.add(1);
            res.add(curRow);
      }

      return res;

  }

  public static  void  printList(List<List<Integer>>   res){
      for(List<Integer> nums :res){
      System.out.println(nums);
      }

  }


}
