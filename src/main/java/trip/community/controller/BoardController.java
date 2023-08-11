package trip.community.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trip.community.dto.BoardRequestDTO;
import trip.community.dto.BoardResponseDTO;
import trip.community.service.BoardService;

import static trip.community.global.config.ServerConfig.CURRENT_API_URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = CURRENT_API_URI)
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/boards")
    public ResponseEntity<BoardResponseDTO> getBoard(
            @RequestBody BoardRequestDTO boardReq
            ){

        BoardResponseDTO boardRes = boardService.create(boardReq);


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