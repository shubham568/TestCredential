package Database;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public   class temporarydataRepositoryImpl implements temporarydataRepository {

	 private static final String FIND_ALL_SQL = "SELECT InstitutionName,ContactId,ParentInstitutionId,MobileNumber1,MobileNumber2,EmailId1,EmailId2,Address1,Address2,Address3,City,State,Country,PostalCode from  temporarydata ";
	    private static final String INSERT_SQL = "INSERT INTO temporarydata(InstitutionName,ContactId,ParentInstitutionId,MobileNumber1,MobileNumber2,EmailId1,EmailId2,Address1,Address2,Address3,City,State,Country,PostalCode) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

	    private Connection connection;

	    public temporarydataRepositoryImpl(DataSource dataSource) throws SQLException {
	        this.connection = dataSource.getConnection();
	    }

	  
	    public temporarydataRepositoryImpl() {
			// TODO Auto-generated constructor stub
		}


		@Override
	    public List<temporarydata> findAlltemporarydata() {
	        List<temporarydata> result = new ArrayList<>();
	        try (Statement st = connection.createStatement();
	             ResultSet rs = st.executeQuery(FIND_ALL_SQL)) {
	            while (rs.next()) {
	            	String InstitutionName = rs.getString("InstitutionName");
	            	String ContactId = rs.getString("ContactId");
	            	String ParentInstitutionId = rs.getString("ParentInstitutionId");
	                String MobileNumber1=rs.getString("MobileNumber1");
	                String MobileNumber2 = rs.getString("MobileNumber2");
	                String EmailId1 = rs.getString("EmailId1");
	                String EmailId2 = rs.getString("EmailId2");
	                String Address1 = rs.getString("Address1");
	                String Address2 = rs.getString("Address2");
	                String Address3 = rs.getString("Address3");
	                String City = rs.getString("City");
	                String State = rs.getString("State");
	                String Country = rs.getString("Country");
	                String PostalCode = rs.getString("PostalCode");
	                result.add(new temporarydata(InstitutionName, ContactId, ParentInstitutionId,MobileNumber1, MobileNumber2, EmailId1,EmailId2,Address1,Address2,Address3,City,State,Country,PostalCode));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }

	    @Override
	    public void inserttemporarydata(temporarydata temporarydata) {
	    
	        if (temporarydata != null) {
	            try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
	                ps.setString(1, temporarydata.getInstitutionName());
	                ps.setString(2, temporarydata.getContactId());
	                ps.setString(3, temporarydata.getParentInstitutionId());
	                ps.setString(4, temporarydata.getMobileNumber1());
	                ps.setString(5, temporarydata.getMobileNumber2());
	                ps.setString(6, temporarydata.getEmailId1());
	                ps.setString(7, temporarydata.getEmailId2());
	                ps.setString(8, temporarydata.getAddress1());
	                ps.setString(9, temporarydata.getAddress2());
	                ps.setString(10, temporarydata.getAddress3());
	                ps.setString(11, temporarydata.getCity());
	                ps.setString(12, temporarydata.getState());
	                ps.setString(13,  temporarydata.getCountry());
	                ps.setString(14, temporarydata.getPostalCode());
	                
	                int numRowsAffected = ps.executeUpdate();
	                
	                }
	             catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

		
	        

		}

		
		

