package com.epam.engx.cleancode.naming.task4.service.impl;


import com.epam.engx.cleancode.naming.task4.service.CustomerContactService;
import com.epam.engx.cleancode.naming.task4.thirdpartyjar.CustomerContact;
import com.epam.engx.cleancode.naming.task4.thirdpartyjar.CustomerContactDAO;

public class CustomerContactServiceImpl implements CustomerContactService {

    private CustomerContactDAO customerContactDAO;

    public CustomerContact findCustomerContactDetailsByCustomerId(Long customerId) {
        return customerContactDAO.findById(customerId);
    }

    public void updateCustomerContactDetails(CustomerContact customerContactDetails) {
        customerContactDAO.update(customerContactDetails);
    }
}
