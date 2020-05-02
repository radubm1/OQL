import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class MyList<T> extends ArrayList<T> {
	static int[] n; //coloanele de afisat
	public MyList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int[] parseToInts(String no)
	{
		String[] parts = no.split(",");
		int[] n1 = new int[parts.length];
		for(int n = 0; n < parts.length; n++) {
		   n1[n] = Integer.parseInt(parts[n]);
		}
		return n1;
	}
	public MyList<T> Select(String cols)
	{
		this.n = parseToInts(cols);
		
		MyList<T> arr=new MyList<T>();
		for(int i=0; i<this.size();i++)
			arr.add(this.get(i));

		return (MyList<T>) arr;
	}
	
	public <T> List<Integer> findIf(T t)
	{
		List<Integer> index=new ArrayList<Integer>(); //acolo unde vrem sa pozitionam indexul

		for(int i=0; i<this.size() ;i++)//parcurgem toate sub-colectiile sa cautam cuv.
		{
			//System.out.println(this.get(i));
			List<T> tmp = (List<T>) this.get(i);
			Iterator<T> it = tmp.iterator();//pentru fiecare sub-lista
			int p=0;
			while(it.hasNext())
			{
				if (it.next().equals(t)){
					index.add(p);
				}
				p++;
			}
		}
		
		return index;	
	}
	
	public <T> List<T> Where(T t)
	{
		List<T> arr = new ArrayList<T>();//ce intoarce Where()
		
		for(int i=0; i<n.length ;i++)//parcurgem numai sub-colectiile(coloane) precizate in select ca sa adaugam elemente
		{
			List<T> tmp = (List<T>) this.get(n[i]);
			for (Integer id : findIf(t))
				arr.add(tmp.get(id));//adauga din fiecare lista elementul de pe randul corespunzator
		}
		return arr;
		
	}
}
