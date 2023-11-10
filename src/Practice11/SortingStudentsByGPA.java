package Practice11;

public class SortingStudentsByGPA {
    public static void quickSort(Comparator[] sortArr, int low, int high) {
        if (sortArr.length == 0 || low >= high) return;

        int middle = low + (high - low) / 2;
        Comparator border = sortArr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (sortArr[i].compareTo(border) > 0) i++;
            while (sortArr[j].compareTo(border) < 0) j--;
            if (i <= j) {
                Comparator swap = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = swap;
                i++;
                j--;
            }
        }

        if (low < j) quickSort(sortArr, low, j);
        if (high > i) quickSort(sortArr, i, high);
    }
}