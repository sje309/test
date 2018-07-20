package spEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-17 17:19
 * @Description:
 */
@Component(value = "addressBean")
public class Address {
    @Value(value = "GaoDeng,QiongShang")
    private String street;
    @Value(value = "571100")
    private int postcode;
    @Value("#{'CN'.toLowerCase()}")
    private String country;

    public String getFullAddress(String prefix) {
        return prefix + " : " + street + " " + postcode + " " + country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address[" +
                "street='" + street + '\'' +
                ", postcode=" + postcode +
                ", country='" + country + '\'' +
                ']';
    }
}
