package com.penovatech.shopping.controller;

import com.penovatech.common.dto.ResultDto;
import com.penovatech.shopping.dto.CommentDto;
import com.penovatech.shopping.service.CommentService;
import com.penovatech.shopping.utils.SessionUtility;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentRestController {

    public CommentRestController(CommentService service) {
        this.service = service;
    }

    private final CommentService service;

    @PostMapping
    public ResultDto<Void> commentProduct(@RequestBody CommentDto dto) {
        service.commentProduct(SessionUtility.getCurrentUserId(), dto.getProductId(), dto.getComment());
        return new ResultDto<>("Comment", "It is registered successfully", Boolean.TRUE);
    }

    @DeleteMapping("/{commentId}")
    public ResultDto<Void> delete(@PathVariable("commentId") Long commentId) {
        service.unCommentProduct(commentId);
        return new ResultDto<>("Comment", "Comment remove successfully", Boolean.TRUE);
    }

}
