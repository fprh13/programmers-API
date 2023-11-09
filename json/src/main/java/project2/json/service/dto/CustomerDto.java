package project2.json.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import project2.json.repository.queryDto.CustomerQueryDto;


@Slf4j
public class CustomerDto {

    /**
     * 총 회원 수 집계
     */
    @Data
    @AllArgsConstructor
    public static class CountRes {
        private Long total;
    }

    /**
     * 반환 Dto
     * @param <T>
     */
    @Data
    @AllArgsConstructor
    public static class ResultPage<T> {
        private int page;
        private int perPageNum;
        private int totalItem;
        private T response;
    }

    @Data
    public static class DormantRes {
        private Long id;

        public DormantRes(CustomerQueryDto customerQueryDto) {
            this.id = customerQueryDto.getId();
        }
    }
}
