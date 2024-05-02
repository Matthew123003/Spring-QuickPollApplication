package io.zipcoder.tc_spring_poll_application.domain;

import javax.persistence.*;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VOTE_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "OPTION_ID")
    private Option option;

    public Vote() {
    }

    public Vote(Option option) {
        this.option = option;
    }

    public Vote(Long id, Option option) {
        this.id = id;
        this.option = option;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
