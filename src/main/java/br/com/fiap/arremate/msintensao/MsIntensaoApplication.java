package br.com.fiap.arremate.msintensao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsIntensaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsIntensaoApplication.class, args);
	}


}
