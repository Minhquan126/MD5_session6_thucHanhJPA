package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Customer;
import ra.service.CustomerServiceIMP;
import ra.service.ICustomerService;

import java.util.List;

@Controller
@RequestMapping({"/customerController","/"})
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping({"/getAll",""})
    public String getAll(Model model){
        List<Customer> list = customerService.findAll();
        model.addAttribute("list",list);
        return "index";
    }
@GetMapping("/create")
    public ModelAndView create(){
return new ModelAndView("creat","customer",new Customer());
}
@PostMapping("add")
    public String add(@ModelAttribute("customer") Customer customer,Model model){
        customerService.save(customer);
        return "redirect:/";
}
@GetMapping("edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id){
        return new ModelAndView("edit","editCus",customerService.findById(id));
}
@PostMapping("update")
    public String update(@ModelAttribute("editCus") Customer customer){
customerService.save(customer);
return "redirect:/";
}
@GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id){
        customerService.delete(id);
        return "redirect:/";
}
}
