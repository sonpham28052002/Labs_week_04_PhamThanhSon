package vn.edu.iuh.fit.labs_week_04_phamthanhson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.reponsitories.CandidateReponsitory;
import vn.edu.iuh.fit.reponsitories.JobRepository;

@SpringBootApplication(scanBasePackages = {"vn.edu.iuh.fit.reponsitories", "vn.edu.iuh.fit.entities"})
public class LabsWeek04PhamThanhSonApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabsWeek04PhamThanhSonApplication.class, args);
    }

    @Autowired
    private CandidateReponsitory reponsitory;

    @Bean
    public CommandLineRunner lineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
            }
        };
    }

}
