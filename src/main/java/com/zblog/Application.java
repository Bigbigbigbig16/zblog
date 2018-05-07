package com.zblog;

import com.blade.Blade;

public class Application {

    public static void main(String[] args) {
        Blade.me()
                .get("/", ((request, response) -> response.text("Hello World1111!")))
                .start(Application.class);
    }

}
