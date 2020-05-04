import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> elevi = new ArrayList<String>();
		elevi.add("radu");elevi.add("radu");elevi.add("vasi");elevi.add("vasi");
		
		List<String> materii = new ArrayList<String>();
		materii.add("info");materii.add("mate");materii.add("chim");materii.add("fiz");
		
		List<Integer> note = new ArrayList<Integer>();
		note.add(10);note.add(9);note.add(7);note.add(8);
		
		MyList catalog = new MyList();
		catalog.add(elevi);catalog.add(materii);catalog.add(note);
		
/*		|elev|disc|nota|
		-----------------
		|radu|info| 10 |
		-----------------
		|radu|mate|  9 |
		-----------------
		|vasi|chim|  7 |
		-----------------*/
		
		System.out.print(catalog.Select("0,2").Where("vasi").Group(1, 0));
		

	}

}
