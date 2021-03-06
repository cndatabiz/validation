package com.dataz.entity;

import com.dataz.groups.GroupAddress;
import com.dataz.groups.GroupName;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@GroupSequence({GroupBean.class,GroupName.class,GroupAddress.class})
public class GroupBean {
    @NotNull(groups = GroupName.class)
    String firstName;

    @NotNull(groups = GroupName.class)
    String lastName;

    @NotNull(groups = GroupAddress.class)
    String streetAddress;

    @NotNull(groups = GroupAddress.class)
    String country;

    @NotNull(groups = GroupAddress.class)
    @Size(min = 5, groups = GroupAddress.class)
    String zipCode;

    @NotNull
    String groupId;

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

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
