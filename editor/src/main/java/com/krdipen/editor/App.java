package com.krdipen.editor;

public class App {
    public static void main(String[] args) {
        Document document = new Document();
        document.execute(new Command("Hello"));
        document.execute(new Command("World"));
        System.out.println(document.getText());
        document.undo();
        System.out.println(document.getText());
        document.undo();
        System.out.println(document.getText());
        document.undo();
        System.out.println(document.getText());
        document.redo();
        System.out.println(document.getText());
        document.redo();
        System.out.println(document.getText());
        document.redo();
        System.out.println(document.getText());
        System.out.println("================");
    }
}
