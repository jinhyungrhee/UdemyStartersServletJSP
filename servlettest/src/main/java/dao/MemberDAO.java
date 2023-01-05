package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dto.MemberDTO;

public class MemberDAO {
	
	// dto에 전달받은 내용을 가져와 member 테이블에 입력
	// 단, 회원가입일에 대한 정보는 없으므로 현재시간(now())을 넣어줌
	public int insertMember(MemberDTO dto) {
		
		
		
		// \ PrepareStatment 사용
		
		Connection con = null;
		PreparedStatement pt = null;
		int count = 0;
		
		MemberDTO selectedDto = getMember(dto.getId(), dto.getPw()); // 연결-해제 (try밖에 있어도 OK)
		

		// id 중복체크
		/*
		 * MemberDTO dto = getMember(id, pw);
		 * dto == null : insert 가능
		 * dto != null  : ID 중복 (insert 불가능)
		 * */
		if(selectedDto == null) {
		
			try {
				
				Class.forName(ConnectionInform.DRIVER_CLASS);
				con = DriverManager.getConnection
				(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
				
					
					String sql = "insert member values(?, ?, ?, ?, ? , ? , now())";
					
					pt = con.prepareStatement(sql);
					pt.setString(1, dto.getId());
					pt.setString(2, dto.getPw());
					pt.setString(3, dto.getName());
					pt.setString(4, dto.getPhone());
					pt.setString(5, dto.getEmail());
					pt.setString(6, dto.getAddress());
					
					count = pt.executeUpdate();
				
				
			} catch (ClassNotFoundException e) {
				System.out.println("해당 드라이버가 발견되지 않습니다");
			} catch (SQLException e) {
				System.out.println("연결 정보를 확인하세요");
			} finally {
				try {
				pt.close();
				con.close();
				} catch(SQLException e) {}
					
			}
			
			return count;
			
		}
		else {
			System.out.println("이미 존재하는 아이디입니다.");
			return count;
		}
		
	} // end of insertMember

	
	int getTotalMember() { // 전체 멤버 수 리턴
		
		Connection con = null;
		PreparedStatement pt = null;
		int count = 0;
		
		try {
			
//			Class.forName(ConnectionInform.DRIVER_CLASS);
//			con = DriverManager.getConnection
//			(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
			
			Context initContext = new InitialContext(); // context.xml 준비
			Context envContext = (Context)initContext.lookup("java:/comp/env"); // 자바 연관 설정 정보 찾기 (comp - 자바 객체, env - 환경 설정 정보)
			DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
			con = ds.getConnection();
			
			String sql = "select count(*) from member"; // 1행 1열 -> null / 숫자
			pt = con.prepareStatement(sql);
			ResultSet rs = pt.executeQuery();
			
			rs.next();  // 1개 행 리턴
			if (rs.getString("count(*)") == null) {
				count = 0;
			}
			else {
				count = rs.getInt("count(*)");
			}
			
		} catch (NamingException e) {
			System.out.println("해당 드라이버가 발견되지 않습니다");
		} catch (SQLException e) {
			System.out.println("연결 정보를 확인하세요");
		} finally {
			try {
				pt.close();
				con.close();
			} catch(SQLException e) {}
		}
		return count;
	}
	
	public ArrayList<MemberDTO> getMemberList(int currentPage, int memberPerPage) {
		
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> list = new ArrayList<>();
		
		// currPage : 1 ->  range : (currPage - 1)*3 + 1 ~ (currPage - 1)*3 + 3		
		try {
			
			Context initContext = new InitialContext(); // context.xml 준비
			Context envContext = (Context)initContext.lookup("java:/comp/env"); // 자바 연관 설정 정보 찾기 (comp - 자바 객체, env - 환경 설정 정보)
			DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
			// connection pool 하나 빌려오기
			con = ds.getConnection();
			
			String sql = "select id, insert(pw, 2, char_length(pw)-1, repeat('*', char_length(pw)-1)) as pw,"
					+ " name, indate from member";
			// **또 다른 방법**
			//String sql = "select id, name from member order by indate limit ?, ?";

			pt = con.prepareStatement(sql);
			// **또 다른 방법**
			//pt.setInt(1, (currentPage - 1) * memberPerPage);
			//pt.setInt(2, memberPerPage);
			
			rs = pt.executeQuery();
			
			int range = (currentPage - 1) * memberPerPage;
			while(rs.next()) {
				
				if (rs.getRow() >= range+1 && rs.getRow() <= range+memberPerPage) {
					MemberDTO dto = new MemberDTO(rs.getString("id"), rs.getString("name"), rs.getString("indate"));
					dto.setPw(rs.getString("pw"));
					list.add(dto);
				}
			}
			
		} catch (NamingException e) {
			System.out.println("해당 드라이버가 발견되지 않습니다");
		} catch (SQLException e) {
			System.out.println("연결 정보를 확인하세요");
		} finally {
			try {
				pt.close();
				con.close();
			} catch(SQLException e) {}
		}
		return list;		
	}
	
	
	public MemberDTO getMember(String id, String pw) {
		
		Connection con = null;
		PreparedStatement pt = null;
		MemberDTO dto = null;
		
		try {
			
			// default 문장
			Context initContext = new InitialContext(); // context.xml 준비
			Context envContext = (Context)initContext.lookup("java:/comp/env"); // 자바 연관 설정 정보 찾기 (comp - 자바 객체, env - 환경 설정 정보)
			DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
			// connection pool 하나 빌려오기
			con = ds.getConnection();
			
			String sql = "select * from member where id=?;";
			
			// rs.next() true
			
			pt = con.prepareStatement(sql);
			pt.setString(1, id);
			ResultSet rs = pt.executeQuery();
			if(rs.next()) { // 아이디가 있는 경우
				String dbpw = rs.getString("pw");
				if(pw.equals(dbpw)) { // 암호가 일치하는 경우
					dto = new MemberDTO(rs.getString("id"), rs.getString("pw"), rs.getString("name"),
							rs.getString("email"), rs.getString("phone"), 
							rs.getString("address"), rs.getString("indate"));
				}
				else { // 암호가 불일치하는 경우
					dto = new MemberDTO();
					dto.setId(rs.getString("id"));
					System.out.println("암호가 맞지 않습니다. 4번 다시 입력하세요.");
				}
			}
			else { // 아이디가 없는 경우
				System.out.println("1번 회원가입부터 하세요");
			}
	
			
		} catch (NamingException e) {
			System.out.println("해당 드라이버가 발견되지 않습니다");
		} catch (SQLException e) {
			System.out.println("연결 정보를 확인하세요");
		} finally {
			try {
				pt.close();
				con.close(); // pool로 반납
			} catch(SQLException e) {}
		}
		return dto;		
	}
	
	
	int updateMember(MemberDTO dto, HashMap map) {
		
		Connection con = null;
		PreparedStatement pt = null;
		int result = 0;
		
		System.out.println(map.toString());
		
		try {
		
//			Class.forName(ConnectionInform.DRIVER_CLASS);
//			con = DriverManager.getConnection
//					(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
			
			Context initContext = new InitialContext(); // context.xml 준비
			Context envContext = (Context)initContext.lookup("java:/comp/env"); // 자바 연관 설정 정보 찾기 (comp - 자바 객체, env - 환경 설정 정보)
			DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
			con = ds.getConnection();
			
			String sql = "update member set pw=ifnull(?, ?), name=ifnull(?, ?), email=ifnull(?, ?), phone=ifnull(?, ?), address=ifnull(?, ?) "
					+ "where id=?";
			
			pt = con.prepareStatement(sql);
			pt.setString(1, (String)map.get("pw"));
			pt.setString(2, dto.getPw());
			pt.setString(3, (String)map.get("name"));
			pt.setString(4, dto.getName());
			pt.setString(5, (String)map.get("email"));
			pt.setString(6, dto.getEmail());
			pt.setString(7, (String)map.get("phone"));
			pt.setString(8, dto.getPhone());
			pt.setString(9, (String)map.get("address"));
			pt.setString(10, dto.getAddress());
			pt.setString(11, dto.getId());
			
			result = pt.executeUpdate();
			
		} catch(NamingException e) {
			System.out.println("해당 드라이버가 발견되지 않았습니다");
		} catch(SQLException e) {
			System.out.println("연결 정보를 확인하세요");
		} finally {
			try {
				pt.close();
				con.close();
			} catch(SQLException e) {}
			
		}
		
		return result;
	}
	
	public int updateMemberAnswer(HashMap<String, String> updateMap) {
		
		Connection con = null;
		PreparedStatement pt = null;
		int result = 0;
		
		try {
			
//			Class.forName(ConnectionInform.DRIVER_CLASS);
//			con = DriverManager.getConnection
//			(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
			
			Context initContext = new InitialContext(); // context.xml 준비
			Context envContext = (Context)initContext.lookup("java:/comp/env"); // 자바 연관 설정 정보 찾기 (comp - 자바 객체, env - 환경 설정 정보)
			DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
			con = ds.getConnection();
			
			// 자주 변하는 String에는 StringBuffer 사용
			StringBuffer sql = new StringBuffer(); // 16문자버터 + ...
			sql.append("update member set ");
			Set<String> keys = updateMap.keySet();
			for(String k : keys) {
				if(!k.equals("id")) {
					sql.append(k + "='" + updateMap.get(k) + "' ,");					
				}
			}
			sql.deleteCharAt(sql.lastIndexOf(","));
			sql.append(" where id=?");
			
			System.out.println(sql); // 확인
			
			pt = con.prepareStatement(sql.toString());
			pt.setString(1, updateMap.get("id"));
			result = pt.executeUpdate();
			
			
		} catch (NamingException e) {
			System.out.println("해당 드라이버가 발견되지 않습니다");
		} catch (SQLException e) {
			System.out.println("연결 정보를 확인하세요");
		} finally {
			try {
				pt.close();
				con.close();
			} catch(SQLException e) {}
		}		
		
		return result;
	}
	
	
	public int deleteMember(String id) {
		
		Connection con = null;
		PreparedStatement pt = null;
		int insertCount = 0;
		int deleteCount = 0;
		
		try {
			
//			Class.forName(ConnectionInform.DRIVER_CLASS);
//			con = DriverManager.getConnection
//			(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
			
			Context initContext = new InitialContext(); // context.xml 준비
			Context envContext = (Context)initContext.lookup("java:/comp/env"); // 자바 연관 설정 정보 찾기 (comp - 자바 객체, env - 환경 설정 정보)
			DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
			con = ds.getConnection();
	
			// con 객체에서 트랜잭션 처리 설정 -> 하나의 트랜잭션으로 묶어서 처리!
			// [1] : auto-commit : false
			con.setAutoCommit(false); // 수동으로 트랜잭션 처리하도록 설정 (원하면 commit, 원하지 않으면 rollback)
			
			
			String insertSql = "insert into deletedmember select * from member where id=?";
			String deleteSql = "delete from member where id=?";
		
			// --- 
			pt = con.prepareStatement(insertSql);
			pt.setString(1, id);	
			insertCount = pt.executeUpdate();
			/// ---
			
			// 웹 서버가 회원탈퇴요청 처리중 - lock
			// 또 다른 회원정보수정 처리중 - lock
			
			// --- 
			pt = con.prepareStatement(deleteSql);
			pt.setString(1, id);	
			deleteCount = pt.executeUpdate(); // 예외발생
			/// ---
			// [2] : SQL문이 둘 다 성공했ㅡ을 때만 commit, 아니면 rollback
			con.commit(); 
			System.out.println("회원 탈퇴 처리 완료");
			
		} catch (Exception e){
			System.out.println("회원 탈퇴 처리 중 문제 발생 - 취소");
			try { 
				// [3] : 에러가 발생했을 때, rollback
				con.rollback();				
			} catch(Exception e2) {}
		} finally {
			try {
				pt.close();
				con.close();
			} catch(SQLException e) {}
		}
		return deleteCount;
		
	}
}
