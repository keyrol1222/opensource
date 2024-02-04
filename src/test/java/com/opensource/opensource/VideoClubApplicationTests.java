package com.opensource.opensource;

import Persistence.Controladora;
import com.opensource.Database.Idiomas;
import org.springframework.beans.factory.annotation.Autowired;

class VideoClubApplicationTests {
    
        Controladora c;
    
        @Autowired
        public VideoClubApplicationTests(Controladora c){
    
            this.c = c;
        }

	public static void main(String[] args) {
            

            
            
            Idiomas i = new Idiomas();
            
            i.setEstado("activo");
            
            i.setDescripcion("Espanol");
            
            c.CrearIdiomas(i);
            
            System.out.println(i.getId());
		
	}

}
