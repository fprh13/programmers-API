package project2.json.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project2.json.domain.CustomerStatus;
import project2.json.repository.CustomerRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static project2.json.service.dto.CustomerDto.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    /**
     * 전체 유저 조회
     */
    public CountRes count() {
        return new CountRes(customerRepository.findAll());
    }


    /**
     * 휴먼 계정 조회
     */
    public List<Integer> findDormant() {
         return customerRepository.findByStatus(CustomerStatus.DORMANT).stream()
                .map(c -> c.getId().intValue())
                .collect(toList());
    }

    /**
     * 휴먼 계정 조회 2
     */
    public ResultPage findDormant2(int offset, int limit) {
        List<DormantRes> collector = customerRepository.findByStatusPage(CustomerStatus.DORMANT, offset,limit).stream()
                .map(DormantRes::new)
                .collect(toList());
        return new ResultPage(offset, limit, collector.size(),collector);
    }
}
