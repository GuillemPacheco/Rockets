package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Result;
import utilities.InvalidParamException;
import utilities.NotFoundException;

public class ResultRepository {
	
	public static void storeResult(Result result) throws Exception {
		ConnectionBBDD connection = ConnectionRepository.getConnection();
		
		String sql = "Insert into Result(CIRCUITNAME,TIME,ROCKETNAME) values (?,?,?)";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.clearParameters();
		pst.setString(1, result.getCircuitName());
		pst.setDouble(2, result.getTime());
		pst.setString(3, result.getRocketName());
		
		if(pst.executeUpdate() != 1) {
			throw new InvalidParamException();
		}
	}
	
	public static Result getResult(String resultID) throws Exception {
		
		ConnectionBBDD connection = ConnectionRepository.getConnection();
		try {
			String sql = "SELECT * FROM RESULT WHERE CIRCUITNAME=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.clearParameters();
			preparedStatement.setString(1, resultID);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				String circuitName = rs.getString("CIRCUITNAME");
				int time = rs.getInt("TIME");
				String rocketName = rs.getString("ROCKETNAME");
				return new Result(circuitName,time,rocketName);
			}
			
			throw new NotFoundException();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidParamException();
		}
	}

	public static void updateResult(Result result) throws Exception {
		ConnectionBBDD connection = ConnectionRepository.getConnection();
		try {
			String sql = "UPDATE RESULT SET TIME=?, ROCKETNAME=? WHERE CIRCUITNAME=?";
			PreparedStatement pst= connection.prepareStatement(sql);
			pst.clearParameters();
			pst.setString(1, result.getCircuitName());
			pst.setInt(2, result.getTime());
			pst.setString(3, result.getRocketName());
			
			if(pst.executeUpdate() != 1) {
				throw new InvalidParamException();
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidParamException();
		}
	}

}
