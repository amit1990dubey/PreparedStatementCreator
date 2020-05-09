package com.ibm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Lab60 {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("ibmindia.xml");
        CustomerDAO cdao = (CustomerDAO) ctx.getBean("cdao");

        //1. ADD customer
        CustomerTO cto = new CustomerTO(481,"amit","a@ibm.com",3456789,"Bangalore");
        cdao.addCustomer(cto);

        //2. get All Customers

        System.out.println("getAllCustomers");
        List<CustomerTO> list = cdao.getAllCustomers();

        for(CustomerTO ct : list)
        {
            System.out.println(ct);
        }
    }
}
