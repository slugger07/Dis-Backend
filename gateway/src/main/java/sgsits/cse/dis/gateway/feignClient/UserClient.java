package sgsits.cse.dis.gateway.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sgsits.cse.dis.gateway.message.request.SignUpForm;

@FeignClient(name = "user")
public interface UserClient {

    @RequestMapping(value = "/userFeignClientController/findUser", method = RequestMethod.POST)
    public boolean findUser(@RequestBody SignUpForm signup);

    @RequestMapping(value = "/userFeignClientController/findUserIype", method = RequestMethod.POST)
    public String findUserType(@RequestBody SignUpForm signup);

    @RequestMapping(value = "/userFeignClientController/updateEmailAndUserId", method = RequestMethod.GET)
    public boolean updateEmailAndUserId(@RequestParam("mobileNo") long mobileNo);
}

