package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.model.Customer;
import th.ac.ku.atm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // handle user request
    // step1. update model for template

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;

    }

    @GetMapping
    public String getCustomerPage(Model model){


        model.addAttribute("allCustomers",customerService.getCustomers()); //ชื่อต้องตรงกับ key customer.html

        return "customer"; //customer.html template
    }

    @PostMapping
    public String registerCustomer(@ModelAttribute Customer customer, Model model){

        customerService.createCustomer(customer);

        model.addAttribute("allCustomers",customerService.getCustomers());
        return "redirect:customer";
    }


}
