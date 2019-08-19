public class BitonicBinarySearch {
    public int search(int[] array, int target) {
        // bitonic 双调
        if (array.length == 0) {
            return -1;
        }
        int peakIndex = findPeak(array);
        if (target > array[peakIndex]) {
            return -1;
        }
        int a = binarySearch(array,0,peakIndex,target,true);
        int b = binarySearch(array,peakIndex,array.length-1,target,false);
        return Math.max(a,b);
    }

    private int findPeak(int[] array) {
        int l = 0;
        int r = array.length - 1;
        while (l < r-1) {
            int mid = l + (r-l) / 2;
            if (array[mid-1] > array[mid]) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (array[l] > array[r]) {
            return l;
        }
        return r;
    }

    private int binarySearch(int[] array, int start, int end,int target,boolean ascending) {
        int l = start;
        int r = end;
        while (l<=r) {
            int mid = l + (r-l) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (!ascending ^ array[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return -1;
    }
}
