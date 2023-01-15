public class Property {
    private String city;
    private String street;
    private Integer numberOfRooms;
    private Integer price;
    private int buildingType;
    private String[] buildingTypes = {"", "Regular apartment", "Penthouse apartment", "Private house"};
    private Boolean isRentable;
    private Integer houseNumber;
    private Integer floorNumber;
    private User sellerName;


    public Property(String city, String street, Integer numberOfRooms, Integer price, int buildingType, Boolean isRentable, Integer houseNumber, Integer floorNumber, User sellerName) {
        this.city = city;
        this.street = street;
        this.numberOfRooms = numberOfRooms;
        this.price = price;
        this.buildingType = buildingType;
        this.isRentable = isRentable;
        this.houseNumber = houseNumber;
        this.floorNumber = floorNumber;
        this.sellerName = sellerName;
    }

    @Override
    public String toString() {
        return city + " - " + street + " " + houseNumber + ".\n" +
                buildingTypes[this.buildingType] + " - for " + ConversionRentable() + ":" + this.numberOfRooms + "\n" +
                "rooms ,floor number " + this.floorNumber + "\n" +
                "Price: "+ this.price+"$.\n"+
                "Contact info: "+this.sellerName+"\n"+"\n";
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumberOfRooms() {
        return this.numberOfRooms;
    }
    public boolean matchNumberRooms(int room){
        return this.numberOfRooms==room;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getPrice() {
        return this.price;
    }
    public boolean matchPriceRange(int minPrice,int maxPrice){
        return (this.price>=minPrice &&this.price<=maxPrice);
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public int getBuildingType() {
        return this.buildingType;
    }
    public boolean matchBuildingType(int type){
        return this.buildingType==type;
    }

    public void setBuildingType(int buildingType) {
        this.buildingType = buildingType;
    }

    public boolean matchRentable(boolean rentOrSale){
        return this.isRentable==rentOrSale;
    }
    //O(n) Complexity
    public String ConversionRentable() {
        String rentOrSell;
        if (this.isRentable) {
            rentOrSell = "rent";
        } else rentOrSell = "sell";
        return rentOrSell;
    }

    public void setRentable(boolean rentable) {
        isRentable = rentable;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public User getSellerName() {
        return sellerName;
    }

    public void setSellerName(User sellerName) {
        this.sellerName = sellerName;
    }

}
