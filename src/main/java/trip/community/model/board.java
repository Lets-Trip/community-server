package trip.community.model;

import jakarta.persistence.*;
import java.time.ZonedDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "board")
public class board extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;

    @Column(columnDefinition = "varchar(1000)")
    private String content;

    @Column(columnDefinition = "varchar(20)")
    private String type;

    @Column(columnDefinition = "varchar(20)")
    private String region;

    private String ImageUrl;

    private Long views;
    private Long likeCnt;

    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
}