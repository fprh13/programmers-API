package project2.json.repository.queryDto;

import lombok.Data;

@Data
public class CustomerQueryDto {
    private Long id;

    public CustomerQueryDto(Long id) {
        this.id = id;
    }
}
