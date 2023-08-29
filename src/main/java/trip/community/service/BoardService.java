package trip.community.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trip.community.dto.BoardReviewDTO;
import trip.community.dto.BoardReviewDTO.clientRes;
import trip.community.mapper.BoardMapper;
import trip.community.model.Board;
import trip.community.repository.BoardRepository;
import java.time.format.DateTimeFormatter;


import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    private final AsyncService asyncService;

    @Transactional(readOnly = true)
    public clientRes findBoard(Long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("Can't not find board"));
        asyncService.addViews(board);
        clientRes resDTO = BoardMapper.INSTANCE.toBoardResponseDTO(board);
        return resDTO;
    }
    @Transactional(readOnly = true)
    public List<clientRes> findBoardList(){
        List<Board> board =  boardRepository.findAllByOrderByCreatedAtAsc();
        List<clientRes> resDTO = board.stream().map(BoardMapper.INSTANCE::toBoardResponseDTO).toList();
        return resDTO;
    }

    @Transactional
    public clientRes create(BoardReviewDTO.createClientReq req){
        Board board = req.toBoardEntity();
        Board res = boardRepository.save(board);
        clientRes resDTO = BoardMapper.INSTANCE.toBoardResponseDTO(res);
        return resDTO;
    }

    @Transactional
    public clientRes update(Long boardId, BoardReviewDTO.createClientReq req){
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("board Not Found"));
        board.setBoard(req.getTitle(), req.getContent(), req.getRegion(), req.getImageUrl());
        clientRes resDTO = BoardMapper.INSTANCE.toBoardResponseDTO(board);
        return resDTO;
    }

    @Transactional
    public Long like(Long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("board Not Found"));
        board.countLike();
        Board res = boardRepository.saveAndFlush(board);
        Long likeCnt = res.getLikeCnt();
        return likeCnt;
    }

}
