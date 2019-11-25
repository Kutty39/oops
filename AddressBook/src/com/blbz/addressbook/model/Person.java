package src.com.blbz.addressbook.model;
/*
 * purpose : created class for person details
 */
public class Person {
	private String fName;
	private String lName;
	private long phonNo;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public long getPhonNo() {
		return phonNo;
	}

	public void setPhonNo(long phonNo) {
		this.phonNo = phonNo;
	}

	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + ", phonNo=" + phonNo + "]";
	}

}
