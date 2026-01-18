package com.andergi.apps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.json.JsonCompareMode;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import org.springframework.http.HttpMethod;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Starter.class)
@AutoConfigureMockMvc
public abstract class RequestTestCase {

    @Autowired
    private MockMvc mockMvc;

    protected void assertResponseWithNoBody(final String endpoint, final Integer expectedStatusCode) throws Exception {
        mockMvc.perform(get(endpoint)).andExpect(status().is(expectedStatusCode)).andExpect(content().string(""));
    }

    protected void assertResponseWithBody(final String endpoint, final Integer expectedStatusCode,final String body) throws Exception {
        mockMvc
                .perform(get(endpoint))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(content().json(body, JsonCompareMode.STRICT));
    }

    protected void assertRequestWithBody(final String method, final String endpoint, final String body, final Integer expectedStatusCode)
            throws Exception {
        mockMvc
                .perform(request(HttpMethod.valueOf(method), endpoint).content(body).contentType(APPLICATION_JSON))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(content().string(""));
    }
}
