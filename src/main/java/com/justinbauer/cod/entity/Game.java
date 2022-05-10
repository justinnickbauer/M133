package com.justinbauer.cod.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "T_GAME")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "isActive")
    private boolean Active;

    @Column(name = "date")
    private Date date;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created_at;

    @ManyToOne
    @JoinColumn(name="modus_fk")
    private Modus modus;

    @ManyToOne
    @JoinColumn(name="map_fk")
    private Map map;

    @ManyToOne
    @JoinColumn(name="weapon_fk")
    private Weapon weapon;
}
