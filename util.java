import java.io.*; 

class Contact {
    /* Class containing all contact information. */
    /* Initializing file reader */
    BufferedWriter output;
    private String id;
    private String fName;
    private String lName;
    private String phone;
    private String address;
    private String email;

    public void setId(String userId) {
        this.id = userId;
    }
    public String getId() {
        return id;
    }
    public void setFname(String userFname) {
        this.fName = userFname;
    }
    public String getFname() {
        return fName;
    }
    public void setLname(String userLname) {
        this.lName = userLname;
    }
    public String getLname() {
        return lName;
    }
    public void setPhone(String userPhone) {
        this.phone = userPhone;
    }
    public String getPhone() {
        return phone;
    }
    public void setAddress(String userAddress) {
        this.address = userAddress;
    }
    public String getAddress() {
        return address;
    }
    public void setEmail(String userEmail) {
        this.email = userEmail;
    }
    public String getEmail() {
        return email;
    }
    int lastId = 1;
    /* Creating new contact */
    public Contact(int id, String fName, String lName, String phone, String address, String email) {
        setId(Integer.toString(id));
        setFname(fName);
        setLname(lName);
        setPhone(phone);
        setAddress(address);
        setEmail(email);
        try {
            output = new BufferedWriter(new FileWriter("contacts.txt", true));
            output.append(Integer.toString(id) + ", " + fName + ", " + lName + ", " + phone + ", " + address + ", " + email);
            output.newLine();
            output.close();   
        }
        catch (IOException e){
            System.out.println("Error");
        }
    }
}
