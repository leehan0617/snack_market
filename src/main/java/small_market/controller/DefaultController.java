package small_market.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DefaultController {

    @GetMapping
    public String healthCheck() {
        return "Hello";
    }

    @PostMapping
    public ResponseEntity<String> postCheck() {
        return ResponseEntity.ok("POST PASS");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCheck(@RequestParam String id) {
        return ResponseEntity.ok("PUT PASS" + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCheck(@RequestParam String id) {
        return ResponseEntity.ok("DELETE PASS" + id);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<String> getIdCheck(@RequestParam String id) {
        return ResponseEntity.ok("GET PASS" + id);
    }

    @GetMapping("/ip/{id}")
    public ResponseEntity<String> checkIp(@RequestParam String id, HttpServletRequest request) {
        String ip = Optional.ofNullable(request.getHeader("x-forwarded-for"))
                .orElse(request.getRemoteAddr());
        return ResponseEntity.ok("IP Check:" + ip);
    }
}
