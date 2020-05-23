package pojo;

public final class PersonPojo {
	private String name;
	public PersonPojo(final String name,final int age) {
		this.name = name;
		this.age = age;
	}
	public PersonPojo() {
		
	}
	private int age;
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final int getAge() {
		return age;
	}
	public final void setAge(int age) {
		this.age = age;
	}
	
}
