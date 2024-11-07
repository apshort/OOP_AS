public class MySort {

    //Selection Sort Algorithms

    public static void selectionSortIntArr(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int lowestIndex = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[lowestIndex]){
                    lowestIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[lowestIndex];
            arr[lowestIndex] = temp;

        }
    }

    public static void selectionSortStringArr(String[] arr){
        for(int i=0; i<arr.length-1; i++){
            int lowestIndex = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j].compareToIgnoreCase(arr[lowestIndex]) < 0){
                    lowestIndex = j;
                }
            }
            String temp = arr[i];
            arr[i] = arr[lowestIndex];
            arr[lowestIndex] = temp;

        }
    }

    public static void insertionSortIntArr(int arr[])
    {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

        /* Move elements of arr[0..i-1], that are
           greater than key, to one position ahead
           of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    // https://www.geeksforgeeks.org/insertion-sort-algorithm/
    // This code is contributed by Hritik Shah.
    // I changed it a little bit

    public static void insertionSortStringArr(String arr[])
    {
        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            int j = i - 1;

        /* Move elements of arr[0..i-1], that are
           greater than key, to one position ahead
           of their current position */
            while (j >= 0 && arr[j].compareToIgnoreCase(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

}


