package io.pivotal.spinnaker.multifoundationgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MultifoundationGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultifoundationGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("forward", r -> r.path("/persons").uri("lb://myservice/persons"))
				.build();
	}
}
