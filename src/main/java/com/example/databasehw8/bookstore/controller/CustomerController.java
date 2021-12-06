package com.example.databasehw8.bookstore.controller;

import com.example.databasehw8.bookstore.domain.Contains;
import com.example.databasehw8.bookstore.domain.Customer;
import com.example.databasehw8.bookstore.projection.BookPublisherAuthor;
import com.example.databasehw8.bookstore.repository.ContainsRepository;
import com.example.databasehw8.bookstore.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerController {
    private CustomerRepository customerRepository;
    private ContainsRepository containsRepository;

    /**
     * 모든 고객의 정보 확인
     * @return
     */
    @GetMapping(value = "/customer")
    public ModelAndView customers() {
        List<Customer> customerList = customerRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("2cCustomer");
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    /**
     * 특정 고객이 주문한 도서 정보 확인
     * @param email
     * @return
     */
    @GetMapping(value = "/customer/book")
    public ModelAndView customerBooks(@RequestParam String email) {
        System.out.println(email);
        List<BookPublisherAuthor> bookPublisherAuthors = containsRepository.findAllByCustomer(email);
        Customer customer = customerRepository.getById(email);
        ModelAndView modelAndView = new ModelAndView("2cCustomerBooks");
        modelAndView.addObject("customerName", customer.getName());
        modelAndView.addObject("bookPublisherAuthors", bookPublisherAuthors);
        return modelAndView;
    }
}
