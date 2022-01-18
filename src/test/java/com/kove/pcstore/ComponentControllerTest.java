package com.kove.pcstore;

import static org.junit.Assume.assumeTrue;

import com.kove.pcstore.model.Component;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ComponentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAllComponent() throws Exception {
        this.mockMvc
                .perform(get("/components/all")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .with(csrf())
                        .with(user("mate").password("1234567").roles("USER", "ADMIN")))
                .andExpect(status().isOk());
    }

    @Test
    public void testInvalidAllComponents() throws Exception {
        this.mockMvc
                .perform(get("/components/all")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .with(csrf()))
                .andExpect(status().is3xxRedirection());
    }

/*    @Test
    public void testInvalidBookSubmit() throws Exception {
        this.mockMvc
                .perform(post("/components/new")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("title", "T")
                        .with(csrf())
                        .with(user("test").password("testpass").roles("USER", "ADMIN")))
                .andExpect(status().isOk());
    }*/

/*    @Test
    public void testValidComponentSubmit() throws Exception {
        assumeTrue(this.mockMvc != null);

        this.mockMvc
                .perform(post("/components/new")
                        .param("title", "Test title")
                        .param("contents", "Test test test test test test test test test test test test test test")
                        .param("type", Component.Type.GPU.toString())
                        .param("manafacturer.company", "Tester")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .with(csrf())
                        .with(user("test").password("testpass").roles("USER", "ADMIN")))
                .andExpect(status().isOk())
                .andExpect(view().name("componentProposal"));
    }*/

    @Test
    public void testNewComponent() throws Exception {
        this.mockMvc
                .perform(get("/components/new")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .with(csrf())
                        .with(user("test").password("testpass").roles("USER", "ADMIN")))
                .andExpect(status().isOk());
    }

}
