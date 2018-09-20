package kr.itedu.test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Query {
	
	public static ArrayList<BoardVO> getAllBoardList(int num) {
		
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			Connection conn = DBConnector.getConn();
			String query = " select " + 
					" bid, btitle, " +
					" to_char(bregdate, 'yyyy-mm-dd hh24:mi:ss') as bregdate " +
					" from t_board"+num
					+ " order by bid desc ";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bregdate = rs.getString("bregdate");
				
				BoardVO b = new BoardVO();
				b.setBid(bid);
				b.setBtitle(btitle);
				b.setBregdate(bregdate);
				
				list.add(b);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static BoardVO getDetail(int bid, int num) {
		
		BoardVO vo = new BoardVO();
		try {
			Connection conn = DBConnector.getConn();
			String query = "select " +
					" btitle, bcontent, " +
					" to_char(bregdate, 'yyyy-mm-dd hh24:mi:ss') as bregdate " +
					" from t_board"+num+
					" where bid=? ";
					
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, bid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bregdate = rs.getString("bregdate");
				
				vo.setBid(bid);
				vo.setBtitle(btitle);
				vo.setBcontent(bcontent);
				vo.setBregdate(bregdate);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	
	public static int insert(String title, String content, int num) {
		int result = -1;
		try {
			Connection conn = DBConnector.getConn();
			String query = " insert into t_board"+num+
					" (bid, btitle, bcontent) " +
					" values " +
					" ((select nvl(max(bid),0)+1 from t_board"+num+"), ?, ?) ";
					
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, content);
			result = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static int update(String title, String content, int bid, int num) {
		int result = -1;
		
		try {
			Connection conn = DBConnector.getConn();
			String query = " update t_board"+num+
					" set " +
					" btitle = ?, " +
					" bcontent = ? " +
					" where bid = ? ";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, bid);
			result = ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static void delete(int bid, int num) {
		
		try {
			Connection conn = DBConnector.getConn();
			String query = " delete from t_board"+num+
					" where bid = ? ";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, bid);
			ps.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
