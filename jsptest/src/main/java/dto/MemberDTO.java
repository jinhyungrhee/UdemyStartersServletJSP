package dto;

//MemberDTO : Member 테이블 컬럼들 변수로 변경
// 다른 클래스에서 사용하도록 public setter / getter 메서드 필요
public class MemberDTO {
	
	// html form(= name 속성값 == parameter명) 입력 -- dto(변수명) -- db table(컬럼명)
	
	String id, pw, name, email, phone, address, indate;
	// 자바      - int, double, date, String 
	// maria db - int, double, datetime, char/varchar 
	// => 어떤 타입이든 전부 String 타입으로 가져와도 됨(maria db -> Java)
	// 함수사용하면 전부 String으로 변환됨 (hire_Date, "%Y")
	
	public MemberDTO() {}
	
	public MemberDTO(String id, String name, String indate) {
		super();
		this.id = id;
		this.name = name;
		this.indate = indate;
	}
	
	public MemberDTO(String id, String pw, String name, String email, String phone, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public MemberDTO(String id, String pw, String name, String email, String phone, String address, String indate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.indate = indate;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	// pw는 암호화된 정보 가져와도 됨
	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	// ============================

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + " , indate= " + indate + "]";
	}
	
	
	

}
