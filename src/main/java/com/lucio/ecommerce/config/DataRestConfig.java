package com.lucio.ecommerce.config;

import com.lucio.ecommerce.Entity.Product;
import com.lucio.ecommerce.Entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        // disable methods for Product, PUT/POST/DELETE
        HttpMethod[] unsupportedActions = {HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT};
        config.getExposureConfiguration()
              .forDomainType(Product.class)
              .withItemExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedActions))
              .withCollectionExposure(((metadata, httpMethods) -> httpMethods.disable(unsupportedActions)));

        // disable methods for Category
        config.getExposureConfiguration()
              .forDomainType(ProductCategory.class)
              .withItemExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedActions))
              .withCollectionExposure(((metadata, httpMethods) -> httpMethods.disable(unsupportedActions)));

    }
}
