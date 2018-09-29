package br.com.voffice.java.jwptf02.week3.examples.practice12;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

@JsonTest
@RunWith(SpringRunner.class)
public class JSONManipulationTest  {

    private String JSON_TO_TEST;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setup(){
        try {
            JSON_TO_TEST = objectMapper.writeValueAsString(Color.BLACK);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSerialization() throws JsonProcessingException{
        String json = objectMapper.writeValueAsString(Color.BLACK);
        assertEquals(JSON_TO_TEST, json );
    }

    @Test
    public void testDeserialization() throws IOException {
        Color c = objectMapper.readValue(JSON_TO_TEST, Color.class);
        assertEquals(c.getBlue(), Color.BLACK.getBlue());
    }
}
