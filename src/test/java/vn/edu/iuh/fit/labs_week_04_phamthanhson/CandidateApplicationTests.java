package vn.edu.iuh.fit.labs_week_04_phamthanhson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.reponsitories.CandidateReponsitory;

@SpringBootTest
class CandidateApplicationTests {

    @Autowired
    private CandidateReponsitory candidateReponsitory;

    @Test
    void getAll() {
        System.out.println("\n----------------------------------------------------------------\n");
        candidateReponsitory.getAll().forEach(System.out::println);

    }

    @Test
    void findOne() {
        System.out.println("\n----------------------------------------------------------------\n");
        candidateReponsitory.findOne(1);
    }

    @Test
    void insert() {
        System.out.println("\n----------------------------------------------------------------\n");
        Candidate candidate = new Candidate("Pham Thanh Leon", "leonpham28052002@gmail.com", "0559492805", "566 nguyễn thái sơn");
        boolean checkInsert = candidateReponsitory.insert(candidate);
        if (checkInsert) {
            System.out.println("thêm thành công.");
        } else System.out.println("thêm thất bại!");
        getAll();
    }

    @Test
    void update() {
        System.out.println("\n----------------------------------------------------------------\n");
        Candidate candidate = new Candidate("Pham Thanh kkk", "leonpham28052002@gmail.com", "0559492805", "566 nguyễn thái sơn");
        candidate.setCandidateID(8);
        boolean checkInsert = candidateReponsitory.update(candidate);
        if (checkInsert) {
            System.out.println("cập nhật thành công.");
        } else System.out.println("cập nhật thất bại!");
    }

    @Test
    void delete(){
        System.out.println("\n----------------------------------------------------------------\n");
        boolean checkInsert = candidateReponsitory.delete(8);
        if (checkInsert) {
            System.out.println("Xoá thành công.");
        } else System.out.println("Xoá thất bại!");
    }

}
