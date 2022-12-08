import java.util.*;
import java.io.*;

public class Node {
    private String name;
    private int fileSize;
    private Map <String, Node> subdirs;
    private Node parent;

    public Node(String name, Node parent) {
	this.name = name;
	fileSize = 0;
	subdirs = new HashMap <String, Node> ();
	this.parent = parent;
    } //constructor

    public String getName () {
	return name;
    } //getName

    public int getSize() {
	return fileSize;
    } //getSize

    public void setSize(int fileSize) {
	this.fileSize = fileSize;
    } //setSize

    public void addSubDir (Node subdir) {
	subdirs.put(subdir.getName(),subdir);
    } //addSubDir

    public Node getParent() {
	return parent;
    } //getParent

    public Node getSubDir(String subdir) {
	return subdirs.getOrDefault(subdir, null);
    } //getSubDir

    public boolean isLeaf() {
	return subdirs.size() == 0;
    } //isLeaf

    public Map <String, Node> getSubDirs() {
	return subdirs;
    } //getSubDirs
    
} //class
