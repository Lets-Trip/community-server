package trip.community.service;


import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trip.community.model.Board;
import trip.community.repository.BoardRepository;

@Service
@RequiredArgsConstructor
public class AsyncService {

  private final BoardRepository boardRepository;

  @Async
  @Transactional
  public void addViews(Board board){
    board.countBoard();
    boardRepository.saveAndFlush(board);
  }
}
