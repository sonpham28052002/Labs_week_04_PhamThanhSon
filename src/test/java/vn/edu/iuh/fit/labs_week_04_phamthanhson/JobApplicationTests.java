package vn.edu.iuh.fit.labs_week_04_phamthanhson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.entities.Job;
import vn.edu.iuh.fit.reponsitories.JobRepository;

@SpringBootTest
public class JobApplicationTests {

    @Autowired
    private JobRepository jobRepository;

    @Test
    void findOne() {
        System.out.println("\n----------------------------------------------------------------\n");
        System.out.println(jobRepository.findOne(1));
    }

    @Test
    void getAll() {
        System.out.println("\n----------------------------------------------------------------\n");
        jobRepository.getAll().forEach(System.out::println);
    }

    @Test
    void insert() {
        System.out.println("\n----------------------------------------------------------------\n");
        Job job = new Job("Lap trinh java", "biet ve java core, java swing","12 nguyen van bao", 20000000);
        if (jobRepository.insert(job)){
            System.out.println("thêm job thanh cong");
        }else System.out.println("them job khong thanh cong");
        getAll();
    }
    @Test
    void update() {
        System.out.println("\n----------------------------------------------------------------\n");
        Job job = new Job("Lap trinh java", "biet ve java core, java swing","12 nguyen van bao", 40000000);
        job.setJobId(3);
        if (jobRepository.update(job)){
            System.out.println("cap nhat job thanh cong");
        }else System.out.println("cap nhat job khong thanh cong");
        getAll();
    }
    @Test
    void delete(){
        System.out.println("\n----------------------------------------------------------------\n");

        if (jobRepository.delete(4)){
            System.out.println("xoá job thanh cong");
        }else System.out.println("xoá job khong thanh cong");
    }
}
