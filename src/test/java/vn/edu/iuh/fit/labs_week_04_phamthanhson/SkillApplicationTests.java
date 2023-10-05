package vn.edu.iuh.fit.labs_week_04_phamthanhson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.entities.Skill;
import vn.edu.iuh.fit.reponsitories.SkillReponsitory;

@SpringBootTest
public class SkillApplicationTests {
    @Autowired
    private SkillReponsitory skillReponsitory;

    @Test
    void getAll(){
        System.out.println("\n----------------------------------------------------------------\n");
        skillReponsitory.getAll().forEach(System.out::println);
    }

    @Test
    void findOne(){
        System.out.println("\n----------------------------------------------------------------\n");
        System.out.println(skillReponsitory.findOne(1));
    }

    @Test
    void insert(){
        System.out.println("\n----------------------------------------------------------------\n");
        Skill skill = new Skill("lap trinh java");
        if (skillReponsitory.insert(skill)){
            System.out.println("them skill thanh cong");
        }else System.out.println("them skill khong thanh cong");
    }

    @Test
    void update() {
        System.out.println("\n----------------------------------------------------------------\n");
        Skill skill = new Skill("lap trinh java core");
        skill.setSkillId(1);
        if (skillReponsitory.insert(skill)) {
            System.out.println("cap nhat skill thanh cong");
        } else System.out.println("cap nhat skill khong thanh cong");
    }

    @Test
    void delete() {
        System.out.println("\n----------------------------------------------------------------\n");
        if (skillReponsitory.delete(1)) {
            System.out.println("xoá skill thanh cong");
        } else System.out.println("xoá skill khong thanh cong");
    }


}
