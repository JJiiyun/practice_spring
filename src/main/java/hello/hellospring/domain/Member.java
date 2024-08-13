package hello.hellospring.domain;

public class Member {
    private Long id; //member 저장할 때 system에서 부여하는 id
    private String name; //고객이 지정하는 name

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
