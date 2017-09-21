package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserInfoDao {

	//ログインIDとパスワードが正しいか確認
	public static boolean isLogin(String loginID,String password) {
		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT login_id,password FROM userinfo where login_id = ? and password = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginID);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;

	}

	//ログインIDがあっていればユーザー情報を取得する
	public static UserInfoBeans findUser(String loginID) {
		Connection conn = null;
		UserInfoBeans beans = new UserInfoBeans();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * from userinfo WHERE login_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginID);
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				beans.setId(rs.getString("id"));
				beans.setLogin_id(rs.getString("login_id"));
				beans.setName(rs.getString("name"));
				beans.setBirth_date(rs.getString("birth_date"));
				beans.setPassword(rs.getString("password"));
				beans.setCreate_date(rs.getString("create_date"));
				beans.setUpdate_date(rs.getString("update_date"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				try {
				conn.close();
				} catch(SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
		return beans;
	}

	//ログインIDがあっていればユーザー情報を取得する
		public static List<UserInfoBeans> findUser() {
			Connection conn = null;
			List<UserInfoBeans> beansList = new ArrayList<UserInfoBeans>();

			try {
				conn = DBManager.getConnection();

				String sql = "SELECT * from userinfo";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				ResultSet rs = pStmt.executeQuery();

				while(rs.next()) {
					UserInfoBeans beans = new UserInfoBeans();
					beans.setId(rs.getString("id"));
					beans.setLogin_id(rs.getString("login_id"));
					beans.setName(rs.getString("name"));
					beans.setBirth_date(rs.getString("birth_date"));
					beans.setPassword(rs.getString("password"));
					beans.setCreate_date(rs.getString("create_date"));
					beans.setUpdate_date(rs.getString("update_date"));

					beansList.add(beans);
				}

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} finally {
				if(conn != null) {
					try {
					conn.close();
					} catch(SQLException e){
						e.printStackTrace();
						return null;
					}
				}
			}
			return beansList;
		}

}
