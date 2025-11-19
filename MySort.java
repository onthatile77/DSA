package myproject;

public class MySort {
	
	
	public void mergeSort(int[] array)//divide
	{
		int length = array.length;
		if(length<=1)
		{
			return;
		}
		
		int mid = length/2;
		
		int[] left = new int[mid];
		int[] right = new int[length-mid];
		
		int l;
		int r=0;
		
		for(l=0;l<length;l++)
		{
			if(l<mid)
			{
				left[l] = array[l];
			}
			else
			{
				right[r] = array[l];
				r++;
			}
			
		}
		
		
		
		mergeSort(left);
		mergeSort(right);
		//merge(array, left, right);
	}
	
//	public void merge(int[] array, int[] left, int[] right)
//	{
//		
//	}
	
	
	
	public static void quickSort(int[] arr)
	{
		quickSort(arr, 0, arr.length-1);
	}
	
	public static void quickSort(int[] arr, int first, int last)
	{
		if(first<last)
		{
			int pivotIndex = partition(arr, first, last);
			quickSort(arr, first, pivotIndex-1);
			quickSort(arr,pivotIndex+1,last);
		}
	}
	
	public static int partition(int[] arr, int first, int last)
	{
		int pivot = arr[first];
		int low = first+1;
		int high = last;
		
		while(high > low)
		{
			while(low <= high && arr[low] < pivot)
			{
				low++;
			}
			while(low<=high && arr[high] >= pivot)
			{
				high--;
			}
			
			if(low<high)
			{
				int tmp = arr[low];
				arr[low]=arr[high];
				arr[high] = tmp;
			}
		}
		
		while(first<high && arr[high]>pivot)
		{
			high--;
		}
		if(arr[high]<pivot)
		{
			
			arr[first]=arr[high];
			arr[high] = pivot;
			return high;
		}
		else {
			return first;
		}
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {3,5,1,2,4,0};
		
		quickSort(arr);
		
		System.out.println("SORTED ");
		
		for(int i:arr)
		{
			System.out.print(i + " ");

		}
	}

}
