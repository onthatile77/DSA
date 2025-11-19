package myproject;

public class MyArrayList<E>{
	
	private int size;
	private E[] data;
	private int MAXELEMENTS = 100;
	@SuppressWarnings("unchecked")
	public MyArrayList()
	{
		size=0;
		data = ((E[])new Object[MAXELEMENTS]);
	}
	
	public void add(int index, E e)
	{
		if (index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException("Out of bounds\nsize:" + size + "\nindex: " + index);
		}
		
		for(int i = size; i >= index;i--)
		{
			data[i+1] = data[i];
		}
		data[index] = (E)e;
		size++;
	}
	
	public boolean checkSpace()
	{
		if(this.size() < MAXELEMENTS)
		{
			return true;
		}
		return false;
	}
	
	public E remove(int index)
	{
		if (index < 0 || index > size || size == 0)
		{
			throw new IndexOutOfBoundsException("Out of bounds: " + size);
		}
		
		E tmp = data[index];
		for(int i = index; i < size; i++)
		{
			data[i] = data[i+1];
		}
		data[size-1] = null;
		size--;
		
		return tmp;
	}
	
	
	
	public E remove(Object e)
	{
		if (size == 0)
		{
			throw new IndexOutOfBoundsException("Out Of Bounds: " + size);
		}
		
		for(int i = 0; i<size;i++)
		{
			if (e.equals(data[i]))
			{
				E tmp = data[i];
				for(int k = i; k < size; k++)
				{
					data[k] = data[k+1];
				}
				data[size-1] = null;
				size--;
				
				return tmp;
				
			}
		}
		
		return null;
	}
	
	
	
	public E get(int index)
	{
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException("Out Of Bounds: "+ index);
		}
		
		return data[index];
	}
	
	public String toString()
	{
		String result = "[";
		for(int i = 0; i < size; i++)
		{
			result += data[i];
			if(i < size-1)
			{
				result += ", ";
			}
		}
		return result + "]";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean sortList() 
	{
		boolean isSorted = false;
	   
	   	E hold;
	   	for(int i = 0; i < size-1; i++) 
	   	{
	   		for(int k = 0; k < size-1; k++)
	   		{
	   			if(((Comparable)data[k]).compareTo(data[k+1]) > 0)
	   			{
	   				hold = data[k];
	   				data[k] = data[k+1];
	   				data[k+1] = hold;
	   				isSorted = true;
	   			}
	   		}
	   	}
	   	
	   	return isSorted;
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	public boolean contains(Object e)
	{
		
		for(int i = 0; i < size();i++)
		{
			if(((Comparable)data[i]).compareTo(e) == 0)
			{
				 return true;
			}
		}
		return false;
	 }
	 
	 public void clear()
	 {
		 size = 0;
	 }
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	public MyArrayList<E> filter (E low, E high)
	{
		if (((Comparable)low).compareTo(high) > 0)
		{
			return null;
		}
		MyArrayList<E> filtered = new MyArrayList<>();
		int fInd = 0;
		for(int i = 0; i < size;i++)
		{
			if (((Comparable)data[i]).compareTo(low) >= 0 && ((Comparable)data[i]).compareTo(high) <= 0)
			{
				filtered.add(fInd, data[i]);
				fInd++;
			}
		}
		
		return filtered;
	}
	
	public int size()
	{
		return size;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public MyArrayList<E> merge(MyArrayList<E> param)
	{
		int t = 0,p = 0,r = 0;
		
		if (param.size() == 0  && this.size() == 0)
		{
			return null;
		}
		if (param.size() == 0)
		{
			return this;
		}
		if (this.size() == 0)
		{
			return param;
		}
		
		MyArrayList<E> result = new MyArrayList<>();
		
		
		while(t < this.size() && p < param.size())
		{
			if(((Comparable)this.data[t]).compareTo(param.data[p]) < 0)
			{
				result.add(r, this.data[t]);
				t++;
				r++;
			}
			else
			{
				result.add(r, param.data[p]);
				r++;
				p++;
			}
		}
		
		if(t <= this.size() - 1)
		{
			for(; t<this.size();t++)
			{
				result.add(r, this.data[t]);
				r++;
			}			
		}
		if (p <= param.size() - 1)
		{
			for(;p<param.size();p++)
			{
				result.add(r, param.data[p]);
				r++;
			}
		}
		
		return result;
	}
	
	public int binarySearch(E key)
	{
		int low = 0;
		int high = this.size() - 1;
		return binarySearch(key, low, high);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int binarySearch(E key, int low, int high)
	{
		if (low > high)//low mus be <= high
		{
			return -low - 1;
		}
		
		int mid = (low+high)/2;//get root of tree(mid element)
		
		
		if(((Comparable)data[mid]).compareTo(key) > 0)
		{
			//go left
			return binarySearch(key, low, mid-1);
		}
		else if(((Comparable)data[mid]).compareTo(key) < 0)
		{
			//go right
			return binarySearch(key, mid+1, high);
		}
		else
		{
			return mid;
		}
		
		
		
	}
	
	
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArrayList<Integer> list = new MyArrayList<>();
		
		list.add(0, new Integer(7));
		list.add(1, new Integer(9));
		list.add(2, new Integer(3));
		list.add(3, new Integer(6));
		//System.out.println(list.toString());
		list.add(2, new Integer(10));
		System.out.println(list.toString());
		
		MyArrayList<Integer> filtered = new MyArrayList<>();
		filtered = list.filter(4, 10);
		System.out.println("filtered" + " : " + filtered.toString());
		
		MyArrayList<Integer> param = new MyArrayList<>();
		
		param.add(0, new Integer(0));
		param.add(1, new Integer(1));
		param.add(2, new Integer(8));
		param.add(3, new Integer(11));
		
		boolean isSorted = list.sortList();
		boolean isSorted2 = param.sortList();
		
		System.out.println("Sorted" + " : " + list.toString());
		System.out.println("Sorted2" + " : " + param.toString());
		
		filtered = list.merge(param);
		System.out.println("Merged" + " : " + filtered.toString());
		int key = filtered.binarySearch(4);
		
		System.out.println("Key: " + key);
		
		list.remove(1);
		System.out.println("with index: " + list.toString());
		
		//E e = new Integer(10);
		
		int removed = list.remove(new Integer(10));
		System.out.println("with element = " + removed + ":" + list.toString());
		boolean isSorted3 = list.sortList();
		
		System.out.println("Sorted = " + isSorted3 + " : " + list.toString());
		

		//MyArrayList<E> filtered = new MyArrayList<>();
		filtered = list.filter(0, 6);
		System.out.println("filtered" + " : " + filtered.toString());
		
		
		
		
		
	
		
	}

}
