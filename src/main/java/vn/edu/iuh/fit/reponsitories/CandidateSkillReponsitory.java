package vn.edu.iuh.fit.reponsitories;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.entities.Candidate;
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
                CandidateSkill skill = new CandidateSkill();
                skill.setCandidateID(rs.getInt(1));
                skill.setSkillID(rs.getInt(2));
                skill.setLevel(rs.getInt(3));
                return skill;
            }
        };
    }

    @Override
    public CandidateSkill findOne(List<Integer> ids) {
        String query = "select * from candidateskill where candidate_id = ? and skill_id = ? ";
        return jdbcTemplate.queryForObject(query, rowMapper, ids.get(0), ids.get(1));
    }

    public List<CandidateSkill> findOneByCandidateID(int id) {
        String query = "select * from candidateskill where candidate_id = ?";
        return jdbcTemplate.query(query, rowMapper, id);
    }

    public List<CandidateSkill> findOneBySkillID(int id) {
        String query = "select * from candidateskill where skill_id = ?";
        return jdbcTemplate.query(query, rowMapper, id);
    }

    @Override
    public List<CandidateSkill> getAll() {
        String query = "select * from candidateskill";
        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public boolean insert(CandidateSkill candidateSkill) {
        String insert = "INSERT INTO candidateskill (candidate_id, skill_id, level) VALUES (?,?,?)";
        int n = jdbcTemplate.update(insert, candidateSkill.getCandidateID(), candidateSkill.getSkillID(), candidateSkill.getLevel());
        if (n != 0) return true;
        return false;
    }

    @Override
    public boolean delete(List<Integer> ids) {
        String delete = "delete from candidateskill where candidate_id = ? and skill_id = ?";
        int n = jdbcTemplate.update(delete, ids.get(0), ids.get(1));
        if (n != 0) return true;
        return false;
    }

    @Override
    public boolean update(CandidateSkill candidateSkill) {
        String update = "update candidateskill set level = ? where candidate_id = ? and skill_id = ?";
        int n = jdbcTemplate.update(update, candidateSkill.getLevel(), candidateSkill.getCandidateID(), candidateSkill.getSkillID());
        if (n != 0) return true;
        return false;
    }
}
