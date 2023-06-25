public class selection_sort {
    public static void main(String[] args) {
        int arr[]={4,8,1,9,0,4,6,8};

//        selection sort
//        time complexity =O(n^2)
        for (int i=0; i< arr.length-1;i++){
            int smallest = i;
            for (int j=i+1;j<arr.length;j++){
                if(arr[smallest]>arr[j]){
                    smallest=j;
                }
            }
            arr[smallest]=arr[smallest]^arr[i];
            arr[i]=arr[smallest]^arr[i];
            arr[smallest]=arr[smallest]^arr[i];
        }
        for (int a:arr) {
            System.out.print(a+" ");
        }
    }
}
