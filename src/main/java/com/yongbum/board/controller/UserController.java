package com.yongbum.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yongbum.board.dto.response.ResponseDto;
import com.yongbum.board.dto.user.GetUserResponseDto;
import com.yongbum.board.dto.user.PatchUserDto;
import com.yongbum.board.dto.user.PostUserDto;
import com.yongbum.board.dto.user.ResultResponseDto;
import com.yongbum.board.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired UserService userService;
	
	// CRUD 순서대로
	@PostMapping("")
	public ResponseDto<ResultResponseDto> postUser(@RequestBody PostUserDto requestBody) {
		return userService.postUser(requestBody);
	}
	
	@GetMapping("{email}")
	public ResponseDto<GetUserResponseDto> getUser(@PathVariable("email") String email) {
		return userService.getUser(email);
	}
	
	
	@PatchMapping("")
	public ResponseDto<GetUserResponseDto> patchUser(@RequestBody PatchUserDto requestBody) {
		return userService.patchUser(requestBody);
	}
	
	@DeleteMapping("{email}")
	public ResponseDto<ResultResponseDto> deleteUser(@PathVariable("email") String email) {
		return userService.deleteUser(email);
	}
	
}
