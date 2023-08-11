package trip.community.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trip.community.model.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}