/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.addressbookmvc;

import com.tsg.addressbookmvc.dao.AddressBookDAO;
import com.tsg.addressbookmvc.dto.Address;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
@Controller
public class RESTController {

    // The controller uses the DAO to do all the heavy lifting of storing
    // and retrieving Addresses
    private final AddressBookDAO dao;

    // @Inject and @Autowired are synonyms
    // This annotation tells the Spring Framework to hand an object of type
    // AddressBookDao to this constructor when it creates an instance of this
    // class (which happens when the web application starts). If there is no
    // object of type AddressListDao defined in the Spring application context,
    // Spring Framework will throw an exception.
    @Inject
    public RESTController(AddressBookDAO dao) {
        this.dao = dao;
    }

    // This method will be invoked by Spring MVC when it sees a GET request for
    // AddressBookMVC/address/<some-contact-id>. It retrieves the Address
    // associated with the given address id (or null if no such Address
    // exists).
    //
    // @ResponseBody indicates that the object returned by this method should
    // be put in the body of the response going back to the caller.
    //
    // @PathVariable indicates that the portion of the URL path marked by curly
    // braces {...} should be stripped out, converted to an int and passed into
    // this method when it is invoked.
    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Address getAddress(@PathVariable("id") int id) {
        return dao.getAddressById(id);
    }

    // This method will be invoked by Spring MVC when it sees a POST request for
    // AddressBookMVC/address. It persists the given Address to the data layer.
    //
    // @ResponseStatus tells Spring MVC to return an HTTP CREATED status upon success
    //
    // @ResponseBody indicates that the object returned by this method should
    // be put in the body of the response going back to the caller.
    //
    // @RequestBody indicates that we expect an Address object
    // in the body of the incoming request.
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    // response back to javascript confirming request was created
    @ResponseStatus(HttpStatus.CREATED)
    // payload expected
    @ResponseBody
    public Address createAddress(@Valid @RequestBody Address address) {
        // persist the incoming address
        // The addAddress call to the dao assigned an addressId to the incoming
        // Address and set that value on the object. Now we return the updated
        // object to the caller.
        return dao.addAddress(address);

    }

    // This method will be invoked by Spring MVC when it sees a DELETE request
    // for AddressBookMVC/address/<some-address-id>. It deletes the Address
    // associated with the give id from the data layer (it does nothing if there
    // is no such Address).
    //
    // @ResponseStatus tells Spring MVC to return HTTP NO_CONTENT from this call
    // because this method has no return value.
    //
    // @PathVariable indicates that the portion of the URL path marked by curly
    // braces {...} should be stripped out, converted to an int and passed into
    // this method when it is invoked.
    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable("id") int id) {
        // remove the Address associated with the given id from the data layer
        dao.removeAddress(id);

    }

    // This method will be invoked by Spring MVC when it sees a PUT request for
    // AddressBookMVC/address/<some-address-id>. It updates the given Address
    // to the data layer.
    //
    // @ResponseStatus tells Spring MVC to return HTTP NO_CONTENT from this call
    // because this method has no return value.
    //
    // @PathVariable indicates that the portion of the URL path marked by curly
    // braces {...} should be stripped out, converted to an int and passed into
    // this method when it is invoked.
    //
    // @RequestBody indicates that we expect an Address object in the body of the
    // incoming request.
    @RequestMapping(value = "/address/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAddress(@PathVariable("id") int id, @Valid @RequestBody Address address) {
        // set the value of the PathVariable id on the incoming Address object
        // to ensure that a) the address id is set on the object and b) that
        // the value of the PathVariable id and the Address object id are the
        // same.
        address.setAddressId(id);
        // update the address
        dao.updateAddress(address);

    }

    // This method will be invoked by Spring MVC when it sees a GET request for
    // AddressBookMVC/addresses. It retrieves all of the Addresses from the
    // data layer and returns them in a List.
    //
    // @ResponseBody indicates that the List returned by this method should
    // be put in the body of the response going back to the caller. 'Payload expected'
    @RequestMapping(value = "/addresses", method = RequestMethod.GET)
    @ResponseBody
    public List<Address> getAllAddresses() {
        // get all of the Addresses from the data layer
        return dao.getAllAddresses();

    }
}