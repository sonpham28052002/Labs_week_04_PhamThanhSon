package vn.edu.iuh.fit.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.entities.CandidateSkill;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class CandidateSkillReponsitory extends DataReponsitory<CandidateSkill, List<Integer>> {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    private RowMapper<CandidateSkill> rowMapper;

    public CandidateSkillReponsitory(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.rowMapper = new RowMapper<CandidateSkill>() {
            @Override
            public CandidateSkill mapRow(ResultSet rs, int rowNum) throws SQLException {

                System.out.println(rs);
                if (rs == null) return  null;
                CandidateSkill skill = new CandidateSkill();
                skill.setCandidateID(rs.getInt(1));
                skill.setSkillID(rs.getInt(2));
                skill.setLevel(rs.getInt(3));
                return skill;
            }
        };
    }

    public List<CandidateSkill> findOneByCandidateID(int id) {
        String query = "select * from candidateskill where candidateID = ?";
        return jdbcTemplate.query(query, rowMapper, id);
    }

    public List<CandidateSkill> findOneBySkillID(int id) {
        String query = "select * from candidateskill where skillID = ?";
        return jdbcTemplate.query(query, rowMapper, id);
    }

    @Override
    public CandidateSkill findOne(List<Integer> id) {
        System.out.println(id.get(0)+" "+id.get(1));
        String query = "select * from candidateskill where skillID = ? and candidateID = ?";
        return jdbcTemplate.queryForObject(query, rowMapper, id.get(0),id.get(1));
    }

    @Override
    public List<CandidateSkill> getAll() {
        String query = "select * from candidateskill";
        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public boolean insert(CandidateSkill candidateSkill) {
        String insert = "INSERT INTO candidateskill (candidateID, skillID, level) VALUES (?,?,?)";
        int n = jdbcTemplate.update(insert, candidateSkill.getCandidateID(), candidateSkill.getSkillID(), candidateSkill.getLevel());
        if (n != 0) return true;
        return false;
    }

    @Override
    public boolean delete(List<Integer> ids) {
        String delete = "delete from candidateskill where candidateID = ? and skillID = ?";
        int n = jdbcTemplate.update(delete, ids.get(0), ids.get(1));
        if (n != 0) return true;
        return false;
    }

    @Override
    public boolean update(CandidateSkill candidateSkill) {
        String update = "update candidateskill set level = ? where candidateID = ? and skillID = ?";
        int n = jdbcTemplate.update(update, candidateSkill.getLevel(), candidateSkill.getCandidateID(), candidateSkill.getSkillID());
        if (n != 0) return true;
        return false;
    }
}
