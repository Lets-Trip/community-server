package trip.community.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "board")
public class Board extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private String title;

    @Column(columnDefinition = "varchar(1000)")
    private String content;

    @Column(columnDefinition = "varchar(20)")
    private String type;

    @Column(columnDefinition = "varchar(20)")
    private String region;

    private String ImageUrl;

    @Builder.Default
    private Long views = 0L;

    @Builder.Default
    private Long likeCnt= 0L;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
}