package com.justinbauer.cod.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_GAMEINSTANCE")
public class GameInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_fk")
    User user;

    @ManyToOne
    @JoinColumn(name = "game_fk")
    Game game;

    @ManyToOne
    @JoinColumn(name="team_fk")
    private Team team;

    @Column(name = "winner")
    private boolean isWinner;

    @Column(name = "teamleader")
    private boolean teamleader;

    @Column(name = "kills")
    private Integer kills;

    @Column(name = "deaths")
    private Integer deaths;

    public GameInstance(User user, Game game) {
        this.user = user;
        this.game = game;
    }
}