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
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
@Controller
public class HomeControllerNoAjax {

    // Reference to our DAO
    private final AddressBookDAO dao;

    // Use annotation-driven constructor injection to inject a DAO implementation
    // into our controller
    @Inject
    public HomeControllerNoAjax(AddressBookDAO dao) {
        this.dao = dao;
    }

    // This endpoint simply returns the name of the view that will serve as
    // the main landing page for the new functionality. The name of that view
    // is displayAddressListNoAjax.jsp.
    //
    // NOTE: The RequestMapping value, the name of the method, and the name
    // of the JSP are all the same in this case (displayAddressListNoAjax).
    // THIS IS NOT A REQUIREMENT!!! These names can be all different if
    // you want them to be.
    //
    // NOTE: This method does take a Model object as a parameter. This is
    // because this method gets a list of all the Address objects from the
    // DAO. We need to place this list on the Model so that Spring MVC
    // can pass the list of Addresses on to the view component. We'll
    // use JSTL tags to iterate through the list and print the Address
    // information to the screen.
    @RequestMapping(value = "/displayAddressListNoAjax", method = RequestMethod.GET)
    public String displayAddressListNoAjax(Model model) {
        // Get the list of all Addresses
        List<Address> adList = dao.getAllAddresses();
        // Put the list of all Addresses on the Model so Spring MVC can pass it
        // along to the view
        model.addAttribute("addressBook", adList);
        // Return the logical view name
        return "displayAddressListNoAjax";
    }

    // This endpoint simply returns the name of the view that will display the
    // New Address Form (newAddressFormNoAjax.jsp).
    @RequestMapping(value = "displayNewAddressFormNoAjax", method = RequestMethod.GET)
    public String displayNewAddressFormNoAjax(Model model) {
        Address address = new Address();

        model.addAttribute("address", address);
        return "newAddressFormNoAjax";
    }

    @RequestMapping(value = "/addNewAddressFormNoAjax", method = RequestMethod.POST)
    public String addNewAddressNoAjax(@Valid @ModelAttribute("address") Address address,
            BindingResult result) {
        if (result.hasErrors()) {
            return "newAddressFormNoAjax";
        }

        // below are not needed with new funtionality, kept as a reference 
//        <-- Get all of the form data from the request -->
//        String firstName = req.getParameter("firstName");
//        String lastName = req.getParameter("lastName");
//        String address = req.getParameter("address");
//        String city = req.getParameter("city");
//        String state = req.getParameter("state");
//        String zipCode = req.getParameter("zipCode");
//
//        <--Create a new Contact and set all the fields-->
//        Address address1 = new Address();
//        address1.setFirstName(firstName);
//        address1.setLastName(lastName);
//        address1.setAddress(address);
//        address1.setCity(city);
//        address1.setState(state);
//        address1.setZipCode(zipCode);
//
//        Add the Address to the DAO
        dao.addAddress(address);
        // Redirect to the displayAddressListNoAjax controller endpoint - we must
        // use the redirect: here so that Spring MVC routes us to the controller
        // endpoint and not directly to a JSP.
        return "redirect:displayAddressListNoAjax";

    }

    // This method gets the id of the Address to be deleted from the
    // HttpServletRequest and then asks the DAO to delete the Address. When
    // finished, it redirects to the displayAddressListNoAjax controller
    // endpoint.
    @RequestMapping(value = "/deleteAddressNoAjax", method = RequestMethod.GET)
    public String deleteAddressNoAjax(HttpServletRequest req) {
        // Get the id of the address to be deleted from the HttpServletRequest
        int addressId = Integer.parseInt(req.getParameter("addressId"));
        // Ask DAO to delete the given contact
        dao.removeAddress(addressId);
        // Redirect to the displayAddressListNoAjax controller endpoint - we must
        // use the redirect: here so that Spring MVC routes us to the controller
        // endpoint.
        return "redirect:displayAddressListNoAjax";
    }

    // This method gets the id of the Address to be edited from the HttpServletRequest,
    // retrieves the specified Address from the DAO, puts the retrieved Address
    // on the Model, and returns the name of the view that will display the
    // Address data in the Edit Form.
    @RequestMapping(value = "/displayEditAddressFormNoAjax", method = RequestMethod.GET)
    public String displayEditAddressFormNoAjax(HttpServletRequest req, Model model) {
        // Get the id of the Address to be edited
        int addressId = Integer.parseInt(req.getParameter("addressId"));
        // Get the Address from the DAO
        Address address = dao.getAddressById(addressId);
        // Put the Address on the Model
        model.addAttribute("address", address);

        return "editAddressFormNoAjax";
    }

    // This method uses the @ModelAttribute annotation to tell Spring to
    // convert the submitted form data into a Address object for us. The method
    // then hands the Address to the DAO for update, and finally redirects to
    // the displayAddressListNoAjax controller endpoint.
    @RequestMapping(value = "/editAddressNoAjax", method = RequestMethod.POST)
    public String EditAddressNoAjax(@Valid @ModelAttribute("address") Address address,
            BindingResult result) {
        if (result.hasErrors()) {
            return "editAddressFormNoAjax";
        }

        dao.updateAddress(address);
        return "redirect:displayAddressListNoAjax";
    }
}
