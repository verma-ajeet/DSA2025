
public class SearchAnElementInSortedAndRotatedArray {
	public static void main(String[] args) {
		int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int k = 3;
		int n = arr.length;
		int index = getIndex(arr, 0, n-1, k);
		System.out.println(index);
	}

	private static int getIndex(int[] arr, int l, int r, int key) {
		if (l > r) {
			return -1;
		}
		int mid = (l + r) / 2;
		if (arr[mid] == key) {
			return mid;
		}
		if (arr[l] <= arr[mid]) {
			if (key >= arr[l] && key <= arr[mid]) {
                return getIndex(arr, l, mid-1, key);
			}else {
				return getIndex(arr, mid+1, r, key);
			}
		}
		if(key>=arr[mid] && key<=arr[r]) {
			return getIndex(arr, mid+1, r, key);
		}
		return getIndex(arr, l, mid-1, key);
	}
}
