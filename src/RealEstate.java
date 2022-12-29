import java.util.Scanner;

public class RealEstate {

    private User[] users = new User[5];
    private Property[] properties=new Property[5];
    private City[] cities;
    private final int FIRST_NUMBER = 0, SECOND_NUMBER = 1, PHONE_LENGTH = 10, MIN_PASS_LENGTH = 5;


    public RealEstate() {
        this.cities = new City[10];
        City yeruham = new City("Yeruham", "Negev", "Rabin, Begin");
        City dimona = new City("Dimona", "Negev", "Kadesh, Ben ami");
        City ashkelon = new City("Ashkelon", "South", "Carmel, Binyamin");
        City ashdod = new City("Ashdod", "South", "Habanot, Yekutiel adam");
        City telAviv = new City("Tel Aviv", "Central", "Jerusalem,Bet ezra");
        City rishonLezion = new City("Rishon Lezion", "Central", "Golani, Alexandroni");
        City netanya = new City("Netanya", "Sharon", "Givati, Yaalom");
        City herzliya = new City("Herzliya", "Sharon", "Nahal, City");
        City nahariya = new City("Nahariya", "North", "Bar kochva, Balfor");
        City carmiel = new City("Carmiel", "North", "Paratroops, Navon");
        this.cities = new City[]{yeruham, dimona, ashkelon, ashdod, telAviv, rishonLezion, netanya, herzliya, nahariya, carmiel};
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Please enter 1 - to create a new user\nPlease enter 2 - to log in\nPlease enter 3 to quit the program");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> createUser();
                case 2 -> {
                    User user = login();
                    if (user != null) {
                        menuProperty(user);
                    }
                }
                case 3 -> endProgram();
            }

        } while (choice != 3);
    }

    public void endProgram() {
        System.out.println("Bye.");
    }

    public User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert your user name");
        String userName = scanner.nextLine();
        User user = null;
        boolean currectUser = false;
        int userLocation = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                if (users[i].getName().equals(userName)) {
                    userLocation = i;
                    currectUser = true;
                    break;
                }
            }
        }
        if(!currectUser) System.out.println("The user doesn't exists in the system");
        if (currectUser) {
            System.out.println("Please enter your password");
            String password = scanner.nextLine();
            if (users[userLocation].getPassword().equals(password)) {
                user = users[userLocation];
            } else System.out.println("The password doesn't exists in the system");
        }
        return user;
    }


    public void createUser() {
        User[] usersArray = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            usersArray[i] = this.users[i];
        }
        User newUser = new User(userId(), password(), phoneNumber(), isRealEstateAgent());
        usersArray[this.users.length] = newUser;
        this.users = usersArray;
    }


    private String userId() {
        Scanner scanner = new Scanner(System.in);
        String userId;
        boolean checkName = false;
        do {
            System.out.println("Please enter your user name");
            userId = scanner.nextLine();
            checkName = isIdExists(userId);
            if (checkName) {
                System.out.println("The user name is already in the system");
            }
        } while (checkName);
        return userId;
    }

    private boolean isIdExists(String userId) {
        boolean isExist = false;
        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i] != null) {
                if (this.users[i].getName().equals(userId)) {
                    isExist = true;
                    break;
                }
            }
        }
        return isExist;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    private boolean isRealEstateAgent() {
        Scanner scanner = new Scanner(System.in);
        boolean isRealEstate = false;
        int answer;
        do {
            System.out.println("Please enter 1 if you are a real estate agent, 2 if regular user");
            answer = scanner.nextInt();
        } while (answer != 1 && answer != 2);
        if (answer == 1) {
            isRealEstate = true;
        }
        return isRealEstate;
    }

    private String password() {
        Scanner scanner = new Scanner(System.in);
        String password;
        do {
            System.out.println("Please enter a valid password that contains at least 5 characters and has at least one of those symbols : ($,%,_)");
            password = scanner.nextLine();
            if (!checkPass(password)) {
                System.out.println("You entered invalid password");
            }
        } while (!checkPass(password));
        return password;
    }


    private boolean checkPass(String password) {
        boolean check = false;
        if (password.length() >= 5) {
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                    check = true;
                    break;
                }
            }
        }
        if (check) {
            for (int j = 0; j < password.length(); j++) {
                if (password.charAt(j) == '_' || password.charAt(j) == '$' || password.charAt(j) == '%') {
                    check = true;
                    break;
                } else {
                    check = false;
                }
            }
        }
        return check;
    }

    private String phoneNumber() {
        Scanner scanner = new Scanner(System.in);
        String phoneNumber;
        do {
            System.out.println("Please enter a valid Israeli phone number");
            phoneNumber = scanner.nextLine();
        } while (!isValidPhoneNumber(phoneNumber));
        return phoneNumber;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        boolean isValid = false;
        if (phoneNumber.charAt(FIRST_NUMBER) == '0' && phoneNumber.charAt(SECOND_NUMBER) == '5' && phoneNumber.length() == PHONE_LENGTH) {
            for (int i = 0; i < phoneNumber.length(); i++) {
                char tempChar = phoneNumber.charAt(i);
                if (!Character.isDigit(tempChar)) {
                    isValid = false;
                    break;
                } else {
                    isValid = true;
                }
            }
        }
        if (!isValid) {
            System.out.println("You entered invalid phone number");
        }
        return isValid;
    }

    public void menuProperty(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You can continue to choose from the following list:\n" +
                "1.Post a new property.\n" +
                "2.Remove advertising on a property.\n" +
                "3.show all the properties in the system.\n" +
                "4.View all my properties.\n" +
                "5.Search for a property by parameter.\n" +
                "6.Disconnect and return to the main menu.");

        int newChoice;
        do {
            newChoice = scanner.nextInt();
            switch (newChoice) {
                case 1 -> {
                    if (postNewProperty(user)) {
                        System.out.println("Your property is saved");
                    } else System.out.println("Your property has not been saved");
                }
                case 2 -> removeProperty(user);
                case 3 -> printAllProperties();
                case 4 -> printProperties(user);
                case 5 -> search();
                case 6 ->
                        System.out.println("Back to the main menu"); // צריך לגרום לפונקציה לצאת מהתוכנית, לוודא אם זה יוצא וחוזר לתפריט החוזר
            }
        } while (newChoice < 1 || newChoice > 6);
    }


    public boolean postNewProperty(User user) {
        Scanner scanner = new Scanner(System.in);
        boolean checkAllowPost;
        int counter = 0;

            for (int i = 0; i < properties.length; i++) {
                if(properties[i]!=null) {
                    if (properties[i].getSellerName() == user)
                        counter++;
                }
            }

        if (user.isRealEstateAgentOrRegular() && counter < 5) {
            checkAllowPost = true;
            System.out.println("You can post,Note that you can post " + (5 - counter) + " more");
        } else if (!user.isRealEstateAgentOrRegular() && counter < 2) {
            checkAllowPost = true;
            System.out.println("You can post,Note that you can post " + (2 - counter) + " more");
        } else {
            checkAllowPost = false;
            System.out.println("You cannot post, you have reached a maximum number");
        }

        if (checkAllowPost) {
            int city = checkCity();
            if (city == -1) {
                System.out.println("The name of the city does not exist in the system");
                checkAllowPost = false;
            } else {
                boolean currectStreet = checkStreets(city);
                if (!currectStreet) {
                    System.out.println("The street you gave is not on the available streets");
                    checkAllowPost = false;
                } else {
                    checkAllowPost = propertyType(user, city);
                }

            }
        }
        return checkAllowPost;
    }


    public int checkCity() {
        Scanner scanner = new Scanner(System.in);
        boolean checkCity = false;
        for (int i = 0; i < this.cities.length; i++) {
            System.out.println(this.cities[i].getName() + ",");
        }
        System.out.println("Please enter the name of the city you would like to see");
        String nameCity = scanner.nextLine();
        nameCity = nameCity.toLowerCase();
        int location = -1;
        for (int t = 0; t < this.cities.length; t++) {
            if (this.cities[t].getName().toLowerCase().equals(nameCity)) {
                checkCity = true;
                location = t;
                break;
            }
        }
        return location;

    }

    public boolean checkStreets(int city) {
        Scanner scanner = new Scanner(System.in);
        boolean checkStreet = false;
        System.out.println(this.cities[city].getAvailableStreets());
        System.out.println("Please enter a street");
        String nameStreet = scanner.nextLine();
        nameStreet = nameStreet.toLowerCase();
        String[] parts = this.cities[city].getAvailableStreets().split(", ");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].toLowerCase().equals(nameStreet)) {
                checkStreet = true;
                break;
            }
        }
        return checkStreet;
    }

    public boolean propertyType(User user, int city) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 for normal apartment in the building\n" +
                "Press 2 for Penthouse in the building\n" +
                "Press 3 for a private house");
        int userChoice = scanner.nextInt();
        boolean validCheck = false;
        boolean checkBuild = false;
        if (userChoice >= 1 && userChoice <= 3) {
            validCheck = true;
            switch (userChoice) {
                case 1 -> checkBuild = buildingApartment(user, city);
                case 2 -> System.out.println("You chose penthouse, will be added on our next program");
                case 3 -> System.out.println("You chose private house, will be added on our next program");
            }
        } else System.out.println("You choose is invalid option ");

        return checkBuild;
    }

    public boolean buildingApartment(User user, int city) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What floor is the property on?");
        int floor = scanner.nextInt();
        System.out.println("How many rooms are in the property?");
        int room = scanner.nextInt();
        System.out.println("What is the property's house number?");
        int homeNumber = scanner.nextInt();
        boolean rentOrSale = false;
        int rentOrSaleInt;
        do {
            System.out.println("Press 1 if the building is for rent\t" +
                    "press 2 if the building is for sale");
            rentOrSaleInt = scanner.nextInt();
            if (rentOrSaleInt == 1) {
                rentOrSale = true;
            }
            if (rentOrSaleInt == 2) {
                rentOrSale = false;
            }
        } while (rentOrSaleInt != 1 && rentOrSaleInt != 2);
        System.out.println("What is the price for the property?");
        int price = scanner.nextInt();
        boolean ifCreated = false;
        Property property1 = new Property(this.cities[city].getName(), this.cities[city].getAvailableStreets(), room, price, 1, rentOrSale, homeNumber, floor, user);

            for (int j = 0; j < this.properties.length; j++) {
                if (properties[j] == null) {
                    properties[j] = property1;
                    ifCreated = true;
                    break;
                }
            }

        if (ifCreated) {
            System.out.println("The property saved");
        } else {
            System.out.println("The property did not assign to the system");
        }
        return ifCreated;
    }

    public void removeProperty(User user) {
        final int MAX_PROPERTY = 5;
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        Property[] propertyLocation = new Property[MAX_PROPERTY];
        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null && properties[i].getSellerName() == user) {
                propertyLocation[counter] = properties[i];
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("You have no properties to remove");
        } else {
            System.out.println("Those are your properties:");
            for (int t = 0, count = 1; t < propertyLocation.length; t++) {
                if (propertyLocation[t] != null) {
                    System.out.println(count + " " + propertyLocation[t]);
                    count++;
                }
            }
            int remove;
            do {
                System.out.println("Select the number you want to remove");
                remove = scanner.nextInt();
            } while (remove > counter || remove <= 0);
            remove -= 1;
            boolean removed = false;
            for (int j = 0; j < properties.length; j++) {
                if (properties[j] == propertyLocation[remove]) {
                    properties[j] = null;
                    removed = true;
                    break;
                }
            }
            if (removed) System.out.println("The removal was successful");
        }

    }

    private void printAllProperties() {
        int counter = 1;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null) {
                System.out.println(counter + ") " + properties[i]);
                counter++;
            }
        }
    }

    private void printProperties(User user) {
        int counter = 1;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null && properties[i].getSellerName() == user) {
                System.out.println(counter + ") " + properties[i]);
                counter++;
            }

        }
    }

    public Property[] search() {
        Scanner scanner = new Scanner(System.in);
        int rentOrSaleInt;
        boolean rentOrSale = false;
        do {
            System.out.println("Press 1 if the building is for rent\t" +
                    "press 2 if the building is for sale");
            rentOrSaleInt = scanner.nextInt();
            if (rentOrSaleInt == 1) {
                rentOrSale = true;
            }
            if (rentOrSaleInt == 2) {
                rentOrSale = false;
            }
        } while ((rentOrSaleInt < 1 || rentOrSaleInt > 2) && rentOrSaleInt != -999);

        int type;
        do {
            System.out.println("Press 1 if The property type is an apartment\n" +
                    "press 2 if if The property type is Penthouse apartment\n"
                    + "press 3 if The property type is Private house\n");

            type = scanner.nextInt();
        } while ((type < 1 || type > 3) && type != -999);

        int rooms;
        do {
            System.out.println("Enter a number of rooms:");
            rooms = scanner.nextInt();
        } while (rooms < 0 && type != -999);

        int minPrice;
        int maxPrice;
        do {
            System.out.println("Enter the price range:\n" + "Min price:");
            minPrice = scanner.nextInt();
            System.out.println("Max price:");
            maxPrice = scanner.nextInt();
        } while ((maxPrice < minPrice) && (minPrice != -999 && maxPrice != -999));

        Property[] propertySearch = new Property[properties.length];
        int counter = 0;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i].isRentable() == rentOrSale || rentOrSaleInt == -999) {
                if (properties[i].getBuildingType() == type || type == -999) {
                    if (properties[i].getNumberOfRooms() == rooms || rooms == -999) {
                        if ((properties[i].getPrice() >= minPrice && properties[i].getPrice() <= maxPrice) || (minPrice == -999 || maxPrice == -999)) {
                            propertySearch[counter] = properties[i];
                            counter++;
                        }
                    }
                }
            }
        }
        Property[] propertyNewSearch = new Property[counter];
        propertyNewSearch = propertySearch;
        return propertyNewSearch;
    }


}



