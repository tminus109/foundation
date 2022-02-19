package com.gfa.using_dependencies.playing_with_colors.services;

import com.gfa.using_dependencies.hello_bean_world.Printer;
import com.gfa.using_dependencies.playing_with_colors.models.MyColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlackColor implements MyColor {
    private final Printer printer;

    @Autowired
    public BlackColor(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void printColor() {
        printer.log("This is BLACK.");
    }
}
