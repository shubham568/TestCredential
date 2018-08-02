package Database;

import java.io.Serializable;


@SuppressWarnings("serial")
public class temporarydata implements Serializable {
	
	private String InstitutionName;
	private String ContactId;
	private String ParentInstitutionId;
    private String MobileNumber1;
    private String MobileNumber2;
    private String EmailId1;
    private String EmailId2;
    private String Address1;
    private String Address2;
    private String Address3;
    private String City;
    private String State;
    private String Country;
    private String PostalCode;
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("InstitutionName [InstitutionName=");
		builder.append(InstitutionName);
		builder.append(", Contact_Id=");
		builder.append(ContactId);
		builder.append(", Parent_Institution_Id=");
		builder.append(ParentInstitutionId);
		builder.append(", MobileNumber1=");
		builder.append(MobileNumber1);
		builder.append(", MobileNumber2=");
		builder.append(MobileNumber2);
		builder.append(", EmailId1=");
		builder.append(EmailId1);
		builder.append(", EmailId2=");
		builder.append(EmailId2);
		builder.append(", Address1=");
		builder.append(Address1);
		builder.append(", Address2=");
		builder.append(Address2);
		builder.append(", Address3=");
		builder.append(Address3);
		builder.append(", City=");
		builder.append(City);
		builder.append(", State=");
		builder.append(State);
		builder.append(", Country=");
		builder.append(Country);
		builder.append(", PostalCode=");
		builder.append(PostalCode);
		builder.append("]");
		return builder.toString();
	}

	public temporarydata(String InstitutionName, String ContactId, String ParentInstitutionId,String MobileNumber1,String MobileNumber2, String EmailId1, String EmailId2, String Address1, String Address2, String Address3,
			String City, String State, String Country, String PostalCode) {
		super();
		InstitutionName = InstitutionName;
		ContactId = ContactId;
		ParentInstitutionId = ParentInstitutionId;
		MobileNumber1 = MobileNumber1;
		MobileNumber2 = MobileNumber2;
		EmailId1 = EmailId1;
		EmailId2 = EmailId2;
		Address1 = Address1;
		Address2 = Address2;
		Address3 = Address3;
		City = City;
		State = State;
		Country = Country;
		PostalCode = PostalCode;
		
		
	}

	public String getInstitutionName() {
		return InstitutionName;
	}

	public void setInstitutionName(String institutionName) {
		InstitutionName = institutionName;
	}
	
	public String getContactId() {
		return ContactId;
	}

	public void setContactId(String ContactId) {
		ContactId = ContactId;
	}
	
	public String getParentInstitutionId() {
		return ParentInstitutionId;
	}

	public void setParentInstitutionId(String ParentInstitutionId) {
		ParentInstitutionId = ParentInstitutionId;
	}

	public String getMobileNumber1() {
		return MobileNumber1;
	}

	public void setMobileNumber1(String mobileNumber1) {
		MobileNumber1 = mobileNumber1;
	}

	public String getMobileNumber2() {
		return MobileNumber2;
	}

	public void setMobileNumber2(String mobileNumber2) {
		MobileNumber2 = mobileNumber2;
	}

	public String getEmailId1() {
		return EmailId1;
	}

	public void setEmailId1(String emailId1) {
		EmailId1 = emailId1;
	}

	public String getEmailId2() {
		return EmailId2;
	}

	public void setEmailId2(String emailId2) {
		EmailId2 = emailId2;
	}

	public String getAddress1() {
		return Address1;
	}

	public void setAddress1(String address1) {
		Address1 = address1;
	}

	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String address2) {
		Address2 = address2;
	}

	public String getAddress3() {
		return Address3;
	}

	public void setAddress3(String address3) {
		Address3 = address3;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}

	
}

	
	
	