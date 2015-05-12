package com.hhu.utils;

import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 使用beanutils进行表单传值
 */
public class FormBeanUtil {

    /**
     * 使用泛型，可以通用
     * @param request
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T>T fillFormBean(HttpServletRequest request, Class<T> tClass){
        try {
            //通过反射创建新的类,得到需要的Bean
            T bean = tClass.newInstance();
            //得到表单参数
            Map map = request.getParameterMap();
            //使用BeanUtils
            BeanUtils.populate(bean, map);
            return bean;

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
