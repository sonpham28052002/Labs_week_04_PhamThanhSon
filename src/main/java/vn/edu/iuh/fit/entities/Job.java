package vn.edu.iuh.fit.entities;

public class Job {
    private int jobId;
    private String title;
    private String description;
    private String location;
    private double salary;

    public Job() {
    }

    public Job( String title, String description, String location, double salary) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.salary = salary;
    }

    public int getJobId() {
        return jobId;
    }


    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", salary=" + salary +
                '}';
    }
}
