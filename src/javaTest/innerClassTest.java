package javaTest;

import javafx.scene.input.DataFormat;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.util.Date;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class innerClassTest {


    public static void main(String[] args) throws ParseException {

        Long l = 20L;

        String s = "123";

        BillForm billForm = new BillForm();
        billForm.click();

        //分离调用者和执行者 委托
        billForm.click(new ClickHandle() {
            @Override
            public void doOperation() {
                System.out.println("play");
            }
        });
        billForm.click(() -> System.out.println(l + "sleep"));
        billForm.click("UTH", user -> {
            System.out.println(user + "play");
        });

        //但还有个问题，每次调用都需要动态绑定，是否可以在区分调用者和执行者的基础上，进一步分离注册执行者和调用执行者？
        billForm.click(x -> x > 5);
        //todo 响应式编程可以解决这个问题。

        BinaryOperator<Long> operator = (x, y) -> x - y;
        Long apply = operator.apply(10l, 11l);
        System.out.println(apply);

        ThreadLocal<Date> dateThreadLocal = ThreadLocal.withInitial(() -> new Date());
        ThreadLocal<DateFormatter> dateFormatterThreadLocal = ThreadLocal.withInitial(() -> new DateFormatter());
        System.out.println(dateThreadLocal.get());
        System.out.println(dateFormatterThreadLocal.get().stringToValue("2023-03-01"));

        JButton button = new JButton();
        button.addActionListener(event ->
                System.out.println(event.getActionCommand()));
        button.doClick();
    }
}

interface ClickHandle {
    void doOperation();
}


interface UserClickHandle {
    void doOperation(String user);
}

class BillForm {
    protected void click() {
        System.out.println("doAnything");
    }

    //委托
    protected void click(ClickHandle handle) {
        handle.doOperation();
    }

    protected void click(Predicate<Integer> handle) {
    }


    protected void click(String s, UserClickHandle handle) {
        handle.doOperation(s);
    }
}