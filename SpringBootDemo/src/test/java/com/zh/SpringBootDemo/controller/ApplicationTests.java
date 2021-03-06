package com.zh.SpringBootDemo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.zh.SpringBootDemo.domain.p.User;
import com.zh.SpringBootDemo.domain.p.UserRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class ApplicationTests {

//	private MockMvc mvc;
	
	@Autowired
    private UserRepository userRepository;

	@Test
    public void test() throws Exception {

        // 创建10条记录
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("DDD", 40));
        userRepository.save(new User("EEE", 50));
        userRepository.save(new User("FFF", 60));
        userRepository.save(new User("GGG", 70));
        userRepository.save(new User("HHH", 80));
        userRepository.save(new User("III", 90));
        userRepository.save(new User("JJJ", 100));

        // 测试findAll, 查询所有记录
        Assert.assertEquals(10, userRepository.findAll().size());

        // 测试findByName, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findByName("FFF").getAge().longValue());

        // 测试findUser, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findUser("FFF").getAge().longValue());

        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
        Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).getName());

        // 测试删除姓名为AAA的User
        userRepository.delete(userRepository.findByName("AAA"));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        Assert.assertEquals(9, userRepository.findAll().size());

    }

//	@Before
//	public void setUp() throws Exception {
//		mvc = MockMvcBuilders.standaloneSetup(
//				new HelloWorldController(),
//				new UserController()).build();
//	}
//	
	

//	@Test
//	public void getHello() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(content().string(equalTo("Hello World")));
//	}

//	@Test
//	public void testUserController() throws Exception {
//  	测试UserController
//		RequestBuilder request = null;
//
//		// 1、get查一下user列表，应该为空
//		request = get("/users/");
//		mvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(content().string(equalTo("[]")));
//
//		// 2、post提交一个user
//		request = post("/users/")
//				.param("id", "1")
//				.param("name", "测试大师")
//				.param("age", "20");
//		mvc.perform(request)
////				.andDo(MockMvcResultHandlers.print())
//				.andExpect(content().string(equalTo("success")));
//
//		// 3、get获取user列表，应该有刚才插入的数据
//		request = get("/users/");
//		mvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));
//
//		// 4、put修改id为1的user
//		request = put("/users/1")
//				.param("name", "测试终极大师")
//				.param("age", "30");
//		mvc.perform(request)
//				.andExpect(content().string(equalTo("success")));
//
//		// 5、get一个id为1的user
//		request = get("/users/1");
//		mvc.perform(request)
//				.andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));
//
//		// 6、del删除id为1的user
//		request = delete("/users/1");
//		mvc.perform(request)
//				.andExpect(content().string(equalTo("success")));
//
//		// 7、get查一下user列表，应该为空
//		request = get("/users/");
//		mvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(content().string(equalTo("[]")));

//	}

}