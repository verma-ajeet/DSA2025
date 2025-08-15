package array;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.print("max area is 49 = ");
		getContainer(arr);
	}

	private static void getContainer(int[] wall) {
		int n = wall.length;
		int maxArea = 0, left = 0, right = n-1;
		while (left < right) {
			int h = Math.min(wall[left], wall[right]);
			int w = right - left;
			int area=h*w;
			maxArea=Math.max(maxArea, area);
			if(wall[left]<wall[right]) {
				left++;
			}else {
				right--;
			}
		}
		System.out.println(maxArea);
	}
}
