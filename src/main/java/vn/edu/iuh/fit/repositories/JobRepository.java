package vn.edu.iuh.fit.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.entities.Job;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JobRepository extends DataReponsitory<Job, Integer> {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    private RowMapper<Job> rowMapper;

    public JobRepository(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        rowMapper = new RowMapper<Job>() {
            @Override
            public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
                Job job = new Job();
                job.setJobId(rs.getInt(1));
                job.setTitle(rs.getString(2));
                job.setDescription(rs.getString(3));
                job.setLocation(rs.getString(4));
                job.setSalary(rs.getDouble(5));
                return job;
            }
        };
    }

    @Override
    public Job findOne(Integer id) {
        String query = "select * from job where jobID = ?";
        return jdbcTemplate.queryForObject(query, rowMapper, id);

    }

    @Override
    public List<Job> getAll() {
        String query = "select * from job ";
        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public boolean insert(Job job) {
        String insert = "INSERT INTO job ( title, description, location, salary) VALUES (?,?,?,?)";
        int n = jdbcTemplate.update(insert, job.getTitle(), job.getDescription(), job.getLocation(), job.getSalary());
        if (n != 0) return true;
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String delete ="delete from job where jobID = ?";
        int n = jdbcTemplate.update(delete,id);
        if (n!=0) return true;
        return false;
    }

    @Override
    public boolean update(Job job) {
        String update = "update job set title = ? , description = ?, location = ?, salary = ? where jobID = ?";
        int n = jdbcTemplate.update(update, job.getTitle(), job.getDescription(), job.getLocation(), job.getSalary(),job.getJobId());
        if (n != 0) return true;
        return false;
    }
}
