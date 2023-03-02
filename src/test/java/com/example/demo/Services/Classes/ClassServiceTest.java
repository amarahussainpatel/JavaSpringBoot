//package com.example.demo.Services.Classes;
//
////import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.*;
//import static org.mockito.ArgumentMatchers.any;
//
//import java.util.ArrayList;
//import java.util.List;
//
////import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.junit.Test;
//
//import com.example.demo.Entities.Classes.ClassEntity;
//import com.example.demo.Exceptions.EmptyRequestException;
//import com.example.demo.Exceptions.Null_IDException;
//import com.example.demo.Repositories.Class.ClassRepo;
//import com.example.demo.dto.ClassDTO;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ClassServiceTest {
//	
//	@InjectMocks
//	ClassService service;
//	
//	@Mock
//	private ClassRepo repos;
//	
//	//testing DTO given for test and DTO received are same
//	@Test
//	public void testSave() throws Null_IDException , EmptyRequestException {
//		ClassDTO classdto = new ClassDTO();
//		classdto.setRoomNo("RB-809");
//		classdto.setSubjectName("Mathematics");
//		
//		ClassEntity classentity = new ClassEntity();
//		classentity.setRoomNo("RB-809");
//		classentity.setSubjectName("Mathematics");
//		
//		Mockito.when(repos.save(any())).thenReturn(classentity);
////		ClassDTO resultclassdto = service.save(classdto);
////		assertEquals(resultclassdto.getRoomNo(), classdto.getRoomNo());
////		assertEquals(resultclassdto.getSubjectName(), classdto.getSubjectName());
//	}
//	
//	//post method must not send id in request
//	@Test(expected = Null_IDException.class)
//	public void testSave_for_POSTwithID() throws Null_IDException , EmptyRequestException {
//		ClassDTO classdto = new ClassDTO();
//		classdto.setClassID(1);
//		service.save(classdto);
//	}
//
//	@Test
//	public void testDisplay() {
//		List<ClassDTO> classdtolist= new ArrayList<>();
//		
////		classdtolist.add
//	}
//
//	@Test
//	public void testDisplaybyID() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDelete() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdatebyPUT() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdatebyPatch() {
//		fail("Not yet implemented");
//	}
//
//}
