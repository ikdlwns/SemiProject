package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.MemberDto;
import mysql.db.DbConnect;

public class MemberDao {
	
	DbConnect db=new DbConnect();
	
	//아이디 체크_boolean(String id)
	public boolean isIdCheck(String user_name)
	{
		boolean isid=false;
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select*from user where user_name=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, user_name);
			
			//싱행
			rs=pstmt.executeQuery();
			
			if(rs.next()) //해당아이디 존재할경우 true
				isid=true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isid;
		
	}
	
	//아이디에 따른 name(String id)
	public String getName(String user_name)
	{
		
		String name="";
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select*from user where user_name=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, user_name);
			
			//싱행
			rs=pstmt.executeQuery();
			
			if(rs.next()) //해당아이디 존재할경우 true
				name=rs.getString("user_name");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			db.dbClose(rs, pstmt, conn);
		}
		
		return name;
	}
	

	//insert
	public void insertMember(MemberDto dto)
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into user (user_pw,user_name_user_hp,user_addr,user_point,is_admin,user_joinday) values (?,?,?,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, dto.getUser_pw());
			pstmt.setString(2, dto.getUser_name());
			pstmt.setString(3, dto.getUser_hp());
			pstmt.setString(4, dto.getUser_addr());
			pstmt.setInt(5, dto.getUser_point());
			pstmt.setString(6, dto.getIs_admin());
			pstmt.setTimestamp(7, dto.getUser_joinday());
			
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
			
		
	}
	
	//전체리스트
	
	//전체출력
	public List<MemberDto> getAllMembers()
	{
		List<MemberDto> list=new Vector<MemberDto>();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from user order by user_name";

		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				MemberDto dto=new MemberDto();
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_pw(rs.getString("user_pw"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_hp(rs.getString("user_hp"));
				dto.setUser_addr(rs.getString("user_addr"));
				dto.setUser_point(rs.getInt("user_point"));
				dto.setIs_admin(rs.getString("is_admin"));
				dto.setUser_joinday(rs.getTimestamp("gaipday"));


				list.add(dto);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}				

		return list;
	}


	
	//비밀번호 체크
			public boolean isPassEqual(String user_id,String user_pw)
			{
				boolean b=false;
				
				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				
				String sql="select * from user where user_id=? and user_pw=?";
				
				try {
					pstmt=conn.prepareStatement(sql);
					
					//바인딩
					pstmt.setString(1, user_id);
					pstmt.setString(2, user_pw);
					
					rs=pstmt.executeQuery();
					
					if(rs.next())
					{
						b=true;
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(rs, pstmt, conn);
				}
				
				
				return b;
			}
			
			//삭제
			public void deleteMember(String user_id)
			{
				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				
				String sql="delete from user where user_id=?";
				
				try {
					pstmt=conn.prepareStatement(sql);
					
					//바인딩
					pstmt.setString(1, user_id);
					
					//실행
					pstmt.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(pstmt, conn);
				}
				
			}
			
			//num에 해당하는 하나의 데이터 조회 dto 반환
			
			public MemberDto getMember(String user_id)
			{
				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				
				MemberDto dto=new MemberDto();
				
				String sql="select * from user where user_id=?";
				
				try {
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, user_id);
					
					rs=pstmt.executeQuery();
					
					if(rs.next())
					{
						dto.setUser_id(rs.getString("user_id"));
						dto.setUser_pw(rs.getString("user_pw"));
						dto.setUser_name(rs.getString("user_name"));
						dto.setUser_hp(rs.getString("user_hp"));
						dto.setUser_addr(rs.getString("user_addr"));
						dto.setUser_point(rs.getInt("user_point"));
						dto.setIs_admin(rs.getString("is_admin"));
						dto.setUser_joinday(rs.getTimestamp("gaipday"));

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(rs, pstmt, conn);
				}
				
				
				
				return dto;
			}
			

			
			//수정하는 메서드
			public void updateMamber(MemberDto dto)
			{

				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				//이름(닉네임),전화번호,주소
				String sql="update user set user_name=?,user_hp=?,user_addr=? where user_id=?";
				
				try {
					pstmt=conn.prepareStatement(sql);
					
					//바인딩
					pstmt.setString(1, dto.getUser_name());
					pstmt.setString(2, dto.getUser_hp());
					pstmt.setString(3, dto.getUser_addr());
					pstmt.setString(4, dto.getUser_id());
						
					
					//실행
					pstmt.execute();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(pstmt, conn);
				}
				
				
			}
			
			//아이디의 비번체크_로그인을 위한
			

			public boolean isIdPass(String user_name,String user_pw)
			{
				boolean b=false;
				
				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				
				String sql="select * from user where user_name=? and user_pw=?";
				
				try {
					pstmt=conn.prepareStatement(sql);
					
					//바인딩
					pstmt.setString(1, user_name);
					pstmt.setString(2, user_pw);
					
					//실행
					rs=pstmt.executeQuery();
					
					if(rs.next())
					{
						b=true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(rs, pstmt, conn);
				}
				
				
				
				return b;
			}

			

}

