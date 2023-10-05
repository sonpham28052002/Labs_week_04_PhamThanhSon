package vn.edu.iuh.fit.entities;

import java.util.ArrayList;
import java.util.List;

public class Skill {
    private int skillId;
    private String skillName;

    public Skill() {
    }

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "skill{" +
                "skillId=" + skillId +
                ", skillName='" + skillName + '\'' +
                '}';
    }


}
