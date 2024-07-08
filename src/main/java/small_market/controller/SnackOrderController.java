package small_market.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import small_market.entity.SnackOrder;
import small_market.service.SnackOrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class SnackOrderController {

    private final SnackOrderService snackOrderService;

    @GetMapping
    public ResponseEntity<List<SnackOrder>> order() {
        return ResponseEntity.ok(snackOrderService.findSnackOrderList());
    }

    @PostMapping
    public String createOrder() {
        return "";
    }
}
