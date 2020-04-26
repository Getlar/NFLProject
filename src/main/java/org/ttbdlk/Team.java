package org.ttbdlk;
import javax.persistence.*;

@Entity
@Table(name="Teams")

public class Team{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Name")
    private String name;
    @Column(name = "Division")
    private String division;
    @Column(name = "HeadCoach")
    private String headCoach;
    @Column(name = "Owner")
    private String owner;
    /*@Column(name = "Badge")
    private ...
     */

    public Team(String name, String division, String owner, String headCoach) {
        this.name = name;
        this.division = division;
        this.headCoach = headCoach;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getHeadCoach() { return headCoach; }

    public  void setHeadCoach(String headCoach) { this.headCoach = headCoach ;}

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return name;
    }
}
