package hello.hello_spring.domain;

//@Table(name = "MEMBER")
public class Member {

    // @Column (name = "ID")
    private Long id; //시스템 저장 아이디

    // @Column (name = "NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
