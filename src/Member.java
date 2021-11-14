import java.util.ArrayList;

public class Member {

	String memberPhone; 
	String f_name, l_name, address, username;
	int pwd;
	int moviesCount = 0;
	//String moviesBorrowed[];
	ArrayList<String> moviesBorrowed = new ArrayList<>();

	public Member(String f_name, String l_name, String address, String memberPhone, int pwd) {
		// TODO Auto-generated constructor stub
		this.memberPhone = memberPhone;
		this.f_name = f_name;
		this.l_name = l_name;
		this.address = address;
		this.memberPhone = memberPhone;
		this.pwd = pwd;
		this.username = l_name + f_name;
	}
	
	public String getContact() {
			return memberPhone;
		}
}
