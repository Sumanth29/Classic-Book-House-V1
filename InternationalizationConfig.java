package com.controller;
import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
@Configuration
public class InternationalizationConfig implements WebMvcConfigurer {
// Create a SessionLocaleResolver object and set the default locale to
// English return the SessionLocaleResolver object
@Bean
public LocaleResolver localeResolver() {
SessionLocaleResolver resolver = new SessionLocaleResolver();
resolver.setDefaultLocale(new Locale("en"));
return resolver;
}
// Create LocaleChangeInterceptor object and set the parameter name as
// language and return the localeChangeInterceptor
@Bean
public LocaleChangeInterceptor localeChangeInterceptor() {
LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
 interceptor.setParamName("language");
 return interceptor;
}
// register the LocaleChangeInterceptor
@Override
public void addInterceptors(InterceptorRegistry registry) {
registry.addInterceptor(localeChangeInterceptor());
}
@Bean
 public ResourceBundleMessageSource messageSource() {
 ResourceBundleMessageSource bundleMessageSource = new
ResourceBundleMessageSource();

bundleMessageSource.setBasenames("messages","messages_fr","messages_de");
 return bundleMessageSource;
 }

 @Bean
 public LocalValidatorFactoryBean getValidator() {
 LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
 bean.setValidationMessageSource(messageSource());
 return bean;
 }
}
