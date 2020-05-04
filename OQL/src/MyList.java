import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MyList<T> extends ArrayList<T> {
	///coloanele de afisat
	static int[] n; 
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
		for(int i=0; i<n.length;i++)
			arr.add(this.get(n[i]));

		return (MyList<T>) arr;
	}
	
	public <T> List<Integer> findIf(T t)
	{
		List<Integer> index=new ArrayList<Integer>(); //acolo unde vrem sa pozitionam indexul
		///parcurgem toate sub-colectiile sa cautam cuv.
		for(int i=0; i<this.size() ;i++)
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
	
	public <T> MyList<T> Where(T t)
	{	///ce intoarce Where()
		MyList<T> myarr=new MyList<T>();
		///parcurgem numai sub-colectiile(coloane) precizate in select ca sa adaugam elemente
		for(int i=0; i<this.size();i++)
		{
			List<T> tmp = (List<T>) this.get(i);
			List<T> arr = new ArrayList<T>();
			for (Integer id : findIf(t))
				arr.add(tmp.get(id));///<adauga din fiecare lista elementul de pe randul corespunzator
			myarr.add((T) arr);
		}
		return myarr;
	}
	
	public <T> MyList<T> Group(int col1, int col2)
	{
		n=new int[]{col1,col2};
		MyList<T> arr=new MyList<T>();
		List<Double> dbl = new ArrayList<Double>();
		List<T> grp = (List<T>) this.get(col2);
		Set<T> unique = new HashSet<T>(grp);
		Iterator<T> it = unique.iterator();//pentru fiecare sub-lista
		int p=0;
		while(it.hasNext())
		{
			dbl.add(Sum(it.next(),col1));
			p++;
		}
		arr.add((T) new ArrayList<T>(unique));//pt Having...
		arr.add((T) dbl);
			
		
		return arr;
		
	}
	public <T> double Sum(T t, int col)
	{
		List<T> agr = (List<T>) this.get(col);
		Iterator<T> it = agr.iterator();//pentru fiecare sub-lista
		int p=0;
		int sum=0;
		while(it.hasNext())
		{
			T tp = it.next();
			for(int i : findIf(t))
				if (p==i)
					sum+=Double.valueOf(tp.toString());
			p++;
			
		}
		return sum;
	}
}

