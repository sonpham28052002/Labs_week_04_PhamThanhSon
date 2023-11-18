package vn.edu.iuh.fit.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.entities.Skill;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class SkillReponsitory extends DataReponsitory<Skill,Integer>{
    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;
    private final RowMapper<Skill> rowMapper;

    public SkillReponsitory(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.rowMapper = new RowMapper<Skill>() {
            @Override
            public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
                Skill skill = new Skill();
                skill.setSkillId(rs.getInt(1));
                skill.setSkillName(rs.getString(2));
                return skill;
            }
        };
    }


    @Override
    public Skill findOne(Integer id) {
        String query = "select * from skill where skillID = ?";
        return jdbcTemplate.queryForObject(query,rowMapper,id);
    }

    @Override
    public List<Skill> getAll() {
        String query = "select * from skill";
        return jdbcTemplate.query(query,rowMapper);
    }

    @Override
    public boolean insert(Skill skill) {
        String insert = "INSERT INTO skill (skill_name) VALUES (?)";
        int n = jdbcTemplate.update(insert, skill.getSkillName());
        if (n != 0) return true;
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String delete = "delete from skill where skillID = ?";
        int n = jdbcTemplate.update(delete,id);
        if (n != 0) return true;
        return false;
    }

    @Override
    public boolean update(Skill skill) {
        String update = "update skill skill_name = ? where skill_id = ?";
        int n = jdbcTemplate.update(update, skill.getSkillName(),skill.getSkillId());
        if (n != 0) return true;
        return false;
    }
}
