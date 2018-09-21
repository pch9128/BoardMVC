package kr.itedu.boardmvc.common;

import static kr.itedu.boardmvc.common.DBConnector.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import kr.itedu.boardmvc.BoardVO;

public class BoardDAO {
	
	private static BoardDAO dao;
	
	private BoardDAO() {} //private 생성자
	
	public static BoardDAO getInstance() { //싱글톤 패턴
		
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	public ArrayList<BoardVO> getBoardList(int btype){
		
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConn();
			String query = "select bid, btitle, "
					+ " to_char(bregdate, 'yyyy-mm-dd hh24:mi:ss') as bregdate "
					+ " from t_board"+btype+
					  " order by bid desc ";
			
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bregdate = rs.getString("bregdate");
				
				BoardVO b = new BoardVO();
				b.setBid(bid);
				b.setBtitle(btitle);
				b.setBregdate(bregdate);
				
				result.add(b);
			}
		}catch(SQLException e) {
			//TODO: 예외처리
		}catch(Exception e) {
			//TODO: 예외처리
		}finally {
			close(con, ps, rs);
		}
		return result;
	}
	public ArrayList<BoardVO> list(int page) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int countList=10,countpage=10;
		
		int startPage=(page-1)*10+1;
		int endPage=startPage+countList-1;
		ArrayList<BoardVO> result=new ArrayList<>();
		
		
		String sql="select*from(select rownum as rnum, z.*from (select*from t_board order by bid desc) z where rownum <=?)where rnum >=?";
		
		try {
			conn=DBConnector.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1,endPage);
			ps.setInt(2, startPage);
			rs=ps.executeQuery();
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bregdate = rs.getString("bregdate");
				
				BoardVO b = new BoardVO();
				b.setBid(bid);
				b.setBtitle(btitle);
				b.setBregdate(bregdate);
				
				result.add(b);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBConnector.close(conn, ps, rs);
		}
		
		return result;
	}
public int maxpage() {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	int max=0;
	String sql="select count(*) from t_board";
	
	try {
		conn=DBConnector.getConn();
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		if(rs.next()) {
			max=rs.getInt(1);
			
		}
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		DBConnector.close(conn, ps, rs);
	}
	return max;
	
}	
public String pageCon(int page) {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	int conutList=10,countPage=10,total=0;
	String q="";
	
	
	total=maxpage()/conutList;
	
	if(maxpage()%conutList>0) {
		total++;
			}
	if(page>total) {
		page=total;
	}
	
	int startPage=((page-1)/10)*10+1;
	int endPage=startPage+countPage-1;
	
	if(endPage>total){
		endPage=total;
	}

	if(startPage>1) {
		q+="<a href=\"?page="+1+"\">처음</a>";
	}
	if(page>1) {
		q+="<a href=\"?page="+(page-1)+"\">이전</a>";
	}
	for(int count=startPage;count<=endPage;count++) {
		if(count==page) {
			q+="<b>"+count+"</b>";
		}else {
			q+="<a href=\"?page="+count+"\">"+count+"</a>";
		}
	}
	if(page<total) {
		q+="<a href=\"?page="+(page+1)+"\">다음</a>";
		
		q+="<a href=\"?page="+total+"\">끝</a>";
	}
	
	return q;

	
	
}	
}

