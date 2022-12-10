import java.util.*;
import java.io.*;

public class Day9_2 {
    public static void main (String [] args) {
	try {
	    Scanner in = new Scanner (new File("test.txt"));
	    HashSet <String> seen = new HashSet<> ();
	    
	    int hx, hy, tx, ty, prevHx = 0, prevHy = 0;
	    String [] knots = new String [10];
	    for (int i = 0; i < knots.length; i++) knots[i] = "0,0";

	    while (in.hasNextLine()) {
		String [] cmd = in.nextLine().split(" ");
		char dir = cmd[0].charAt(0);
		int steps = Integer.parseInt(cmd[1]);

		
		for (int i = 0; i < steps; i++) {
		    hx = Integer.parseInt(knots[0].split(",")[0]); 
		    hy = Integer.parseInt(knots[0].split(",")[1]); 
		    
		    tx = Integer.parseInt(knots[1].split(",")[0]); 
		    ty = Integer.parseInt(knots[1].split(",")[1]); 
		    
		    prevHx = hx;
		    prevHy = hy;
		    
		    seen.add(knots[9]);
		    
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
	    
		    knots[0] = (hx + "," + hy);

		    for (int j = 0; j < knots.length-1; j++) {
			hx = Integer.parseInt(knots[j].split(",")[0]); 
			hy = Integer.parseInt(knots[j].split(",")[1]); 
			tx = Integer.parseInt(knots[j+1].split(",")[0]); 
			ty = Integer.parseInt(knots[j+1].split(",")[1]); 

			if (hx == tx && hy == ty) continue; //H and T are overlapping
			else if ((Math.abs(hx-tx) < 2 && hy == ty) || (hx == tx && Math.abs(hy-ty) < 2)) continue;
			else if (Math.abs(hx-tx) < 2 && Math.abs(hy-ty) < 2) continue;
			int tempX = tx, tempY = ty;
			tx = prevHx;
			ty = prevHy;
			prevHx = tempX;
			prevHy = tempY;
			knots[j+1] = (tx + "," + ty);
		    }
		    seen.add(knots[9]);
		} //for
	    } //while

	    System.out.println(seen.size());
	    
	} catch (FileNotFoundException fnfe) {

	} //try
    } //main
} //class
