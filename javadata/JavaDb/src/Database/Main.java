package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import Database.*;

public class Main {

	
	
	
	public static void main(String[] args) throws Exception {
		getConnection();
		
	}

	



	public static Connection getConnection() throws Exception{
		Connection connection = null;
		try {
			String driver ="com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/digitalcredx?autoReconnect=true&useSSL=false";
			String username = "root";
			String password = "Vivek@1986";
			
			String filePath = "E:\\DigitalCredentialXpress\\Data";
			
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			ReadDataFromExcel read = new ReadDataFromExcel();
            List<String> lines = read.readCSV();
            System.out.println("total lines from csv :"+lines.size());
            String sql = "Insert into temporarydata(Institution_Name,Contact_Id,Parent_Institution_Id,Mobile_Number_1,Mobile_Number_2,Email_Id_1,Email_Id_2,Address_1,Address_2,Address_3,City,State,Country,Postal_Code) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            for(Integer i = 1 ; i<lines.size() ; i++){
				String line = lines.get(i);
            	if (line != null) 
            		
				{System.out.println(line);
					String[] fields = line.split(",");
					//System.out.println("Length"+array.length);
					Integer rowIndex = 1;
					
					for(String fieldValue:fields)
					{
						//System.out.println("Result here"+result);
				//Create preparedStatement here and set them and excute them
						
						
						
						
					    System.out.println("Row index"+rowIndex+": Result "+fieldValue);
						ps.setString(rowIndex,fieldValue);
						rowIndex++;
						
				// ps.setString(2,str[1]);
				// ps.setString(3,str[2]);
				// ps.setString(4,strp[3])
						
				//Assuming that your line from file after split will follow that sequence

					}
					ps.executeUpdate();			
					
				}
			}	
            ps.close();
		
			//System.out.println("String"+s);
			
			} catch (Exception e) {System.out.println(e);}
		
		
		
		return connection;
		

	}
	

}
