package com.example.footballers.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "sayHello")
public interface HelloService {


    @WebMethod(operationName = "hello")
    String sayHello(@WebParam(name="name", targetNamespace = "") String name);
}
