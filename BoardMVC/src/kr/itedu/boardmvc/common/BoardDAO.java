package kr.itedu.boardmvc.common;

import static kr.itedu.boardmvc.common.DBConnector.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.itedu.boardmvc.BoardVO;

public class BoardDAO {
	private static BoardDAO dao; // 222 1과 2 다른곳


	private BoardDAO() {
	} // 외부에서 바로가져가는걸 막는다. private 생성자

	public static BoardDAO getInstance() { // 다른곳에서 111 <싱글톤>
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}// BoardDAO(1) dao = BoardDAO.getInstance();
	
	public ArrayList<BoardVO> getBoardList(int btype){
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		try {
			con=getConn();
			String query = String.format(" select " + 
					" bid, btitle, " +
					" to_char(bregdate, 'yyyy-mm-dd hh24:mi:ss') as bregdate " +
					" from t_board%d "
					+ " order by bid desc ", btype);			
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
			//TODO: 에외처리		
		}catch(Exception e) {
			//TODO: 에외처리
		}finally {
			close(con,ps,rs);
		}
		return result;
	}
}
		
