package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.UserDto;
import mysql.db.DbConnect;

public class UserDao {
	
	DbConnect db=new DbConnect();
	
	//아이디 중복 체크_boolean(String id)
	public boolean isIdCheck(String user_id)
	{
		boolean isid=false;
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select*from user where user_id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, user_id);
			
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
	public String getName(String user_id)
	{
		
		String name="";
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select*from user where user_id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, user_id);
			
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
	

	//insert메서드
	public void insertMember(UserDto dto)
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into user (user_name,user_id,user_pw,user_hp,user_addr,user_joinday) values (?,?,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, dto.getUser_name());
			pstmt.setString(2, dto.getUser_id());
			pstmt.setString(3, dto.getUser_pw());
			pstmt.setString(4, dto.getUser_hp());
			pstmt.setString(5, dto.getUser_addr());
			
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
			
		
	}
	
	//로그인할떄 아이디 비번 체크
			

	public boolean isIdPass(String user_id,String user_pw)
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
	
	
			