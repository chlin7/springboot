package com.zh.SpringBootDemo.domain.s;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TestRepository extends JpaRepository<Test, Long> {

	Test findByName(String name);

	Test findByNameAndAge(String name, Integer age);

    @Query("from Test u where u.name=:name")
    Test findUser(@Param("name") String name);


}
