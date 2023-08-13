package trip.community.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trip.community.dto.BoardReviewDTO;
import trip.community.dto.BoardReviewDTO.clientRes;
import trip.community.service.BoardService;

import java.util.List;

import static trip.community.global.config.ServerConfig.CURRENT_API_URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = CURRENT_API_URI)
public class BoardController {

    private final BoardService boardService;

    @Operation(summary = "게시글 리스트 조회")
    @GetMapping("/boards")
    public ResponseEntity<List<clientRes>> getBoardList(){
        List<clientRes> boardRes = boardService.findBoardList();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(boardRes);
    }

    @Operation(summary = "게시글 단일 조회")
    @GetMapping("/boards/{boardId}")
    public ResponseEntity<clientRes> getBoard(
            @PathVariable Long boardId
    )
    {
        clientRes boardRes = boardService.findBoard(boardId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(boardRes);
    }

    @Operation(summary = "게시글 생성")
    @PostMapping("/boards")
    public ResponseEntity<clientRes> createBoard(
            @RequestBody BoardReviewDTO.createClientReq boardReq
            ){


        System.out.println(boardReq.getStartTime());
        System.out.println(boardReq.getEndTime());
        clientRes boardRes = boardService.create(boardReq);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(boardRes);
    }

    @Operation(summary = "게시글 수정")
    @PutMapping("/boards/{boardId}")
    public ResponseEntity<clientRes> updateBoard(
            @PathVariable Long boardId,
            @RequestBody BoardReviewDTO.createClientReq boardReq
    )
    {
        clientRes boardRes = boardService.update(boardId, boardReq);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(boardRes);
    }

    @GetMapping
    public ResponseEntity<String> test(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("ok");
    }

}
