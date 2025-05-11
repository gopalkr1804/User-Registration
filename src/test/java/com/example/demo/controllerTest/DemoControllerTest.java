package com.example.demo.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.example.demo.controller.DemoController;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;

public class DemoControllerTest {

//	@InjectMocks
//	DemoController demoController = new DemoController();
//	
//	
//	@Test
//    void testControllerSample() {
//        String result = demoController.controllerSample();
//        assertEquals("Calling controller", result);
//    }
//	
//	@Test
//	void testGetUserSuccess() throws Exception{
//		 UserDto user = demoController.getUser("123");
//		 assertEquals(user.getId(),"123");
//	}
//	
//	@Test
//	void testGetUserError() throws Exception{
//		assertThrows(UserNotFoundException.class, ()-> demoController.getUser("000"));
//	}
	
}
