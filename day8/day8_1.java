import java.util.*;
import java.io.*;

public class day8_1 {
    public static void main (String [] args) {
	try {
	Scanner in = new Scanner(new File("../input/day8_2.txt"));
	Scanner lineCounter = new Scanner(new File("../input/day8_2.txt"));

	int lineCount = 0, row = 0, sol = 0, lineLen = 0;
	while (lineCounter.hasNextLine()) {
	    lineCount++;
	    //lineCounter.nextLine();
	    lineLen = lineCounter.nextLine().length();
	} //while
	int [][] mat = new int [lineCount][99];

	while (in.hasNextLine()) {
	    String line = in.nextLine();
	    for (int i = 0; i < line.length(); i++) {
		mat[row][i] = Integer.parseInt(line.substring(i,i+1));
	    } //for
	    row++;
	} //while

	/*
	for (int i = 0; i < mat.length; i++) {
	    for (int j = 0; j < mat[0].length; j++) {
		System.out.print(mat[i][j] + ",");
	    }
	    System.out.println();
	}
	*/
	for (int i = 0; i < mat.length; i++) {
	    for (int j = 0; j < mat[0].length; j++) {
		/*if (vis(mat[i][j],i,j,mat,-1,0, true) ||
		    vis(mat[i][j],i,j,mat,1,0, true) ||
		    vis(mat[i][j],i,j,mat,0,-1, true) ||
		    vis(mat[i][j],i,j,mat,0,1, true))
		    sol++;
		*/
		int viewDist = (vis(mat[i][j],i,j,mat,-1,0,true,0) *
				vis(mat[i][j],i,j,mat,1,0,true,0) *
				vis(mat[i][j],i,j,mat,0,-1,true,0) *
				vis(mat[i][j],i,j,mat,0,1,true,0));
		
		System.out.println("[" + i + "," + j + "]\tView:" + viewDist);
		
		sol = sol < viewDist ? viewDist : sol;
	    }
	} 

      
	System.out.println(sol);
    } catch (FileNotFoundException fnfe) {
	System.out.println("Fuck off");
    } //try
    } //class

    /*
    public static boolean dfs(int prev, int x, int y, int [][] mat, HashSet<String> seen) {
	if ((mat[x][y] >= prev && seen.size() != 0) || seen.contains(x + "," + y)) return false; 
	if (x == 0 || x == mat.length - 1 || y == 0 || y == mat[0].length - 1) return true;
	int curr = mat[x][y];
	seen.add(x + "," + y);
	return dfs(curr, x-1,y,mat, seen) ||
	    dfs(curr, x+1,y,mat, seen) ||
	    dfs(curr, x,y-1,mat, seen) ||
	    dfs(curr, x,y+1,mat, seen);
    } //dfs
    */

    public static boolean vis(int prev, int x, int y, int[][] mat, int e, int n, boolean isFirst) {
	if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length) return true;
	if (mat[x][y] >= prev && !isFirst) return false;
	return vis(prev,x+e,y+n,mat,e,n, false); 
    } //vis

    
    public static int vis(int prev, int x, int y, int[][] mat, int e, int n, boolean isFirst, int dist) {
	if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length) return dist - 1;
	if (mat[x][y] >= prev && !isFirst) return dist;
	return vis(prev,x+e,y+n,mat,e,n, false, 1 + dist); 
    } //vis

} //main
