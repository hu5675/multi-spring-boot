package com.mars.controller;

import com.mars.dao.GirlDao;
import com.mars.model.Girl;
import com.mars.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;

@RestController
@RequestMapping
public class HelloController {

    @GetMapping(value = "/hello/say")
    public String say(HttpServletRequest request) throws IOException {

        Girl girl = new Girl();
        System.out.println(girl);
        return "客户端ip:" + this.getIp() + "，服务器ip:" + this.getIp();
    }

    private String getIp() throws SocketException {
        Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        List<String> ipList = new ArrayList<String>();
        while (allNetInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
            Enumeration addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                ip = (InetAddress) addresses.nextElement();
                if (ip != null && ip instanceof Inet4Address) {
                    ipList.add(ip.getHostAddress());
                }
            }
        }
        return ipList.toString();
    }

    @Autowired
    private GirlService girlService;


    @GetMapping(value = "/girl/list")
    public List<Girl> girlList(){
        return girlService.list();
    }
}
