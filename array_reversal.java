import java.util.*;

public class array_reversal{
	public static void main(String[] args){
		int arr[]={10,18,15,36,24,50,38,49};
		
		for(int i=0;i<4;i++){
		arr[0+i]=arr[0+i]^arr[7-i];
		arr[7-i]=arr[0+i]^arr[7-i];
		arr[0+i]=arr[0+i]^arr[7-i];
}
		for(int i:arr){
		System.out.print(i+" ");
}
		System.out.println();
}
}
