
public class SeacrhAnElement {
	public static void main(String[] args) {
		int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int k = 3;
		int n = arr.length;
		int index = getIndex(arr, 0, n - 1, k);
		System.out.println(index);
	}

	private static int getIndex(int[] arr, int left, int right, int key) {
		int mid=(left+right)/2;
		if(key==arr[mid]) {
			return mid;
		}
		if(arr[left]<arr[mid]) {
			if(key>=arr[left] && key<=arr[mid]) {
				return getIndex(arr, left, mid-1, key);
			}else {
				return getIndex(arr, mid+1, right, key);
			}
		}else {
			if(key>=arr[mid] && key<=arr[right]) {
				return getIndex(arr, mid+1, right, key);
			} else {
				return getIndex(arr, left, mid-1, key);
			}
		}
	}
}
