package cardealer.config;

import cardealer.util.ValidationUtil;
import cardealer.util.ValidationUtilImpl;
import cardealer.util.XmlParse;
import cardealer.util.XmlParseImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ValidationUtil validationUtil() {
        return new ValidationUtilImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public XmlParse xmlParse() {
        return new XmlParseImpl();
    }
}
