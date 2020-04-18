package org.ttbdlk;
import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Locale;

@Entity
@Table(name="Players")

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pick")
    private int pick;
    @Column(name = "Name")
    private String name;
    @Column(name = "College")
    private String college;
    @Column(name = "Position")
    private String position;
    @Column(name = "DateOfBirth")
    private LocalDate dateOfBirth;
    @Column(name = "Weight")
    private int weight;
    @Column(name = "Height")
    private int height;
    @Column(name = "DraftTeam")
    private String draftTeam;
    /*@Column(name = "Picture")
    private Date ;*/

    public Player(int pick, String name, String college, String position, LocalDate dateOfBirth, int weight, int height, String draftTeam) {
        this.pick = pick;
        this.name = name;
        this.college = college;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
        this.draftTeam = draftTeam;
    }

    public int getPick() {
        return pick;
    }

    public void setPick(int pick) {
        this.pick = pick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setDraftTeam(String draftTeam) {
        this.draftTeam = draftTeam;
    }

    public String getDraftTeam() {
        return draftTeam;
    }

    @Override
    public String toString() {
        return "Player{" +
                "pick=" + pick +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                ", position='" + position + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", weight=" + weight +
                ", height=" + height +
                ", draftTeam=" + draftTeam +
                '}';
    }
}
