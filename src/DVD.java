
public class DVD extends Movie {

	int state = 0;
	int cur_rent = 0;
	int cnt = 0; 
	Member m;

	int copy = 0;

	public DVD(String title, String starring, String director, String genre, String classification, int duration,
			int releaseDate, int copy) {
		// TODO Auto-generated constructor stub
		super(title, starring, director, genre, classification, duration, releaseDate);
		this.copy = copy;

	}

	public boolean checkOut() {

		if (cur_rent <= copy) {

			this.cur_rent += 1;
			this.cnt += 1;
			this.copy -= 1;

			return true;
		}
		
		return false;

	}

	public void checkIn() {
		this.cur_rent -= 1;
		this.copy += 1;

	}

}
