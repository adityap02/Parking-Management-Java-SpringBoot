package com.epam.engx.cleancode.functions.task1;


import com.epam.engx.cleancode.functions.task1.thirdpartyjar.Address;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ValidAccountMock extends ValidAccountStub {

    private boolean created = false;
    private Address homeAddress = new AddressDummy();
    private Address workAddress = new AddressDummy();
    private Address additionalAddress = new AddressDummy();
    private List<Address> addresses;

    @Override
    public void setCreatedDate(Date date) {
        created = true;
    }

    @Override
    public Address getHomeAddress() {
        return this.homeAddress;
    }

    @Override
    public Address getWorkAddress() {
        return this.workAddress;
    }

    @Override
    public Address getAdditionalAddress() {
        return this.additionalAddress;
    }

    @Override
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void assertCreationDateExist() {
        assertTrue(created);
    }

    public void assertHomeAddressInAddresses() {
        assertTrue(this.addresses.contains(homeAddress));
    }

    public void assertWorkAddressInAddresses() {
        assertTrue(this.addresses.contains(workAddress));
    }

    public void assertAdditionalAddressInAddresses() {
        assertTrue(this.addresses.contains(additionalAddress));
    }
}
