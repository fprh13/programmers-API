package project2.json.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project2.json.domain.Customer;
import project2.json.domain.CustomerStatus;
import project2.json.repository.queryDto.CustomerQueryDto;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class CustomerRepository {

    private final EntityManager em;

    /**
     * 이니셜라이져를 위한 전체 저장
     */
    public void saveAll(List<Customer> customers) {
        customers.stream().forEach(c -> em.persist(c));
    }

    /**
     * 전체 조회
     * @return
     */
    public Long findAll() {
        return em.createQuery("select count(c) from Customer c", Long.class)
                .getSingleResult();
    }



    /**
     * 휴면 계정으로 조회
     * @param status
     * @return
     */
    public List<CustomerQueryDto> findByStatus(CustomerStatus status) {
        return em.createQuery("select new project2.json.repository.queryDto.CustomerQueryDto(c.id)" +
                        "from Customer c where c.status = :status", CustomerQueryDto.class)
                .setParameter("status",status)
                .getResultList();
    }


    /**
     * 휴면 계정으로 조회 2
     * @param status
     * @return
     */
    public List<CustomerQueryDto> findByStatusPage(CustomerStatus status,int offest,int limit) {
        return em.createQuery("select new project2.json.repository.queryDto.CustomerQueryDto(c.id)" +
                "from Customer c where c.status = :status", CustomerQueryDto.class)
                .setParameter("status",status)
                .setFirstResult((offest - 1) * limit)
                .setMaxResults(limit)
                .getResultList();
    }
}