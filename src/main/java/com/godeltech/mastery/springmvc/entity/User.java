package com.godeltech.mastery.springmvc.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Valid
public class User {

    Integer id;
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;

    String profileInfo;

    public User() {
    }

    public User(Integer id, String firstName, String lastName, String profileInfo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileInfo = profileInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getProfileInfo() {
        return profileInfo;
    }

    public void setProfileInfo(String profileInfo) {
        this.profileInfo = profileInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(profileInfo, user.profileInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, profileInfo);
    }
}
