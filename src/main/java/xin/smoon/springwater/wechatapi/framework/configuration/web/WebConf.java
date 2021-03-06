package xin.smoon.springwater.wechatapi.framework.configuration.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author Forest10
 * @date 2018/9/13 下午4:29
 */
@Configuration
public class WebConf {

    @Resource
    private RequestMappingHandlerAdapter handlerAdapter;

    /**
     * 增加字符串转日期的功能
     */
    @PostConstruct
    public void initEditableValidation() {
        ConfigurableWebBindingInitializer initializer =
            (ConfigurableWebBindingInitializer)handlerAdapter.getWebBindingInitializer();
        if (initializer.getConversionService() != null) {
            GenericConversionService genericConversionService =
                (GenericConversionService)initializer.getConversionService();
            genericConversionService.addConverter(new DateConverter());
        }

    }
}
