package org.choongang.main.controllers;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.constants.Menu;
import org.choongang.member.controllers.JoinController;
import org.choongang.member.controllers.LoginController;

import java.util.HashMap;
import java.util.Map;

public class MemberControllerLocator implements ControllerLocator {

    private static ControllerLocator instance;

    private Map<Menu, Controller> controllers;

    private MemberControllerLocator() {
        controllers = new HashMap<>();
    }

    public static ControllerLocator getInstance(){
        if(instance == null) {
            instance = new MemberControllerLocator();
        }

        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if (controller != null) {
            return controller;

        }

        switch (menu) {
            case JOIN: controller = new JoinController();break;
            default: controller = new LoginController();

        }
        controllers.put(menu, controller);

        return null;
    }


}
