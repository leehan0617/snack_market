package small_market.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import small_market.entity.SnackOrder;
import small_market.repository.SnackOrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SnackOrderService {

    private final SnackOrderRepository snackOrderRepository;

    public SnackOrder createSnackOrder(SnackOrder snackOrder) {
        return snackOrderRepository.save(snackOrder);
    }

    public List<SnackOrder> findSnackOrderList() {
        return snackOrderRepository.findAll();
    }
}
