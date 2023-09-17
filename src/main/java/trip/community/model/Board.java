package trip.community.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.List;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import trip.community.util.StringListConverter;


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

    private Long userId;

    private String title;

    @Column(columnDefinition = "varchar(1000)")
    private String content;

    @Column(columnDefinition = "varchar(20)")
    private String type;

    @Column(columnDefinition = "varchar(20)")
    private String region;

    @Column(columnDefinition = "varchar(1000)")
    @Convert(converter = StringListConverter.class)
    private List<String> imageUrl;

    @Builder.Default
    private Long views = 0L;

    @Builder.Default
    private Long likeCnt= 0L;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public void setBoard(String title, String content, String region, List<String> imageUrl){
        this.title = title;
        this.content = content;
        this.region = region;
        this.imageUrl = imageUrl;
    }

    public void countBoard(){
        this.views = this.views+1;
    }
    public void countLike(){
        this.likeCnt = this.likeCnt+1;
    }
}