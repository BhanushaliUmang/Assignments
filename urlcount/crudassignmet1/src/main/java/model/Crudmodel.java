package model;

public class Crudmodel {
    private int userid;
    private String Name;
    private String UserName;
    private String Address;
    private String PhoneNumber;

    

    public Crudmodel(int userid , String Name , String UserName , String Address , String PhoneNumber){
        
        this.userid = userid;
        this.Name = Name;
        this.UserName = UserName;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Crudmodel [userid=" + userid + ", Name=" + Name + ", UserName=" + UserName + ", Address=" + Address
                + ", PhoneNumber=" + PhoneNumber + "]";
    }
}
