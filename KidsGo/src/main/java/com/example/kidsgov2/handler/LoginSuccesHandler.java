package com.example.kidsgov2.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//TENDRA EL COMPORTAMIENTO DE UN COMPONENTE
@Component
//SimpleUrlAuthenticationSuccessHandler mantiene los estados de sesion
public class LoginSuccesHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        SessionFlashMapManager flashMapManager = new SessionFlashMapManager();
        //Implementar mensaje
        FlashMap flashMap = new FlashMap();
        flashMap.put("success","¡Hola "+authentication.getName()+"! Has iniciado sesión con éxito");
        flashMapManager.saveOutputFlashMap(flashMap,request,response);
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
