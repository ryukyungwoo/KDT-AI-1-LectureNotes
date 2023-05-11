package com.example.demo.accountTest;

import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountCheckTypeRequestForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountTypeResponseForm;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.account.repository.TestAccountRepository;
import com.example.demo.lectureClass.testCode.account.service.TestAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AccountTest {

    @Autowired
    private TestAccountService testAccountService;
    @Autowired
    private TestAccountRepository testAccountRepository;

    @Test
    @DisplayName("사용자가 회원 가입을 할 수 있음")
    void 사용자가_회원_가입한다_refactoring () {
        final String email = "admin@test.com";
        final String password = "test";
        final String type = "admin";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password,type);
        TestAccount account = testAccountService.register(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());

    }
    @Test
    @DisplayName("똑같은 사용자는 회원 가입을 할 수 없음")
    void 이미_존재하는_이메일로_회원_가입시도 () {
        final String email = "test@test.com";
        final String password = "test";
        final String type = "seller";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password, type);
        TestAccount account = testAccountService.register(requestForm);

        assertTrue(account == null);
    }

    @Test
    @DisplayName("잘못된 비밀번호 정보를 토대로 로그인")
    void 비밀번호를_틀리게_입력한_상태에서_로그인 () {
        final String email = "test@test.com";
        final String password = "응틀렸어";
        final String type = "seller";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password, type);
        TestAccountLoginResponseForm responseform = testAccountService.login(requestForm);

        assertTrue(responseform.getUserToken() == null);
    }

    @Test
    @DisplayName("이메일을 잘못 입력한 상태로 로그인")
    void 이메일을_틀리게_입력한_상태에서_로그인 () {
        final String email = "gogo@gogo.com";
        final String password = "test";
        final String type = "seller";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password, type);
        TestAccountLoginResponseForm responseform = testAccountService.login(requestForm);

        assertTrue(responseform.getUserToken() == null);
    }
    @Test
    @DisplayName("올바른 입력한 정보를 토대로 로그인")
    void 올바른_정보로_로그인 () {
        // 윈도우의 경우 대소문자 구별이 잘 안되는 문제가 추가로 존재함(이것은 운영체제의 문제)
        final String email = "test@test.com";
        final String password = "test";
        final String type = "seller";

        // 로그인을 좀 더 잘 관리하기 위해선 docker 기반의 redis에 token 관리가 필요합니다.
        // token 관리는 Docker redis 및 AWS 설정 이후에 작업해야하므로 잠시 보류합니다.
        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password, type);
        TestAccountLoginResponseForm responseform = testAccountService.login(requestForm);

        assertTrue(responseform.getUserToken() != null);
    }

    // 로그아웃, 회원 탈퇴와 같은 사항들이 남아있음
    // 이 사항들은 역시나 로그인 되어 있는 token을 기반으로 진행되어야 합니다.
    // 그러므로 위 두 가지 사항은 현 시점에선 보류합니다.

    @Test
    @DisplayName("특정 회원이 어떤 타입인지 확인")
    void 특정_회원이_어떤_타입인지_확인 () {
        final String email = "admin@test.com";
        final String type = "admin";

        TestAccountCheckTypeRequestForm requestForm = new TestAccountCheckTypeRequestForm(email);

        TestAccountTypeResponseForm accountTypeResponseForm = testAccountService.findType(requestForm);

        assertEquals(type, accountTypeResponseForm.getType());
        System.out.println("accountTypeResponseForm.getType(): " + accountTypeResponseForm.getType());
    }
}
