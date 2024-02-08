package com.opensource.main;


import Persistence.Controladora;
import com.opensource.Database.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VideoClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoClubApplication.class, args);
	}
        
        
        Controladora c;
        
        
        @Autowired
        public VideoClubApplication (Controladora c){
            
            this.c = c;
        }
        
        
        @GetMapping
        public List<Articulo> sad(){
            return c.obtenerArticulos();
        }
}
