package model;
// Added to allow package model to exist on GitHub
public class Song implements Comparable{
	private String path;
	public Song(String path) {
		this.path=path;
	}
	
	public String getPath() {
		return path;
	}
	
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}