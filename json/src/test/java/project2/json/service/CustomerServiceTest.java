package project2.json.service;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import project2.json.service.dto.CustomerDto;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional(readOnly = true)
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;


    @Test
    public void 총회원수() throws Exception {
        CustomerDto.CountRes count = customerService.count();
        System.out.println(count);
    }

    @Test
    public void 휴먼계정() throws Exception {
        List<Integer> dormant = customerService.findDormant();
        assertThat(dormant).isNotNull();
        assertThat(dormant).isNotEmpty();

    }

    @Test
    public void 휴먼계정2() throws Exception {
        CustomerDto.Result dormant = customerService.findDormant2();
        assertThat(dormant).isNotNull();
    }
}