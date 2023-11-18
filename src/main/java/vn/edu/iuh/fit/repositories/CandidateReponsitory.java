package vn.edu.iuh.fit.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.entities.Candidate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Component
public class CandidateReponsitory extends DataReponsitory<Candidate,Integer>{

   private JdbcTemplate jdbcTemplate;
   private DataSource dataSource;
   private RowMapper<Candidate> rowMapper ;

    public CandidateReponsitory(DataSource dataSource) {
        this.dataSource =dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        rowMapper = new RowMapper<Candidate>() {
            @Override
            public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
                Candidate candidate = new Candidate();
                candidate.setCandidateID(rs.getInt(1));
                candidate.setFullName(rs.getString(2));
                candidate.setEmail(rs.getString(3));
                candidate.setPhone(rs.getString(4));
                candidate.setAddress(rs.getString(5));
                return candidate;
            }
        };
    }

    @Override
    public Candidate findOne(Integer id) {
        String query  = "select * from candidate where candidateID = ?";
        return jdbcTemplate.queryForObject(query, rowMapper, id);

    }

    @Override
    public List<Candidate> getAll() {
        String query  = "select * from candidate";
        return jdbcTemplate.query(query, rowMapper);

    }

    @Override
    public boolean insert(Candidate condidate) {
        System.out.println(condidate);
        String insert = "insert into candidate(full_name,email,phone_number,address) values(?,?,?,?)";
        int n = jdbcTemplate.update(insert, condidate.getFullName(),condidate.getEmail(),condidate.getPhone(),condidate.getAddress());
        return n != 0;
    }

    @Override
    public boolean delete(Integer id) {
        String delete = "delete FROM candidate where candidateID = ?";
        int n = jdbcTemplate.update(delete, id);
        return n != 0;
    }

    @Override
    public boolean update(Candidate condidate) {
        String update = "update candidate set full_name = ? , email = ? , phone_number= ?,address = ? where candidateID = ?";
        int n = jdbcTemplate.update(update, condidate.getFullName(),condidate.getEmail(),condidate.getPhone(),condidate.getAddress(),condidate.getCandidateID());
        return n != 0;
    }
}
