package com.cg.blogging.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.blogging.dao.UserJPARepository;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.User;
import com.cg.blogging.exception.IdNotFoundException;


@Service
public class UserServiceImpl implements UserService {
	
	static Logger log = Logger.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	private UserJPARepository userJPARepository;
	
	
	public User addNewUser(User udto) {
		User u =convertDTOtoEntity(udto);
		u=userJPARepository.saveAndFlush(u);
		udto=convertEntityToDto(u);
		if(udto==null)
			return null;
		return udto;
	}
	
	public User removeUser(User udto) throws IdNotFoundException{
		User u =convertDTOtoEntity(udto);
		Optional <User> user1=userJPARepository.findById(u.getUserId());
		if(user1==null)
			throw new IdNotFoundException("userId is not found");
		userJPARepository.delete(u);
		udto=convertEntityToDto(u);
		return udto;
	}

	public User convertEntityToDto(User users) {
		User udto = new User();
		udto.setUserId(users.getUserId());
		udto.setPassword(users.getPassword());
		udto.setRole(users.getRole());


		return udto;

	}

	public User convertDTOtoEntity(User udto) {
		User user1 = new User();
		user1.setUserId(udto.getUserId());
		user1.setPassword(udto.getPassword());
		user1.setRole(udto.getRole());


		return user1;

	}
	
	public User signIn(String role,String password) throws IdNotFoundException {
		if(role.equals("")||password==null) {
			throw new IdNotFoundException("Invalid details!");
		}
		else {
			User user=userJPARepository.findByEmail(role);
			if(user==null )	
				throw new IdNotFoundException("Email id doesnot exist");
			if(user!=null && !(user.getPassword().equals(password)))
				throw new IdNotFoundException("password doesnot matches");
			
			return user;
		}
	}
	

	
	public Blogger findBloggerthroughEmail(String role) {
		Blogger b=userJPARepository.findBloggerByEmail(role);
		return b;	
	}

/*	public User signIn(User  udto)  throws IdNotFoundException{
		User  u=convertDTOtoEntity(udto);
		Optional <User> user1=userJPARepository.findById(u.getUserId());
		if(!(user1.isPresent()))
		{
			throw new IdNotFoundException("userId is mandatory");	
		}
		if(udto.getPassword().equals(user1.get().getPassword()) && udto.getUserId()==(user1.get().getUserId()))
			return convertEntityToDto(user1.get());
		else
			throw new IdNotFoundException("userId and Password is wrong");
	}
*/	
	
	public User signOut(User  udto)   {
		User u=convertDTOtoEntity(udto);
		Optional<User> user1=userJPARepository.findById(u.getUserId());
		if(udto.getPassword().equals(user1.get().getPassword()))
			return convertEntityToDto(user1.get());
		return null;
	}


	public List<User> getAllUsers(){
		List<User> userDtoList= new ArrayList<User>();
		List<User> userList= userJPARepository.findAll();
		User userDto;
		for(User user:userList) {
			userDto= convertEntityToDto(user);
			userDtoList.add(userDto);
		}
		return userDtoList;
	}
	public User updatePassword(User udto) throws IdNotFoundException{
		if(udto==null)
			throw new IdNotFoundException("Invalid User");
		User u = convertDTOtoEntity(udto);
		Optional<User> user1=userJPARepository.findById(u.getUserId());
		if(user1.isPresent()){
			if(!(user1.get().getPassword().equals(udto.getPassword()))) {
				user1.get().setPassword(udto.getPassword());
				u= user1.get();
				u=userJPARepository.save(u);
			}
		}

		udto = convertEntityToDto(u);

		/*if (udto == null) {
			throw new ApplicationException("Password Not Updated");
		}*/

		return udto;
	}
}