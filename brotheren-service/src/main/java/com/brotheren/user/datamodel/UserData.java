package com.brotheren.user.datamodel;

public class UserData {
    private long id;
    private String userId;
    private String phone;
    private String email;
    private String firstName;
    private String lastName;

    public UserData(long id, String userId, String phone, String email, String firstName, String lastName) {
        this.id = id;
        this.userId = userId;
        this.phone = phone;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public UserData withId(long id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public UserData withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserData withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
