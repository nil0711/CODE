public class bubble_sort {
    public static void main(String[] args) {
        int arr[]={1,8,4,7,3,7,4};
        //bubble sort
        //time complexity = O(n^2)
        for(int i=0; i< arr.length-1;i++){
            for(int j=0; j< arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    //swap
                    arr[j]=arr[j]^arr[j+1];
                    arr[j+1]=arr[j]^arr[j+1];
                    arr[j]=arr[j]^arr[j+1];

                }
            }
        }
        for (int a:arr) {
            System.out.print(a+" ");
        }
    }
}
