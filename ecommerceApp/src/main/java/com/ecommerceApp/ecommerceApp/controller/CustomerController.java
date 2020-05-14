package com.ecommerceApp.ecommerceApp.controller;

import com.ecommerceApp.ecommerceApp.dtos.AddressDto;
import com.ecommerceApp.ecommerceApp.dtos.CustomerViewProfileDto;
import com.ecommerceApp.ecommerceApp.dtos.PasswordDto;
import com.ecommerceApp.ecommerceApp.entities.ReturnJson;
import com.ecommerceApp.ecommerceApp.services.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Locale;
import java.util.Set;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    MessageSource messageSource;

    ///////////////done
    @ApiOperation(value = "Api to view the profile of customer", authorizations = {@Authorization(value = "Bearer")})
    @GetMapping(value = "/customer", produces = "application/json")
    public CustomerViewProfileDto getprofile(@ApiIgnore HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        String username = principal.getName();
        return customerService.getcustomerProfile(username);
    }

    //////////done
    @ApiOperation(value = "Api to view all the address of customer", authorizations = {@Authorization(value = "Bearer")})
    @GetMapping(value = "/customer/addresses", produces = "application/json")
    public Set<AddressDto> getCustomerAddresses(@ApiIgnore HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        String username = principal.getName();
        return customerService.getCustomerAllAdress(username);
    }

    //////////done
    @ApiOperation(value = "Api to add new address for the customer", authorizations = {@Authorization(value = "Bearer")})
    @PostMapping(value = "/customer/addresses", produces = "application/json")
    public ReturnJson addNewAddress(@Valid @RequestBody AddressDto addressDto, @ApiIgnore HttpServletRequest request, @ApiIgnore Locale locale) {
        Principal principal = request.getUserPrincipal();
        String username = principal.getName();
        return customerService.addNewAddress(username, addressDto, locale);
    }

    /////////////////////done
    @ApiOperation(value = "Api to Update the profile of the customer", authorizations = {@Authorization(value = "Bearer")})
    @PutMapping(value = "/customer", produces = "application/json")
    public ResponseEntity updateProfile(@Valid @RequestBody CustomerViewProfileDto customerViewProfileDto,
                                        @ApiIgnore HttpServletRequest httpServletRequest, @ApiIgnore Locale locale) {
        Principal principal = httpServletRequest.getUserPrincipal();
        String username = principal.getName();
        return customerService.updateCustomerProfile(username, customerViewProfileDto, locale);
    }

    ////////////////dalabase mai persist nai ho rha
    @ApiOperation(value = "Api to delete address of customer", authorizations = {@Authorization(value = "Bearer")})
    @DeleteMapping(value = "/customer/address/{id}", produces = "application/json")
    public ReturnJson deleteAddressById(@PathVariable Long id, @ApiIgnore HttpServletRequest request, @ApiIgnore Locale locale) {
        Principal principal = request.getUserPrincipal();
        String username = principal.getName();
        return customerService.deleteAddress(username, id, locale);
    }

    ///////////////////dekha ha
    @ApiOperation(value = "Api to Update the address of customer", authorizations = {@Authorization(value = "Bearer")})
    @PatchMapping(value = "/customer/address/{id}", produces = "application/json")
    public ReturnJson updateCustomerAddress(@Valid @RequestBody AddressDto addressDto,
                                            @PathVariable Long id, HttpServletRequest httpServletRequest, @ApiIgnore Locale locale) {
        Principal principal = httpServletRequest.getUserPrincipal();
        String username = principal.getName();
        return customerService.updateCustomerAddress(username, addressDto, id, locale);

    }

    /////////done
    @ApiOperation(value = "Api to Update the Password of customer", authorizations = {@Authorization(value = "Bearer")})
    @PutMapping(value = "/customer/password", produces = "application/json")
    public String updatePassword(@RequestBody PasswordDto passwordDto, @ApiIgnore Locale locale) {
        customerService.updateCustomerPassword(passwordDto, locale);
        return messageSource.getMessage("password.updated.message", null, locale);
    }
}
