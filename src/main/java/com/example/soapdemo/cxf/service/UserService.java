package com.example.soapdemo.cxf.service;

import com.example.soapdemo.cxf.model.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://ws.cxf.soapdemo.example.com/")
public interface UserService {
    @WebMethod
    String getUserName(@WebParam(name = "userId") String userId);

    @WebMethod
    User getUser(@WebParam(name = "userId") String userId);

    @WebMethod
    List getUserList(@WebParam(name = "userId") String userId);
}
