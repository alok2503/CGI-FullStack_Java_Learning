package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.repo.UserRepository;
import com.example.demo.ui.UserRequestModel;
import com.example.demo.ui.UserResponseModel;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
	
	private final ModelMapper modelMapper;
	private final UserRepository userRepository;
	

	@Override
	public UserResponseModel createUser(UserDto userDto) {
		log.info("within create user method of service layer");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		UserEntity userEntity =modelMapper.map(userDto, UserEntity.class);
		userEntity.setUserId(UUID.randomUUID().toString());
		userRepository.save(userEntity);
		UserResponseModel userResponseModel =modelMapper.map(userEntity, UserResponseModel.class);
		return userResponseModel;
	}

	@Override
	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public UserResponseModel getuserById(int id) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Optional<UserEntity> e=userRepository.findById(id);
		
		if(!e.isPresent()) {
			return null;
		}
		else {
			
			return modelMapper.map(e, UserResponseModel.class);
		}
	}

	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

	@Override
	public UserResponseModel updateUserById(int id,UserRequestModel request) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		UserEntity userEntity = userRepository.getById(id);
		if(userEntity==null) {
			return null;
		}else {
			userEntity.setFirstName(request.getFirstName());
			UserResponseModel responseModel= modelMapper.map(userEntity, UserResponseModel.class);
			return responseModel;	
		}
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserResponseModel findByUserId(String userId) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		UserEntity entity = userRepository.findByUserId(userId);
		UserResponseModel response = modelMapper.map(entity, UserResponseModel.class);
		return response;
	}

	@Override
	public UserResponseModel findByEmail(String email) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity entity = userRepository.findByEmail(email);
		UserResponseModel response = modelMapper.map(entity, UserResponseModel.class);
		return response;
	}

}
