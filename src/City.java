public class City {
    private String name;
    private String district;
    private String availableStreets;
    private final String[] DISTRICT = {"Negev", "South", "Central", "Sharon", "North"};
    public String getName() {
        return name;
    }

    public City(String name, String district, String availableStreets) {
        this.name = name;
        this.district = district;
        this.availableStreets = availableStreets;
    }
    public boolean matchName(String name){
        return this.name.toLowerCase().equals(name.toLowerCase());
    }
    public boolean matchStreets(String name) {
        boolean checkStreet=false;
        String[] parts = this.availableStreets.split(", ");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].toLowerCase().equals(name.toLowerCase())) {
                checkStreet = true;
                break;
            }
        }
            return checkStreet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAvailableStreets() {
        return availableStreets;
    }

    public void setAvailableStreets(String availableStreets) {
        this.availableStreets = availableStreets;
    }
}
