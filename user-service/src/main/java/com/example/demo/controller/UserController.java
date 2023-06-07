package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.ui.ErrorModel;
import com.example.demo.ui.UserRequestModel;
import com.example.demo.ui.UserResponseModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Controller
@Getter
@Setter@AllArgsConstructor
public class UserController {
	
	private final ModelMapper modelMapper;
	private final UserService userService;
	
	@ExceptionHandler(value=NumberFormatException.class)
	public ResponseEntity<ErrorModel> handleException(NumberFormatException e){
		
		ErrorModel model = new ErrorModel(HttpStatus.BAD_REQUEST.value(),e.getMessage(),System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(model);
	}
	
	@PostMapping("/users")
	public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequestModel){
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userRequestModel, UserDto.class);
		
		StringBuffer sb = new StringBuffer();
		sb.append(userRequestModel.getPassword());
		userDto.setEncrytedPassword(sb.reverse().toString());
		
		UserResponseModel userResponseModel = userService.createUser(userDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponseModel);	
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserResponseModel>> getAllUsers(){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<UserResponseModel> models = new ArrayList<UserResponseModel>();
		List<UserEntity> userEntity =  userService.getAllUsers();
		
		for(UserEntity entity : userEntity) {
			models.add(modelMapper.map(entity, UserResponseModel.class));
		}
		
		return ResponseEntity.ok(models);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") int id) throws NumberFormatException{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserResponseModel response =userService.getuserById(id);
		if (response == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user with this:"+id+"not found");
		} else {
			return ResponseEntity.ok(response);
		}
	}
	@GetMapping("/findByUserId/{userid}")
	public ResponseEntity<UserResponseModel> getUserByUserId(@PathVariable("userid") String userId){
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserResponseModel response = userService.findByUserId(userId);
		return ResponseEntity.ok(response);
		
	}
}
