//////////////////////////////////////////////////////////////
//  The main entry point of the Spring Boot application.   //
/////////////////////////////////////////////////////////////

package com.prykhodko.shoppinglistSB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ShoppingListSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingListSbApplication.class, args);
	}

}

