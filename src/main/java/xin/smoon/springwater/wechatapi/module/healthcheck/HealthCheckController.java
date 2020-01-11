package xin.smoon.springwater.wechatapi.module.healthcheck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 水木
 * @Date 2020-01-11  11:59
 */
@RequestMapping("/health")
@RestController
public class HealthCheckController {
    @GetMapping("/check")
    public String check(){
        return "ok";
    }

}
