package com.amplesoftech.dress2impress.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.amplesoftech.dress2impress.model.RegisterModel;
import com.amplesoftech.dress2impressbackend.dao.UserDAO;
import com.amplesoftech.dress2impressbackend.dto.Address;
import com.amplesoftech.dress2impressbackend.dto.Cart;
import com.amplesoftech.dress2impressbackend.dto.User;

@Component
public class RegisterHandler 
{	
	/*  @Autowired 
	  private BCryptPasswordEncoder passwordEncoder;*/
	 
	@Autowired
	private UserDAO userDAO;

	public RegisterModel init() {
		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}

	public String validateUser(User user, MessageContext error) {
		String transitionValue = "success";

		// checking if password matches confirm password
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			error.addMessage(new MessageBuilder().error().source("confirmPassword")
					.defaultText("Password does not match confirm password!").build());
			transitionValue = "failure";
		}
		//checking the uniqueness of the email id
		if (userDAO.getByEmail(user.getEmail()) != null) {
			error.addMessage(new MessageBuilder().error().source("email").defaultText("Email address is already taken!")
					.build());
			transitionValue = "failure";
		}
		if (userDAO.getByContactNumber(user.getContactNumber())!= null) {
			error.addMessage(new MessageBuilder().error().source("contactNumber").defaultText("Contact Number is already taken!")
					.build());
			transitionValue = "failure";
		}
		return transitionValue;
	}

	public String saveAll(RegisterModel registerModel) {
		String transitionValue = "success";
		User user = registerModel.getUser();
		if (user.getRole().equalsIgnoreCase("USER")) {
			// create a new cart
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}

		// encode the password
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		//user.setPassword(user.getPassword());

		// save the user
		userDAO.addUser(user);
		// save the billing address
		Address billing = registerModel.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		userDAO.addAddress(billing);
		return transitionValue;
	}
}
