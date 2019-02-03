package com.felipelucas.test.integration;

import com.felipelucas.robot.api.dto.response.ResRobotStepDTO;
import com.felipelucas.test.commons.IntegrationTestBase;
import com.felipelucas.test.commons.RestRequest;
import com.felipelucas.test.mock.ReqMockFactory;
import com.felipelucas.test.mock.ResMockFactory;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpStatus.OK;

public class RobotAPITest extends IntegrationTestBase {

    @Test
    public void postDefault(){
        ResponseEntity<ResRobotStepDTO> response =
                RestRequest.build()
                        .baseUrl(getBaseUrl())
                        .method(POST)
                        .endpoint("/step/default")
                        .execute(new ParameterizedTypeReference<ResRobotStepDTO>() {});

        assertEquals(OK, response.getStatusCode());
        assertEquals(response.getBody(), ResMockFactory.mockDefaultSteps());
    }

    @Test
    public void getCustomerAllValidateStore() throws Exception {
        ResponseEntity<ResRobotStepDTO> response =
                RestRequest.build()
                        .baseUrl(getBaseUrl())
                        .method(POST)
                        .endpoint("/step")
                        .payload(ReqMockFactory.mockAllSteps())
                        .execute(new ParameterizedTypeReference<ResRobotStepDTO>() {});

        assertEquals(OK, response.getStatusCode());
        assertEquals(ResMockFactory.mockSomeSteps(), response.getBody());
    }

}