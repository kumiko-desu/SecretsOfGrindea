import java.util.Scanner;

public class List {
	public static void main(String[] args) {
		int result = 16;//写入结果
        int[] arr = { 2, 3, 2, 3, 2 , 2};//写入数字数组
        char[] sign = {'*','*','-','+','+'};//写入运算符号数组
        Scanner input = new Scanner(System.in);
        System.out.print("输入答案：");
        result = input.nextInt();
        System.out.print("输入数字（空格隔开）：");
        for (int i=0;i<6;i++) { 
        	arr[i] = input.nextInt();
        }
        System.out.print("输入运算符号（连续输入）：");
        String signs = input.next();
        for (int i=0;i<5;i++) { 
        	sign[i] = signs.charAt(i);
        }
        //System.out.println(sign);
        fullSort(arr, sign, 0, arr.length - 1, result);
    }
	public static int issign(int a, char cha, int b) {
		int c = 0;
		switch (cha)
		{
		case '+':c = a + b; break;
		case '-':c = a - b; break;
		case '*':c = a * b; break;
		case '/':c = a / b; break;
		}
		return c;
	}
    public static void fullSortc(int[] num, char[] arr, int start, int end,int result) {
        // 递归终止条件
    	//char[] sign = {'*','+','*','-'};
        if (start == end) {
        	calculate(num,arr,result);
            return;
        }
        for (int i = start; i <= end; i++) {
            swapc(arr, i, start);
            fullSortc(num, arr, start + 1, end,result);
            swapc(arr, i, start);
        }
    }
    private static void swapc(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
	public static void calculate(int[] arr,char[] sign, int result) {
		//char[] sign = {'*','+','*','-'};
		//运算符排序
		//写入运算结果
		if((issign(issign(issign(issign(issign(arr[0], sign[0] ,arr[1]),sign[1],arr[2]),sign[2],arr[3]),sign[3],arr[4]),sign[4],arr[5]))==result) {
			for (int i=0;i<5;i++) {
                System.out.printf("%d%c",arr[i],sign[i]);
                if (i==4) {
                	System.out.printf("%d",arr[5]);
                }
            }
			/*for (char j : sign) {
                System.out.print(j); 
            }*/
			System.out.println();
		}
	}
    public static void fullSort(int[] arr,char[] sign, int start, int end, int result) {
        // 递归终止条件
    	//char[] sign = {'-','*','-','+'};//写入运算符号数组
        if (start == end) {
        	fullSortc(arr, sign, 0, 4, result);
        	/*for (int i : arr) {
                System.out.print(i);
            }*/
            //System.out.println();
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(arr, i, start);
            fullSort(arr, sign ,start + 1, end, result);
            swap(arr, i, start);
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
