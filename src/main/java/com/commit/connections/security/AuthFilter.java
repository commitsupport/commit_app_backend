package com.commit.connections.security;

import com.commit.connections.dto.ApiError;
import com.commit.connections.dto.ApiResponse;
import com.commit.connections.dto.common.CurrentUser;
import com.commit.connections.dto.common.RequestContext;
import com.commit.connections.entity.UserSession;
import com.commit.connections.exception.ErrorCode;
import com.commit.connections.exception.InvalidCredentials;
import com.commit.connections.service.TokenService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.io.IOException;

/*
*   Filter HTTP:
*   - przechwytuje każdy request HTTP,
*   - sprawdza czy jest podany token w request
*
*/

@Component
public class AuthFilter implements Filter {

    private final TokenService tokenService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public AuthFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
        HttpServletResponse httpRes = (HttpServletResponse) servletResponse;

        String path = httpReq.getRequestURI();

        // dla tego endpoint przepuszczaj bez authorization
        if (path.equals("/api/auth/login")) {
            System.out.println("/api/auth/login");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String authHeader = httpReq.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            authErrorResposne(
                    httpRes,
                    401,
                    ErrorCode.MISSING_TOKEN,
                    "Brak tokena - zaloguj się ponownie",
                    "Missing or invalid authorization token"
            );
            return;
        }

        String token = authHeader.substring("Bearer ".length()).trim();

        if(!tokenService.isValid(token)){
            System.out.println("Nie znaleziono podanego aktywnego tokenu !!");
            authErrorResposne(
                    httpRes,
                    401,
                    ErrorCode.INVALID_CREDENTIALS,
                    "Sesja wygasła. Zaloguj się ponownie.",
                    "Invalid or expired authorization token"
            );
            return;
        }

        // zapisanie userSession
        UserSession userSession = tokenService.getActiveSession(token);
        RequestContext.set(new CurrentUser(userSession.getUsrid(),userSession.getToken()));

        filterChain.doFilter(servletRequest,servletResponse);
    }

    // pomocnicza metoda do zwracające błedy w response przy exception
    private void authErrorResposne(
            HttpServletResponse response,
            int httpStatus,
            ErrorCode code,
            String message,
            String details
    ) throws IOException {
        response.setStatus(httpStatus);
        response.setContentType("application/json;charset=UTF-8");
        System.out.println("authErrorResposne");
        ApiError error = new ApiError(
                httpStatus,
                code,
                message,
                details
        );

        ApiResponse<Void> body = ApiResponse.error(error);
        String json = objectMapper.writeValueAsString(body);
        response.getWriter().write(json);
    }
}
