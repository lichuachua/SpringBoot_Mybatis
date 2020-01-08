package com.lichuachua.blog.blogserver.web.interceptor;

import com.lichuachua.blog.common.constant.SysConstant;
import com.lichuachua.blog.common.util.JsonUtil;
import com.lichuachua.blog.common.util.ThreadLocalMap;
import com.lichuachua.blog.blogserver.constant.BlogConstant;
import com.lichuachua.blog.blogserver.dto.TokenInfo;
import com.lichuachua.blog.blogserver.dto.UserInfoDTO;
import com.lichuachua.blog.blogserver.enums.ErrorCodeEnum;
import com.lichuachua.blog.blogserver.service.ITokenService;
import com.lichuachua.blog.blogserver.wrapper.ResultWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private ITokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String accessToken = null;

        accessToken = request.getHeader(BlogConstant.HTTP_HEADER_WMK_ACCESS_TOKEN);

        if (null == accessToken) {
            accessToken = request.getParameter(BlogConstant.RQE_PARAM_WMK_ACCESS_TOKEN);
        }


        ResultWrapper  resultWrapper =null;
        response.setHeader("Content-Type", "application/json;charset=utf-8");

        /**
         * 用户没有传递token，返回错误信息给用户
         */
        if (null == accessToken) {
            ThreadLocalMap.remove(SysConstant.THREAD_LOCAL_KEY_LOGIN_USER);
            resultWrapper = ResultWrapper.failure(ErrorCodeEnum.UNAUTHORIZED);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            try {
                response.getWriter().println(JsonUtil.toJson(resultWrapper));
            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }

        /**
         * token错误
         */
        TokenInfo tokenInfo = tokenService.getTokenInfo(accessToken);
        if (null == tokenInfo) {
            ThreadLocalMap.remove(SysConstant.THREAD_LOCAL_KEY_LOGIN_USER);
            resultWrapper = ResultWrapper.failure(ErrorCodeEnum.BAD_ACCESS_TOKEN);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            try {
                response.getWriter().println(JsonUtil.toJson(resultWrapper));
            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }

        /**
         * 将UserInfo设置到ThreadLocal
         */
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserId(tokenInfo.getUserId());
        ThreadLocalMap.put(SysConstant.THREAD_LOCAL_KEY_LOGIN_USER, userInfoDTO);
        return true;
    }
}
