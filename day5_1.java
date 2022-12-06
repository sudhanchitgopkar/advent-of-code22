import java.util.*;
import java.io.*;

public class day5_1 {
    public static void main (String [] args) {
	try {
	    Scanner in = new Scanner(new File("input/day5_2.txt"));
	    String currLine = "";
	    List<Deque <Character>> crates = new ArrayList<> ();
	    for (int i = 0; i < 9; i++) crates.add(new LinkedList <Character> ());
	    
	    while (in.hasNextLine()) {
		currLine = in.nextLine();
		if (currLine.charAt(0) != '[') break;
		for (int i = 0; i < 9; i++) {
		    char curr = currLine.charAt(1 + (4 * i));
		    if (curr != ' ') crates.get(i).offerLast(curr);
		} //for
	    } //while

	    while (in.hasNextLine()) {
		currLine = in.nextLine();
		if (currLine.length() > 0 && currLine.charAt(0) == 'm') break; 
	    }

	    do {
		int offset = currLine.charAt(6) == ' ' ? 0 : 1;
		int mvAmt = Integer.parseInt(currLine.substring(5,6 + offset));
		int from = Integer.parseInt(currLine.substring(12 + offset,13 + offset));
		int to = Integer.parseInt(currLine.substring(currLine.length()-1));

		for (int i = 0; i < mvAmt; i++) crates.get(to-1).offerFirst(crates.get(from-1).pollFirst());

		currLine = in.hasNextLine() ? in.nextLine() : null;
	    } while (currLine != null);

	    String sol = "";
	    for (Deque crate : crates) if (!crate.isEmpty()) sol += crate.peekFirst();
	    System.out.println(sol);
	} catch (FileNotFoundException fnfe) {
	    System.out.println(fnfe);
	} //try
    } //main
} //class
