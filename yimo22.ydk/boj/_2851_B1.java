import java.util.*;

public class _2851_B1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[10];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}

		// 최대한 100에 가깝게 만듬
		// 100에 가까운 수가 2개라면, 큰값을 선택
		// 중간에 멈출경우 더이상 버섯을 먹을 수 없음
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			// i번쨰 것을 집는 다고 생각
			int nextSum = sum + arr[i];
			if(Math.abs(nextSum - 100) <= Math.abs(sum - 100)) sum += arr[i];
			else break;
		}
		System.out.println(sum);
	}

}
