package com.dewen.account;

import com.dewen.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @RequestMapping("/decrease")
    public ResponseEntity<Void> decrease(@RequestParam("accountId") Long accountId, @RequestParam("money") Integer money) {
        accountService.decrease(accountId, money);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}