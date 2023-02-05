package com.example.WeeklyTest;


import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;





@Service
public class RestaurantService {
	 private static List<Restaurant> restaurant=new ArrayList<>(); // In-memory database
	    private static int todoCount=0;

	    static {
	    	restaurant.add(new Restaurant(++todoCount,"Taj Hotel","Mumbai","982597225","Indian Food",100));
	    	restaurant.add(new Restaurant(++todoCount,"The Oberoi Amarvilas","Agra","364578235","Indian Food",544));
	    	restaurant.add(new Restaurant(++todoCount,"Umaid Bhavan Palace","Jodhpur","5432134567" ,"Indian Food",65));
	    	restaurant.add(new Restaurant(++todoCount,"The Imperial New ","Delhi","9805972251","Indian Food",43));
	    	restaurant.add(new Restaurant(++todoCount,"RAMBAGH PALACE","Jaipur","9825909251","Indian Food",200));
	    	
	    
	    }

		public List<Restaurant> finaAll() {
			return restaurant;
		}

		public Restaurant findById(int id) {
			Restaurant res=restaurant.get(id);
			
			return res;
		}

		public void addHotel(Restaurant hotelDetails) {
			restaurant.add(hotelDetails);
			
		}

		public void deleteById(int RestaurantId) {
			restaurant.remove(RestaurantId);
			
		}

		public void updateById(int restaurantId, Restaurant restaurant1) {
		
			Restaurant restaurantUpdate=findById(restaurantId);

			restaurantUpdate.setRestaurantName(restaurant1.getRestaurantName());
			restaurantUpdate.setRestaurantAddress(restaurant1.getRestaurantAddress());
			restaurantUpdate.setRestaurantNumber(restaurant1.getRestaurantNumber());
			restaurantUpdate.setSpecialty(restaurant1.getSpecialty());
			restaurantUpdate.setTotalStaff(restaurant1.getTotalStaff());
		}
    }
