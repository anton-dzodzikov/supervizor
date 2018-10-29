package supervizor.domain;

public class Issue {
    private Long id;
    private Long parentId;
    private String title;
    private String description;
    private String status; // TODO: Rework to another domain entity IssueStatus

    public Issue(String title, String description, String status) {
        this(null, title, description, status);
    }

    public Issue(Long parentId, String title, String description, String status) {
        this.parentId = parentId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
