package com.ecommerceApp.ecommerceApp.controller;
import com.ecommerceApp.ecommerceApp.dtos.CustomerDto;
import com.ecommerceApp.ecommerceApp.dtos.SellerDto;
import com.ecommerceApp.ecommerceApp.services.Activation_Deactivation_Service;
import com.ecommerceApp.ecommerceApp.services.CustomerService;
//import com.ecommerceApp.ecommerceApp.services.SellerService;
//import com.ecommerceApp.ecommerceApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
public class AdminController {
    @Autowired
    CustomerService customerService;

    @Autowired
    Activation_Deactivation_Service activation_deactivation_service;

/*
    @GetMapping("/customers")
    public List<CustomerDto> getAllCustomers(@RequestParam(defaultValue = "0") String offset,
                                             @RequestParam(defaultValue = "10") String size,
                                             @RequestParam(defaultValue = "id") String sortByField,
                                             @RequestParam(required = false) String email) {
        if (email != null)
            return Arrays.asList(customerService.getCustomerByEmail(email));

        return customerService.getAllCustomers(offset, size, sortByField);
    }

    @GetMapping("/sellers")
    public List<SellerDto> getAllSellers(@RequestParam(defaultValue = "0") String offset,
                                         @RequestParam(defaultValue = "10") String size,
                                         @RequestParam(defaultValue = "id") String sortByField,
                                         @RequestParam(required = false) String email) {
        if (email != null)
            return Arrays.asList(sellerService.getSellerByEmail(email));
        return sellerService.getAllSeller(offset, size, sortByField);
    }


 */
    @PutMapping("/activate/{id}")
    public String activateUser(@PathVariable Long id, WebRequest webRequest) {
        return activation_deactivation_service.ActivateUser(id, webRequest);
    }

    @PutMapping("/deactivate/{id}")
    public String deActivateUser(@PathVariable Long id, WebRequest webRequest) {
        return activation_deactivation_service.DeactivateUser(id, webRequest);
    }
}