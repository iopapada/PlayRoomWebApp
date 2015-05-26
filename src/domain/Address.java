/**
 * 
 */
package domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Address {

	@Column(name="addressStreet", length=50, nullable=false)
	@NotEmpty(message="{invalid.addressStreet}")
	private String addressStreet;

	@Column(name="addressNumber", length=10, nullable=false)
	@NotEmpty(message="{invalid.addressNumber}")
	private String addressNumber;

	@Column(name="addressZipCode", length=10, nullable=true)
	@NotEmpty(message="{invalid.addressZipCode}")
	private String addressZipCode;

	@Column(name="city", length=20, nullable=false)
	@NotEmpty(message="{invalid.city}")
	private String city;
	
	@Column(name="country", length=20, nullable=false)
	@NotEmpty(message="{invalid.country}")
	private String country;

	public Address(){}
	
	public Address(String addstreet, String addnumber, String zipcode, String city, String country) {
		this.addressStreet = addstreet;
		this.addressNumber = addnumber;
		this.addressZipCode = zipcode;
		this.city = city;
		this.country = country;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getAddressZipCode() {
		return addressZipCode;
	}

	public void setAddressZipCode(String addressZipCode) {
		this.addressZipCode = addressZipCode;
	}
		
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	/**
     * Ξ— ΞΉΟƒΟ�Ο„Ξ·Ο„Ξ± Ξ²Ξ±ΟƒΞ―Ξ¶ΞµΟ„Ξ±ΞΉ ΟƒΞµ Ο�Ξ»Ξ± Ο„Ξ± Ο€ΞµΞ΄Ξ―Ξ± Ο„Ξ·Ο‚ Ξ΄ΞΉΞµΟ�ΞΈΟ…Ξ½ΟƒΞ·Ο‚.
     * @param other Ξ¤ΞΏ Ξ¬Ξ»Ξ»ΞΏ Ξ±Ξ½Ο„ΞΉΞΊΞµΞ―ΞΌΞµΞ½ΞΏ Ο€Ο�ΞΏΟ‚ Ξ­Ξ»ΞµΞ³Ο‡ΞΏ
     * @return  {@code true} Ξ±Ξ½ Ο„Ξ± Ξ±Ξ½Ο„ΞΉΞΊΞµΞ―ΞΌΞµΞ½Ξ± ΞµΞ―Ξ½Ξ±ΞΉ Ξ―ΟƒΞ±
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Address)) {
            return false;
        }

        Address theAddress = (Address) other;
        if (!(addressStreet == null ? theAddress.addressStreet 
                == null : addressStreet.equals(theAddress.addressStreet))) {
            return false;
        }
        if (!(addressNumber == null ? theAddress.addressNumber 
                == null : addressNumber.equals(theAddress.addressNumber))) {
            return false;
        }
        if (!(city == null ? theAddress.city 
                == null : city.equals(theAddress.city))) {
            return false;
        }
        if (!(addressZipCode == null ? theAddress.addressZipCode
                == null : addressZipCode.equals(theAddress.addressZipCode))) {
            return false;
        }
        if (!(country == null ? theAddress.country
                == null : country.equals(theAddress.country))) {
            return false;
        }
        return true;
    }


    @Override
    public int hashCode() {
        if (addressStreet == null && addressNumber == null && city == null
                && addressZipCode == null && country == null) {
            return 0;
        }

        int result = 0;
        result = addressStreet == null ? result : 13 * result + addressStreet.hashCode(); 
        result = addressNumber == null ? result : 13 * result + addressNumber.hashCode();
        result = city == null ? result : 13 * result + city.hashCode();
        result = addressZipCode == null ? result : 13 * result + addressZipCode.hashCode();
        result = country == null ? result : 13 * result + country.hashCode();
        return result;
    }

	
 
}