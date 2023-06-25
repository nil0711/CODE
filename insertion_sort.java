public class insertion_sort {
    public static void main(String[] args) {
        int arr[]={5,6,8,3,2,4,6,2,6,8,9};

//        insertion sort
//          time complexity =O(n^2)
        for (int i=1;i < arr.length;i++){
            int current= arr[i];
            int j=i-1;
            while (j>= 0&&current< arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            //placement
            arr[j+1]=current;
        }

        for (int a:arr) {
            System.out.print(a+" ");
        }
    }
}
