package co.wemiguel.digitalbank.automation.ui.models;

public class ProfileInfo {

    //      | title | firstName | lastName | homePhone | mobilePhone | workPhone  | address            | Locality | Region     | postalCode | Country |

    private String title;
    private String firstName;
    private String lastName;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String address;
    private String locality;
    private String region;
    private String postalCode;
    private String country;

    public ProfileInfo(String title, String firstName, String lastName, String homePhone, String mobilePhone, String workPhone, String address, String postalCode, String region, String locality, String country) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.address = address;
        this.postalCode = postalCode;
        this.region = region;
        this.locality = locality;
        this.country = country;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}


//    public String getTitle() {
//        return this.title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getFirstName() {
//        return this.firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return this.lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getHomePhone() {
//        return this.homePhone;
//    }
//
//    public void setHomePhone(String homePhone) {
//        this.homePhone = homePhone;
//    }
//
//    public String getMobilePhone() {
//        return this.mobilePhone;
//    }
//
//    public void setMobilePhone(String mobilePhone) {
//        this.mobilePhone = mobilePhone;
//    }
//
//    public String getWorkPhone() {
//        return this.workPhone;
//    }
//
//    public void setWorkPhone(String workPhone) {
//        this.workPhone = workPhone;
//    }
//
//    public String getAddress() {
//        return this.address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getPostalCode() {
//        return this.postalCode;
//    }
//
//    public void setPostalCode(String postalCode) {
//        this.postalCode = postalCode;
//    }
//
//    public String getRegion() {
//        return this.region;
//    }
//
//    public void setRegion(String region) {
//        this.region = region;
//    }
//
//    public String getLocality() {
//        return this.locality;
//    }
//
//    public void setLocality(String locality) {
//        this.locality = locality;
//    }
//
//    public String getCountry() {
//        return this.country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//}