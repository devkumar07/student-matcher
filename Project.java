public class Project {
    private String project_id;
    private String number;
    private String organization;
    private String title;
    private String primary_first_name;
    private String primary_last_name;
    private String primary_email;

    public Project(String project_id, String number, String organization, String title, String primary_first_name,
            String primary_last_name, String primary_email) {
        this.project_id = project_id;
        this.number = number;
        this.organization = organization;
        this.title = title;
        this.primary_first_name = primary_first_name;
        this.primary_last_name = primary_last_name;
        this.primary_email = primary_email;
    }

    public Project(Project_data list) {
        this.project_id = list.project_id;
        this.number = list.number;
        this.organization = list.organization;
        this.title = list.title;
        this.primary_first_name = list.primary_first_name;
        this.primary_last_name = list.primary_last_name;
        this.primary_email = list.primary_email;
    }

    public String get_title() {
        return title;
    }

    public String get_number() {
        return number;
    }

    public String get_project_id() {
        return project_id;
    }

    public String get_organization() {
        return organization;
    }

    public String get_primary_first_name() {
        return primary_first_name;
    }

    public String get_primary_last_name() {
        return primary_last_name;
    }

    public String get_primary_email() {
        return primary_email;
    }

    public String output_project() {
        return "Title:" + title + "; Number:" + number;
    }
}