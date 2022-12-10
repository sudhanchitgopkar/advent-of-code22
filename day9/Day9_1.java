import java.util.*;
import java.io.*;

public class Day9_1 {
    public static void main (String [] args) {
	try {
	    Scanner in = new Scanner (new File("in.txt"));
	    HashSet <String> seen = new HashSet<> ();

	    int hx = 0, hy = 0, tx = 0, ty = 0;
	    
	    while (in.hasNextLine()) {
		String [] cmd = in.nextLine().split(" ");
		char dir = cmd[0].charAt(0);
		int steps = Integer.parseInt(cmd[1]);

		
		for (int i = 0; i < steps; i++) {
		    int prevHx = hx, prevHy = hy;
		
		    seen.add(tx + "," + ty);

		    switch (dir) {
			
		    case 'R':
			hx += 1;
			break;
		    case 'L':
			hx -= 1;
			break;
		    case 'U':
			hy += 1;
			break;
		    case 'D':
			hy -= 1;
			break;
		    }
		
		    
		    if (hx == tx && hy == ty) continue; //H and T are overlapping
		    else if ((Math.abs(hx-tx) < 2 && hy == ty) || (hx == tx && Math.abs(hy-ty) < 2)) continue;
		    else if (Math.abs(hx-tx) < 2 && Math.abs(hy-ty) < 2) continue;

		    tx = prevHx;
		    ty = prevHy;
		    seen.add(tx + "," + ty);
		} //for
	    } //while

	    System.out.println(seen.size());
	    
	} catch (FileNotFoundException fnfe) {

	} //try
    } //main
} //class
