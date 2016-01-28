package de.misterwebster;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles("test")

//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@WebAppConfiguration
@ContextConfiguration(classes = {ExampleController.class})


public class ExampleControllerTest {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext wac;

  @Before
  public void before() {
    System.out.println("WAC = " + wac);
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }
    
  @Test
  public void checkHappyPath() throws Exception {      
    mockMvc.perform(get("/")).andExpect(status().isOk());        
  }

  @Test
  public void checkContent() throws Exception {
    this.mockMvc.perform(get("/").accept("application/json"))
      .andExpect(content().string("Test!"));

  }

}
