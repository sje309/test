package spEL;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-19 9:33
 * @Description: 在applicationContext.xml中配置
 */
public class CustomerByXml {
    private AddressByXml address;
    private String country;
    private String fullAddress;

    public AddressByXml getAddress() {
        return address;
    }

    public void setAddress(AddressByXml address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    @Override
    public String toString() {
        return "CustomerByXml{" +
                "address=" + address +
                ", country='" + country + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                '}';
    }
}
