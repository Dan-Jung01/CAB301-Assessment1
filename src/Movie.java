
public class Movie {

	String title;
	String starring;
	String director;
	String genre;
	String classification;
	int duration;
	int releaseDate;

	public Movie(String title, String starring, String director, String genre, String classification, int duration,
			int releaseDate) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.starring = starring;
		this.director = director;
		this.genre = genre;
		this.classification = classification;
		this.duration = duration;
		this.releaseDate = releaseDate;
	}
	
	public String getTitle() {
		return title;
	}

}
