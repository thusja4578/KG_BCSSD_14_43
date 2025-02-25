package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controller.database;
import model.Assignment;
import model.Bill;
import model.Driver;
import model.Vehicle;
import model.help;
import model.register;





public class web_service {
	//**********************************************************************************************************************************************************************************
	//add vehicle
	public void add_vehicle(Vehicle app1)
	{
		try {
			String query="insert into vehicle values ('"+app1.getVehicleid()+"','"+app1.getModel()+"','"+app1.getLicenseplate()+"','"+app1.getBrand()+"','"+app1.getColor()+"','"+app1.getEngine()+"','"+app1.getChasi()+"','"+app1.getName()+"','"+app1.getEmail()+"','"+app1.getPhone()+"','"+app1.getIdnum()+"','"+app1.getProvider()+"','"+app1.getPolicy()+"','"+app1.getExpire()+"')";
			Statement state=database.getcon().createStatement();
			state.executeUpdate(query);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//**********************************************************************************************************************************************************************************
	//add driver
	 public void add_driver(Driver app1)
		{
			try {
				String query="insert into driver values ('"+app1.getDriverid()+"','"+app1.getName()+"','"+app1.getAddress()+"','"+app1.getContact()+"','"+app1.getDob()+"','"+app1.getIdnum()+"','"+app1.getLicen()+"')";
				Statement state=database.getcon().createStatement();
				state.executeUpdate(query);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	 //********************************************************************************************************************************************************************************
	 //assign drivers to vehicle
	 public List<Assignment> getAllAssignments() {
	        List<Assignment> assignments = new ArrayList<>();
	        try {
	            Connection con = database.getcon();
	            String query = "SELECT a.driver_id, d.name, a.vehicle_id, v.model FROM assignment a JOIN driver d ON a.driver_id = d.driver_id JOIN vehicle v ON a.vehicle_id = v.vehicle_id";
	            PreparedStatement pstmt = con.prepareStatement(query);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                Assignment assign = new Assignment();
	                assign.setDriverId(rs.getString("driver_id")); //mewa database eke num
	                assign.setDriverName(rs.getString("name"));
	                assign.setVehicleId(rs.getString("vehicle_id"));
	                assign.setVehicleModel(rs.getString("model"));
	                assignments.add(assign);
	            }
	        } catch (Exception e) { e.printStackTrace(); }
	        return assignments;
	    }
	 //***************************************************************************************************************************************************************************
	 //add assign
	 public boolean reg_as(Assignment app1) {
	        try {
	            String query = "INSERT INTO assignment VALUES ('" + app1.getDriverId() + "', '" + app1.getVehicleId() + "')";
	            Statement state = database.getcon().createStatement();
	            int rowsAffected = state.executeUpdate(query);
	            return rowsAffected > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	 }
	        //********************************************************************************************************************************************************************
	        //validate driver
	        public boolean validatedriver(Driver user_log)
			{
				try {
					
					String query = "select * from driver where idnum ='" + user_log.getIdnum() + "' and licen='" + user_log.getLicen() + "'";
			Statement statement=database.getcon().createStatement();
			ResultSet rs=statement.executeQuery(query);

					if(rs.next()) { //next kiyana eken enne boolean value ekak
						return true; //rs ekata data samanam true kiyala return karanawa
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				return false;
			
	    }
	   //**************************************************************************************************************************************
	   //get one driver
	        
	        
	        public Driver getonedriver(Driver user_log)
			{
				try {
					
					String query = "select * from driver where idnum ='" + user_log.getIdnum() + "' and licen='" + user_log.getLicen() + "'";
			Statement statement=database.getcon().createStatement();
			ResultSet rs=statement.executeQuery(query);

					if(rs.next()) { //next kiyana eken enne boolean value ekak
						user_log.setDriverid(rs.getString("driver_id")); //mewa database eke num
						user_log.setName(rs.getString("name"));
						user_log.setAddress(rs.getString("address"));
						user_log.setContact(rs.getInt("contact"));
						user_log.setDob(rs.getString("dob"));
						user_log.setIdnum(rs.getString("idnum"));
						user_log.setLicen(rs.getString("licen"));
					
						return user_log;
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				return null;
			}
	        //*****************************************************************************************************************************************
	        
	        //driver table eka 
	        public ArrayList<Driver> getalldriver()
			{
				try {
					ArrayList<Driver> listcus=new ArrayList<Driver>();
					String query="select*from driver";
					Statement statement=database.getcon().createStatement();
					ResultSet rs=statement.executeQuery(query);
					while(rs.next())
					{
						
						
						
						Driver cus1=new Driver();
						cus1.setDriverid(rs.getString("driver_id")); //mewa database eke num
						cus1.setName(rs.getString("name"));
						cus1.setAddress(rs.getString("address"));
						cus1.setContact(rs.getInt("contact"));
						cus1.setDob(rs.getString("dob"));
						cus1.setIdnum(rs.getString("idnum"));
						cus1.setLicen(rs.getString("licen"));
						listcus.add(cus1);
					}
					return listcus;
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
	        //******************************************************************************************************************************************
	        //driver delete 
	        public void del_driver(Driver del)
			{
				try {
					String query="delete from driver where idnum='"+del.getIdnum()+"'";
					Statement statet=database.getcon().createStatement();
					statet.executeUpdate(query);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	        //******************************************************************************************************************************************
	        //update driver
	        public boolean updatedriver(String driveridd,String namee,String addresss,int contactt,String dobb,String idnumm,String licenn) {
		        try (Connection con = database.getcon()) {
		            String query = "UPDATE driver SET driver_id=? , name=?,address=?,contact=?,dob=?,licen=? WHERE idnum = ?"; //database num
		            PreparedStatement ps = con.prepareStatement(query);
		          
		            
		            ps.setString(1, driveridd);
		            ps.setString(2, namee);
		            ps.setString(3, addresss);
		            ps.setInt(4, contactt);
		            ps.setString(5, dobb);
		            ps.setString(6, licenn);
		            ps.setString(7, idnumm);
		         
		          

		            int rowsUpdated = ps.executeUpdate();
		            return rowsUpdated > 0;
		        } catch (ClassNotFoundException | SQLException e) {
		            e.printStackTrace();
		            return false;
		        }
		    }
	        //**************************************************************************************************************************************************
	        //validate vehicle 
	        public boolean validatevehicle(Vehicle user_log)
			{
				try {
					
					String query = "select * from vehicle where model ='" + user_log.getModel() + "' and license_plate='" + user_log.getLicenseplate() + "'";
			Statement statement=database.getcon().createStatement();
			ResultSet rs=statement.executeQuery(query);

					if(rs.next()) { //next kiyana eken enne boolean value ekak
						return true; //rs ekata data samanam true kiyala return karanawa
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				return false;
			
	    }
	        //**************************************************************************************************************************************************
	        // getone vehicle
	        public Vehicle getonevehicle(Vehicle user_log)
			{
				try {
					
					String query = "select * from vehicle where model ='" + user_log.getModel() + "' and license_plate='" + user_log.getLicenseplate() + "'";
			Statement statement=database.getcon().createStatement();
			ResultSet rs=statement.executeQuery(query);

					if(rs.next()) { //next kiyana eken enne boolean value ekak
						
						
						user_log.setVehicleid(rs.getString("vehicle_id"));
						user_log.setModel(rs.getString("model"));
						user_log.setLicenseplate(rs.getString("license_plate"));
						user_log.setBrand(rs.getString("brand"));
						user_log.setColor(rs.getString("color"));
						user_log.setEngine(rs.getString("engine"));
						user_log.setChasi(rs.getString("chasi"));
						user_log.setName(rs.getString("name"));
						user_log.setEmail(rs.getString("email"));
						user_log.setPhone(rs.getString("phone"));
						user_log.setIdnum(rs.getString("idnum"));
						user_log.setProvider(rs.getString("provider"));
						user_log.setPolicy(rs.getString("policy"));
						user_log.setExpire(rs.getString("expire"));
						
						
						
					
						return user_log;
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				return null;
			}
	        //****************************************************************************************************************************************************
	        //vehicle table
	        public ArrayList<Vehicle> getallvehicle()
			{
				try {
					ArrayList<Vehicle> listcus=new ArrayList<Vehicle>();
					String query="select*from vehicle";
					Statement statement=database.getcon().createStatement();
					ResultSet rs=statement.executeQuery(query);
					while(rs.next())
					{
						
						
						
						Vehicle cus11=new Vehicle();
						
						
						cus11.setVehicleid(rs.getString("vehicle_id"));
						cus11.setModel(rs.getString("model"));
						cus11.setLicenseplate(rs.getString("license_plate"));
						cus11.setBrand(rs.getString("brand"));
						cus11.setColor(rs.getString("color"));
						cus11.setEngine(rs.getString("engine"));
						cus11.setChasi(rs.getString("chasi"));
						cus11.setName(rs.getString("name"));
						cus11.setEmail(rs.getString("email"));
						cus11.setPhone(rs.getString("phone"));
						cus11.setIdnum(rs.getString("idnum"));
						cus11.setProvider(rs.getString("provider"));
						cus11.setPolicy(rs.getString("policy"));
						cus11.setExpire(rs.getString("expire"));
						listcus.add(cus11);
					}
					return listcus;
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
	        //**************************************************************************************************************************************************************
	        //delete vehicle
	        public void del_vehicle(Vehicle dell)
			{
				try {
					String query="delete from vehicle where idnum='"+dell.getIdnum()+"'";
					Statement statet=database.getcon().createStatement();
					statet.executeUpdate(query);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	        //***************************************************************************************************************************************************************
	        //update vehicle
	        public boolean updatevehicle(String vehicleidd,String modell,String license_platee,String brandd,String colorr,String enginee,String chasii,String namee,String emaill,String phonee,String idnumm,String provider,String policyy,String expire) {
		        try (Connection con = database.getcon()) {
		            String query = "UPDATE vehicle SET model=?,license_plate=?,brand=?,color=?,engine=?,chasi=?,name=?,email=?,phone=?,idnum=?,provider=?,policy=?expire=? WHERE vehicle_id = ?"; //database num
		            PreparedStatement ps = con.prepareStatement(query);
		          
		            
		            ps.setString(1, modell);
		            ps.setString(2,license_platee );
		            ps.setString(3, brandd);
		            ps.setString(4, colorr);
		            ps.setString(5, enginee);
		            ps.setString(6, chasii);
		            ps.setString(7, namee);
		            ps.setString(8, emaill);
		            ps.setString(9, phonee);
		            ps.setString(10, idnumm);
		            ps.setString(11, provider);
		            ps.setString(12, policyy);
		            ps.setString(13, expire);
		            ps.setString(14, vehicleidd);
		          

		            int rowsUpdated = ps.executeUpdate();
		            return rowsUpdated > 0;
		        } catch (ClassNotFoundException | SQLException e) {
		            e.printStackTrace();
		            return false;
		        }
		    }
	        //*****************************************************************************************************************************************************************
	        //register user

	    	public boolean reg_user(register app1) throws ClassNotFoundException {
	            try {
	                String query = "INSERT INTO reg (registration_number, name, address, nic, username, password) VALUES ('"
	                        + app1.getRegistration_number() + "','" + app1.getName() + "','" + app1.getAddress() + "','"
	                        + app1.getNic() + "','" + app1.getUsername() + "','" + app1.getPassword() + "')";
	                
	                Statement state = database.getcon().createStatement();
	                state.executeUpdate(query);
	                return true; // Registration successful
	            } catch (SQLException e) {
	                e.printStackTrace();
	                return false; // Registration failed
	            }
	        }
	    	//**************************************************************************************************************
	    	//user log 
	    	public boolean validate(register user_log)
	 		{
	 			try {
	 				
	 				String query = "select * from reg where username ='" + user_log.getUsername() + "' and password='" + user_log.getPassword() + "'";
	 		Statement statement=database.getcon().createStatement();
	 		ResultSet rs=statement.executeQuery(query);

	 				if(rs.next()) { //next kiyana eken enne boolean value ekak
	 					return true; //rs ekata data samanam true kiyala return karanawa
	 				}
	 			} catch (Exception e) {
	 				
	 				e.printStackTrace();
	 			}
	 			return false;
	 		}
	 	 //*********************************************************************************************************************************************
	 	 //getone
	 	 public register getone(register user_log)
	 		{
	 			try {
	 				
	 				String query = "select * from reg where username ='" + user_log.getUsername() + "' and password='" + user_log.getPassword() + "'";
	 		Statement statement=database.getcon().createStatement();
	 		ResultSet rs=statement.executeQuery(query);

	 				if(rs.next()) { //next kiyana eken enne boolean value ekak
	 					
	 					
	 					user_log.setRegistration_number(rs.getString("registration_number"));
	 					user_log.setName(rs.getString("name"));
	 					user_log.setAddress(rs.getString("address"));
	 					user_log.setNic(rs.getInt("nic"));
	 					user_log.setUsername(rs.getString("username"));
	 					user_log.setPassword(rs.getString("password"));
	 				
	 					return user_log;
	 				}
	 			} catch (Exception e) {
	 				
	 				e.printStackTrace();
	 			}
	 			return null;
	 		}
	    
	        //***************************************************************************************************************
	 	 //register table
	 	   public ArrayList<register> getallusers()
	 				{
	 					try {
	 						ArrayList<register> listcus=new ArrayList<register>();
	 						String query="select*from reg";
	 						Statement statement=database.getcon().createStatement();
	 						ResultSet rs=statement.executeQuery(query);
	 						while(rs.next())
	 						{
	 							
	 							
	 							
	 						register cus12=new register();
	 							cus12.setRegistration_number(rs.getString("registration_number"));
	 							cus12.setName(rs.getString("name"));
	 							cus12.setAddress(rs.getString("address"));
	 							cus12.setNic(rs.getInt("nic"));
	 							cus12.setUsername(rs.getString("username"));
	 							cus12.setPassword(rs.getString("password"));
	 							
	 							
	 							listcus.add(cus12);
	 						}
	 						return listcus;
	 					} catch (Exception e) {
	 						e.printStackTrace();
	 						return null;
	 					}
	 				}
	 	   //****************************************************************************************************************
	 	   //delete register
	 	  public void del_user(register dell)
			{
				try {
					String query="delete from reg where registration_number='"+dell.getRegistration_number()+"'";
					Statement statet=database.getcon().createStatement();
					statet.executeUpdate(query);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	 	  //****************************************************************************************************************
	 	  //booking table
	 	 public ArrayList<Bill> getallbookings()
			{
				try {
					ArrayList<Bill> listcus=new ArrayList<Bill>();
					String query="select*from bill";
					Statement statement=database.getcon().createStatement();
					ResultSet rs=statement.executeQuery(query);
					while(rs.next())
					{
						
						
						
					Bill app11=new Bill(query, query, query, 0, query, 0, 0);
					app11.setBookingNumber(rs.getString("bookingNumber"));
					app11.setCustomerName(rs.getString("customerName"));
					app11.setAddress(rs.getString("address"));
					app11.setTelephone(rs.getInt("telephone"));
					app11.setDestinationAddress(rs.getString("destinationAddress"));
					app11.setDistance(rs.getInt("distance"));
					app11.setVehicle(rs.getInt("vehicle"));
					app11.setAmount(rs.getInt("amount"));
						
						
						
						listcus.add(app11);
					}
					return listcus;
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
	 	 //*****************************************************************************************************************
	 	 //delete bookings
	 	  public void del_book(Bill dell)
			{
				try {
					String query="delete from bill where bookingNumber='"+dell.getBookingNumber()+"'";
					Statement statet=database.getcon().createStatement();
					statet.executeUpdate(query);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	 	  //*****************************************************************************************************************
	 	 //help
	 	 public help createhelp(String size) {
	 	        switch (size.toLowerCase()) {
	 	            case "low":
	 	                return new help("Apple"); // Create Apple phone for low size
	 	            case "medium":
	 	                return new help("Huawei"); // Create Huawei phone for medium size
	 	            case "large":
	 	                return new help("Nokia"); // Create Nokia phone for large size
	 	            default:
	 	                return null; // Return null if no valid size is provided
	 	        }
	 	    }
		
}
