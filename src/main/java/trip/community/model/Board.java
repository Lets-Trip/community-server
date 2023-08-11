package trip.community.model;

import jakarta.persistence.*;

import java.awt.*;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public void setBoard(String title, String content, String region, String ImageUrl){
        this.title = title;
        this.content = content;
        this.region = region;
        this.ImageUrl = ImageUrl;
    }

    @Builder.Default
    private Long views = 0L;

    @Builder.Default
    private Long likeCnt= 0L;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
}