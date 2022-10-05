package com.example.springbootstudyjpa.advice;


import com.example.springbootstudyjpa.exception.BizException;
import com.example.springbootstudyjpa.pojo.Result;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = "com.example.springbootstudyjpa.controller")
@Slf4j
public class ResponseAdvice implements ResponseBodyAdvice {
	//自定义一个自己的duzhihaoEx
	@Override
	public boolean supports(MethodParameter methodParameter, Class aClass) {
		return true;
	}
	
	@Override
	public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
			Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
		if (Objects.isNull(o)) {
			return Result.builder().message("success").build();
		}
		
		if (o instanceof Result) {
			return o;
		}
		
		return Result.builder().message("success").data(o).build();
	}
	

	
	/**
	 * 针对业务异常统一处理
	 *
	 * @param request
	 * @param bizException
	 *
	 * @return
	 */
	@ExceptionHandler(NumberFormatException.class)
	@ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
	public Result<?> bizExceptionHandler(HttpServletRequest request, NumberFormatException bizException) {
		
		log.error("catch bizException {}", bizException.getLocalizedMessage());
		return Result.builder().message("路径错误").status(500).data("错误").build();
	}
	
	@ExceptionHandler(BizException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public Result<?> exceptionHandler(HttpServletRequest request, BizException e) {
		log.error(e.getMessage(), e);
		return Result.builder().message(e.getMessage()).status(Result.fail).data("错误").build();
	}

	
	/**
	 * 针对Assert断言异常统一处理
	 *
	 * @param request
	 * @param illegalArgumentExceptionException
	 *
	 * @return
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
	public Result<?> illegalArgumentExceptionHandler(HttpServletRequest request,
			IllegalArgumentException illegalArgumentExceptionException) {
		log.error("illegalArgumentExceptionException:[{}],[{}]",
				illegalArgumentExceptionException.getMessage(), illegalArgumentExceptionException);
		return Result.builder().message(illegalArgumentExceptionException.getMessage())
				.status(Result.fail).build();
	}
	
	
}