
public class Person {

    private String ID;
	private String firstname;
	private String lastname;
	private HealthProfile hProfile;
	
	public Person(String fname, String lname, HealthProfile hp, String id) {
		this.setFirstname(fname);
		this.setLastname(lname);
        this.setID(id);
		this.hProfile=hp;
	}
	public Person(String fname, String lname) {
		this.setFirstname(fname);
		this.setLastname(lname);
		this.hProfile=new HealthProfile();
	}
    public Person(String id) {
        this.setID(id);
        this.hProfile=new HealthProfile();
    }
	public Person() {
		this.hProfile=new HealthProfile();
	}

	public String getFirstname(){
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public HealthProfile gethProfile() {
		return hProfile;
	}
	public void sethProfile(HealthProfile hProfile) {
		this.hProfile = hProfile;
	}

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString(){
        return String.format("%s %s %s",this.getID(), this.getFirstname(), this.getLastname());
    }
}
