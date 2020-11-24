package pismo.controllers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountResourceTests {
//	@Autowired
//	private TestRestTemplate template;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCreateAccount() throws Exception {
		var body = new HashMap<String, String>();
		body.put("document_number", "12345678900");
		
		var jsonBody = new Gson().toJson(body);
		
		mockMvc.perform(post("/accounts").contentType(MediaType.APPLICATION_JSON).content(jsonBody))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.document_number").value( "12345678900"))
			.andExpect(jsonPath("$.id").value( 1));
	}

}
