
package com.app.rc;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * @author iHSPA
 */
public class SpringApplicationContext
        implements
            ApplicationContextAware {

    private static ApplicationContext CONTEXT;

    /**
     * 
     */
    @Override
    public void setApplicationContext (
            ApplicationContext applicationContext )
            throws BeansException {
        CONTEXT = applicationContext;
    }

    /**
     * @param beanName
     * @return
     */
    public static Object getBean ( String beanName ) {
        return CONTEXT.getBean ( beanName );
    }
}
