package com.boot.mvc20220916junho.web.controller.api;

import com.boot.mvc20220916junho.domain.User;
import com.boot.mvc20220916junho.repository.UserRepository;
import com.boot.mvc20220916junho.web.dto.UserAddReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class UserRestController {

    @Autowired
    @Qualifier("a")
    private UserRepository userRepository;

    @GetMapping("/users/{userCode}")
    public ResponseEntity<?> getUser(@PathVariable int userCode) {

        User user = userRepository.findUserByUserCode(userCode);

        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUser(@RequestParam String userId) {
        User user = userRepository.findUserByUserId(userId);

        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(UserAddReqDto userAddReqDto) {
        int result = userRepository.save(userAddReqDto.toEntity());
        if(result == 0) {
            return ResponseEntity.internalServerError().body("데이터 오류(Server)");
        }

        return ResponseEntity.ok().body("사용자 추가 완료");
    }
}
