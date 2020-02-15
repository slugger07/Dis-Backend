package sgsits.cse.dis.gateway.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sgsits.cse.dis.gateway.message.request.SignUpForm;
/**
 * <h1><b>AcademicsClient</b> interface.</h1>
 * <p>This interface contains reference to controller "userFeignClientController" to 
 * ensure communication with <b>user</b> microservice.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 2-DEC-2019.
 */
@FeignClient(name = "user")
public interface UserClient {

    @RequestMapping(value = "/userFeignClientController/findUser", method = RequestMethod.POST)
    public boolean findUser(@RequestBody SignUpForm signup);

    @RequestMapping(value = "/userFeignClientController/findUserIype", method = RequestMethod.POST)
    public String findUserType(@RequestBody SignUpForm signup);

    @RequestMapping(value = "/userFeignClientController/updateEmailAndUserId", method = RequestMethod.GET)
    public boolean updateEmailAndUserId(@RequestParam("mobileNo") long mobileNo);
}

