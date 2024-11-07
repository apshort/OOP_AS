public class Search {

    public static int linearSearch (String[] arr, String searchTerm){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase(searchTerm)){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int searchTerm){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = (start + end)/2;
            if (searchTerm == arr[mid]){
                return mid;
            } else if( searchTerm > arr[mid] ){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }//binarySearch

    public static int binarySearch(double[] arr, double searchTerm){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = (start + end)/2;
            if (searchTerm == arr[mid]){
                return mid;
            } else if( searchTerm > arr[mid] ){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }//binarySearch

    public static int binarySearch(String[] arr, String searchTerm){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = (start + end)/2;
            if (searchTerm.equalsIgnoreCase(arr[mid])){
                return mid;
            } else if( searchTerm.compareToIgnoreCase(arr[mid]) > 0){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }//binarySearch

}
