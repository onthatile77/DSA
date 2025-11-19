package myproject;

public class MyLinkedList<E>
{
	
	private Node<E> head;
	private Node<E> tail;
	
	public MyLinkedList()
	{
		head = null;
		tail = null;
	}
	
	private static class Node<E>
	{
		E data;
		Node<E> next;
		
		public Node(E data)
		{
			this.data = data;
			next = null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void add(int index, Object e)
	{
		if (index < 0)
		{
			throw new IndexOutOfBoundsException("Index out of Bounds: " + index);
		}
		Node<E> node = new Node<>((E)e);
		if(index == 0)
		{
			if (head == null)
			{
				head = node;
				tail=head;
			}
			else
			{
				node.next = head;
				head = node;
			}
			
			return;
		}

		Node<E> curr= head;
		Node<E> prev = null;
		int i = 0;
		
		while(curr != null && i < index)
		{	
			prev = curr;
			curr= curr.next;
			i++;			
		}
		
		
		if (i != index)
		{		
			throw new IndexOutOfBoundsException("Out of Bounds: " + index);
		}
		prev.next = node;
		node.next = curr;
		for(curr = head; curr.next!=null;)
		{
			curr=curr.next;
		}
		tail=curr;
			
		return;	
		
	}
	
	public void prepend(Object e)
	{
		@SuppressWarnings("unchecked")
		Node<E> node = new Node<>((E)e);
		Node<E> curr;
		if(head == null)
		{
			head = node;
			tail = node;
			return;
		}
		else
		{
			node.next = head;
			head = node;
			
			for (curr=head;curr.next!=null;)
			{
				curr = curr.next;
				
			}
			tail=curr;
			return;
		}
		
		
		
	}
	
	public void append(Object e)
	{
		@SuppressWarnings("unchecked")
		Node<E> node = new Node<>((E)e);
		if (head == null)
		{
			head = tail = node;
		}
		else
		{
			tail.next = node;
			tail = node;
		}
		
	}
	
	public E getFirst()
	{
		if(head == null)
		{
			return null;
		}
		
		return head.data;
	}
	
	public E getLast()
	{
		if (head == null)
		{
			return null;
		}
		return tail.data;
	}
	
	public E delete(int index)
	{
		
		if(head == null || index < 0)
		{
			return null;
		}
		
		if (tail == head && index == 0)
		{
			E hold = head.data;
			tail = null;
			head = null;
			return hold;
		}
		Node<E> curr = head;
		Node<E> prev = head;
		E hold;
		int i;
		for(i = 0; i < index && curr != null; i++)
		{
			prev = curr;
			curr = curr.next;
			//after = curr.next;
		}
		if (i != index )
		{
			throw new IndexOutOfBoundsException("Out of bounds: " + "\nTarget: "+ index + "Current position" + i);
		}
		if(i == 0)
		{
			head = head.next;
		}
		hold = curr.data;
		prev.next = curr.next;
		
		for (curr=head;curr.next!=null;)
		{
			curr = curr.next;
			
		}
		tail=curr;
		return hold;
	}
	
	public E removeFirst()
	{
		E hold;
		if (head == null)
		{
			hold = null;
		}
		
		else
		{
			hold= head.data;
			head = head.next;
		}
		
		return hold;
	}
	
	public E removeLast()
	{
		E hold;
		if (head == null)
		{
			return null;
		}
		if(head==tail &&head!=null)
		{
			hold = tail.data;
			head = null;
			tail = null;
			return hold;
		}
		else
		{
			Node<E> curr = head, prev = head;
			for (;curr.next!=null;)
			{
				prev = curr;
				curr=curr.next;
			}
			hold = tail.data;
			prev.next = null;
			tail = prev;
			return hold;
		}
		
		
	}
	
	public String toString()
	{
		String result = "[";
		if (head == null)
		{
			return result += "]";
		}
		Node<E> curr;
		for(curr = head; curr!=null;curr=curr.next)
		{
			result += curr.data;
			if(curr.next!=null)
			{
				result += ", ";
			}
		}
		return result += "]";
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public MyLinkedList<E> filter(E low, E high)
	{
		if (((Comparable)low).compareTo(high) > 0)
		{
			return null;
		}
		MyLinkedList<E> result = new MyLinkedList<>();
		Node<E> curr;
		int index = 0;
		System.out.println(head.data);
		for (curr=head; curr!=null;curr=curr.next)
		{
			if(((Comparable)curr.data).compareTo(low) >= 0 && ((Comparable)curr.data).compareTo(high) <= 0)
			{
				result.add(index, curr.data);
				index++;
			}
		}
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void sortList()
	{
		
		if (head==null)
		{
			return;
		}
		E hold;
		Node<E> currOut;
		Node<E> currIn;
		
		for(currOut = head; currOut!=null;currOut=currOut.next)
		{
			for (currIn = head;currIn.next!=null;currIn=currIn.next)
			{
				if (((Comparable)currIn.data).compareTo(currIn.next.data) > 0)
				{
					hold = currIn.data;
					currIn.data = currIn.next.data;
					currIn.next.data = hold;
				}
			}
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MyLinkedList<E> merge(MyLinkedList<E> param)
	{
		
		if(this.head == null && param.head == null)
		{
			return null;
		}
		
		if (this.head == null)
		{
			return param;
		}
		if (param.head == null)
		{
			return this;
		}
		
		Node<E> t = this.head;
		Node<E> p = param.head;
		MyLinkedList<E> result = new MyLinkedList<E>();
		
		
		while(t!=null && p!=null)
		{
			if(((Comparable)t.data).compareTo(p.data) <= 0)
			{
				result.append(t.data);
				t=t.next;
			}
			
			else
			{
				result.append(p.data);
				p=p.next;
			}
		}
		
		if(t!=null)
		{
			while(t!=null)
			{
				result.append(t.data);
				t=t.next;
			}
		}
		if(p!=null)
		{
			while(p!=null)
			{
				result.append(p.data);
				p=p.next;
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] args)
	{
		MyLinkedList<Integer> list = new MyLinkedList<>();
		
		
		
		list.prepend(new Integer(11));
		
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.toString());
		
		list.removeFirst();
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.toString());
		
		list.removeLast();
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.toString());
		
		list.delete(0);
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.toString());
		
		list.add(0, new Integer(4));
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.toString());
		
		list.add(1, new Integer(8));
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.toString());
		
		list.add(1, new Integer(10));
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.toString());
		
		list.prepend(new Integer(101));
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.toString());
		
		
		
		
		MyLinkedList<Integer> filtered = list.filter(4, 10);
		System.out.println(filtered.getFirst());
		System.out.println(filtered.getLast());
		System.out.println("filtered: " + filtered.toString());
		
		
		list.append(new Integer(111));
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.toString());
		
		list.sortList();
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println("Sorted lst: " + list.toString());
		
		filtered.removeLast();
		filtered.removeLast();
		filtered.removeFirst();
		
		filtered.prepend(new Integer(5));
		filtered.prepend(new Integer(0));
		filtered.append(new Integer(55));
		filtered.prepend(new Integer(10));
		filtered.sortList();
		System.out.println(filtered.getFirst());
		System.out.println(filtered.getLast());
		System.out.println("Sorted flt: " + filtered.toString());
		
		System.out.println("\n\n");
		MyLinkedList<Integer> mergeList = list.merge(filtered);
		
		System.out.println(mergeList.getFirst());
		System.out.println(mergeList.getLast());
		System.out.println("Merged and sorted: " + mergeList.toString());

		
		
		list.delete(0);
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.toString());
		
		list.delete(3);
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.toString());
		
		list.removeLast();
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.toString());
		
		
		
		
		
		
	}
	
	

	
}
