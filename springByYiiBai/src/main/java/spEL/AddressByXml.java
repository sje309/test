package spEL;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-19 9:19
 * @Description: 在applicationContext.xml中配置Address的相关属性
 */
public class AddressByXml {
    private String street;
    private int postcode;
    private String country;

    public String getFullAddress(String prefix) {
        return prefix + ":" + street + " " + postcode + " " + country;
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
        return "AddressByXml{" +
                "street='" + street + '\'' +
                ", postcode=" + postcode +
                ", country='" + country + '\'' +
                '}';
    }
}
