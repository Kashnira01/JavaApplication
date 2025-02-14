package com.housing.service;

import java.util.List;

import com.housing.dto.UserDTO;
import com.housing.exception.HousingException;

public interface UserService {
	
	public Long addUser(UserDTO userDTO) throws HousingException;
	
	public UserDTO getUser(Long userId) throws HousingException;
	
	public List<UserDTO> getAllUsers() throws HousingException;
	
	public Boolean userAlreadyExists(UserDTO userDTO) throws HousingException;
	
}
