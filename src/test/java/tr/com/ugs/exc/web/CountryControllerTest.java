package tr.com.ugs.exc.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by sezerug on 01/05/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CountryControllerTest {

    @Value("${local.server.port}")
    private int port = 0;
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new TestRestTemplate();
    }

    @Test
    public void getCountryByCodeSuccess() {
        String countryCode = "TR";
        ResponseEntity<String> response = restTemplate.getForEntity(path("/countries/" + countryCode),
                String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("data:{\"id\":302667,\"code\":\"TR\",\"name\":\"Turkey\",\"continent\":\"AS\"}\n\n", response.getBody());
    }

    private String path(String context) {
        return String.format("http://localhost:%d%s", port, context);
    }
}
