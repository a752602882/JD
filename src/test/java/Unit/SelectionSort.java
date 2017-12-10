package Unit;

import org.testng.annotations.Test;

public class SelectionSort  {


    private  SelectionSort(){}


    public static  void sort(Comparable[] arr){

        int  n = arr.length;
        for (int i =0;i<n;i++){
            int minIndex = i;
            for(int j=i+1;j<n;j++)
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            swap(arr, i, minIndex);
        }

    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    @Test
    private void testSort(){
        Integer [] a={1,24,5,6,5,33,6,7,9,9,5,0};
        sort(a);
        for( int i = 0 ; i < a.length ; i ++ ){
            System.out.print(a[i]);
            System.out.print(' ');
        }


       String[] b =new String[]{"胡萝卜" ,"胡椒" ,"胡姬花花椒油","胡萝卜素" ,"胡椒研磨器"," 胡姬花","胡椒粉" ,"胡辣汤" ,"胡须刀" ,"胡麻油" };
        sort(b);
        for( int i = 0 ; i < b.length ; i ++ ){
            System.out.print(b[i]);
            System.out.print(' ');
        }
    }
}
