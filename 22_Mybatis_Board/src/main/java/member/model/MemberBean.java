package member.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberBean {
	
	private final String message = " �Է� �ʼ�";
	
	@NotEmpty(message="���̵�"+message)
	private String id;
	
	@NotEmpty(message="�̸�"+message)
	private String name;
	
	@NotEmpty(message="��й�ȣ"+message)
	private String password;
	
	
	
	
	@NotNull(message="���� ���� �ʼ�")
	private String gender; // radio
	
	@NotNull(message="��̴� �ּ� 1�� �̻� ����")
	private String hobby;
	
	private String job;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMessage() {
		return message;
	}

	public MemberBean(String id, String name, String password, String gender, String hobby, String job) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.hobby = hobby;
		this.job = job;
	}

	public MemberBean() {
		super();
	}
	
	
	
	
	
}