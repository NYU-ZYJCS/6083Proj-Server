package com.nyu.db.projServer.exception;

import com.nyu.db.projServer.utils.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @Author: yingjie
 * @Description: TODO
 * @CreateTime: 2023/12/6 11:09
 */
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
public class GlobalExceptionHandler {
    /**
     *
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponses> ExceptionHandler(IllegalArgumentException e) {
        return ResponseEntity.ok(new ApiResponses(null,e.getMessage(),0,false));
    }

    /**
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ApiResponses> ExceptionHandler(final MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        String msg = allErrors.get(0).getDefaultMessage();
        return ResponseEntity.ok(new ApiResponses(null,msg,0,false));
    }
}
