package com.testStudy.assertj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

public class LambdaTest {

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
    @DisplayName("람다식 이용 필터링 테스트")
    void lambda_test() {
        List<NameTag> nameTagList = new ArrayList<>();
        NameTag admin = new NameTag("admin", 0);
        nameTagList.add(admin);
        nameTagList.add(new NameTag("user" + 0, 0));
        nameTagList.add(new NameTag("user" + 1, 1));


        assertThat(nameTagList).filteredOn(tag -> tag.getName().contains("admin")).containsOnly(admin);
    }

    @Test
    @DisplayName("property 추출 테스트 - 단일 property")
    void extract_property_test() {
        List<NameTag> nameTagList = new ArrayList<>();
        NameTag admin = new NameTag("admin", 0);
        nameTagList.add(admin);
        nameTagList.add(new NameTag("user" + 0, 0));
        nameTagList.add(new NameTag("user" + 1, 1));


        assertThat(nameTagList).extracting("name").contains("admin", "user0", "user1");
    }

    @Test
    @DisplayName("property 추출 테스트 - 여러 property")
    void extract_properties_test() {
        List<NameTag> nameTagList = new ArrayList<>();
        NameTag admin = new NameTag("admin", 0);
        nameTagList.add(admin);
        nameTagList.add(new NameTag("user" + 0, 0));
        nameTagList.add(new NameTag("user" + 1, 1));


        assertThat(nameTagList)
                .extracting("name","age")
                .contains(tuple("admin", 0),
                        tuple("user0",0),
                        tuple("user1",1));
    }
}
