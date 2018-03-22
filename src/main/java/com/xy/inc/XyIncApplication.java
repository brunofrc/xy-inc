package com.xy.inc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
/**
 * Classe com o metodo main
 * @author bruno
 *
 */
@SpringBootApplication(exclude = { JpaRepositoriesAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EntityScan
public class XyIncApplication {

	public static void main(String[] args) {
		SpringApplication.run(XyIncApplication.class, args);
	}
}
