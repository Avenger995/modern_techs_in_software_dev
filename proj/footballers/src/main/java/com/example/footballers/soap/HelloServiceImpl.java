package com.example.footballers.soap;


import javax.jws.WebService;

@WebService(serviceName = "Hello")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
