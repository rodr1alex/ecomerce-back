package com.springboot.backend.andres.usersapp.usersbackend.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.springboot.backend.andres.usersapp.usersbackend.auth.filter.JwtAuthenticationFilter;
import com.springboot.backend.andres.usersapp.usersbackend.auth.filter.JwtValidationFilter;

@Configuration
public class SpringSecurityConfig {

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http.authorizeHttpRequests(authz -> authz
                .requestMatchers(HttpMethod.GET, "/base_products/featured_products/page/{page}", "/users", "/users/{id}", "/users/baseproducts", "/users/baseproducts/{id}", "/users/page/{page}"
                  ).permitAll()
                .requestMatchers(HttpMethod.POST, "/users", "/base_products/filter/category_list/page/{page}", "/base_products/filter/brand/{brand_id}/page/{page}", "/base_products/filter/brand/get_list").permitAll()
                .requestMatchers(HttpMethod.POST, "/users/directions/create/{id}", "/cart/create/{user_id}",
                  "/sales/create/{cart_id}").hasAnyRole("USERS","ADMIN")
                .requestMatchers(HttpMethod.GET, "/users/{id}").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.PUT, "/users/directions/update/{direction_id}", "/cart/update/add_product/{cart_id}",
                  "/cart/update/remove_product/{cart_id}/{final_product_id}","/cart/update/quantity_product/{cart_id}",
                  "/cart/update/clean/{cart_id}", "/sales/update/quantity_product/{sale_id}", "/sales/update/remove_product/{sale_id}/{final_product_id}",
                  "/sale/update/cancel_sale/{sale_id}", "/users/{id}", "/users/update_password/{id}").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/users/directions/delete/{direction_id}").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST,  "/categories/create", "/brands/create", "/colors/create", "/sizes/create",
                  "/base_products/create", "/color_variant_products/create", "/final_products/create").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/categories", "/categories/{category_id}", "/brands", "/brands/{brand_id}", "/colors", "/colors/{color_id}",
                  "/sizes", "/sizes/{size_id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/categories/update/{category_id}", "/brands/update/{brand_id}", "/colors/update/{color_id}",
                  "/sizes/update/{size_id}", "/base_product/update/{base_product_id}", "/base_product/update/add_image/{base_product_id}",
                  "/base_product/update/remove_image/{base_product_id}", "/color_variant_products/update/{color_variant_product_id}", "/color_variant_products/update/add_image/{color_variant_product_id}",
                  "/color_variant_products/update/remove_image/{color_variant_product_id}", "/final_products/update/{final_product_id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/users/{id}").hasRole("ADMIN")
                .anyRequest().authenticated())
                .cors(cors -> cors.configurationSource(configurationSource()))
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtValidationFilter(authenticationManager()))
                .csrf(config -> config.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    CorsConfigurationSource configurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(Arrays.asList("*"));
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        config.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE"));
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> corsBean = new FilterRegistrationBean<CorsFilter>(
                new CorsFilter(this.configurationSource()));
        corsBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return corsBean;
    }
}
