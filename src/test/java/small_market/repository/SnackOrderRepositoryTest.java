package small_market.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import small_market.entity.SnackOrder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@TestPropertySource(locations = "/application-test.properties")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 이거안하면 내장DB를 사용, 설정안하면 에러 발생
@Transactional(propagation = Propagation.NOT_SUPPORTED) // 이거안하면 테스트 끝나고 rollback, db상에서 확인하려면 추가
@Slf4j
public class SnackOrderRepositoryTest {

    @Autowired
    SnackOrderRepository snackOrderRepository;

    @Test
    @DisplayName("Snack Order 한건 저장")
    void createTest() {
        SnackOrder snackOrder = new SnackOrder();
        snackOrder.setUserId("heron");
        snackOrder.setSnack("cookie");
        snackOrder.setStatus("init");
        snackOrderRepository.save(snackOrder);
    }

    @Test
    @DisplayName("Snack Order 전체 데이터 조회")
    void selectTest() {
        List<SnackOrder> orderList = snackOrderRepository.findAll();
        orderList.forEach(order -> {
            log.info("------------------");
            log.info(String.valueOf(order.getId()));
            log.info(order.getUserId());
            log.info(order.getStatus());
            log.info("------------------");
        });
    }

    @Test
    @DisplayName("Snack Order Paging 조회")
    void pagingTest() {
        int pageSize = 2;
        int pageNumber = 1;
        Pageable pageInfo = Pageable.ofSize(pageSize).withPage(pageNumber);
        Page<SnackOrder> snackOrderList = snackOrderRepository.findAll(pageInfo);
        assertTrue(snackOrderList.getSize() <= pageSize);
        snackOrderRepository.findAll(pageInfo)
                .forEach(e -> {
                    log.info(String.valueOf(e.getId()));
                    log.info(e.getSnack());
                });
    }

}
