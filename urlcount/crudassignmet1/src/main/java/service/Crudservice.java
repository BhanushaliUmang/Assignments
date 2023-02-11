package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Crudmodel;

@Service
public class Crudservice {
    private static List<Crudmodel> crud=new ArrayList<>(); 
	    private static int Count=0;

	    static {
	    	crud.add(new Crudmodel(++Count,"BhargavKanzariya","Bhargav","Limdi","7894563214"));
	    	crud.add(new Crudmodel(++Count,"JayPatel","Jay","Unjha","5698742563"));
	    	crud.add(new Crudmodel(++Count,"AjayJadeja","Ajay","Khakhar","8965471258"));
            crud.add(new Crudmodel(++Count,"Trishirpatel","Lalu","Bhuj","7896547896"));
            crud.add(new Crudmodel(++Count,"Karanparekh","Karan","Bharuch","9988774455"));
	    	
	    }

        public List<Crudmodel> findAll() {
			return crud;
		}

		public Crudmodel findById(int id) {
			Crudmodel res=crud.get(id);
			
			return res;
		}

		public void addUser(Crudmodel UserDetails) {
			crud.add(UserDetails);
			
		}

		public void deleteById(int UserId) {
			crud.remove(UserId);
			
		}

		public void updateById(int UserId, Crudmodel user1) {
		
			Crudmodel userUpdate=findById(UserId);

			userUpdate.setName(user1.getName());
			userUpdate.setUserName(user1.getUserName());
			userUpdate.setAddress(user1.getAddress());
			userUpdate.setPhoneNumber(user1.getPhoneNumber());
			
		}
}
