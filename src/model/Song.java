package model;
// Added to allow package model to exist on GitHub
public class Song implements Comparable<Song>{
	private String path;
	public Song(String path) {
		this.path=path;
	}
	
	public String getPath() {
		return path;
	}
	
	public String toString()
	{
		return path;
	}
	
	@Override
	public int compareTo(Song o) {
		if(this.getPath().equals(o.getPath()))
			return 0;
		return 1;
	}
}