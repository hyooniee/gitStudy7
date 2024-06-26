package member.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberBean {
	
	private final String message = " 입력 필수";
	
	@NotEmpty(message="아이디"+message)
	private String id;
	
	@NotEmpty(message="이름"+message)
	private String name;
	
	@NotEmpty(message="비밀번호"+message)
	private String password;
	
	
	
	
	@NotNull(message="성별 선택 필수")
	private String gender; // radio
	
	@NotNull(message="취미는 최소 1개 이상 선택")
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