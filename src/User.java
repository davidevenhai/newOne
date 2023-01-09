public class User {

    private String name;
    private String password;
    private String phoneNumber;
    private boolean isRealEstateAgentOrRegular;

    public User(String userName, String password, String phoneNumber, boolean isRealEstateAgentOrRegular) {
        this.name = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isRealEstateAgentOrRegular = isRealEstateAgentOrRegular;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean matchCreds(String userName,String password){
        return userName.equals(this.name)&&password.equals(this.password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isRealEstateAgentOrRegular() {
        return isRealEstateAgentOrRegular;
    }
    public String conversionRealEstateAgentOrRegular(){
        String RealEstateAgentOrRegular;
        if(this.isRealEstateAgentOrRegular){
            RealEstateAgentOrRegular="real estate agent";
        }else RealEstateAgentOrRegular="regular user";
        return RealEstateAgentOrRegular;
    }

    public void setRealEstateAgentOrRegular(boolean realEstateAgentOrRegular) {
        isRealEstateAgentOrRegular = realEstateAgentOrRegular;
    }

    @Override
    public String toString() {
        return this.name+" "+ this.phoneNumber+ "("+conversionRealEstateAgentOrRegular()+").";
    }
}
