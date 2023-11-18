package vn.edu.iuh.fit.labs_week_04_phamthanhson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.entities.CandidateSkill;
import vn.edu.iuh.fit.repositories.CandidateSkillReponsitory;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CandidateSkillApplicationTests {
    @Autowired
    private CandidateSkillReponsitory skillReponsitory;

    @Test
    void getAll() {
        System.out.println("\n----------------------------------------------------------------\n");
        skillReponsitory.getAll().forEach(System.out::println);
    }

    @Test
    void findOneByCandidateID() {
        System.out.println("\n----------------------------------------------------------------\n");
        skillReponsitory.findOneByCandidateID(1).forEach(System.out::println);
    }

    @Test
    void findOneBySkillID() {
        System.out.println("\n----------------------------------------------------------------\n");
        skillReponsitory.findOneBySkillID(2).forEach(System.out::println);
    }

    @Test
    void insert() {
        System.out.println("\n----------------------------------------------------------------\n");
        CandidateSkill skill = new CandidateSkill(3,3,11);
        List<Integer> ids =new ArrayList<>();
        ids.add(skill.getCandidateID());
        ids.add(skill.getSkillID());
        if (skillReponsitory.findOne(ids) == null){
            if (skillReponsitory.insert(skill)){
                System.out.println("Thêm kỹ năng của ứng viên thành công");
            }else System.out.println("Thêm kỹ năng của ứng viên Thất bại");
        }else System.out.println("đã tồn tại rồi!");
    }

    @Test
    void delete() {
        System.out.println("\n----------------------------------------------------------------\n");
        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(2);
        if (skillReponsitory.delete(ids)){
            System.out.println("xoá kỹ năng của ứng viên thành công");
        }else System.out.println("xoá kỹ năng của ứng viên Thất bại");
    }

    @Test
    void update() {
        System.out.println("\n----------------------------------------------------------------\n");
        CandidateSkill skill = new CandidateSkill(1,2,10);
        if (skillReponsitory.update(skill)){
            System.out.println("xoá kỹ năng của ứng viên thành công");
        }else System.out.println("xoá kỹ năng của ứng viên Thất bại");
    }

}
