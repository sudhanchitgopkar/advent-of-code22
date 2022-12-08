import java.util.*;
import java.io.*;

public class day7_1 {
    public static void main (String [] args) {
	Node curr = null;
	String [] currLine;
	int sol = 0;

	System.out.flush();
	try {
	    Scanner in = new Scanner (new File("../input/day7_1.txt"));

	    while (in.hasNextLine()) {
		currLine = in.nextLine().split(" ");
		
		if (currLine.length == 3) { //CD command
		    if (currLine[2].equals("..")) {
			curr = curr.getParent();
		    } else if (currLine[2].equals("/")) {
			if (curr == null) curr = new Node("/",null);
			while (curr.getParent() != null) {
			    curr = curr.getParent();
			} //while
		    } else {
			curr = curr.getSubDir(currLine[2]);
		    } //if
		} else if (!currLine[0].equals("$")) {
		    if (!currLine[0].equals("dir")) {
			curr.setSize(curr.getSize() + Integer.parseInt(currLine[0]));
		    } else {
			Node subdir = new Node(currLine[1],curr);
			curr.addSubDir(subdir);
		    } //if
		} //if
	    } //while

	    while (curr.getParent() != null) curr = curr.getParent();
	    calcSize(curr);
	    System.out.println("Part 1: " + calcTotalSize(curr));
	    System.out.println("Part 2: " + delete(curr, curr, Integer.MAX_VALUE));
	} catch (FileNotFoundException fnfe) {
	    System.out.println(fnfe);
	} 
    } //main

    public static int calcSize(Node root) {
	
	int total = root.getSize();;
	if (!root.isLeaf()) {
	    for (String subdir : root.getSubDirs().keySet()) {
		total += calcSize(root.getSubDir(subdir));
	    } //for
	} //if

	root.setSize(total);
	return total;
    } //calcSize

    
    public static int delete(Node curr, Node root, int min) {
	if (curr.getSize() >= (30000000 - (70000000 - root.getSize())) && curr.getSize() < min) min = curr.getSize();
	if (!curr.isLeaf()) {
	    for (String subdir : curr.getSubDirs().keySet()) {
		min = delete(curr.getSubDir(subdir), root, min);
	    } //for
	} //if
	
	return min;
    } //calcSize

    
    public static int calcTotalSize(Node root) {
	int total = 0;
	if (root.isLeaf()) {
	    total += root.getSize() <= 100000 ? root.getSize() : 0;
	} else {
	    total += root.getSize() <= 100000 ? root.getSize() : 0;
	    for (String subdir : root.getSubDirs().keySet()) {
		total += calcTotalSize(root.getSubDir(subdir));
	    } //for
	} //if

	return total;
    } //calcSize

} //class
