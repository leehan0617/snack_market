package small_market.service;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import small_market.entity.SnackOrder;
import small_market.repository.SnackOrderRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class SnackOrderServiceTest {

    @InjectMocks
    SnackOrderService snackOrderService;
    @Mock
    SnackOrderRepository snackOrderRepository;

    @DisplayName("주문 생성 (create snack order)")
    @Test
    void createTest() {
        SnackOrder snackOrder = new SnackOrder();
        snackOrder.setUserId("test user");
        snackOrder.setSnack("coke");
        snackOrder.setStatus("init");

        // mocking
//        given(snackOrderRepository.save(any(SnackOrder.class))).willReturn(snackOrder);
        when(snackOrderRepository.save(any(SnackOrder.class))).thenReturn(snackOrder);
        SnackOrder result = snackOrderService.createSnackOrder(snackOrder);
        assertEquals(snackOrder.getUserId(), result.getUserId());
        assertEquals(snackOrder.getSnack(), result.getSnack());
        assertEquals(snackOrder.getStatus(), result.getStatus());
    }
}
