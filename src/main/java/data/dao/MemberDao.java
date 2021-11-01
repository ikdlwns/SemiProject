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
	
	//���̵� üũ_boolean(String id)
	public boolean isIdCheck(String user_name)
	{
		boolean isid=false;
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select*from user where user_name=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//���ε�
			pstmt.setString(1, user_name);
			
			//����
			rs=pstmt.executeQuery();
			
			if(rs.next()) //�ش���̵� �����Ұ�� true
				isid=true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isid;
		
	}
	
	//���̵� ���� name(String id)
	public String getName(String user_name)
	{
		
		String name="";
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select*from user where user_name=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//���ε�
			pstmt.setString(1, user_name);
			
			//����
			rs=pstmt.executeQuery();
			
			if(rs.next()) //�ش���̵� �����Ұ�� true
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
			
			//���ε�
			pstmt.setString(1, dto.getUser_pw());
			pstmt.setString(2, dto.getUser_name());
			pstmt.setString(3, dto.getUser_hp());
			pstmt.setString(4, dto.getUser_addr());
			pstmt.setInt(5, dto.getUser_point());
			pstmt.setString(6, dto.getIs_admin());
			pstmt.setTimestamp(7, dto.getUser_joinday());
			
			//����
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
			
		
	}
	
	//��ü����Ʈ
	
	//��ü���
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


	
	//��й�ȣ üũ
			public boolean isPassEqual(String user_id,String user_pw)
			{
				boolean b=false;
				
				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				
				String sql="select * from user where user_id=? and user_pw=?";
				
				try {
					pstmt=conn.prepareStatement(sql);
					
					//���ε�
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
			
			//����
			public void deleteMember(String user_id)
			{
				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				
				String sql="delete from user where user_id=?";
				
				try {
					pstmt=conn.prepareStatement(sql);
					
					//���ε�
					pstmt.setString(1, user_id);
					
					//����
					pstmt.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(pstmt, conn);
				}
				
			}
			
			//num�� �ش��ϴ� �ϳ��� ������ ��ȸ dto ��ȯ
			
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
			

			
			//�����ϴ� �޼���
			public void updateMamber(MemberDto dto)
			{

				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				//�̸�(�г���),��ȭ��ȣ,�ּ�
				String sql="update user set user_name=?,user_hp=?,user_addr=? where user_id=?";
				
				try {
					pstmt=conn.prepareStatement(sql);
					
					//���ε�
					pstmt.setString(1, dto.getUser_name());
					pstmt.setString(2, dto.getUser_hp());
					pstmt.setString(3, dto.getUser_addr());
					pstmt.setString(4, dto.getUser_id());
						
					
					//����
					pstmt.execute();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(pstmt, conn);
				}
				
				
			}
			
			//���̵��� ���üũ_�α����� ����
			

			public boolean isIdPass(String user_name,String user_pw)
			{
				boolean b=false;
				
				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				
				String sql="select * from user where user_name=? and user_pw=?";
				
				try {
					pstmt=conn.prepareStatement(sql);
					
					//���ε�
					pstmt.setString(1, user_name);
					pstmt.setString(2, user_pw);
					
					//����
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

