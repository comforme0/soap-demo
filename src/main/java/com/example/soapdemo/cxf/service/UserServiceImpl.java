package com.example.soapdemo.cxf.service;

import com.example.soapdemo.cxf.model.User;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@WebService(serviceName = "UserService",
        targetNamespace = "http://ws.cxf.soapdemo.example.com/",
        endpointInterface = "com.example.soapdemo.cxf.service.UserService")
@Service
public class UserServiceImpl implements UserService {
    private static User user1;
    private static User user2;
    private static User user3;

    private static List userList = new ArrayList<>();
    private static Map<String, User> userMap;

    static {
        user1 = new User("1", "tom", "tom@gmail.com");
        user2 = new User("2", "jim", "jim@gmail.com");
        user3 = new User("3", "jack", "jack@gmail.com");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        userMap = (Map<String, User>) userList.stream().collect(Collectors.toMap(User::getUserId, Function.identity()));
    }
    @Override
    public String getUserName(String userId) {
        User user = userMap.getOrDefault(userId, new User(userId, "random", "random@gmail.com"));
        return user.getUserName();
    }

    @Override
    public User getUser(String userId) {
        User user = userMap.getOrDefault(userId, new User(userId, "random", "random@gmail.com"));
        return user;
    }

    @Override
    public List getUserList(String userId) {
        return userList;
    }
}
