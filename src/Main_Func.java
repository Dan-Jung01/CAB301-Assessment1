import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;

public class Main_Func {
	
	static String staff_id = "staff";
	static String staff_pwd = "today123";
	static Member memberLogin;
	static int memberid = -1;
	
	static boolean staffMenu = false;
	static boolean memberMenu = false;
	static boolean exit = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		String cur_mem_f_name= "";
		String cur_mem_l_name= "";
		
		int select = -1;
	
		MemberCollection memberList_c = new MemberCollection();
		MovieCollection movieList_c = new MovieCollection();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {

			if (select == -1) {
				System.out.println();
				System.out.println("Welcome to the Community Library");
				System.out.println("========Main Menu========");
				System.out.println(" 1. Staff Login");
				System.out.println(" 2. Member Login");
				System.out.println(" 0. Exit");
				System.out.println("=========================");
				System.out.println();
				System.out.println(" Please make a selection (1-2, or 0 to exit):");

				select = Integer.parseInt(br.readLine());

				if (select == 1) {
					System.out.println("Enter username: ");
					String user_id = br.readLine();
					System.out.println("Enter Password: ");
					String user_pwd = br.readLine();

					if (user_id.equals(staff_id) && user_pwd.equals(staff_pwd)) {
						select = 1;
					} else {
						System.out.println("Wrong ID or Password");
						select = -1;
						continue;
					}

				}

				else if (select == 2) {
					System.out.println("Enter username: (LastnameFirstname)");
					String member_id = br.readLine();
					
					int index = memberList_c.findMember(member_id);
					memberid = index;
					
					int member_pwd = -1;
					if (memberid != -1)
					{
					memberLogin = memberList_c.memberList[memberid];
					}
					do {
						
						System.out.println("Enter Password: ");
						try {
								member_pwd = Integer.parseInt(br.readLine());
						} catch (NumberFormatException e) {
							
							break;
						}
					} while (member_pwd != memberList_c.returnMember(index).pwd);
					
					if(member_pwd == -1) {
						System.out.println("Wrong ID or Password or Unregistered Member");
						select = -1;
						continue;
					}

				}
				
				else if(select == 0) {
					System.exit(0);
				}
				
			}
			
			// STAFF
			if (select == 1) {

				System.out.println("========Staff Menu========");
				System.out.println("1. Add a new movie DVD");
				System.out.println("2. Remove a movie DVD");
				System.out.println("3. Register a new member");
				System.out.println("4. Find a registered member's phone number");
				System.out.println("0. Return to main menu");
				System.out.println("=========================");
				System.out.println(" Please make a selection (1-5, or 0 to exit):");

				int select2 = Integer.parseInt(br.readLine());

				if (select2 == 1) {
					

					System.out.println("Enter the movie title: ");
					String title = br.readLine();
					System.out.println("Enter the starring actor(s): ");
					String actors = br.readLine();
					System.out.println("Enter the director(s): ");
					String director = br.readLine();

					System.out.println("Select the genre: ");
					String[] genres = MovieCollection.getGenres();

					for (int i = 0; i < genres.length; i++) {
						System.out.println((i + 1) + ". " + genres[i]);
					}

					System.out.println("Make selection(1-8): ");
					String genre = genres[Integer.parseInt(br.readLine()) - 1];

					System.out.println("Select the classification: ");
					String[] classfications = MovieCollection.getClassification();

					for (int i = 0; i < classfications.length; i++) {
						System.out.println((i + 1) + ". " + classfications[i]);
					}

					System.out.println("Make selection(1-4): ");
					String classification = classfications[Integer.parseInt(br.readLine()) - 1];

					System.out.println("Enter the duration (minutes): ");
					int duration = Integer.parseInt(br.readLine());

					System.out.println("Enter the release date (year): ");
					int releaseDate = Integer.parseInt(br.readLine());

					System.out.println("Enter the number of copies available: ");
					int copy = Integer.parseInt(br.readLine());

					movieList_c.addNode(
							new DVD(title, actors, director, genre, classification, duration, releaseDate, copy));
				}

				else if (select2 == 2) {

					System.out.println("Enter Remove Movie Title: ");
					String title = br.readLine();
					TreeNode nodeRemove = movieList_c.findNode(title);
					movieList_c.removeNode(nodeRemove.movie);
					try {
						movieList_c.removeNode(nodeRemove.movie);
					} catch (NullPointerException e) {
						
					}

				} else if (select2 == 3) {

					System.out.println("Enter member's first name: ");
					String f_name = br.readLine();
					System.out.println("Enter member's last name: ");
					String l_name = br.readLine();
					boolean pass = false;
					do {
					
					for (int i = 0; i < memberList_c.count; i++) {
						if (memberList_c.memberList[i].l_name.equals(l_name))
						{
							if (memberList_c.memberList[i].f_name.equals(f_name))
							{
									System.out.println("This member name is already existed. Please try again.");
									System.out.println("Enter member's first name: ");
									f_name = br.readLine();
									System.out.println("Enter member's last name: ");
									l_name = br.readLine();
									pass = false;
									break;
								}
							}
							pass = true;
						}
					} while (pass = false);
					
					
						System.out.println("Enter member's address: ");
						String address = br.readLine();
						System.out.println("Enter member's phone number: ");
						String p_number = br.readLine();
						int pwd = -1;
						do {
							System.out.println("Enter member's password(4 digits): ");
							pwd = Integer.parseInt(br.readLine());
						} while (pwd < 1000 || pwd > 9999);
						
						try {
							memberList_c.addMember(new Member(f_name, l_name, address, p_number, pwd));
						} catch (NullPointerException e) {
							
						}
						
						System.out.println("Successfully added " + f_name + " " + l_name);
					

				} else if (select2 == 4) {

					System.out.println("Enter member's first name: ");
					String f_name = br.readLine();
					System.out.println("Enter member's last name: ");
					String l_name = br.readLine();

					String check = memberList_c.get_phone_number(l_name, f_name);

					if (check.equals("False")) {
						System.out.println(f_name + " " + l_name + "is not existing member");
					} else {
						System.out.println(f_name + " " + l_name + "'s phone number is:" + check);
					}
				

				} else if (select2 == 0) {
					select = -1;
					continue;
				}

			}
			// MEMBER
			else {
				System.out.println("========Member Menu========");
				System.out.println("1. Display all movies");
				System.out.println("2. Borrow a movie DVD");
				System.out.println("3. Return a movie DVD");
				System.out.println("4. List current borrrowed movie DVDs");
				System.out.println("5. Display top 10 most popular movies");
				System.out.println("0. Return to main menu");
				System.out.println("=========================");
				System.out.println(" Please make a selection (1-5, or 0 to exit):");

				int select2 = Integer.parseInt(br.readLine());

				if (select2 == 1) {

					movieList_c.inOrderTraverseTree(movieList_c.root);

				} else if (select2 == 2) {

					System.out.println("Enter movie title: ");
					String b_title = br.readLine();
					
					DVD movieBorrow = movieList_c.findNode(b_title).movie;
					if (movieList_c.findNode(b_title) == null)
					{
						System.out.println("Sorry, we don't have this movie in store.");
						continue;
					}
					else if (movieBorrow.copy == 0)
					{
						System.out.println("We currently don't have copy for this movie in store.");
					}
					else if (movieBorrow.copy > 0)
					{
						System.out.println("Movie DVD borrowed.");
						movieBorrow.checkOut();
						memberLogin.moviesBorrowed.add(b_title);
						memberLogin.moviesCount++;
					}
					else if (memberLogin.moviesBorrowed.contains(movieBorrow))
					{
						System.out.println("Sorry, you can't borrow the same movie twice.");
					}
					else if (memberLogin.moviesBorrowed.size() >= 10) {
						System.out.println("You can't borrow more than 10 movies.");
					}
					
				} else if (select2 == 3) {
					System.out.println("Enter movie title: ");
					String m_title = br.readLine();
					DVD movieBorrow = movieList_c.findNode(m_title).movie;
					movieBorrow.checkIn();
					memberLogin.moviesBorrowed.remove(m_title);
					movieList_c.findNode(m_title).movie.cnt++;
					memberLogin.moviesCount--;
					System.out.println("Return successfully.");

				} else if (select2 == 4) {

					System.out.println("You are currently borrowing:");
					
					for(int i=0; i < memberLogin.moviesBorrowed.size(); i++) {
						System.out.println(memberLogin.moviesBorrowed.get(i));
					}
					


				} else if (select2 == 5) {
					movieList_c.storeinTraversal(movieList_c.root);
					movieList_c.sortTop10();
					movieList_c.printTop10();
				}

				else if (select2 == 0) {
					select = -1;
					continue;
				}
			}
		}
	}
}
