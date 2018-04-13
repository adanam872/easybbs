package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Board;

public class BoardDAO {

	private Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/board","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public int writeBoard(Board board) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO board(name, password, title, content, date) "
				+ "VALUES(?, ?, ?, ?, SYSDATE())";
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, board.getName());
			preparedStatement.setString(2, board.getPassword());
			preparedStatement.setString(3, board.getTitle());
			preparedStatement.setString(4, board.getContent());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return 0;
	}
	
	public int updateBoard(Board board) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE board SET title=?, content=? WHERE id=? AND password=?";
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, board.getTitle());
			preparedStatement.setString(2, board.getContent());
			preparedStatement.setInt(3, board.getId());
			preparedStatement.setString(4, board.getPassword());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return 0;
	}
	
	public int deleteBoard(int id, String pw) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM board WHERE id=? AND password=?";
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, pw);
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return 0;
	}
	
	public Board selectOne(int id) {
		Board board = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM board WHERE id=?";
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				board = new Board();
				board.setId(resultSet.getInt("id"));
				board.setName(resultSet.getString("name"));
				board.setPassword(resultSet.getString("password"));
				board.setTitle(resultSet.getString("title"));
				board.setContent(resultSet.getString("content"));
				board.setDate(resultSet.getTimestamp("date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return board;
	}
	
	public List<Board> selectList(int beginRow, int pageRow) {
		List<Board> list = new ArrayList<Board>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM board ORDER BY id DESC LIMIT ?, ?";
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, beginRow);
			preparedStatement.setInt(2, pageRow);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
					Board board = new Board();
					board.setId(resultSet.getInt("id"));
					board.setName(resultSet.getString("name"));
					board.setPassword(resultSet.getString("password"));
					board.setTitle(resultSet.getString("title"));
					board.setContent(resultSet.getString("content"));
					board.setDate(resultSet.getTimestamp("date"));
					list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}		
		
		return list;
	}
	
	public int countBoard() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT COUNT(*) FROM board";
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return 0;
	}
}
