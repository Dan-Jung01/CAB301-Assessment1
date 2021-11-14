public class MemberCollection {

	public Member[] memberList;
	public int count = 0;
	public MemberCollection() {
		memberList = new Member[100];
	}
	
	public void addMember(Member m) {

		memberList[count] = m;
		count++;
	}
	
	public Member returnMember(int index) {
		return memberList[index];
	}
	
	public int findMember(String memberName) {
		try {
			int index = -1;
			for (int i = 0; i < memberList.length; i++) {
				if (memberList[i].username.equals(memberName)) {
					index = i;
					return index;
				}
			}
			return index;
		}catch(NullPointerException npe) {
			return -1;
		}
		
	}
	
	public String searchContact(String memberName) {
		int index = findMember(memberName);
		if (index != -1) {
			return memberList[index].getContact();
		}
		return null;
	}
	
	public String[] get_l_f_name(int idx) {
		
		String[] l_f_name = new String[2];
		
		for(int i = 0; i < memberList.length; i++) {
			l_f_name[0] = memberList[i].l_name;
			l_f_name[1] = memberList[i].f_name;
		}

		return l_f_name;
	}
	
	public int get_pwd(String l_name, String f_name) {
		
		for(int i = 0; i < memberList.length; i++) {
			if(l_name.equals(memberList[i].l_name) && f_name.equals(memberList[i].f_name)) {
				return memberList[i].pwd;
			}
		}
		
		return -1;
	}
	
	public String get_phone_number(String l_name, String f_name) {
		
		for(int i = 0; i < memberList.length; i++) {
			if(memberList[i].l_name.equals(l_name) && memberList[i].f_name.equals(f_name)) {
				
				return memberList[i].memberPhone;
			}
		}
		
		return "False";
		
	}
	
	public int getSize() {
		return memberList.length;
	}

}
