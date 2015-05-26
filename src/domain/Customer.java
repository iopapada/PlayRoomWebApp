/**
 * 
 */
package domain;

import javax.persistence.*;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="customers")
public class Customer {

	@Id
    @Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="firstName", length=200, nullable=false)
	@NotEmpty(message="{invalid.firstName}")
	private String firstName;

	@Column(name="lastName", length=200, nullable=false)
	@NotEmpty(message="{invalid.lastName}")
	private String lastName;

	@Column(name="customerCode", length=20, nullable=false)
	private String customerCode;
	
	@Column(name="email", length=200)
	@Email(message="{invalid.email}")
	private String email;

	@Column(name="telephone", length=200, nullable=false)
	private String telephone;
	
	@Embedded
	private Address address = new Address();

	@Column(name="username", length=200, nullable=false)
	private String username;

	@Column(name="password", length=20, nullable=false)
	private String password;

	@Column(name="userrights", length=20, nullable=false)
	private String userrights;

	public Customer (){}
	//---------------Need For Initialize----------------------------
	public Customer (Address addr, String firstName, String lastname, String email, String telephone, String usr, String pass, String usrights){	
		this.customerCode = customerCodeGenerator();
		Address address = new Address(addr.getAddressStreet(), addr.getAddressNumber(), addr.getAddressZipCode(), addr.getCity(), addr.getCountry());	
		this.setAddress(address);
		this.setTelephone(telephone);	
		this.setFirstName(firstName);
		this.setLastName(lastname);
		this.setEmail(email);
		this.setUsername(usr);
		this.setPassword(pass);
		this.setUserrights(usrights);
	}
	
	public Customer (Address addr, String firstName, String lastname, String email, String telephone, String usr, String usrights){	
		this.customerCode = customerCodeGenerator();
		Address address = new Address(addr.getAddressStreet(), addr.getAddressNumber(), addr.getAddressZipCode(), addr.getCity(), addr.getCountry());	
		this.setAddress(address);
		this.setTelephone(telephone);	
		this.setFirstName(firstName);
		this.setLastName(lastname);
		this.setEmail(email);
		this.setUsername(usr);
		this.setPassword(this.customerCode);
		this.setUserrights(usrights);
	}

//	public Customer (String username, String password, String telephone, String telephone){	
//		this.setTelephone(telephone);	
//		this.setFirstName(firstName);
//		this.setLastName(lastname);
//		this.setEmail(email);
//	}
	
	public int getId() {
		return id;
	}

	public static Customer newUserInstance(Customer customer) {
	    return new Customer(customer.getAddress(), customer.getFirstName(), customer.getLastName(),
	    		customer.getEmail(), customer.getTelephone(),customer.getUsername(),"user");
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	private String customerCodeGenerator() {
		return RandomStringUtils.randomAlphanumeric(5);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCustomerCode() {
		return customerCode;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address == null ? null : new Address(address.getAddressStreet(), address.getAddressNumber(), address.getAddressZipCode(), address.getCity(), address.getCountry());
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getUserrights() {
		return userrights;
	}

	public void setUserrights(String userrights) {
		this.userrights = userrights;
	}
	
}