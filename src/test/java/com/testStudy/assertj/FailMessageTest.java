package com.testStudy.assertj;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FailMessageTest {

    static class NameTag {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public NameTag(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    @Test
    @DisplayName("에러 메세지 출력 테스트")
    void error_message_test() {
        NameTag nameTag = new NameTag("라이언", 25);
        Assertions.assertThat(nameTag.getAge())
                .as("%s의 이름표 에러", nameTag.getName())
                .isGreaterThan(50);
    }

}
