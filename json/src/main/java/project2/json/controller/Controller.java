package project2.json.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project2.json.service.CustomerService;


@Slf4j
@RestController
@RequiredArgsConstructor
public class Controller {
    private final CustomerService customerService;

    /**
     * 총 회원 수 집계
     * @return
     */
    @GetMapping("/count")
    public ResponseEntity<?> countCustomer() {
        return ResponseEntity.ok().body(customerService.count());
    }

    /**
     * 휴면 계정 조회
     * @return
//     */
    @GetMapping("/dormant")
    public ResponseEntity<?> dormantList() {
        return ResponseEntity.ok().body(customerService.findDormant());
    }

    /**
     * 휴면 계정 조회 2
     * @return
     */
    @GetMapping("/dormant2")
    public ResponseEntity<?> dormantList2(
            @RequestParam(value = "offset", defaultValue = "1") int offset,
            @RequestParam(value = "limit", defaultValue = "10") int limit
            ) {
        return ResponseEntity.ok().body(customerService.findDormant2(offset, limit));
    }


}
