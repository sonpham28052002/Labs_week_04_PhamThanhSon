package vn.edu.iuh.fit.entities;


public class CandidateSkill {
    private int candidateID;
    private int skillID;
    private int level;

    public CandidateSkill() {
    }

    public CandidateSkill(int candidateID, int skillID, int level) {
        this.candidateID = candidateID;
        this.skillID = skillID;
        this.level = level;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "CandidateSkill{" +
                "candidateID=" + candidateID +
                ", skillID=" + skillID +
                ", level=" + level +
                '}';
    }
}
