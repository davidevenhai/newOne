public class City {
    private String name;
    private String district;
    private String availableStreets;

    public String getName() {
        return name;
    }
    private final String[] DISTRICT = {"Negev", "South", "Central", "Sharon", "North"};

    public City(String name, String district, String availableStreets) {
        this.name = name;
        this.district = district;
        this.availableStreets = availableStreets;
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
